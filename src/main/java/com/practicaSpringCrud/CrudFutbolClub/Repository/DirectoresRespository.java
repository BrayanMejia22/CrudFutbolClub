package com.practicaSpringCrud.CrudFutbolClub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.DirectoresDocuments;

public interface DirectoresRespository extends MongoRepository<DirectoresDocuments, String> {
    Optional<DirectoresDocuments> findById(String id);
}
