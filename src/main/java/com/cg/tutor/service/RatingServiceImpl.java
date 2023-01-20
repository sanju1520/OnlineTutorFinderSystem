package com.cg.tutor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.RatingDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Rating;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.exception.ParentNotFoundException;
import com.cg.tutor.exception.TutorNotFoundException;
import com.cg.tutor.repository.ParentRepository;
import com.cg.tutor.repository.RatingRepository;
import com.cg.tutor.repository.TutorRepository;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public RatingDto addRating(RatingDto ratingdto) {
		Optional<Parent> optionalParent=parentRepository.findById(ratingdto.getParentDto().getUserId());
		if(optionalParent.isEmpty()) {
			throw new ParentNotFoundException("Parent not existing with id: "+ratingdto.getParentDto().getUserId());
		}
		Parent parent1=optionalParent.get();
		
		Optional<Tutor> optionalTutor=tutorRepository.findById(ratingdto.getTutorDto().getUserId());
		if(optionalTutor.isEmpty()) {
			throw new TutorNotFoundException("Tutor not existing with id: "+ratingdto.getTutorDto().getUserId());
		}
		Tutor tutor1=optionalTutor.get();
		
		Rating rating1=new Rating();
		BeanUtils.copyProperties(ratingdto,rating1);
		rating1.setParent(parent1);
		
		rating1.setTutor(tutor1);
		
		Rating newRating=ratingRepository.save(rating1);
		ratingdto.setRateId(newRating.getRateId());
		ratingdto.setRate(newRating.getRate());
		ratingdto.setComment(newRating.getComment());

		return ratingdto;
	}

	@Override
	public List<RatingDto> viewAllRatings() {
		List<Rating> ratings=ratingRepository.findAll();
		List<RatingDto> ratingsDto=new ArrayList<>();
		ratings.forEach(r->{
			RatingDto ratingDto=new RatingDto();
			
			Parent parent=r.getParent();
			ParentDto parentDto=new ParentDto();
			BeanUtils.copyProperties(parent, parentDto);
			ratingDto.setParentDto(parentDto);
			
			Tutor tutor=r.getTutor();
			TutorDto tutorDto=new TutorDto();
			BeanUtils.copyProperties(tutor, tutorDto);
			ratingDto.setTutorDto(tutorDto);
			
			BeanUtils.copyProperties(r, ratingDto);
			ratingsDto.add(ratingDto);
		});
		
		return ratingsDto;
	}

}
