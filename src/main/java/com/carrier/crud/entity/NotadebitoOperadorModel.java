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
 * @author Ing. Francisco Guevara
 */

@Entity
@Table(name="notadebitooperador") /* NOMBRE TABLA*/
public class NotadebitoOperadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String factura_numero;
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
    private Date created_at;
    private LocalDate updated_at;
    private String usuario;
    private String operador;
    private String direccion;
    private double monto_exento;


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
  
    public String getFactura_numero() {
System.out.println("getFactura_numero AAA"+factura_numero);
        return factura_numero;
    }

    public void setFactura_numero(String factura_numero) {
        this.factura_numero = factura_numero;
System.out.println("BBB "+factura_numero);
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
        return String.format("%.2f", subtotal);
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
    
    //@JsonFormat(pattern = "dd-MM-yyyy")
    public Date getCreated_at() {
        return created_at;
    }
    
   // @JsonFormat(pattern = "dd-MM-yyyy")
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getUpdated_at() {
        return updated_at;
    }
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
