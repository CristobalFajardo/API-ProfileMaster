package com.profile.master.api.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class TipoEducacionDTO {
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

    public Integer idTipoEducacion;
    public boolean estado;
    public LocalDateTime fechaCreacion;
    public String nombreTipoEducacion;


}
