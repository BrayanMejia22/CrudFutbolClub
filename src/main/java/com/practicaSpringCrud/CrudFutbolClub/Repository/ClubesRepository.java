package com.practicaSpringCrud.CrudFutbolClub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.ClubesDocuments;

public interface ClubesRepository extends MongoRepository<ClubesDocuments, String>{
    Optional<ClubesDocuments> findById(String id);

}
