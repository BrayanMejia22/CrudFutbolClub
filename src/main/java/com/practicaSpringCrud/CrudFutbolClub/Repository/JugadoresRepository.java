package com.practicaSpringCrud.CrudFutbolClub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.JugadoresDocuments;

public interface JugadoresRepository extends MongoRepository<JugadoresDocuments, String>{
    Optional<JugadoresDocuments> findById(String id);    
}
