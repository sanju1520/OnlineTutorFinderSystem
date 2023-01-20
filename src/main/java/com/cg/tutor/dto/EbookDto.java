package com.cg.tutor.dto;

public class EbookDto {
	private int bookId;
	private String bookName;
	private String author;
	private ParentDto parentDto;
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public ParentDto getParentDto() {
		return parentDto;
	}
	public void setParentDto(ParentDto parentDto) {
		this.parentDto = parentDto;
	}
	
	
}
