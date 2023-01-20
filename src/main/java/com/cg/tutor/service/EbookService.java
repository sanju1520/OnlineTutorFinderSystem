package com.cg.tutor.service;

 

import java.util.List;

 

import com.cg.tutor.dto.EbookDto;
import com.cg.tutor.entity.Ebook;
import com.cg.tutor.exception.EbookNotFoundException;

 


public interface EbookService {

 

    public EbookDto saveEbook(EbookDto ebook);

    public EbookDto updateEbook(EbookDto ebook) throws EbookNotFoundException;

    public void deleteEbookById(int ebookId) throws EbookNotFoundException;

    public EbookDto retrieveEbookByName(String EbookName) throws EbookNotFoundException;

    public List<EbookDto> getAllEbook();
}