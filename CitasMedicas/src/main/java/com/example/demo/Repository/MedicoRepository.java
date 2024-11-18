package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Medico;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {
    // Métodos adicionales si se necesitan búsquedas personalizadas
}
