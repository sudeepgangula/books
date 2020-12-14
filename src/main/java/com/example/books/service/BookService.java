package com.example.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.books.entities.Book;
import com.example.books.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void updateBook(Book book) {
		Book savedBook = bookRepository.findById(book.getBookId()).get();
		savedBook.setTotalCopies(book.getTotalCopies() + savedBook.getTotalCopies());
		savedBook.setAvailableCopies(book.getTotalCopies() + savedBook.getAvailableCopies());
		bookRepository.save(savedBook);
	}

	public Book getBook(String bookName) {
		return bookRepository.findByName(bookName);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public List<Book> getAvailableBooks() {
		return bookRepository.findAvailableBooks();
	}

	public void deallocateBook(@RequestParam Long bookId) {
		Book savedBook = bookRepository.findById(bookId).get();
		savedBook.setAvailableCopies(savedBook.getAvailableCopies() + 1);
		bookRepository.save(savedBook);
	}

	public void allocateBook(@RequestParam Long bookId) {
		Book savedBook = bookRepository.findById(bookId).get();
		savedBook.setAvailableCopies(savedBook.getAvailableCopies() - 1);
		bookRepository.save(savedBook);
	}

	public Book getBook(Long bookId) {
		return bookRepository.findById(bookId).get();
	}

	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}

}
