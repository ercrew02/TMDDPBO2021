package model;

import java.sql.*;

public class DB {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tmddpbo2021";
	// menyambunghkan ke database
	static final String USER = "root";
	static final String PASS = "";
	static Statement stmt;
	static ResultSet rs;
	static Connection conn;

	public DB() throws Exception, SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			// membuat koneksi MYSQL dan basis data
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			throw e;
		}
	}

	// CRUD
	public void createQuery(String query) throws Exception, SQLException {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public void createUpdate(String query) throws Exception, SQLException {
		try {
			stmt = conn.createStatement();
			int hasil = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw e;
		}
	}

	public ResultSet getResult() throws Exception, SQLException {
		ResultSet temp = null;
		try {
			return rs;
		} catch (Exception ex) {
			return temp;
		}
	}

	public void closeResult() throws Exception, SQLException {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				rs = null;
				throw e;
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				stmt = null;
				throw e;
			}
		}
	}

	public void closeConnection() throws Exception, SQLException {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				conn = null;
				throw e;
			}
		}
	}
}