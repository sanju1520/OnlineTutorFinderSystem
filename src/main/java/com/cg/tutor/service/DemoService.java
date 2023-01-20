package com.cg.tutor.service;

import java.util.List;

import com.cg.tutor.dto.DemoDto;
import com.cg.tutor.dto.DemoReq;

public interface DemoService{
	
	List<DemoDto> viewAllDemos();	
	
	DemoDto getDemoDetails(int demoId);
	
	DemoDto saveDemoRequest(DemoReq demoReq);
	
	List<DemoDto> getAllDemosByParent(int parentId);
	
	List<DemoDto> getAllDemosByTutor(int tutorId);
	
	DemoDto updateDemoRequestStatus(int demoId, String status);
	
}
