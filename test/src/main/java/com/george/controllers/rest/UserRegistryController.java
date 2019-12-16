package com.george.controllers.rest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.george.model.UserRegistry;
import com.george.service.UserRegistryService;

@RestController
public class UserRegistryController {

	@Autowired
	private UserRegistryService service;
	
	@GetMapping("/userRegistries")
	public List<UserRegistry> getAllUserRegistries()
	{
		List<UserRegistry> userRegistries = service.getAllUserRegistries();
		return userRegistries;
	}
	
	@GetMapping("/userRegistries/{id}")
	public UserRegistry getUserRegistry(@PathVariable("id") long userRegistryId)
	{
		UserRegistry userRegistry = service.getUserRegistry(userRegistryId);
		return userRegistry;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/userRegistries")
	public UserRegistry addUserRegistry(@RequestBody UserRegistry userRegistry)
	{
		
		return service.addUserRegistry(userRegistry);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/userRegistries/{id}")
	public UserRegistry updateUserRegistry(@RequestBody UserRegistry userRegistry, @PathVariable("id") long userRegistryId)
	{
		userRegistry.setUserRegistryId(userRegistryId);
		return service.updateUserRegistry(userRegistry);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/userRegistries/{id}")
	public void deleteUserRegistry(@PathVariable("id") long userRegistryId)
	{
		service.delete(userRegistryId);
	}
}
