package com.Security.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Security.Entity.User;
import com.Security.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@RequestBody User user)
	{
		return userService.registerNewUser(user); 
	}
	
	
	@PostMapping({"/registerNewAdminUser"})
	public User registerNewAdminUser(@RequestBody User user)
	{
		return userService.registerNewAdminUser(user); 
	}
	
	@PostConstruct
	public void initRolesAndUser()
	{
		userService.initRolesAndUser();
	}
	
	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")	
	public String forAdmin()
	{
		return "this url only accessible admin";
	}
	
	@GetMapping({"/forUser"})
	@PreAuthorize("hasRole('User')")	
	public String forUser()
	{
		return "this url only accessible user";
	}
	
}
