package com.example.books.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	private String bookName;
	private String author;
	private Long availableCopies;
	private Long totalCopies;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
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

	public Long getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Long availableCopies) {
		this.availableCopies = availableCopies;
	}

	public Long getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(Long totalCopies) {
		this.totalCopies = totalCopies;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", availableCopies="
				+ availableCopies + ", totalCopies=" + totalCopies + "]";
	}

}
