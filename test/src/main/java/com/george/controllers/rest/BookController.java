package com.george.controllers.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.george.model.Book;
import com.george.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(@PathParam("author") String author)
	{
		List<Book> books = service.getAllBooks();
		if(author != null && !author.isEmpty())
		{
			books = service.getAllBooksByAuthor(author);
		}
		return books;
	}
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") long bookId)
	{
		Book book = service.getBook(bookId);
		return book;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/books")
	public Book addBook(@RequestBody Book book)
	{
		return service.addBook(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") long bookId)
	{
		book.setUniqueId(bookId);
		return service.updateBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/books/{id}")
	public void deleteBook(@PathVariable("id") long bookId)
	{
		service.delete(bookId);
	}
}
