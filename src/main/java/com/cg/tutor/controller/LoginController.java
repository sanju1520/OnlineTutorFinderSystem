package com.cg.tutor.controller;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tutor.dto.LoginResponseDto;
import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.dto.UserDto;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.service.LoginService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login/parent")
    public ResponseEntity<ParentDto> doLogin(@RequestBody LoginResponseDto loginResponse){
        ParentDto parent = loginService.parentLogin(loginResponse.getUsername(),loginResponse.getPassword());
        ResponseEntity<ParentDto> responseEntity = new ResponseEntity<>(parent,HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/login/tutor")
    public ResponseEntity<TutorDto> do1Login(@RequestBody LoginResponseDto loginResponse){
        TutorDto tutor = loginService.tutorLogin(loginResponse.getUsername(),loginResponse.getPassword());
        ResponseEntity<TutorDto> responseEntity = new ResponseEntity<>(tutor,HttpStatus.OK);
        return responseEntity;
    }
}