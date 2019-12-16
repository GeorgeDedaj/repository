package com.george.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.george.model.Book;
import com.george.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks()
	{
		List<Book> books = new ArrayList<>();
		Iterable<Book> bookIt = bookRepository.findAll();
		bookIt.forEach(books::add);

		return books;
	}
	
	public List<Book> getAllBooksByAuthor(String author)
	{
		Iterable<Book> bookIterable = bookRepository.findAllByAuthor(author);
		/*
		 * List<Book> books = new ArrayList<>();
		 * bookIterable.forEach(books::add);
		 */

		List<Book> books = StreamSupport.stream(bookIterable.spliterator(), false)
			    .collect(Collectors.toList());
		
		return books;
	}
	
	public Book addBook(Book book)
	{
		System.out.println("LibraryService.addBook: the value of book is " + book);
		Book retBook = bookRepository.save(book);
		return retBook;
	}
	
	public Book getBook(long id)
	{
		Optional<Book> book = bookRepository.findById(id);
		return book.orElse(new Book());
	}
	
	public Book updateBook(Book book)
	{
		Book retBook = bookRepository.save(book);
		return retBook;
	}
	
	public void delete (long id)
	{
		bookRepository.deleteById(id);
	}
}
