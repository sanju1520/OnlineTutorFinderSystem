package com.cg.tutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Role;



	public interface RoleRepository extends JpaRepository<Role, Integer>
	{
}
