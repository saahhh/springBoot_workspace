package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionProvider {
	private static final String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; //static final써서 빼와서 사용 가능
	private static final String jdbcUser = "khaca";
	private static final String jdbcPasswod = "kh1234";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPasswod);
	}
}
