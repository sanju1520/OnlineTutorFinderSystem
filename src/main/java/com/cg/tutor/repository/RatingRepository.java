package com.cg.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tutor.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating,Integer>{

}
