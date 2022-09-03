package com.profile.master.api.dto;

import java.time.LocalDateTime;

public class EducacionDTO {
    public Integer getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
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

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDateTime fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public TipoEducacionDTO getTipoEducacion() {
        return tipoEducacion;
    }

    public void setTipoEducacion(TipoEducacionDTO tipoEducacion) {
        this.tipoEducacion = tipoEducacion;
    }


    public Integer idEducacion;
public boolean estado;
    public LocalDateTime fechaCreacion;
    public int anosExperiencia;
    public LocalDateTime fechaInicio;
    public LocalDateTime fechaTermino;
    public String nombreTitulo;
    public String universidad;
    public TipoEducacionDTO tipoEducacion;


}
