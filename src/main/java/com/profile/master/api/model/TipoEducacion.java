package com.profile.master.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_educacion")
public class TipoEducacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idTipoEducacion;
    @Column(name = "estado",insertable = false,updatable = false)
    public boolean estado;
    @Column(name = "fecha_creacion",insertable = false,updatable = false)
    public LocalDateTime fechaCreacion;
    @Column(name = "nombre_tipo_educacion")
    public String nombreTipoEducacion;

    public Integer getIdTipoEducacion() {
        return idTipoEducacion;
    }

    public void setIdTipoEducacion(Integer idTipoEducacion) {
        this.idTipoEducacion = idTipoEducacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreTipoEducacion() {
        return nombreTipoEducacion;
    }

    public void setNombreTipoEducacion(String nombreTipoEducacion) {
        this.nombreTipoEducacion = nombreTipoEducacion;
    }




}
