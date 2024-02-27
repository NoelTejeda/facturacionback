package com.carrier.crud.entity;

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
 * @author FranMovilnet
 */

@Entity
@Table(name="rutas")
public class RutasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column (unique = true, nullable = false)
    @Size(min = 3, message="El Nombre del Origen debe tener mas de 3 caracteres")
    private String origin;
    private LocalDate created_at;
    private LocalDate updated_at;
    private boolean status;

    public RutasModel() {
    }
    
    public RutasModel(Long id, String origin, LocalDate created_at, LocalDate updated_at, boolean status) {
        this.id = id;
        this.origin = origin;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
