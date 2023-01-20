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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="request_demo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="requestId")
public class Demo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto-increment
	@Column(name="request_id")
	private int requestId; //variable
	
	@Column(name="request_Date")
	private LocalDate requestDate;
	
	@NotNull(message="Request status is required") //validation
	@Column(name="request_status")
	private String requestStatus;
	
	@ManyToOne
    @JoinColumn(name="parentId")
    private Parent parent;
	
	@ManyToOne
    @JoinColumn(name="tutorId")
    private Tutor tutor;

	//getter-setter
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
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
