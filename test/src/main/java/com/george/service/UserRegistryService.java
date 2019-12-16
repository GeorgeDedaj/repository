package com.george.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.george.model.UserRegistry;
import com.george.repository.UserRegistryRepository;

@Service
public class UserRegistryService {
	
	@Autowired
	private UserRegistryRepository userRegistryRepository;
	
	public List<UserRegistry> getAllUserRegistries()
	{
		Iterable<UserRegistry> userRegistryIt = userRegistryRepository.findAll();
		
		/*
		List<UserRegistry> userRegistries = new ArrayList<>();
		userRegistryIt.forEach(userRegistries::add);
		*/
		
		System.out.println("The value of userRegistryIt is " + userRegistryIt);
		List<UserRegistry> userRegistries = StreamSupport.stream(userRegistryIt.spliterator(), false)
				    .collect(Collectors.toList());

		return userRegistries;
	}
	
	public UserRegistry addUserRegistry(UserRegistry userRegistry)
	{
		System.out.println("LibraryService.addUserRegistry: the value of userRegistry is " + userRegistry);
		UserRegistry retUserRegistry = userRegistryRepository.save(userRegistry);
		return retUserRegistry;
	}
	
	public UserRegistry getUserRegistry(long id)
	{
		Optional<UserRegistry> userRegistry = userRegistryRepository.findById(id);
		return userRegistry.orElse(new UserRegistry());
	}
	
	public UserRegistry updateUserRegistry(UserRegistry userRegistry)
	{
		UserRegistry retUserRegistry = userRegistryRepository.save(userRegistry);
		return retUserRegistry;
	}
	
	public void delete (long id)
	{
		userRegistryRepository.deleteById(id);
	}
}
