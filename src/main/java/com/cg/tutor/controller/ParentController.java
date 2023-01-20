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
import com.cg.tutor.entity.Parent;
import com.cg.tutor.service.ParentService;


@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class ParentController {

	
	@Autowired
	private ParentService parentService;
	
	
	@GetMapping("/parent/all")
	public List<ParentDto> fetchAllParents() {
		List<ParentDto> list = parentService.getAllParents();
		return list;
	}
	
	@GetMapping("/parent/{id}")
	public ResponseEntity<ParentDto> fetchParentDetails(@PathVariable("id") int parentId) {
		ParentDto parentDto = parentService.getParentById(parentId);
		ResponseEntity<ParentDto> responseEntity = new ResponseEntity<>(parentDto, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/parent/update")
	  public ResponseEntity<ParentDto> modifyParent(@RequestBody ParentDto parentDto)
	  {
		ParentDto updateParent = parentService.updateParent(parentDto);
		ResponseEntity<ParentDto> responseEntity = new ResponseEntity<>(updateParent,HttpStatus.OK);
		return responseEntity;
	  }
	
	
	
	
	
	@PostMapping("/parent/save")
	public ResponseEntity<ParentDto> addParent(@Valid@RequestBody ParentDto parentDto) {
		ParentDto newParent = parentService.saveParent(parentDto);
		ResponseEntity<ParentDto> responseEntity = new ResponseEntity<>(newParent, HttpStatus.CREATED);
		return responseEntity;
	}
	
	
	
	
}
