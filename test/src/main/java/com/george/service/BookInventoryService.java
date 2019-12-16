package com.george.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.george.model.BookInventory;
import com.george.repository.BookInventoryRepository;

@Service
public class BookInventoryService {
	
	@Autowired
	private BookInventoryRepository bookInventoryRepository;
	
	public List<BookInventory> getAllBookInventories()
	{
		List<BookInventory> bookInventories = new ArrayList<>();
		Iterable<BookInventory> bookInventoryIt = bookInventoryRepository.findAll();
		bookInventoryIt.forEach(bookInventories::add);

		return bookInventories;
	}
	
	public BookInventory addBookInventory(BookInventory bookInventory)
	{
		System.out.println("LibraryService.addBookInventory: the value of bookInventory is " + bookInventory);
		BookInventory retBookInventory = bookInventoryRepository.save(bookInventory);
		return retBookInventory;
	}
	
	public BookInventory getBookInventory(long id)
	{
		Optional<BookInventory> bookInventory = bookInventoryRepository.findById(id);
		return bookInventory.orElse(new BookInventory());
	}
	
	public BookInventory updateBookInventory(BookInventory bookInventory)
	{
		BookInventory retBookInventory = bookInventoryRepository.save(bookInventory);
		return retBookInventory;
	}
	
	public void delete (long id)
	{
		bookInventoryRepository.deleteById(id);
	}

	public BookInventory processBook(BookInventory bookInventory, String actionCode) {
		BookInventory retBookInventory = null;
		int availableNoOfCopies = bookInventory.getAvailableNoOfCopies();
		if(actionCode.equalsIgnoreCase("Borrow"))
		{
			availableNoOfCopies--;

		}
		else if(actionCode.equalsIgnoreCase("Return"))
		{
			availableNoOfCopies++;

		}
		if(availableNoOfCopies < 0)
		{
			//Handle error!!!
		}
		else
		{
			bookInventory.setAvailableNoOfCopies(availableNoOfCopies);
			retBookInventory = bookInventoryRepository.save(bookInventory);
		}
		return retBookInventory;
	}
}
