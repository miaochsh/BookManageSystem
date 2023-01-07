package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.BookInfo;
import dao.BookListsDao;

public class BookBorrowAction extends ActionSupport {
	private String bookCd;
	private String bookName;
	private String bookAuthor;
	private String borrowDays;

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

	public String getBorrowDays() {
		return borrowDays;
	}

	public void setBorrowDays(String borrowDays) {
		this.borrowDays = borrowDays;
	}

	public String search() throws SQLException {
		BookListsDao bookListsDao = new BookListsDao();
		booksInfoList = bookListsDao.getAllBooks(bookCd, bookName, bookAuthor);
		return "success";
	}
	
	public String borrow() throws SQLException {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		String accountId = String.valueOf(session.get("accountId"));
		BookListsDao bookListsDao = new BookListsDao();
		bookListsDao.borrowBooksUpdate(accountId,bookCd,borrowDays);
		return "success";
	}
	
}
