package com.cg.tutor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tutor.dto.DemoDto;
import com.cg.tutor.dto.DemoReq;
import com.cg.tutor.dto.DemoStatusReq;
import com.cg.tutor.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired 
    private DemoService demoService;
	
    @PostMapping("/save") //adding data into database
    public ResponseEntity<DemoDto> addDemoDetails(@Valid @RequestBody DemoReq demoReq){
        DemoDto requestDemo= demoService.saveDemoRequest(demoReq);
        ResponseEntity<DemoDto> responseEntity=new ResponseEntity<>(requestDemo,HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/all") //retrieving data from database
    public List<DemoDto> fetchAllDemoDetails(){
        List<DemoDto> list=demoService.viewAllDemos();
        return list;
    }
    
    
    @GetMapping("/parent/{parentId}") 
    public List<DemoDto> fetchAllDemoByParent(@PathVariable("parentId") int parentId){
        List<DemoDto> list=demoService.getAllDemosByParent(parentId);
        return list;
    }
    
    @GetMapping("/tutor/{tutorId}") 
    public List<DemoDto> fetchAllDemoByTutor(@PathVariable("tutorId") int tutorId){
        List<DemoDto> list=demoService.getAllDemosByTutor(tutorId);
        return list;
    }    
    
    @PutMapping("/updateStatus") 
    public DemoDto changeDemoRequestStatus(@RequestBody DemoStatusReq demoStatusReq){
        DemoDto demoDto=demoService.updateDemoRequestStatus(demoStatusReq.getDemoReqId(), demoStatusReq.getReqStatus());
        return demoDto;
    }    
}
