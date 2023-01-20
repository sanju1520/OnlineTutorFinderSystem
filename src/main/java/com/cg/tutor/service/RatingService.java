package com.cg.tutor.service;

import java.util.List;

import com.cg.tutor.dto.RatingDto;
import com.cg.tutor.entity.Rating;

public interface RatingService {
	//save rating
	RatingDto addRating(RatingDto rating);
	
	//view all ratings
	public List<RatingDto> viewAllRatings();

}
