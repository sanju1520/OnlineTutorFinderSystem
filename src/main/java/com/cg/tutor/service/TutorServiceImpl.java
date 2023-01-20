package com.cg.tutor.service;

import java.util.ArrayList;


import java.util.List;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tutor.dto.EbookDto;
import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.RoleDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Role;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.exception.EbookNotFoundException;
import com.cg.tutor.exception.ParentNotFoundException;
import com.cg.tutor.exception.RoleNotFoundException;
import com.cg.tutor.exception.TutorNotFoundException;
import com.cg.tutor.repository.RoleRepository;
import com.cg.tutor.repository.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService {

	
	@Autowired
	private TutorRepository tutorRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public TutorDto saveTutor(TutorDto tutorDto) {
		Optional<Role> optionalRole=roleRepository.findById(tutorDto.getRole().getRoleId());
		if(optionalRole.isEmpty()) {
			throw new RoleNotFoundException("Role not existing with id: "+tutorDto.getRole().getRoleId());
		}
		Role role=optionalRole.get();
		Tutor tutor=new Tutor();
		BeanUtils.copyProperties(tutorDto, tutor);
		tutor.setRole(role);
		System.out.println(tutor.getFirstName());
		Tutor newTutor=tutorRepository.save(tutor);
		tutorDto.setUserId(newTutor.getUserId());
		return tutorDto;
	}
	
	
	@Override
	public TutorDto getTutorById(int tutorId) {
		Optional<Tutor> optionalTutor=tutorRepository.findById(tutorId);
		if(optionalTutor.isEmpty()) {
			throw new TutorNotFoundException("Tutor not existing with id: "+tutorId);
		}
		Tutor tutor=optionalTutor.get();
		TutorDto tutorDto=new TutorDto();
		BeanUtils.copyProperties(tutor, tutorDto);
		return tutorDto;
	}


	

	@Override
	public List<TutorDto> getAllTutors() {
		List<Tutor> tutors=tutorRepository.findAll();
		List<TutorDto> tutorsDto=new ArrayList<>();
		tutors.forEach(t->{
			TutorDto tutorDto=new TutorDto();
			Role role=t.getRole();
			RoleDto roleDto=new RoleDto();
			BeanUtils.copyProperties(role, roleDto);
			tutorDto.setRole(roleDto);
			BeanUtils.copyProperties(t, tutorDto);
			tutorsDto.add(tutorDto);
		});
		
		return tutorsDto;
	}

	
	
	@Override
	public TutorDto updateTutor(TutorDto tutor) throws TutorNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	@Override
	public TutorDto acceptDemo(TutorDto tutor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TutorDto rejectDemo(TutorDto tutor) {
		// TODO Auto-generated method stub
		return null;
	}



}
