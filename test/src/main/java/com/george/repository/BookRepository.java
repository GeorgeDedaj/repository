package com.george.repository;

import org.springframework.data.repository.CrudRepository;

import com.george.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	public Iterable<Book> findAllByAuthor(String author);
}
