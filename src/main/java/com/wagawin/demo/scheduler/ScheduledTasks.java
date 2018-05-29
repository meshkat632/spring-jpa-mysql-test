package com.wagawin.demo.scheduler;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    /*
    @PersistenceContext
    private EntityManager em;
    */

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
    	/*
    	 
    	 SELECT COUNT(mytable.parent_id), mytable.childrenCount from ( SELECT parent_id, COUNT(parent_id) as childrenCount FROM `test-db`.child group by parent_id) as mytable group by mytable.childrenCount order by mytable.childrenCount;
    	  
    	 */
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}