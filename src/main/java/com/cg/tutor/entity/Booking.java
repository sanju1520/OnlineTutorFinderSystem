package com.cg.tutor.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="booking_tbl")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="bookingId")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    @Column(name="booking_id")
    private int bookingId; //variable- primary key

    @Column(name="dateof_booking")
    private LocalDate dateofBooking; 
   
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parentId")
    Parent parent;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tutorId")
    Tutor tutor;

    //setter-getter
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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
}
