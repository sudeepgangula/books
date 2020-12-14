package com.example.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.entities.Book;
import com.example.books.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping("/add")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@PostMapping("/update")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}

	@GetMapping("/name")
	public Book getBook(@RequestParam String bookName) {
		return bookService.getBook(bookName);
	}

	@GetMapping("/id")
	public Book getBook(@RequestParam Long bookId) {
		return bookService.getBook(bookId);
	}

	@GetMapping("/availableBooks")
	public List<Book> getAvailableBooks() {
		return bookService.getAvailableBooks();
	}

	@PostMapping("/deallocateBook")
	public void deallocateBook(@RequestParam Long bookId) {
		bookService.deallocateBook(bookId);
	}

	@PostMapping("/allocateBook")
	public void allocateBook(@RequestParam Long bookId) {
		bookService.allocateBook(bookId);
	}

	@DeleteMapping
	public void deleteBook(@RequestParam Long bookId) {
		bookService.deleteBook(bookId);
	}
}
