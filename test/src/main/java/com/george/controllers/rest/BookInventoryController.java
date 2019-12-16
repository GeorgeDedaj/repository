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

import com.george.model.BookInventory;
import com.george.service.BookInventoryService;

@RestController
public class BookInventoryController {

	@Autowired
	private BookInventoryService service;
	
	@GetMapping("/bookInventories")
	public List<BookInventory> getAllBookInventories()
	{
		List<BookInventory> bookInventories = service.getAllBookInventories();
		return bookInventories;
	}
	
	@GetMapping("/bookInventories/{id}")
	public BookInventory getBookInventory(@PathVariable("id") long bookInventoryId)
	{
		BookInventory bookInventory = service.getBookInventory(bookInventoryId);
		return bookInventory;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/bookInventories")
	public BookInventory addBookInventory(@RequestBody BookInventory bookInventory)
	{
		return service.addBookInventory(bookInventory);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/bookInventories/{id}")
	public BookInventory updateBookInventory(@RequestBody BookInventory bookInventory, @PathVariable("id") long bookInventoryId)
	{
		bookInventory.setUniqueId(bookInventoryId);
		return service.updateBookInventory(bookInventory);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/bookInventories/{id}")
	public void deleteBookInventory(@PathVariable("id") long bookInventoryId)
	{
		service.delete(bookInventoryId);
	}
}
