package com.carrier.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
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
@Table(name="total")
public class FacturaGeneralModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; 
    private String client;
    private double total_2;
    private Date end_date;
    private Date start_date;
    private String service_description;
    private LocalDate created_at;
    private Boolean status;
    private String rif;
    private Time issue_hour;
    private Date expiration_date;
    private double total_nd;
    private double total_nc;
    private double total_final;
    private double total_dif;

     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public double getTotal_2() {
        return total_2;
    }

    public void setTotal_2(double total_2) {
        this.total_2 = total_2;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }
    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate getCreated_at() {
        return created_at;
    }
    @JsonFormat(pattern = "dd-MM-yyyy")
    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public Time getIssue_hour() {
        return issue_hour;
    }

    public void setIssue_hour(Time issue_hour) {
        this.issue_hour = issue_hour;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public double getTotal_nd() {
        return total_nd;
    }

    public void setTotal_nd(double total_nd) {
        this.total_nd = total_nd;
    }

    public double getTotal_nc() {
        return total_nc;
    }


    public void setTotal_nc(double total_nc) {
        this.total_nc = total_nc;
    }

    public double getTotal_final() {
        return total_final;
    }

    public void setTotal_final(double total_final) {
        this.total_final = total_final;
    }
    
   public double getTotal_dif() {
        return total_dif;
    }

    public void setTotal_dif(double total_dif) {
        this.total_dif = total_dif;
    }
       
}
