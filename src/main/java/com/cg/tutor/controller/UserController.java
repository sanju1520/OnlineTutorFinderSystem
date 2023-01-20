package com.cg.tutor.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tutor.dto.UserDto;
import com.cg.tutor.entity.User;
import com.cg.tutor.exception.UserNotFoundException;
import com.cg.tutor.service.UserService;

@CrossOrigin(origins="http://localhost:3000")

@RestController
public class UserController


{
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/all")
	public List<User> fetchAllUsers() {
		List<User> list = userService.getAllUsers();
		return list;
	}
	

	@GetMapping("/user/{id}")
	public ResponseEntity<User> fetchUserDetails(@PathVariable("id") int userId) throws UserNotFoundException {
		User user = userService.getUserById(userId);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/user/save")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
		UserDto newUser = userService.saveUser(userDto);
		ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		return responseEntity;
	}
	
	
	@DeleteMapping("/user/{id}")
	   public void deleteUser(@PathVariable("id") int id) 
	{
	      userService.deleteUserById(id);
	      
	}
	      
	@PutMapping("/user/update")
    public ResponseEntity<User> modifyUser(@RequestBody User user)
    {
            User updateUser = userService.updateUser(user);
            ResponseEntity<User> responseEntity = new ResponseEntity<>(updateUser,HttpStatus.OK);

        return responseEntity;
	
    }
	
	
	
	
}
