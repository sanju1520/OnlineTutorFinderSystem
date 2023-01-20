package com.cg.tutor.service;

import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.dto.UserDto;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Tutor;

public interface LoginService {

	public TutorDto tutorLogin(String username,String password);

    public ParentDto parentLogin(String username,String password);
}