package org.scoula.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PhishingDetectedException.class)
	public ResponseEntity<String> handlePhisingException(PhishingDetectedException ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain; charset=UTF-8");
		return new ResponseEntity<>(ex.getMessage(), headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain; charset=UTF-8");
		return new ResponseEntity<>("서버 오류가 발생했습니다.", headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
