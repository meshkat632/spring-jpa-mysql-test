package com.wagawin.demo.scheduler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	ChildRepository childRepository;

	@Autowired
	ParentSummaryRepository parentSummaryRepository;

	@Scheduled(fixedRate = 20000)
	@Transactional
	public void reportCurrentTime() {

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