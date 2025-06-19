package org.scoula.service;

import org.scoula.dto.MessageDTO;
import org.scoula.exception.PhishingDetectedException;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MessageService {

	private static final String[] BANNED_WORDS = {"계좌번호", "보안카드", "대출"};

	public String sendMessage(MessageDTO message) {
		for (String banned : BANNED_WORDS) {
			if (message.getContent().contains(banned)) {
				throw new PhishingDetectedException("보이스피싱 의심 단어 감지: " + banned);
			}
		}
		log.info("📩 메시지 전송됨: {}", message.getContent());
		return "메시지 전송 완료";
	}
}
