package org.scoula.security.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class, SecurityConfig.class })
@Log4j2
class JwtProcessorTest {

	@Autowired
	JwtProcessor jwtProcessor;

	@Test
	void generateToken() {
		String username = "user0";
		String token = jwtProcessor.generateToken(username);
		log.info(token);
		assertNotNull(token);
	}

	@Test
	void validateToken() {
		String username = "user0";
		String token = jwtProcessor.generateToken(username);
		boolean isValid = jwtProcessor.validateToken(token);
		log.info(isValid);
		assertTrue(isValid);
	}
}