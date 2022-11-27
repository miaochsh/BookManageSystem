package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.BookInfo;
import dao.BookListsDao;

public class BookListsAction extends ActionSupport {
	private String bookName;
	private ArrayList<BookInfo> booksInfoList;

	public ArrayList<BookInfo> getBooksInfoList() {
		return booksInfoList;
	}

	public void setBooksInfoList(ArrayList<BookInfo> booksInfoList) {
		this.booksInfoList = booksInfoList;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String search() throws SQLException {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String accountId = String.valueOf(session.get("accountId"));

		BookListsDao bookListsDao = new BookListsDao();
		booksInfoList = bookListsDao.getLendBooks(accountId, bookName);
		return "success";
	}

	public String toShow() throws SQLException {
		return "success";
	}
}
