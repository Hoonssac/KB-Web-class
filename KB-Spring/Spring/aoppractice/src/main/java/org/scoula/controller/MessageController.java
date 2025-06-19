package org.scoula.controller;

import org.scoula.dto.MessageDTO;
import org.scoula.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping(value = "/send", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> send(@RequestBody MessageDTO message) {
		String result = messageService.sendMessage(message);
		return ResponseEntity.ok(result);
	}
}
