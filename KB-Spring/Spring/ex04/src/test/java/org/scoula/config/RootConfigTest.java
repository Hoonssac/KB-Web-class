package org.scoula.config;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class RootConfigTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Test
	@DisplayName("Database 연결이 된다.")
	public void dataSource() throws SQLException {
		try (Connection con = dataSource.getConnection()) {
			log.info("DataSource 준비 완료");
			log.info(con);
		}
	}

	@Test
	public void testSqlSessionFactory() {
		try (
			// MyBatis Session 열기
			SqlSession session = sqlSessionFactory.openSession();

			// Session을 통해 JDBC Connection 획득
			Connection con = session.getConnection();
		) {
			log.info(session); // Session 정보 출력
			log.info(con); // Connection 정보 출력

		} catch (Exception e) {
			fail(e.getMessage()); // 실패 시 예외 메시지 출력
		}
	}
}