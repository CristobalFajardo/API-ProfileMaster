package com.profile.master.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idPersona;
    @Column(name = "estado",insertable = false,updatable = false)
    public boolean estado;
    @Column(name = "fecha_creacion",insertable = false,updatable = false)
    public LocalDateTime fechaCreacion;
    @Column(name = "nombre")
    public String nombre;
    @Column(name = "apellidoPaterno")
    public String apellidoPaterno;
    @Column(name = "apellidoMaterno")
    public String apellidoMaterno;
    @Column(name = "correo")
    public String correo;
    @Column(name = "fecha_nacimiento")
    public LocalDateTime fechaNacimiento;
    @Column(name = "open_to_work")
    public boolean openToWork;
    @ManyToOne
    @JoinColumn(name = "id_direccion", foreignKey = @ForeignKey(name = "FK_persona_direccion"))
    public Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_persona_usuario"))
    public Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "persona_educacion", joinColumns = @JoinColumn(name = "id_persona", referencedColumnName = "idPersona"), inverseJoinColumns = @JoinColumn(name = "id_educacion", referencedColumnName = "idEducacion"))
    public List<Educacion> educacionList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "persona_experiencia_laboral", joinColumns = @JoinColumn(name = "id_persona", referencedColumnName = "idPersona"), inverseJoinColumns = @JoinColumn(name = "id_experiencia_laboral", referencedColumnName = "idExperienciaLaboral"))
    public List<ExperienciaLaboral> experienciaLaboralList;


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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    public List<ExperienciaLaboral> getExperienciaLaboralList() {
        return experienciaLaboralList;
    }

    public void setExperienciaLaboralList(List<ExperienciaLaboral> experienciaLaboralList) {
        this.experienciaLaboralList = experienciaLaboralList;
    }



}
