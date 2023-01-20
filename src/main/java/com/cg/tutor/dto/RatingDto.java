package com.cg.tutor.dto;

public class RatingDto {
	private int rateId;
	private int rate;
	private String comment;
	private ParentDto parentDto;
	private TutorDto tutorDto;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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