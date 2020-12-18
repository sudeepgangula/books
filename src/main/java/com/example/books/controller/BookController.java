package com.example.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.entities.Book;
import com.example.books.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public List<Book> getAllBooks(@RequestParam(required = false) String bookName,
			@RequestParam(required = false) Long bookId) {
		List<Book> list = new ArrayList<Book>();

		if (null != bookId) {
			list.add( bookService.getBook(bookId));
			return list;
		} else if (null != bookName) {
			list.add(bookService.getBook(bookName));
			return list;
		} else {
			return bookService.getAllBooks();
		}
	}

	@PostMapping("/addBook")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@PostMapping("/updateBook")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
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

	@DeleteMapping("/books")
	public void deleteBook(@RequestParam Long bookId) {
		bookService.deleteBook(bookId);
	}
}
