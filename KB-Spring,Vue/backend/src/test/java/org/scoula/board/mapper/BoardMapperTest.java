package org.scoula.board.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;

	@Test
	void create() {
		for (int i = 0; i < 130; i++) {
			BoardVO board = BoardVO.builder()
				.title("페이지 데이터 " + i)
				.writer((i % 2 == 0) ? "admin" : "user0")
				.content("메시지 내용 " + i)
				.build();

			mapper.create(board);
		}
	}
}