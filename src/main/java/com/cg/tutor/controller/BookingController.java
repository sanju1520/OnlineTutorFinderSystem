package com.cg.tutor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tutor.dto.BookingDto;
import com.cg.tutor.dto.BookingReq;
import com.cg.tutor.service.BookingService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService; 
	
	@PostMapping("/save")
	public ResponseEntity<BookingDto> addNewBooking(@RequestBody BookingReq bookingReq){
		BookingDto newBooking=bookingService.saveBookingDetails(bookingReq);
		ResponseEntity<BookingDto> responseEntity = new ResponseEntity<>(newBooking, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/all") //retrieving data from database
	public List<BookingDto> fetchAllBookingDetails() {
		List<BookingDto> list = bookingService.getAllBookingDetails();
		return list;
	}
		
	@GetMapping("/parent/{parentId}") //retrieving data from database
	public List<BookingDto> fetchAllParentBookings(@PathVariable int parentId) {
		List<BookingDto> list = bookingService.getAllBookingsByParent(parentId);
		return list;
	}
	
	@GetMapping("/tutor/{tutorId}") //retrieving data from database
	public List<BookingDto> fetchAllTutorBookings(@PathVariable int tutorId) {
		List<BookingDto> list = bookingService.getAllBookingsByTutor(tutorId);
		return list;
	}	
	
	@GetMapping("booking/{bookingId}")

	public BookingDto fetchBookingDetails(@PathVariable ("bookingId") int bookingId){

	BookingDto booking1=bookingService.getBookingDetails(bookingId);

	return booking1;

	}
}
