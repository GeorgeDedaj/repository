package com.george.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.george.model.User;
import com.george.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		List<User> users = service.getAllUsers();
		return users;
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") long userId)
	{
		User user = service.getUser(userId);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public User addUser(@RequestBody User user)
	{
		return service.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") long userId)
	{
		user.setUserId(userId);
		return service.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteUser(@PathVariable("id") long userId)
	{
		service.delete(userId);
	}
}
