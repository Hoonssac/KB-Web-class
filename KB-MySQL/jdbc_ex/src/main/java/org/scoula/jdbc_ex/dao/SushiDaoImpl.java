package org.scoula.jdbc_ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.scoula.jdbc_ex.common.JDBCUtil;

public class SushiDaoImpl implements SushiDao {
	Connection conn = JDBCUtil.getConnection();

	private static final String INSERT_CUSTOMER = "INSERT INTO customer (id, name) VALUES (?, ?)";
	private static final String INSERT_SUSHI_LOG = "INSERT INTO sushi_log (customer_id, plate_color) VALUES (?, ?)";
	private static final String SELECT_SUSHI_LOG = "SELECT * FROM sushi_log WHERE customer_id = ? order by eaten_at desc";

	@Override
	public int insertCustomer(String id, String name) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement(INSERT_CUSTOMER)) {
			stmt.setString(1, id);
			stmt.setString(2, name);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int insertSushiLog(String customerId, String plateColor) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement(INSERT_SUSHI_LOG)) {
			stmt.setString(1, String.valueOf(customerId));
			stmt.setString(2, plateColor);
			return stmt.executeUpdate();
		}
	}

	@Override
	public void printSushiLogByCustomer(String customerId) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement(SELECT_SUSHI_LOG)) {
			stmt.setString(1, customerId);
			try (ResultSet rs = stmt.executeQuery()) {
				System.out.println("[고객 ID: cust01] 의 접시 기록:");
				while (rs.next()) {
					System.out.println(
						rs.getInt("id") + ". " +
							rs.getString("plate_color") + "\t" + "(" +
							rs.getTimestamp("eaten_at") + ")"
					);
				}
			}
		}
	}

	public SushiDaoImpl(Connection conn) {
		this.conn = conn;
	}
}
