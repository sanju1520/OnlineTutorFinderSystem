package com.cg.tutor.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.exception.TutorNotFoundException;
import com.cg.tutor.service.TutorService;


@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class TutorController {

	
	
	@Autowired
	private TutorService tutorService;
	
	@GetMapping("/tutor/all")
	public List<TutorDto> fetchAllTutors() {
		List<TutorDto> list = tutorService.getAllTutors();
		return list;
	}
	
	@PostMapping("/tutor/save")
	public ResponseEntity<TutorDto> addTutor(@Valid @RequestBody TutorDto tutorDto) {
		TutorDto newTutor = tutorService.saveTutor(tutorDto);
		ResponseEntity<TutorDto> responseEntity = new ResponseEntity<>(newTutor, HttpStatus.CREATED);
		return responseEntity;
	}
	

	@GetMapping("/tutor/{id}")
	public ResponseEntity<TutorDto> fetchTutorDetails(@PathVariable("id") int tutorId) {
		TutorDto tutorDto = tutorService.getTutorById(tutorId);
		ResponseEntity<TutorDto> responseEntity = new ResponseEntity<>(tutorDto, HttpStatus.OK);
		return responseEntity;
	}
	

	@PutMapping("/tutor/update")
	  public ResponseEntity<TutorDto> modifyTutor(@RequestBody TutorDto tutorDto)
	  {
		TutorDto updateTutor = tutorService.updateTutor(tutorDto);
		ResponseEntity<TutorDto> responseEntity = new ResponseEntity<>(updateTutor,HttpStatus.OK);
		return responseEntity;
	  }
	
	@PostMapping("/tutor/acceptDemo")
	public ResponseEntity<TutorDto> acceptDemo(@RequestBody TutorDto tutorDto) {
		TutorDto newTutor = tutorService.acceptDemo(tutorDto);
		ResponseEntity<TutorDto> responseEntity = new ResponseEntity<>(newTutor, HttpStatus.CREATED);
		return responseEntity;
	}
	
}
