package com.practicaSpringCrud.CrudFutbolClub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.CompetenciasDocuments;

public interface CompetenciasRepository extends MongoRepository<CompetenciasDocuments, String>{
    Optional<CompetenciasDocuments> findById(String id);    
}
