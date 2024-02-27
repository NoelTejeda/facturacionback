package com.carrier.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
//import java.sql.Date;
import java.time.LocalDate;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ing.Francisco Guevara
 */


@Entity
@Table(name="notacreditooperador")
public class NotacreditoOperadorModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (unique = true, nullable = false)
    private Long id;
    private String numero_nota_credito;
    private String numero_factura;
    private String rif;
    private String descripcion_servicio;
    private String codigo_servicio;
    private LocalDate fecha_emision;
    private Time hora_emision;
    private double subtotal;
    private double monto_iva;
    private double monto_total;
    private String observaciones;
    private boolean status;
    private Date created_at;
    private Date updated_at;
    private Long id_usuario;
    private String  id_servicio;
    private String operador;
    private String direccion;
    private double monto_exento;

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMonto_exento() {
        return String.format("%.2f", monto_exento);
    }

    public void setMonto_exento(double monto_exento) {
        this.monto_exento = Math.round(monto_exento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_nota_credito() {
        return numero_nota_credito;
    }

    public void setNumero_nota_credito(String numero_nota_credito) {
        this.numero_nota_credito = numero_nota_credito;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    public String getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(String codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Time getHora_emision() {
        return hora_emision;
    }

    public void setHora_emision(Time hora_emision) {
        this.hora_emision = hora_emision;
    }

    public String getSubtotal() {
        return String.format("%.2f", subtotal);
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = Math.round(subtotal);
    }

    public String getMonto_iva() {
        return String.format("%.2f", monto_iva);
    }

    public void setMonto_iva(double monto_iva) {
        this.monto_iva = Math.round(monto_iva*100.0)/100.0;
    }

    public String getMonto_total() {
        return String.format("%.2f", monto_total);
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = Math.round(monto_total*100.0)/100.0;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
  
    public Date getCreated_at() {
        return created_at;
    }
    
   
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

  
    public Date getUpdated_at() {
        return updated_at;
    }


    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
