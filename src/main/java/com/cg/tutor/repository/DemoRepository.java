package com.cg.tutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cg.tutor.entity.Demo;

public interface DemoRepository extends JpaRepository<Demo, Integer>{

	@Query("select d from Demo d where d.parent.userId = :pId")
	List<Demo> findDemoByParentId(@Param("pId") int parentId);
	
	@Query("select d from Demo d where d.tutor.userId = :tId")
	List<Demo> findDemoByTutorId(@Param("tId") int parentId);
	
	@Transactional
	@Modifying
	@Query("update Demo d set d.requestStatus= :status where d.requestId = :demoId")
	void updateDemoRequestStatus(@Param("demoId") int demoId,@Param("status") String status);
}
