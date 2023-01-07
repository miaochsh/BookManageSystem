package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class LoginDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public LoginDao() {
		super();
	}

	public User getUser(String id) throws SQLException {
		User us = new User();

		con = DBUtil.getConnect();

		String sql = "select * from book_manage_db.userinfo where accountId =?";
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
			us.setAccountId(rs.getString("accountId"));
			us.setPassword(rs.getString("password"));
			return us;
		}
		;
		return null;
	}

}
