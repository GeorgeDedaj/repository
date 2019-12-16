package com.george.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.george.model.User;
import com.george.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		List<User> users = new ArrayList<>();
		Iterable<User> userIt = userRepository.findAll();
		userIt.forEach(users::add);

		return users;
	}
	
	public User addUser(User user)
	{
		System.out.println("LibraryService.addUser: the value of user is " + user);
		User retUser = userRepository.save(user);
		return retUser;
	}
	
	public User getUser(long id)
	{
		Optional<User> user = userRepository.findById(id);
		return user.orElse(new User());
	}
	
	public User updateUser(User user)
	{
		User retUser = userRepository.save(user);
		return retUser;
	}
	
	public void delete (long id)
	{
		userRepository.deleteById(id);
	}
}
