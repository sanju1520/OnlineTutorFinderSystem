package com.cg.tutor.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tutor.dto.UserDto;
import com.cg.tutor.entity.User;
import com.cg.tutor.exception.UserNotFoundException;
import com.cg.tutor.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService

{

	public UserDto create(UserDto userdto) {

		User user = new User();

		user.setUsername(userdto.getUsername());

		user.setUserId(userdto.getUserId());

		user.setFirstName(userdto.getFirstName());
		
		user.setLastName(userdto.getLastName());


		user.setUserPassword(userdto.getUserPassword());

		user.setMobileNo(userdto.getMobileNo());

		user.setEmail(userdto.getEmail());

		user.setAddress(userdto.getAddress());

		
		

		 

		User newUser=userRepository.save(user);

	    UserDto newDto = new UserDto();

		newDto.setUserId(newUser.getUserId());

		newDto.setFirstName(newUser.getFirstName());
		
		newDto.setLastName(newUser.getLastName());

		newDto.setMobileNo(newUser.getMobileNo());
		
		newDto.setUsername(newUser.getUsername());
		

		newDto.setUserPassword(newUser.getUserPassword());
		
		newDto.setAddress(newUser.getAddress());

		newDto.setEmail(newUser.getEmail());

		return newDto ;

		}
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException {
		Optional<User> optionalUser =userRepository.findById(userId);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User not Found with Id"+userId);
		}
		User user= optionalUser.get();
		return user;
	}
	
	/*@Override
	public User deleteUser(User user)
	{
		User newUser = userRepository.delete(user);
		return newUser;
	}*/
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto saveUser(UserDto userdto) {
		// TODO Auto-generated method stub
		return null;
	}

	




	
}
