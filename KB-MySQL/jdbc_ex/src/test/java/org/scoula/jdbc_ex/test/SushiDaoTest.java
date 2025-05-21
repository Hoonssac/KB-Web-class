package org.scoula.jdbc_ex.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.dao.SushiDao;
import org.scoula.jdbc_ex.dao.SushiDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SushiDaoTest {
	Connection conn;
	SushiDao dao;

	@BeforeEach
	void setUp() throws SQLException {
		conn = JDBCUtil.getConnection();
		dao = new SushiDaoImpl(conn);
		conn.createStatement().executeUpdate("DELETE FROM sushi_log");
		conn.createStatement().executeUpdate("DELETE FROM customer");

		dao.insertCustomer("cust01", "김초밥");
		dao.insertSushiLog("cust01", "red");
		dao.insertSushiLog("cust01", "blue");
		dao.insertSushiLog("cust01", "gold");

	}

	@Test
	@DisplayName("모든 customer를 조회한다.")
	@Order(1)
	public void selectUser() throws SQLException {
		String sql = "select * from customer";
		try (Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
		) {
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		}
	}

	@Test
	@DisplayName("고객의 접시 기록을 콘솔에 출력한다")
	void testPrintSushiLogByCustomer() throws SQLException {
		dao.printSushiLogByCustomer("cust01");
	}
}
