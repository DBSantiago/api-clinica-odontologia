package com.clinica.odontologia.model.dto;

import com.clinica.odontologia.model.Domicilio;

import java.util.Date;

public class PacienteDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Domicilio domicilio;
    private Date fecha;

    public PacienteDTO() {
    }

    public PacienteDTO(String nombre, String apellido, String dni, Domicilio domicilio, Date fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fecha = fecha;
    }

    public PacienteDTO(Integer id, String nombre, String apellido, String dni, Domicilio domicilio, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
