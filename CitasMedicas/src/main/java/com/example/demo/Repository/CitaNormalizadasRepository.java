package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Cita;

import java.util.List;

@Repository
public interface CitaNormalizadasRepository extends MongoRepository<Cita, String> {
    List<Cita> findByCondicionesEspecialesInAndPrioridadAndIdPaciente(String condicion, String prioridad);
}
