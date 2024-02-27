package com.carrier.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
//import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 *  @author Ing. Francisco Guevara
 */

@Entity
@Table(name="operador")
public class OperadorModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    //@Column (unique = true, nullable = false)
    @Size(min = 3, message="El Operador del servicio debe tener mas de 3 caracteres")
    private String operador;
    //@Column (unique = true, nullable = false)
    private String rif;
    private String direccion;
    private String telefono;
    private LocalDate fecha_registro;
    private Time hora_registro;
    private boolean status;
    private String usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperador() {
        return operador.toLowerCase();
    }

    public void setOperador(String operador) {
        this.operador = operador.toLowerCase();
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    @JsonFormat (pattern = "dd-MM-yyyy")
    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Time getHora_registro() {
        return hora_registro;
    }

    public void setHora_registro(Time hora_registro) {
        this.hora_registro = hora_registro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
