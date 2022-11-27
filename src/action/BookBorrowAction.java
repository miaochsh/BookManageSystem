package action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import bean.BookInfo;
import dao.BookListsDao;

public class BookBorrowAction extends ActionSupport {
	private String bookCd;
	private String bookName;
	private String bookAuthor;

	private ArrayList<BookInfo> booksInfoList;

	public ArrayList<BookInfo> getBooksInfoList() {
		return booksInfoList;
	}

	public void setBooksInfoList(ArrayList<BookInfo> booksInfoList) {
		this.booksInfoList = booksInfoList;
	}

	public String getBookCd() {
		return bookCd;
	}

	public void setBookCd(String bookCd) {
		this.bookCd = bookCd;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String search() throws SQLException {
		BookListsDao bookListsDao = new BookListsDao();
		booksInfoList = bookListsDao.getAllBooks(bookCd, bookName, bookAuthor);
		return "success";
	}

}
