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
import com.practicaSpringCrud.CrudFutbolClub.Repository.AsociacionesRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.AsociacionesDocuments;

@RestController
@RequestMapping("/asociacion")
public class AsociacionWeb {

    @Autowired
    private AsociacionesRepository asociacionesRepository;

    @GetMapping("/mostrarAsociaciones")
    public List<AsociacionesDocuments> finAll() {
        return asociacionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public AsociacionesDocuments findById(@PathVariable String id) {
        return asociacionesRepository.findById(id).orElseThrow(() -> new NotFundException("ASOCIACION NO ENCONTRADA"));
    }

    @PostMapping("/")
    public AsociacionesDocuments save(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        AsociacionesDocuments asociacion = mapper.convertValue(body, AsociacionesDocuments.class);
        return asociacionesRepository.save(asociacion);
    }

    @PostMapping("/{id}")
    public AsociacionesDocuments update(@PathVariable String id, AsociacionesDocuments asociacion) {
        asociacion.setId(id);
        return asociacionesRepository.save(asociacion);
    }

    @DeleteMapping("/{id}")
    public AsociacionesDocuments delete(@PathVariable String id) {
        AsociacionesDocuments asociacion = asociacionesRepository.findById(id)
                .orElseThrow(() -> new NotFundException("ASOCIACION NO ENCONTRADA"));
        asociacionesRepository.deleteById(id);
        return asociacion;
    }
}
