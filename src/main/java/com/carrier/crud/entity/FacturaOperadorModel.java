package com.carrier.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author Ing. Francisco Guevara
 */
@Entity
@Table(name="atffacturaoperador")
public class FacturaOperadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String rif;
    private String operador;
    private double iva;
    private double total_mount;
    private LocalDate fecha_inicial;
    private LocalDate fecha_final;
    private String codigo_servicio;
    private String descripcion_servicio;
    private String numero_factura;
    private LocalDate fecha_factura;
    private Time hora_factura;
    private LocalDate fecha_vencimiento;
    private String user_id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private boolean status;
    private double total_nc_ope;
    private double total_nd_ope;
    private double totalfinal_ope;
    private String observacion;
     
 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal_mount() {
        return total_mount;
    }

    public void setTotal_mount(double total_mount) {
        this.total_mount = total_mount;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_inicial() {
        return fecha_inicial;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setFecha_inicial(LocalDate fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_final() {
        return fecha_final;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setFecha_final(LocalDate fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(String codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_factura() {
        return fecha_factura;
    }

     @JsonFormat(pattern = "dd-MM-yyyy")
    public void setFecha_factura(LocalDate fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public Time getHora_factura() {
        return hora_factura;
    }

    public void setHora_factura(Time hora_factura) {
        this.hora_factura = hora_factura;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getCreated_at() {
        return created_at;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setCreated_at(LocalDate created_at) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotal_nc_ope() {
        return total_nc_ope;
    }

    public void setTotal_nc_ope(double total_nc_ope) {
        this.total_nc_ope = total_nc_ope;
    }

    public double getTotal_nd_ope() {
        return total_nd_ope;
    }

    public void setTotal_nd_ope(double total_nd_ope) {
        this.total_nd_ope = total_nd_ope;
    }

    public double getTotalfinal_ope() {
        return totalfinal_ope;
    }

    public void setTotalfinal_ope(double totalfinal_ope) {
        this.totalfinal_ope = totalfinal_ope;
    }
    
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }






}
