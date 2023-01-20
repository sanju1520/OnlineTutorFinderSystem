package com.cg.tutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tutor.dto.RatingDto;
import com.cg.tutor.entity.Rating;
import com.cg.tutor.service.RatingService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/rating/save")
	public ResponseEntity<RatingDto> saveRating (@RequestBody RatingDto ratingDto){
		RatingDto newRating=ratingService.addRating(ratingDto);
		ResponseEntity<RatingDto> responseEntity=new ResponseEntity<>(newRating,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/rating/all")   //retrieving data from database
	public List<RatingDto>fetchAllRatings(){
		List<RatingDto> list=ratingService.viewAllRatings();
		return list;
	}

}
