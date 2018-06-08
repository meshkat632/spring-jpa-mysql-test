package com.wagawin.demo.controller;



import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@RestController
public class EchoController {
	
	
	private static StringBuilder x = new StringBuilder(); 
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	class Message {
		private String message;

		public Message(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}
	
	//private Counter hellos = Metrics.counter("hellos");

    @Timed
	@GetMapping(path = "/echo/{message}")
	public Message echo(@PathVariable("message") String message) {
    	//hellos.increment();
		return new Message(message);
	}
    
    
    
    @GetMapping("/endpointA")
    public void handlerA() throws InterruptedException {
    	 //hellos.increment();
         logger.info("/endpointA");
         //Thread.sleep(RandomUtils.nextLong(0, 100));
         
          
         for(int i = 0 ; i< 1000000; i++) {
        	 x.append("ljklKSFKLJhasdkfjhaskljdfkalsjdfklajhskdlfjhalksjdhfklajshdfkljahskldjfhaklsjdfhlkajshdfkljhaskldjfhklasjdhfkljashdkfljhaskldjfhklasjdhfklasjdhfkjahsdkjf");
         }
         
    }

    @GetMapping("/endpointB")
    public void handlerB() throws InterruptedException {
    	 //hellos.increment();
         logger.info("/endpointB ");
         //Thread.sleep(RandomUtils.nextLong(0, 100));
          
         for(int i = 0 ; i< 1000; i++) {
        	 x.append("ljklKSFKLJhasdkfjhaskljdfkalsjdfklajhskdlfjhalksjdhfklajshdfkljahskldjfhaklsjdfhlkajshdfkljhaskldjfhklasjdhfkljashdkfljhaskldjfhklasjdhfklasjdhfkjahsdkjf");
         }
    }

}
