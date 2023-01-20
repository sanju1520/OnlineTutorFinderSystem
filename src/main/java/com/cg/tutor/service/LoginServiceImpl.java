package com.cg.tutor.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.exception.AuthenticationFailureException;
import com.cg.tutor.exception.UserNotFoundException;
import com.cg.tutor.repository.LoginRepository;
import com.cg.tutor.repository.ParentRepository;
import com.cg.tutor.repository.TutorRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private TutorRepository tutorRepository;
	
	@Override
    public ParentDto parentLogin(String username, String password) {

            Optional<Parent> optionalParent =parentRepository.findByUsername(username);

            if(optionalParent.isEmpty())
            {
                throw new UserNotFoundException("User not registered");
            }
            Parent parent = optionalParent.get();
            ParentDto parentDto=new ParentDto();
            BeanUtils.copyProperties(parent,parentDto);
            if(!password.equals(parentDto.getUserPassword()))
            {
                throw new AuthenticationFailureException("Login Failed");
            }
            return parentDto;
        }

    @Override
    public TutorDto tutorLogin(String username, String password) {

            Optional<Tutor> optionalTutor =tutorRepository.findByusername(username);

            if(optionalTutor.isEmpty())
            {
                throw new UserNotFoundException("User not registered");
            }
            Tutor tutor = optionalTutor.get();
            TutorDto tutorDto=new TutorDto();
            BeanUtils.copyProperties(tutor,tutorDto);
            if(!password.equals(tutorDto.getUserPassword()))
            {
                throw new AuthenticationFailureException("Login Failed");
            }
            return tutorDto;
        }
}
