package com.cg.tutor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.entity.User;

 

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
	@Query("select  c from Parent c where c.username=:username and c.userPassword=:pwd")
    Optional<Parent> ParentLogin(@Param("username")String username,@Param("pwd") String password);
    Optional<Parent> findByUsername(String username);

    @Query("select  t from Tutor t where t.username=:username and t.userPassword=:pwd")
    Optional<Tutor> TutorLogin(@Param("username")String username,@Param("pwd") String password);
    Optional<Tutor> findByusername(String username);

}