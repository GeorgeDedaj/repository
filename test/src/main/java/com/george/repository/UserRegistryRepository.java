package com.george.repository;

import org.springframework.data.repository.CrudRepository;

import com.george.model.UserRegistry;

public interface UserRegistryRepository extends CrudRepository<UserRegistry, Long> {

}
