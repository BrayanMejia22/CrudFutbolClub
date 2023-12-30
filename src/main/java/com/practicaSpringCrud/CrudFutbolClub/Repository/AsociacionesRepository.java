package com.practicaSpringCrud.CrudFutbolClub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practicaSpringCrud.CrudFutbolClub.Repository.Documents.AsociacionesDocuments;

public interface AsociacionesRepository extends MongoRepository<AsociacionesDocuments, String>{    
    Optional<AsociacionesDocuments> findById(String id);
}
