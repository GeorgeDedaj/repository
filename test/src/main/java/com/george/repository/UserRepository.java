package com.george.repository;

import org.springframework.data.repository.CrudRepository;

import com.george.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
