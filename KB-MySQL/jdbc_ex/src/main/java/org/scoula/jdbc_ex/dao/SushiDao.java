package org.scoula.jdbc_ex.dao;

import java.sql.SQLException;

public interface SushiDao {
	// 고객 등록 기능
	int insertCustomer(String id, String name) throws SQLException;

	// 접시 기록 기능
	int insertSushiLog(String customerId, String plateColor) throws SQLException;

	// 접시 기록 출력
	void printSushiLogByCustomer(String customerId) throws SQLException;
}
