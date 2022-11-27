package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.BookInfo;

public class BookListsDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public BookListsDao() {
		super();
		this.con = DBUtil.getConnect();
	}

	public ArrayList<BookInfo> getLendBooks(String accountId, String bookName) throws SQLException {

		ArrayList<BookInfo> list = new ArrayList<BookInfo>();

		String sql = "select * from book_manage_db.bookinfo where borrowUser = ? ";
		if (bookName != null && !bookName.isEmpty()) {
			sql = sql + "AND bookName like '%" + bookName + "%'";
		}
		ps = con.prepareStatement(sql);
		ps.setString(1, accountId);

		rs = ps.executeQuery();

		while (rs.next()) {
			BookInfo bkinfo = new BookInfo();

			bkinfo.setBookCd(rs.getString("bookCd"));
			bkinfo.setBookName(rs.getString("bookName"));
			bkinfo.setBookAuthor(rs.getString("bookAuthor"));
			bkinfo.setBorrowFlag(rs.getString("borrowFlag"));
			bkinfo.setBorrowStartTime(stringTodateHMS(rs.getTimestamp("borrowStartTime")));
			bkinfo.setBorrowEndTime(stringTodateHMS(rs.getTimestamp("borrowEndTime")));
			bkinfo.setBorrowDays(String.valueOf(rs.getInt("borrowDays")));

			list.add(bkinfo);
		}
		return list;
	}

	public ArrayList<BookInfo> getAllBooks(String bookCd, String bookName, String bookAuthor) throws SQLException {

		ArrayList<BookInfo> list = new ArrayList<BookInfo>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from book_manage_db.bookinfo where 1=1 ");
		if (bookCd != null && !bookCd.isEmpty()) {
			sql.append("AND bookCd = '" + bookCd + "'");
		}
		if (bookName != null && !bookName.isEmpty()) {
			sql.append("AND bookName like '%" + bookName + "%'");
		}
		if (bookAuthor != null && !bookAuthor.isEmpty()) {
			sql.append("AND bookAuthor like '%" + bookAuthor + "%'");
		}
		sql.append(" order by borrowFlag");
		ps = con.prepareStatement(sql.toString());
		rs = ps.executeQuery();

		while (rs.next()) {
			BookInfo bkinfo = new BookInfo();

			bkinfo.setBookCd(rs.getString("bookCd"));
			bkinfo.setBookName(rs.getString("bookName"));
			bkinfo.setBookAuthor(rs.getString("bookAuthor"));
			bkinfo.setBorrowFlag(rs.getString("borrowFlag"));
			bkinfo.setBorrowStartTime(stringTodateHMS(rs.getTimestamp("borrowStartTime")));
			bkinfo.setBorrowEndTime(stringTodateHMS(rs.getTimestamp("borrowEndTime")));
			bkinfo.setBorrowDays(rs.getInt("borrowDays") == 0 ? "" : String.valueOf(rs.getInt("borrowDays")));

			list.add(bkinfo);
		}
		return list;
	}

	/*public void borrowBooksUpdate(String accountId, String bookCd, String borrowDays) throws SQLException {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currdate = format.format(d);

		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, Integer.parseInt(borrowDays));
		d = ca.getTime();
		String enddate = format.format(d);
	}*/

	private String stringTodateHMS(Timestamp time) {
		if (time == null) {
			return "";
		}
		Date time1 = new Date(time.getTime());
		SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pubtime = formattime.format(time1);

		return pubtime;
	}
}
