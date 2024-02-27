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
@Table(name="invoice")
public class FacturaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; // Id se Utiliza para Ambos Tipos de Facturacion
    //Datos necesarios para la Facturacion por Interconexion
    private String interconnection;
    private String rif;
    private String client;
    private Integer interconecction_id;
    private double total_mount;
    private Integer register_cod;
    private double second_price;
    private Boolean activo;
    private Long seconds_calls;
    private LocalDate start_date;
    private LocalDate end_date;
    private String service_cod;
    private String service_description;
    private Integer termination_cod;
    private LocalDate issue_date;
    private Long invoice_number;
    private Time issue_hour;
    private LocalDate expiration_date;
    private String observaciones;
    private Integer conciliacion_id;
    private double iva;
    private LocalDate created_at;
    private LocalDate updated_at;
    private boolean status;
    
    //Datos Requeridos para la Facturacion Comercial
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
    private String invoice_type;
    private String username; // Registro del Usuario que Ingreso los Datos para ambos Tipos de facturacion
    private String direccion; // Direccion Agregada Octubre 2023 para PDF
    private String telefono; // Telefono Agregada Octubre 2023 para PDF
    
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
        return month_bs;
    }

    public void setMonth_bs(double month_bs) {
        this.month_bs = month_bs;
    }

    public String getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(String invoice_type) {
        this.invoice_type = invoice_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
      
    public String getIva() {
        return  String.format("%.2f",iva);
    }

    public void setIva(double iva) {
        iva = (total_mount * 0.16);
        this.iva = Math.round(iva*100.0)/100.0;
    }
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterconnection() {
        return interconnection;
    }

    public void setInterconnection(String interconnection) {
        this.interconnection = interconnection;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Integer getInterconecction_id() {
        return interconecction_id;
    }

    public void setInterconecction_id(Integer interconecction_id) {
        this.interconecction_id = interconecction_id;
    }

    public String getTotal_mount() {
        return String.format("%.2f", total_mount);
    }

    public void setTotal_mount(double total_mount) {
        this.total_mount = Math.round(total_mount*100.00)/100.00;
    }

    public Integer getRegister_cod() {
        return register_cod;
    }

    public void setRegister_cod(Integer register_cod) {
        this.register_cod = register_cod;
    }

    public String getSecond_price() {
        return String.format("%.6f", second_price);
    }

    public void setSecond_price(double second_price) {
        this.second_price = second_price;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Long getSeconds_calls() {
        return seconds_calls;
    }

    public void setSeconds_calls(Long seconds_calls) {
        this.seconds_calls = seconds_calls;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getStart_date() {
        return start_date;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getEnd_date() {
        return end_date;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getService_cod() {
        return service_cod;
    }

    public void setService_cod(String service_cod) {
        this.service_cod = service_cod;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public Integer getTermination_cod() {
        return termination_cod;
    }

    public void setTermination_cod(Integer termination_cod) {
        this.termination_cod = termination_cod;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getIssue_date() {
        return issue_date;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setIssue_date(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public Time getIssue_hour() {
        return issue_hour;
    }

    public void setIssue_hour(Time issue_hour) {
        this.issue_hour = issue_hour;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getExpiration_date() {
        return expiration_date;
    }
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getConciliacion_id() {
        return conciliacion_id;
    }

    public void setConciliacion_id(Integer conciliacion_id) {
        this.conciliacion_id = conciliacion_id;
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

    public Long getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(Long invoice_number) {
        this.invoice_number = invoice_number;
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
