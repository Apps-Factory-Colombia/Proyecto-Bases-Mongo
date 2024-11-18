package com.example.demo.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "citas")
public class Cita {

    @Id
    private ObjectId id;
    private Date fecha;
    private String idMedico;
    private String idPaciente;
    private String prioridad;
    private List<String> condicionesEspeciales;

    public Cita() {
    }

    public Cita(Date fecha, String idMedico, String idPaciente, String prioridad, List<String> condicionesEspeciales) {
        this.fecha = fecha;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.prioridad = prioridad;
        this.condicionesEspeciales = condicionesEspeciales;
    }

    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    public void setId(String id) {
        this.id = id != null ? new ObjectId(id) : null;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public List<String> getCondicionesEspeciales() {
        return condicionesEspeciales;
    }

    public void setCondicionesEspeciales(List<String> condicionesEspeciales) {
        this.condicionesEspeciales = condicionesEspeciales;
    }
}
