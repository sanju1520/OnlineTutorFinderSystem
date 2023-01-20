package com.cg.tutor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tutor.entity.Parent;


@Repository

public interface ParentRepository extends JpaRepository<Parent, Integer>
{
	Optional<Parent> findByUsername(String username);
}
