package com.george.controllers.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.george.model.UserRegistry;
import com.george.service.UserRegistryService;

@Controller
public class UserRegistryWebController {	
	@Autowired
	private UserRegistryService userRegistryService;
	
	@RequestMapping("/addUserRegistryForm")
	public String add(UserRegistry userRegistry)
	{
		return "/userRegistry/add";
	}
	
	@RequestMapping("/addUserRegistry")
	public String addUserRegistry(/*UserRegistry userRegistry*/
			@RequestParam(value="issueDate", required = false) String issueDateStr,
			@RequestParam(value="returnDate", required = false) String returnDateStr) throws ParseException
	{
		System.out.println("The value of issueDate is " + issueDateStr);
		System.out.println("The value of returnDate is " + returnDateStr);
		
		Date issueDate = new SimpleDateFormat("yyyy-MM-dd").parse(issueDateStr);  		
		Date returnDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDateStr);  
		UserRegistry userRegistry = new UserRegistry(-1, issueDate, returnDate);

		userRegistryService.addUserRegistry(userRegistry);
		
		return "/userRegistry/add";
	}
	
	@RequestMapping("/findUserRegistries")
	public ModelAndView findUsers()
	{
		ModelAndView mv = new ModelAndView("/userRegistry/display");
		
		List<UserRegistry> userRegistries = userRegistryService.getAllUserRegistries();
		System.out.println("The value of books is " + userRegistries);
		mv.addObject("userRegistries", userRegistries);

		return mv;
	}
}
