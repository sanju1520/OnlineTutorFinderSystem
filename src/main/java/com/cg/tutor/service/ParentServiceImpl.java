package com.cg.tutor.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.RoleDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Role;

import com.cg.tutor.exception.ParentNotFoundException;
import com.cg.tutor.exception.RoleNotFoundException;
import com.cg.tutor.exception.TutorNotFoundException;
import com.cg.tutor.repository.ParentRepository;
import com.cg.tutor.repository.RoleRepository;


@Service
public class ParentServiceImpl implements ParentService
{	
	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ParentDto saveParent(ParentDto parentDto) {
		Optional<Role> optionalRole=roleRepository.findById(parentDto.getRole().getRoleId());
		if(optionalRole.isEmpty()) {
			throw new RoleNotFoundException("Role not existing with id: "+parentDto.getRole().getRoleId());
		}
		Role role=optionalRole.get();
		Parent parent=new Parent();
		BeanUtils.copyProperties(parentDto, parent);
		parent.setRole(role);
		System.out.println(parent.getFirstName());
		Parent newParent=parentRepository.save(parent);
		parentDto.setUserId(newParent.getUserId());
		return parentDto;
	}

	@Override
	public ParentDto getParentById(int parentId) {
		Optional<Parent> optionalParent=parentRepository.findById(parentId);
		if(optionalParent.isEmpty()) {
			throw new ParentNotFoundException("Parent not existing with id: "+parentId);
		}
		Parent parent=optionalParent.get();
		ParentDto parentDto=new ParentDto();
		BeanUtils.copyProperties(parent, parentDto);
		return parentDto;
	}
    
	
	
	@Override
	public ParentDto updateParent(ParentDto parent) throws ParentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public List<ParentDto> getAllParents() {
		List<Parent> parents=parentRepository.findAll();
		List<ParentDto> parentsDto=new ArrayList<>();
		parents.forEach(p->{
			ParentDto parentDto=new ParentDto();
			Role role=p.getRole();
			RoleDto roleDto=new RoleDto();
			BeanUtils.copyProperties(role, roleDto);
			parentDto.setRole(roleDto);
			BeanUtils.copyProperties(p, parentDto);
			parentsDto.add(parentDto);
		});
		
		return parentsDto;
	}


/*
	@Override
	public Parent saveParent(Parent parent) 
	{
		Optional<Role> optionalRole =roleRepository.findById(parent.getRole().getRoleId());
		if(optionalRole.isEmpty()) {
		       throw new RoleNotFoundException("Role not existing with id: "+parent.getRole().getRoleId());
				}
			    Role role= optionalRole.get();
			    parent.setRole(role);
		Parent newParent = parentRepository.save(parent);
		return newParent;
	}
	
	
	 	@Override
		public Parent getParentById(int parentId) {
			Optional<Parent> optionalParent =parentRepository.findById(parentId);
			if(optionalParent.isEmpty()) {
				throw new ParentNotFoundException("Parent not existing with id: "+parentId);
			}
		    Parent parent= optionalParent.get();
			return parent;
		}
	
	
	
	

	@Override
	public List<Parent> getAllParents() {
		
		return parentRepository.findAll();
	}
*/
	


}
