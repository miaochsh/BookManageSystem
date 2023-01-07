package action;

import java.sql.SQLException;
import java.text.ParseException;
import bean.BookInfo;

import com.opensymphony.xwork2.ActionSupport;
import dao.BookListsDao;

public class BookChangeAction extends ActionSupport {
	private BookInfo bookInfo;
	
	private String bookCd;
	
	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	
	public String getBookCd() {
		return bookCd;
	}

	public void setBookCd(String bookCd) {
		this.bookCd = bookCd;
	}

	public String goInit() throws SQLException {
		BookListsDao bookListsDao = new BookListsDao();
		bookInfo = bookListsDao.getUpdateBook(bookCd);
		return "success";
	}
	
	public String goChange() throws SQLException, ParseException {		
		BookListsDao bookListsDao = new BookListsDao();
		bookListsDao.borrowBooksChange(bookInfo.getBookCd(),bookInfo.getBorrowStartTime(),bookInfo.getBorrowDays());
		return "success";
	}
	
	public String goReturn(){		
		return "success";
	}
}
