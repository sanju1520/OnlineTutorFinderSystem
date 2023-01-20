package com.cg.tutor.service;

import java.util.List;

import com.cg.tutor.dto.BookingDto;
import com.cg.tutor.dto.BookingReq;

public interface BookingService{
	
	List<BookingDto> getAllBookingDetails();
	
	BookingDto saveBookingDetails(BookingReq bookingReq);
	
	BookingDto getBookingDetails(int bookingId);
	
	List<BookingDto> getAllBookingsByParent(int parentId);
	
	List<BookingDto> getAllBookingsByTutor(int tutorId);
}
