package com.cg.tutor.service;

import java.util.List;

import com.cg.tutor.dto.UserDto;
import com.cg.tutor.entity.User;
import com.cg.tutor.exception.UserNotFoundException;

public interface UserService
{
   public  UserDto saveUser(UserDto userDto);
	
	public User getUserById(int userId) throws UserNotFoundException;
	
	List<User> getAllUsers();
	
	public User updateUser(User user);
	
	public User deleteUserById(int userId);

	User saveUser(User user);

	

	
}
