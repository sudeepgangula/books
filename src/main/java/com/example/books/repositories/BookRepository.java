package com.example.books.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.books.entities.Book;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "select * from Book where book_name = :bookName", nativeQuery = true)
	Book findByName(String bookName);

	@Query(value = "select * from Book where available_copies > 0", nativeQuery = true)
	List<Book> findAvailableBooks();

}
