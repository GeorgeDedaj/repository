package com.george.repository;

import org.springframework.data.repository.CrudRepository;

import com.george.model.BookInventory;

public interface BookInventoryRepository extends CrudRepository<BookInventory, Long> {

}
