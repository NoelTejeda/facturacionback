package com.carrier.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ing. Francisco Guevara
 */

@Entity
@Table(name="notadebito")
public class NotadebitoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;//Numero de Nota de Debito Unico
    private String factura;// Antes era el numero de Nota de Debito ahora es la Factura Asociada
    private String rif;
    private String serie;
    private LocalDate fecha_emision;
    private Time hora_emision;
    private LocalDate fecha_vencimiento;
    private String concepto_servicio;
    private double subtotal;
    private double monto_iva;
    private double monto_total;
    private String observaciones;
    private boolean status;
    private String usuario;
    private String id_servicio;
    private String operador;
    private String direccion;
    private double monto_exento;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String telefono; // telefono Agregada Octubre 2023 para PDF

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
        return String.format("%.2f",monto_exento);
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

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getConcepto_servicio() {
        return concepto_servicio;
    }

    public void setConcepto_servicio(String concepto_servicio) {
        this.concepto_servicio = concepto_servicio;
    }

    public String getSubtotal() {
        return String.format("%.2f",subtotal);
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = Math.round(subtotal);
    }

    public String getMonto_iva() {
        return String.format("%.2f",monto_iva);
    }

    public void setMonto_iva(double monto_iva) {
        this.monto_iva = Math.round(monto_iva*100.0)/100.0;
    }

    public String getMonto_total() {
        return String.format("%.2f",monto_total);
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

    public String getUusuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getCreated_at() {
        return created_at;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
