package com.cg.tutor.dto;

import java.time.LocalDate;

public class DemoDto {
	private int requestId;
	private LocalDate requestDate;
	private String requestStatus;
	private ParentDto parentDto;
	private TutorDto tutorDto;
	
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
