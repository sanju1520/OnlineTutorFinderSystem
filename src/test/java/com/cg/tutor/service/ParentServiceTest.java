package com.cg.tutor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.User;
import com.cg.tutor.exception.ParentNotFoundException;
import com.cg.tutor.repository.ParentRepository;
import com.cg.tutor.repository.UserRepository;

@SpringBootTest
public class ParentServiceTest {
	
	@InjectMocks
	private ParentServiceImpl parentService = new ParentServiceImpl();
	
	@InjectMocks
	private UserServiceImpl userService = new UserServiceImpl();
	
	
	@Mock
	private UserRepository userRepository;

	@Test
	void testGetUserById() {
		
		User user= new User();
		user.setUserId(1);
		user.setUsername("Ankita");
		user.setUserPassword("Anki");
		user.setFirstName("Ankita");
		user.setLastName("Sabale");
		user.setMobileNo("9898989898");
		user.setAddress("Mumbai");
		
		Optional<User> optionalUser = Optional.of(user);
		
		CrudRepository<User, Integer> userRepository = null;
		when(userRepository.findById(1)).thenReturn(optionalUser);
		
		Object userService;
	//	User userObj = userService.getUserById(1);
		User userObj = new User();
		
		assertEquals("Ankita",userObj.getUsername());
		assertEquals("Anki",userObj.getUserPassword());				
	}
	
/*	@Test
	public void testGetProductByIdException() {
		
		when(productRepository.findById(1020)).thenThrow(ProductNotFoundException.class);
		
		assertThrows(ProductNotFoundException.class,()->productService.getProductById(1020));
	}
	*/
	@Test
	void testGetAllUsers() {
		
		List<User> users = new ArrayList<>();
		
		User user1 = new User();
		user1.setUserId(1);
		user1.setUsername("Amruta");
		user1.setUserPassword("Amruta22");
		user1.setFirstName("Amruta");
		user1.setLastName("Patil");
		user1.setMobileNo("9892289338");
		user1.setAddress("Delhi");

		User user2 = new User();
		user2.setUserId(1);
		user2.setUsername("Pooja");
		user2.setUserPassword("Pooja22");
		user2.setFirstName("Pooja");
		user2.setLastName("More");
		user2.setMobileNo("9898989338");
		user2.setAddress("Pune");
		
		
		User user3= new User();
		user3.setUserId(1);
		user3.setUsername("Kirti");
		user3.setUserPassword("Kirti22");
		user3.setFirstName("Kirti");
		user3.setLastName("Khan");
		user3.setMobileNo("9822989338");
		user3.setAddress("Agra");

		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	
		when(userRepository.findAll()).thenReturn(users);
		
		List<User> userList = userService.getAllUsers();
		
		assertEquals(3,userList.size());				
	}
	
	@Test
	public void testDeleteUser() {
		
		User user = new User();
		user.setUserId(1234);
		user.setUsername("Ankita");
		user.setUserPassword("Anki@88");
		user.setFirstName("Ankita");
		user.setLastName("Sabale");
		user.setMobileNo("email");
		user.setAddress("Mumbai");
		
		
		Optional<User> optionalProduct = Optional.of(user);
		
		when(userRepository.findById(1234)).thenReturn(optionalProduct);
		
		doNothing().when(userRepository).deleteById(1234);
		
		userService.deleteUserById(1234);
		
		verify(userRepository,times(1)).findById(1234);
		verify(userRepository,times(1)).deleteById(1234);
	}
	
	@Test
    void testSaveUser() {
		User user = new User();
		user.setUserId(1234);
		user.setUsername("Ankita");
		user.setUserPassword("Anki");
		user.setFirstName("Ankita");
		user.setLastName("Sabale");
		user.setMobileNo("7878787878");
		
		when(userRepository.save(user)).thenReturn(user);
		
		User newUser = userService.saveUser(user);
		
		assertEquals("Ankita",newUser.getUsername());
		
    }
}