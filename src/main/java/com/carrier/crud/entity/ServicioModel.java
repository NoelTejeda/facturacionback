package com.carrier.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
//import java.sql.Date;
import java.time.LocalDate;
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
@Table(name="servicio")
public class ServicioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private Long id;
    @Size(min = 3, message="La descripcion del servicio debe tener mas de 3 caracteres")
    @Column (nullable = false)
    private String descripcion;
    @Column (nullable = false)
    private String codigo;
    private LocalDate fecha_creacion;
    private double precio;
    private String detalle;
    private String tipofactura;
    private boolean status;
    private String usuario;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion.toLowerCase();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toLowerCase();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipofactura() {
        return tipofactura;
    }

    public void setTipofactura(String tipofactura) {
        this.tipofactura = tipofactura;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
