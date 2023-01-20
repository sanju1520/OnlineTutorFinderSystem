package com.cg.tutor.dto;

import java.time.LocalDate;

public class BookingDto {
	private int bookingId;
	private LocalDate dateofBooking;
	private ParentDto parentDto;
	private TutorDto tutorDto;
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getDateofBooking() {
		return dateofBooking;
	}
	public void setDateofBooking(LocalDate dateofBooking) {
		this.dateofBooking = dateofBooking;
	}
	public ParentDto getParentDto() {
		return parentDto;
	}
	public void setParentDto(ParentDto parentDto) {
		this.parentDto = parentDto;
	}
	public TutorDto getTutorDto() {
		return tutorDto;
	}
	public void setTutorDto(TutorDto tutorDto) {
		this.tutorDto = tutorDto;
	}	
	
}
