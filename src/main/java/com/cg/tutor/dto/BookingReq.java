package com.cg.tutor.dto;

import java.time.LocalDate;

public class BookingReq {

	private int parentId;
	private int tutorId;
	private LocalDate dateOfBooking;
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}	
}
