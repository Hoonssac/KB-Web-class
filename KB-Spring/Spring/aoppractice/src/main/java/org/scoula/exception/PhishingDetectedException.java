package org.scoula.exception;

public class PhishingDetectedException extends RuntimeException {
	public PhishingDetectedException(String message) {
		super(message);
	}
}
