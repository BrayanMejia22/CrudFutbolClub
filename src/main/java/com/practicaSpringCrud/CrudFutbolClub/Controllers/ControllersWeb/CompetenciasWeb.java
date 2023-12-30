package com.practicaSpringCrud.CrudFutbolClub.Controllers.ControllersWeb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practicaSpringCrud.CrudFutbolClub.NotFundException.NotFundException;
import com.practicaSpringCrud.CrudFutbolClub.Repository.CompetenciasRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.CompetenciasDocuments;

@RestController
@RequestMapping("/competencia")
public class CompetenciasWeb {

    @Autowired
    private CompetenciasRepository competenciasRepository;

    @GetMapping("/")
    public List<CompetenciasDocuments> finAll(){
        return competenciasRepository.findAll();
    }

    @GetMapping("/{id}")
    public CompetenciasDocuments findById(@PathVariable String id){
        return competenciasRepository.findById(id).orElseThrow(()-> new NotFundException("COMPETENCIA NO ENCONTRADA"));
    }

    @PostMapping("/")
    public CompetenciasDocuments save(@RequestBody Map<String, Object> body){    
        ObjectMapper mapper = new ObjectMapper();
        CompetenciasDocuments competencias = mapper.convertValue(body, CompetenciasDocuments.class);
        return competenciasRepository.save(competencias);
    }

    @PutMapping("/{id}")
    public CompetenciasDocuments update(@PathVariable String id, @RequestBody Map<String, Object> body){
        ObjectMapper mapper = new ObjectMapper();
        CompetenciasDocuments competencias = mapper.convertValue(body, CompetenciasDocuments.class);
        return competenciasRepository.save(competencias);
    }

    @DeleteMapping("/{id}")
    public CompetenciasDocuments delete(@PathVariable String id){
        CompetenciasDocuments competencia = competenciasRepository.findById(id).orElseThrow(()-> new NotFundException("COMPETENCIA NO ENCONTRADA"));;
        competenciasRepository.deleteById(id);
        return competencia;
    } 
}
