package com.carrier.crud.entity;

//import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="cxp")
public class AnalisisTFModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Long factura_id;
    private String operador;
    private LocalDate fecha_factura;
    private Double monto_total;
    private Long conciliacion_id;
    private String observaciones;
    private Long servicio_id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConciliacion_id() {
        return conciliacion_id;
    }

    public void setConciliacion_id(Long conciliacion_id) {
        this.conciliacion_id = conciliacion_id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(Long servicio_id) {
        this.servicio_id = servicio_id;
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
    
    
    public Long getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(Long factura_id) {
        this.factura_id = factura_id;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getFecha_factura() {
        return fecha_factura;
    }
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setFecha_factura(LocalDate fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public Double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }
    
}
