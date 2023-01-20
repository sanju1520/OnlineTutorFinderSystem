package com.cg.tutor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.exception.ParentNotFoundException;
import com.cg.tutor.exception.TutorNotFoundException;

@Service
public interface ParentService {

	

   ParentDto saveParent(ParentDto parent);
	
	ParentDto getParentById(int parentId);
	
	List<ParentDto> getAllParents();
	
	public ParentDto updateParent(ParentDto parent) throws ParentNotFoundException;
	

}




