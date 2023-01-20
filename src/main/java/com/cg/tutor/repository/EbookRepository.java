package com.cg.tutor.repository;

 

import java.util.Optional;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

import com.cg.tutor.entity.Ebook;

 


@Repository
public interface EbookRepository extends JpaRepository<Ebook,Integer>{

    public Ebook findByBookName(String bookName);

}