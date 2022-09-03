package com.profile.master.api.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class ExperienciaLaboralDTO {
    public Integer getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(Integer idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Integer idExperienciaLaboral;

    public boolean estado;

    public LocalDateTime fechaCreacion;

    public String rol;

    public String nombreEmpresa;

}
