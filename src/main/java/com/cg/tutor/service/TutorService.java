package com.cg.tutor.service;

import java.util.List;

import com.cg.tutor.dto.EbookDto;
import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.exception.EbookNotFoundException;
import com.cg.tutor.exception.TutorNotFoundException;

public interface TutorService 
{

    public TutorDto saveTutor(TutorDto tutor);
	
	public TutorDto getTutorById(int tutorId) throws TutorNotFoundException;
	
	public List<TutorDto> getAllTutors();

	
	public TutorDto acceptDemo(TutorDto dto);
	
	public TutorDto updateTutor(TutorDto tutor) throws TutorNotFoundException;
	


	public  TutorDto rejectDemo(TutorDto tutor);

	

	
	


}