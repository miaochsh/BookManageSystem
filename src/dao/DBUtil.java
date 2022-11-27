package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con ;
	private static PreparedStatement ps;
	private static ResultSet rs;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DBドライバのロード成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnect() {
		String accountId = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/Mysql?serverTimezone=JST";

		try {
			if (con == null) {
				con = DriverManager.getConnection(url, accountId, password);
				System.out.println("DB接続成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void disConnect(Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
				System.out.println("Dao接続終わり");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
