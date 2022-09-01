package com.profile.master.api.dto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class PersonaDTO {
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isOpenToWork() {
        return openToWork;
    }

    public void setOpenToWork(boolean openToWork) {
        this.openToWork = openToWork;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
       this.usuario = usuario;
    }

    public List<EducacionDTO> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<EducacionDTO> educacionList) {
        this.educacionList = educacionList;
    }

    public List<ExperienciaLaboralDTO> getExperienciaLaboralList() {
        return experienciaLaboralList;
    }

    public void setExperienciaLaboralList(List<ExperienciaLaboralDTO> experienciaLaboralList) {
        this.experienciaLaboralList = experienciaLaboralList;
    }

    public Integer idPersona;
    public boolean estado;
    public LocalDateTime fechaCreacion;
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String correo;
    public LocalDateTime fechaNacimiento;
    public boolean openToWork;
    public DireccionDTO direccion;

    public UsuarioDTO usuario;
    public List<EducacionDTO> educacionList;
    public List<ExperienciaLaboralDTO> experienciaLaboralList;

}
