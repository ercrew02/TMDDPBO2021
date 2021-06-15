package model;

import java.sql.*;

public class ResultPengguna extends DB {
	public ResultPengguna() throws Exception, SQLException {
		// mengahsilkan data pengguna
		super();
	}

	public void getPengguna() throws Exception, SQLException {
		try {
			String query = "SELECT * FROM player";
			createQuery(query);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void insertPengguna(String nama, String fail, String success) throws Exception, SQLException {
		// memasukan data pengguna
		try {
			String query = "INSERT INTO `player` (`username`, `scorefail`, `scoresuccess`) VALUES ('" + nama + "', '"
					+ fail + "', '" + success + "');";
			createUpdate(query);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}