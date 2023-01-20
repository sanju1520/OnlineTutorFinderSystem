package com.cg.tutor.controller;

 

 

import java.util.List;

 

import javax.validation.Valid;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.tutor.dto.EbookDto;
import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.entity.Ebook;
import com.cg.tutor.service.EbookServiceImpl;

 

//@Validated
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class EbookController {
    @Autowired
    private EbookServiceImpl ebookService;


    @PostMapping("/ebook/save")
    public ResponseEntity<EbookDto> addEbook(@RequestBody  EbookDto ebookDto) {
        EbookDto newEbook = ebookService.saveEbook(ebookDto);
        ResponseEntity<EbookDto> responseEntity = new ResponseEntity<>(newEbook, HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("/ebook/update")
      public ResponseEntity<EbookDto> modifyEbook(@RequestBody EbookDto ebookDto)
      {
        EbookDto updateEbook = ebookService.updateEbook(ebookDto);
        ResponseEntity<EbookDto> responseEntity = new ResponseEntity<>(updateEbook,HttpStatus.OK);
        return responseEntity;
      }

 

    @DeleteMapping("/ebook/delete/{id}")
    public ResponseEntity<String> DeleteEbook(@PathVariable("id") int ebookId){
        ebookService.deleteEbookById(ebookId);
        ResponseEntity<String> responseEntity=new ResponseEntity<>("Ebook deleted successfully.",HttpStatus.OK);
        return responseEntity;
    }

     @GetMapping("/ebook/name/{name}")
        public ResponseEntity<EbookDto> ListEbookByName(@PathVariable("name") String ebookNameDto){
            EbookDto ebook=ebookService.retrieveEbookByName(ebookNameDto);
            ResponseEntity<EbookDto> responseEntity=new ResponseEntity<>(ebook,HttpStatus.OK);
            return responseEntity;
     }  

     @GetMapping("/ebook/all")
        public List<EbookDto> fetchAllEbook() {
            List<EbookDto> list = ebookService.getAllEbook();
            return list;

    }
}