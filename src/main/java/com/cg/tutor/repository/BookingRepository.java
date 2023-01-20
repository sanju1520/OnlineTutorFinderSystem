package com.cg.tutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.tutor.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	@Query("select b from Booking b where b.parent.userId = :pId")
	List<Booking> findBookingsByParentId(@Param("pId") int parentId);
	
	@Query("select b from Booking b where b.tutor.userId = :tId")
	List<Booking> findBookingsByTutorId(@Param("tId") int tutorId);
}
