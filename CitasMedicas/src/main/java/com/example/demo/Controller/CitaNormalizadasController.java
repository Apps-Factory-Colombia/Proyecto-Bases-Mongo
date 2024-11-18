package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.Cita;
import com.example.demo.Repository.CitaNormalizadasRepository;

@RestController
@RequestMapping("/citas")
public class CitaNormalizadasController {

    @Autowired
    private CitaNormalizadasRepository citaNormalizadasRepository;

    // Obtener todas las citas
    @GetMapping
    public List<Cita> getAllCitas() {
        return citaNormalizadasRepository.findAll();
    }

    // Buscar una cita por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable String id) {
        Optional<Cita> cita = citaNormalizadasRepository.findById(id);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva cita
    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return citaNormalizadasRepository.save(cita);
    }

    // Actualizar una cita por ID
    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable String id, @RequestBody Cita citaDetails) {
        Optional<Cita> cita = citaNormalizadasRepository.findById(id);
        if (cita.isPresent()) {
            Cita existingCita = cita.get();
            existingCita.setFecha(citaDetails.getFecha());
            existingCita.setIdMedico(citaDetails.getIdMedico());
            existingCita.setIdPaciente(citaDetails.getIdPaciente());
            existingCita.setPrioridad(citaDetails.getPrioridad());
            existingCita.setCondicionesEspeciales(citaDetails.getCondicionesEspeciales());
            return ResponseEntity.ok(citaNormalizadasRepository.save(existingCita));
        }
        return ResponseEntity.notFound().build();
    }

    // Cambiar prioridad a "Alta" para pacientes mayores de 65 años con condiciones
    // especiales
    @PutMapping("/prioridad/alta")
    public List<Cita> updatePrioridadParaCondicionesEspeciales(@RequestBody List<String> condicionesEspeciales) {
        List<Cita> citas = citaNormalizadasRepository.findAll();
        for (Cita cita : citas) {
            if (cita.getCondicionesEspeciales() != null &&
                    cita.getCondicionesEspeciales().stream().anyMatch(condicionesEspeciales::contains)) {
                cita.setPrioridad("Alta");
                citaNormalizadasRepository.save(cita);
            }
        }
        return citaNormalizadasRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable String id) {
        if (citaNormalizadasRepository.existsById(id)) {
            citaNormalizadasRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
