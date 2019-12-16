package com.george.controllers.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.george.service.BookInventoryService;
import com.george.model.BookInventory;

@Controller
public class BookProcessorController {
	@Autowired
	private BookInventoryService bookInventoryService;
	
	@RequestMapping("/checkinBookForm")
	public String checkin(BookInventory bookInventory)
	{		
		return "/bookProcessor/checkin";
	}
	
	@RequestMapping("/checkIn")
	public String checkinBook(@RequestParam(value="id", required = false) Long id)
	{
		BookInventory bookInventory = bookInventoryService.getBookInventory(id);
		int availableNoOfCopies = bookInventory.getAvailableNoOfCopies();
		int totalNoOfCopies = bookInventory.getTotalNoOfCopies();
		availableNoOfCopies++;
		if(availableNoOfCopies > totalNoOfCopies)
		{
			throw new IllegalStateException("The available number of copies (" + availableNoOfCopies + ") is already at least equal to the total number (" + totalNoOfCopies + ") of copies.");
		}
		bookInventory.setAvailableNoOfCopies(availableNoOfCopies);
		bookInventoryService.addBookInventory(bookInventory);
		
		return "/bookProcessor/checkin";
	}
	
	@RequestMapping("/checkoutBookForm")
	public String checkout(BookInventory bookInventory)
	{		
		return "/bookProcessor/checkout";
	}
	
	@RequestMapping("/checkOut")
	public String checkoutBook(@RequestParam(value="id", required = false) Long id)
	{
		BookInventory bookInventory = bookInventoryService.getBookInventory(id);
		int availableNoOfCopies = bookInventory.getAvailableNoOfCopies();
		availableNoOfCopies--;
		if(availableNoOfCopies < 0)
		{
			throw new IllegalStateException("Cannot check out this copy because the available number of copies is (" + availableNoOfCopies + ")");
		}

		bookInventory.setAvailableNoOfCopies(availableNoOfCopies);
		bookInventoryService.addBookInventory(bookInventory);
		
		return "/bookProcessor/checkout";
	}
}
