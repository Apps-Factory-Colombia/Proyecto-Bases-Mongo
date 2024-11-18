package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Paciente;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {
    List<Paciente> findByEdadBetweenAndEps(int startAge, int endAge, String eps);

    List<Paciente> findByEpsAndEdadGreaterThan(String eps, int age);
}
