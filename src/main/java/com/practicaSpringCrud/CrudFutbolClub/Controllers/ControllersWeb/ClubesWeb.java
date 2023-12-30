package com.practicaSpringCrud.CrudFutbolClub.Controllers.ControllersWeb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practicaSpringCrud.CrudFutbolClub.NotFundException.NotFundException;
import com.practicaSpringCrud.CrudFutbolClub.Repository.ClubesRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.ClubesDocuments;

@RestController
@RequestMapping("/club")
public class ClubesWeb {

    @Autowired
    private ClubesRepository clubesRepository;

    @GetMapping("/")
    public List<ClubesDocuments> finAll(){
        return clubesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClubesDocuments findByID(@PathVariable String id){
        return clubesRepository.findById(id).orElseThrow(()-> new NotFundException("CLUB NO ENCONTRADA"));
    }

    @PostMapping("/")
    public ClubesDocuments save(@RequestBody Map<String, Object> body){
        ObjectMapper mapper = new ObjectMapper();
        ClubesDocuments clubes = mapper.convertValue(body, ClubesDocuments.class);
        return clubesRepository.save(clubes);
    }

    @PostMapping("/{id}")
    public ClubesDocuments update (@PathVariable String id, Map<String, Object> body){
        ObjectMapper mapper = new ObjectMapper();
        ClubesDocuments clubes = mapper.convertValue(body, ClubesDocuments.class);
        clubes.setId(id);        
        return clubesRepository.save(clubes);
    }   
    
    @DeleteMapping("/{id}")
    public ClubesDocuments delete(@PathVariable String id){
        ClubesDocuments clubes = clubesRepository.findById(id).orElseThrow(()-> new NotFundException("CLUB NO ENCONTRADA"));
        clubesRepository.deleteById(id);
        return clubes;
    }
}
