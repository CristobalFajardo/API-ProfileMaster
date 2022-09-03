package com.profile.master.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "educacion")
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idEducacion;

    @Column(name = "estado",insertable = false,updatable = false)
    public boolean estado;
    @Column(name = "fecha_creacion",insertable = false,updatable = false)
    public LocalDateTime fechaCreacion;
    @Column(name = "anos_experiencia")
    public int anosExperiencia;
    @Column(name = "fecha_inicio")
    public LocalDateTime fechaInicio;
    @Column(name = "fecha_termino")
    public LocalDateTime fechaTermino;
    @Column(name = "nombre_titulo")
    public String nombreTitulo;
    @Column(name = "universidad")
    public String universidad;
    @ManyToOne
    @JoinColumn(name = "id_tipo_educacion", foreignKey = @ForeignKey(name = "FK_persona_tipo_educacion"))
    public TipoEducacion educacion;

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

    public TipoEducacion getEducacion() {
        return educacion;
    }

    public void setEducacion(TipoEducacion educacion) {
        this.educacion = educacion;
    }




}
