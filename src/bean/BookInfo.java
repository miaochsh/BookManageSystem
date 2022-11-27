package bean;

import java.sql.Date;

public class BookInfo {
	private String bookCd;
	private String bookName;
	private String bookAuthor;
	private String borrowFlag;
	private String borrowStartTime;
	private String borrowEndTime;
	private String borrowDays;
	
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
	public String getBorrowFlag() {
		return borrowFlag;
	}
	public void setBorrowFlag(String borrowFlag) {
		this.borrowFlag = borrowFlag;
	}
	public String getBorrowStartTime() {
		return borrowStartTime;
	}
	public void setBorrowStartTime(String borrowStartTime) {
		this.borrowStartTime = borrowStartTime;
	}
	public String getBorrowEndTime() {
		return borrowEndTime;
	}
	public void setBorrowEndTime(String borrowEndTime) {
		this.borrowEndTime = borrowEndTime;
	}
	public String getBorrowDays() {
		return borrowDays;
	}
	public void setBorrowDays(String borrowDays) {
		this.borrowDays = borrowDays;
	}
	

}

