package com.cg.tutor.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parent_tbl")
public class Parent extends User {

	@OneToMany(mappedBy = "parent")
	private List<Rating> rating;

	@OneToMany(mappedBy = "parent")
	private Set<Booking> bookings;

	@OneToMany(mappedBy = "parent")
	private List<Demo> requestDemo;

	@OneToMany(mappedBy = "parent")
	private List<Ebook> ebook;

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Demo> getRequestDemo() {
		return requestDemo;
	}

	public void setRequestDemo(List<Demo> requestDemo) {
		this.requestDemo = requestDemo;
	}

	public List<Ebook> getEbook() {
		return ebook;
	}

	public void setEbook(List<Ebook> ebook) {
		this.ebook = ebook;
	}

}
