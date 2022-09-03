package com.profile.master.api.dto;

public class PersonaSkillDTO {

    public Integer idPersona;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String nombre;
    public String nombreSkill;
    public String anosExperiencia;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(String anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }
}
