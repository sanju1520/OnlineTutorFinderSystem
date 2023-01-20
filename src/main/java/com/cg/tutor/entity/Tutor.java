package com.cg.tutor.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tutor_tbl")
public class Tutor extends User
{

     @Column(name="experience")
     private int experience;

     @Column(name="subject_Specialization")
     private String subjectSpecialization;
     
     @OneToMany(mappedBy = "tutor")
     private List<Demo> viewDemo;
     
     @OneToMany(mappedBy = "tutor")
     private Set<Booking> bookings;

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

	public List<Demo> getViewDemo() {
		return viewDemo;
	}

	public void setViewDemo(List<Demo> viewDemo) {
		this.viewDemo = viewDemo;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	
}
