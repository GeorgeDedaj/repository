package com.george.controllers.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.george.model.Book;
import com.george.service.BookService;

@Controller
public class BookAddSearchController {
	@Autowired
	private BookService bookService;
	
	/*
	 * @RequestMapping("/") public String home() { return "home"; }
	 */	
	
	@RequestMapping("/addBookForm")
	public String add(Book book)
	{
		return "/book/add";
	}
	
	@RequestMapping("/addBook")
	public String addBook(Book book)
	{
		bookService.addBook(book);
		
		return "/book/add";
	}
	
	@RequestMapping("/findBookForm")
	public String find(Book book)
	{
		return "/book/find";
	}
	
	@RequestMapping("/findBook")
	public ModelAndView findBook(@RequestParam(value="id", required = false) Long id,
			@RequestParam(value="author", required = false) String author)
	{
		ModelAndView mv = (id !=  null) || (author !=  null) ? 
				new ModelAndView("/book/display") : null;
		if(id !=  null)
		{
			System.out.println("The value of id is " + id);			
			Book book = bookService.getBook(id);
			System.out.println("The value of book is " + book);
			mv.addObject("book", book);
		}
		if(author !=  null)
		{
			System.out.println("The value of author is " + author);
			List<Book> books = bookService.getAllBooksByAuthor(author);
			System.out.println("The value of books is " + books);
			mv.addObject("books", books);
		}

		return mv;
	}
}
