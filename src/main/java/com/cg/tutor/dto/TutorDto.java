package com.cg.tutor.dto;


import java.util.List;
import java.util.Set;

import com.cg.tutor.entity.Booking;
import com.cg.tutor.entity.Demo;
import com.cg.tutor.entity.User;

public class TutorDto extends UserDto
{
	 
	     private int experience;
	     private String subjectSpecialization;
	     private List<DemoDto> viewDemo;
	     private Set<BookingDto> bookings;
	     
		public int getExperience() {
			return experience;
		}

		public void setExperience(int experience) {
			this.experience = experience;
		}

		public String getSubjectSpecialization() {
			return subjectSpecialization;
		}

		public void setSubjectSpecialization(String subjectSpecialization) {
			this.subjectSpecialization = subjectSpecialization;
		}

		public List<DemoDto> getViewDemo() {
			return viewDemo;
		}

		public void setViewDemo(List<DemoDto> viewDemo) {
			this.viewDemo = viewDemo;
		}


		public Set<BookingDto> getBookings() {
			return bookings;
		}


		public void setBookings(Set<BookingDto> bookings) {
			this.bookings = bookings;
		}

		
	     
}
