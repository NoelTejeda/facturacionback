package com.carrier.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Time;
import java.time.LocalDate;
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
@Table(name="facturasinvalor")
public class FacturaSinValorModel {@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; // Id de Facturacion Comercial para la Prueba Sin Valor
    private String service_type;    
    private LocalDate service_activation_date;    
    private String idservice;// ID del Servicio
    private String origin_path;
    private String destiny_path;
    private String transmition_speed;
    private String lease;//Arrendamiento
    private String maintenance;//Mantenimiento
    private double month_dollars;
    private double tasa_bcv;
    private double month_bs;
    private String approval;
    private String invoice_type; // Tipo de Facturacion [Comercial]
    private double iva; //Por el Momento no tendra uso
    private double total_mount; //Monto total en Bs
    private String username; // Usuario que realiza el Registro
    private LocalDate created_at; //Fecha de Creacion del Registro
    private LocalDate updated_at;
    private boolean status; // Aprobada o Rechazada
    private String operador;
    private String rif;
    private String service_cod;
    private String direccion;  // Agregando Dirección Octubre 2023 para PDF
    private String telefono;  // Telefono Dirección Octubre 2023 para PDF
    private Time issue_hour;

    public Time getIssue_hour() {
        return issue_hour;
    }

    public void setIssue_hour(Time issue_hour) {
        this.issue_hour = issue_hour;
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

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getService_activation_date() {
        return service_activation_date;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setService_activation_date(LocalDate service_activation_date) {
        this.service_activation_date = service_activation_date;
    }

    public String getIdservice() {
        return idservice;
    }

    public void setIdservice(String idservice) {
        this.idservice = idservice;
    }

    public String getOrigin_path() {
        return origin_path;
    }

    public void setOrigin_path(String origin_path) {
        this.origin_path = origin_path;
    }

    public String getDestiny_path() {
        return destiny_path;
    }

    public void setDestiny_path(String destiny_path) {
        this.destiny_path = destiny_path;
    }

    public String getTransmition_speed() {
        return transmition_speed;
    }

    public void setTransmition_speed(String transmition_speed) {
        this.transmition_speed = transmition_speed;
    }

    public String getLease() {
        return lease;
    }

    public void setLease(String lease) {
        this.lease = lease;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public double getMonth_dollars() {
        return month_dollars;
    }

    public void setMonth_dollars(double month_dollars) {
        this.month_dollars = month_dollars;
    }

    public double getTasa_bcv() {
        return tasa_bcv;
    }

    public void setTasa_bcv(double tasa_bcv) {
        this.tasa_bcv = tasa_bcv;
    }

    public double getMonth_bs() {
        return Math.round(month_bs*100.0)/100.0;
    }

    public void setMonth_bs(double month_bs) {
        this.month_bs = Math.round(month_bs*100.0)/100.0;
    }

    public String getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(String invoice_type) {
        this.invoice_type = invoice_type;
    }

    public double getIva() {
        return Math.round(iva*100.0)/100.0;
    }

    public void setIva(double iva) {
        this.iva = Math.round(iva*100.0)/100.0;
    }

    public double getTotal_mount() {
        return Math.round(total_mount*100.0)/100.0;
    }

    public void setTotal_mount(double total_mount) {
        this.total_mount = Math.round(total_mount*100.0)/100.0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getService_cod() {
        return service_cod;
    }

    public void setService_cod(String service_cod) {
        this.service_cod = service_cod;
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
        
}
