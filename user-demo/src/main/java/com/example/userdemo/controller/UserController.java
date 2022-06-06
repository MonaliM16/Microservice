package com.example.userdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userdemo.ValueObject.ResponseTemplateObject;
import com.example.userdemo.entity.UserEntity;
import com.example.userdemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
		return new ResponseEntity<UserEntity>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateObject getUser(@PathVariable int id) {
		return userService.getUser(id);
		
	}

}

