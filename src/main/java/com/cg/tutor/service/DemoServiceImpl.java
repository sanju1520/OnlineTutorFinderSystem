package com.cg.tutor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tutor.dto.DemoDto;
import com.cg.tutor.dto.DemoReq;
import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Demo;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.exception.DetailsNotFoundException;
import com.cg.tutor.exception.ParentNotFoundException;
import com.cg.tutor.exception.ResourceNotFoundException;
import com.cg.tutor.exception.TutorNotFoundException;
import com.cg.tutor.repository.DemoRepository;
import com.cg.tutor.repository.ParentRepository;
import com.cg.tutor.repository.TutorRepository;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoRepository demoRepository;

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public DemoDto saveDemoRequest(DemoReq demoReq) {

		Optional<Parent> optionalParent = parentRepository.findById(demoReq.getParentId());
		if (optionalParent.isEmpty()) {
			throw new ParentNotFoundException("Parent not existing with id: " + demoReq.getParentId());
		}
		Parent parent = optionalParent.get();

		Optional<Tutor> optionalTutor = tutorRepository.findById(demoReq.getTutorId());
		if (optionalTutor.isEmpty()) {
			throw new TutorNotFoundException("Tutor not existing with id: " + demoReq.getTutorId());
		}
		Tutor tutor = optionalTutor.get();

		Demo demo = new Demo();
		demo.setRequestDate(demoReq.getRequestDate());
		demo.setParent(parent);
		demo.setTutor(tutor);
		demo.setRequestStatus("New");

		Demo newDemo = demoRepository.save(demo);

		DemoDto demoDto = new DemoDto();
		demoDto.setRequestId(newDemo.getRequestId());
		demoDto.setRequestDate(demo.getRequestDate());
		demoDto.setRequestStatus(demo.getRequestStatus());
		ParentDto parentDto = new ParentDto();
		BeanUtils.copyProperties(demo.getParent(), parentDto);
		TutorDto tutorDto = new TutorDto();
		BeanUtils.copyProperties(demo.getTutor(), tutorDto);
		demoDto.setParentDto(parentDto);
		demoDto.setTutorDto(tutorDto);

		return demoDto;
	}

	@Override
	public List<DemoDto> viewAllDemos() {

		List<Demo> demoList = demoRepository.findAll();
		if (demoList.size() == 0) {
			throw new DetailsNotFoundException("No Demo requests are availabel");
		}

		List<DemoDto> demoDtoList = new ArrayList<>();

		demoList.forEach(d -> {
			DemoDto demoDto = new DemoDto();
			BeanUtils.copyProperties(d, demoDto);
			ParentDto parentDto = new ParentDto();
			BeanUtils.copyProperties(d.getParent(), parentDto);
			TutorDto tutorDto = new TutorDto();
			BeanUtils.copyProperties(d.getTutor(), tutorDto);
			demoDto.setParentDto(parentDto);
			demoDto.setTutorDto(tutorDto);

			demoDtoList.add(demoDto);
		});

		return demoDtoList;
	}

	@Override
	public DemoDto getDemoDetails(int demoId) {

		Optional<Demo> optionalDemo = demoRepository.findById(demoId);
		if (optionalDemo.isEmpty()) {
			throw new ResourceNotFoundException("Demo not existing with id" + demoId);
		}
		Demo demo = optionalDemo.get();
		DemoDto demoDto = new DemoDto();
		demoDto.setRequestId(demo.getRequestId());
		demoDto.setRequestDate(demo.getRequestDate());
		demoDto.setRequestStatus(demo.getRequestStatus());
		ParentDto parentDto = new ParentDto();
		BeanUtils.copyProperties(demo.getParent(), parentDto);
		TutorDto tutorDto = new TutorDto();
		BeanUtils.copyProperties(demo.getTutor(), tutorDto);
		demoDto.setParentDto(parentDto);
		demoDto.setTutorDto(tutorDto);

		return demoDto;
	}

	@Override
	public List<DemoDto> getAllDemosByParent(int parentId) {
		List<Demo> demoList = demoRepository.findDemoByParentId(parentId);
		List<DemoDto> demoDtoList = new ArrayList<>();

		demoList.forEach(d -> {
			DemoDto demoDto = new DemoDto();
			BeanUtils.copyProperties(d, demoDto);
			ParentDto parentDto = new ParentDto();
			BeanUtils.copyProperties(d.getParent(), parentDto);
			TutorDto tutorDto = new TutorDto();
			BeanUtils.copyProperties(d.getTutor(), tutorDto);
			demoDto.setParentDto(parentDto);
			demoDto.setTutorDto(tutorDto);

			demoDtoList.add(demoDto);
		});

		return demoDtoList;
	}

	@Override
	public List<DemoDto> getAllDemosByTutor(int tutorId) {

		List<Demo> demoList = demoRepository.findDemoByTutorId(tutorId);

		List<DemoDto> demoDtoList = new ArrayList<>();

		demoList.forEach(d -> {
			DemoDto demoDto = new DemoDto();
			BeanUtils.copyProperties(d, demoDto);
			ParentDto parentDto = new ParentDto();
			BeanUtils.copyProperties(d.getParent(), parentDto);
			TutorDto tutorDto = new TutorDto();
			BeanUtils.copyProperties(d.getTutor(), tutorDto);
			demoDto.setParentDto(parentDto);
			demoDto.setTutorDto(tutorDto);

			demoDtoList.add(demoDto);
		});

		return demoDtoList;		
	}

	@Override
	public DemoDto updateDemoRequestStatus(int demoId, String status) {
		Optional<Demo> optionalDemo = demoRepository.findById(demoId);
		if (optionalDemo.isEmpty()) {
			throw new ResourceNotFoundException("Demo not existing with id" + demoId);
		}
		Demo demo = optionalDemo.get();
		//demo.setRequestStatus("Approved");
		
		demoRepository.updateDemoRequestStatus(demoId, status);
		DemoDto demoDto = new DemoDto();
		demoDto.setRequestId(demo.getRequestId());
		demoDto.setRequestDate(demo.getRequestDate());
		demoDto.setRequestStatus(status);
		ParentDto parentDto = new ParentDto();
		BeanUtils.copyProperties(demo.getParent(), parentDto);
		TutorDto tutorDto = new TutorDto();
		BeanUtils.copyProperties(demo.getTutor(), tutorDto);
		demoDto.setParentDto(parentDto);
		demoDto.setTutorDto(tutorDto);	
		
		return demoDto;
	}

}
