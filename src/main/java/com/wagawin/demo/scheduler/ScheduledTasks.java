package com.wagawin.demo.scheduler;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wagawin.demo.model.ParentSummary;
import com.wagawin.demo.repository.ChildRepository;
import com.wagawin.demo.repository.ParentSummaryRepository;

@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	

	@Autowired
	ChildRepository childRepository;

	@Autowired
	ParentSummaryRepository parentSummaryRepository;

	@Scheduled(cron = "0 0/15 * * * ?")
	@Transactional
	public void updateSummeryTable() {
		
		logger.info("Cron Task :: Execution Time - {}", LocalDateTime.now());
		Map<Integer, Integer> childrenCountfrequencyMap = new HashMap<>();
		childRepository.getSummery().forEach(item -> childrenCountfrequencyMap
				.compute(item.getChidlrenCount().intValue(), (key, value) -> value != null ? value + 1 : 1));
		Optional<Integer> maxChildCount = childrenCountfrequencyMap.keySet().stream().max(Comparator.naturalOrder());
		if (maxChildCount.isPresent()) {
			List<ParentSummary> parentSummaryLIst = new ArrayList<>();
			for (int i = 0; i < maxChildCount.get() + 1; i++) {
				ParentSummary parentSummary = new ParentSummary();
				parentSummary.setNumberOfChildren(i);
				if (childrenCountfrequencyMap.get(i) == null)
					parentSummary.setNumberOfParents(0);
				else
					parentSummary.setNumberOfParents(childrenCountfrequencyMap.get(i));
				parentSummaryLIst.add(parentSummary);
			}
			parentSummaryRepository.deleteAll();
			parentSummaryRepository.saveAll(parentSummaryLIst);

		}
	}
}