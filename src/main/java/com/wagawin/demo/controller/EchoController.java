package com.wagawin.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
	class Message {
		private String message;

		public Message(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}

	@GetMapping(path = "/echo/{message}")
	public Message echo(@PathVariable("message") String message) {
		return new Message(message);
	}

}
