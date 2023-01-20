package com.cg.tutor.service;

 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cg.tutor.dto.EbookDto;
import com.cg.tutor.dto.ParentDto;
import com.cg.tutor.dto.RoleDto;
import com.cg.tutor.dto.TutorDto;
import com.cg.tutor.entity.Ebook;
import com.cg.tutor.entity.Parent;
import com.cg.tutor.entity.Role;
import com.cg.tutor.entity.Tutor;
import com.cg.tutor.exception.EbookNotFoundException;
import com.cg.tutor.exception.ParentNotFoundException;
import com.cg.tutor.exception.RoleNotFoundException;
import com.cg.tutor.repository.EbookRepository;
import com.cg.tutor.repository.ParentRepository;

 

 

@Service
public class EbookServiceImpl implements EbookService {

    @Autowired
    private EbookRepository ebookRepository;

    @Autowired
    private ParentRepository parentRepository;

 

    @Override
    public EbookDto saveEbook(EbookDto ebook) {
        Optional<Parent> optionalParent=parentRepository.findById(ebook.getParentDto().getUserId());
        if(optionalParent.isEmpty()) {
            throw new ParentNotFoundException("Parent not existing with id: "+ebook.getParentDto().getUserId());
        }
        Parent parent1=optionalParent.get();

        Ebook ebook2=new Ebook();
        BeanUtils.copyProperties(ebook, ebook2);
        ebook2.setParent(parent1);
        Ebook newbook=ebookRepository.save(ebook2);
        ebook.setBookId(newbook.getBookId());
        return ebook;



    }

 

    @Override
    public EbookDto updateEbook(EbookDto ebook) throws EbookNotFoundException {

        Optional<Parent> optionalParent=parentRepository.findById(ebook.getParentDto().getUserId());
        if(optionalParent.isEmpty()) {
            throw new ParentNotFoundException("Parent not existing with id: "+ebook.getParentDto().getUserId());
        }
        Parent parent1=optionalParent.get();

        Ebook ebook2=new Ebook();
        BeanUtils.copyProperties(ebook, ebook2);
        ebook2.setParent(parent1);
        Ebook newbook=ebookRepository.save(ebook2);
        ebook.setBookId(newbook.getBookId());
        return ebook;


 

        

    }


 




    @Override
    public void deleteEbookById(int ebookId) throws EbookNotFoundException{
    Optional<Ebook> optionalEbook=ebookRepository.findById(ebookId);
    if(optionalEbook.isEmpty()) {
        throw new EbookNotFoundException("Ebook Not existing with ID: "+ebookId);
    }
    ebookRepository.deleteById(ebookId);
}

 

    

    @Override
    public EbookDto retrieveEbookByName(String EbookName) throws EbookNotFoundException {  
    Ebook ebook = ebookRepository.findByBookName(EbookName);

    EbookDto ebookDto = new EbookDto();
    BeanUtils.copyProperties(ebook, ebookDto);
    ParentDto parentDto = new ParentDto();
    BeanUtils.copyProperties(ebook.getParent(), parentDto);
    ebookDto.setParentDto(parentDto);
    return ebookDto;
    }

 

 

    

    @Override
    public List<EbookDto> getAllEbook() {
    List<EbookDto> ebookDtoList = new ArrayList<>();
    List<Ebook> ebooks =ebookRepository.findAll();
    ebooks.forEach(b-> {
    EbookDto ebookDto = new EbookDto();
    BeanUtils.copyProperties(b, ebookDto);
    ParentDto parentDto = new ParentDto();
    BeanUtils.copyProperties(b.getParent(), parentDto);
    ebookDto.setParentDto(parentDto);
    ebookDtoList.add(ebookDto);
    });

 

    return ebookDtoList;

 

    }

 



 

    
}

 