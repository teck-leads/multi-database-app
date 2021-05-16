package com.techleads.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Users;
import com.techleads.app.service.UserService;

@RestController
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(value = "/orausers")
	public List<Users> findAllOraUsers(){
		List<Users> oraUsers = userService.findAllOraUsers();
		return oraUsers;
	}
	@GetMapping(value = "/h2users")
	public List<Users> findAllH2Users(){
		List<Users> h2Users = userService.findAllH2Users();
		return h2Users;
	}
}
