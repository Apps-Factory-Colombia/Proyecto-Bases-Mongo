package com.example.demo.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicos")
public class Medico {

    @Id
    private ObjectId id;
    private String nombre;
    private String cedulaProfesional;
    private String correo;
    private String especialidad;
    private String telefono;

    // Constructor vacío requerido por Spring
    public Medico() {
    }

    // Constructor con parámetros
    public Medico(String nombre, String cedulaProfesional, String correo, String especialidad, String telefono) {
        this.nombre = nombre;
        this.cedulaProfesional = cedulaProfesional;
        this.correo = correo;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }

    // Getter para ID que devuelve una representación en String
    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    // Setter para ID que acepta una cadena y la convierte a ObjectId
    public void setId(String id) {
        this.id = id != null ? new ObjectId(id) : null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
