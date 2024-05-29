package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDto;
import com.app.dto.UserDto;
import com.app.entity.User;
import com.app.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public String addUser(@RequestBody UserDto userDto) {
		return userService.newUser(userDto);
	}
	
	@PutMapping("/updateuser/{id}")
	public String updateUser(@PathVariable int id,UserDto userDto) {
		boolean updated=userService.editUser(id,userDto);
		if(updated) {
			return "Updated successfully";
		}else {
			return "Not found";
		}
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody LoginDto loginDto) {
		return userService.userLogin(loginDto);
	}
	
	@GetMapping("/getById/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getById(id);
	}
	
	
}
