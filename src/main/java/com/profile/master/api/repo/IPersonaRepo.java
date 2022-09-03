package com.profile.master.api.repo;

import com.profile.master.api.model.Educacion;
import com.profile.master.api.model.Persona;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPersonaRepo  extends IGenericRepo<Persona, Integer>{

    //SQL SQL Nativo
    //@Transactional
    //@Modifying
    @Query(value = "select * from persona where persona.open_to_work in('True')", nativeQuery = true)
    List<Object[]> openToWorkList();

    @Query(value = "select persona.id_persona, " +
            "persona.nombre," +
            "apellido_materno, " +
            "apellido_paterno, " +
            "correo," +
            "nombre_titulo," +
            "universidad," +
            "nombre_tipo_educacion " +
            " from persona inner join " +
            "persona_educacion on persona.id_persona = persona_educacion.id_persona inner join " +
            "educacion on persona_educacion.id_educacion = educacion.id_educacion inner join " +
            "tipo_educacion on educacion.id_tipo_educacion = tipo_educacion.id_tipo_educacion " +
            "where educacion.id_tipo_educacion in(1);", nativeQuery = true)
    List<Object[]> PersonaPregradoList();

    @Query(value = "select persona.id_persona, " +
            "persona.nombre," +
            "apellido_materno, " +
            "apellido_paterno, " +
            "correo," +
            "nombre_titulo," +
            "universidad," +
            "nombre_tipo_educacion " +
            " from persona inner join " +
            "persona_educacion on persona.id_persona = persona_educacion.id_persona inner join " +
            "educacion on persona_educacion.id_educacion = educacion.id_educacion inner join " +
            "tipo_educacion on educacion.id_tipo_educacion = tipo_educacion.id_tipo_educacion " +
            "where educacion.id_tipo_educacion in(2,3);", nativeQuery = true)
    List<Object[]> PersonaMasterDoctoradoList();

    @Query(value = "select persona.id_persona, " +
            "persona.nombre, " +
            " persona.apellido_paterno, " +
            "persona.apellido_materno, " +
            "skill.nombre_skill," +
            "skill.anos_experiencia " +
            "from persona inner join " +
            "persona_skill  on persona.id_persona = persona_skill.id_persona inner join " +
            "skill  on skill.id_skill = persona_skill.id_skill " +
            "where skill.anos_experiencia = :anosExperiencia ", nativeQuery = true)
    List<Object[]> PersonaAnosExperienciaList(@Param("anosExperiencia") int anosExperiencia);

    @Query(value = " select persona.id_persona, " +
            " persona.nombre, " +
            " persona.apellido_paterno, " +
            " persona.apellido_materno, " +
            " skill.nombre_skill, " +
            " skill.anos_experiencia " +
            " from persona inner join " +
            " persona_skill  on persona.id_persona = persona_skill.id_persona inner join " +
            " skill  on skill.id_skill = persona_skill.id_skill " +
            " where skill.nombre_skill like %:nombreSkill% ", nativeQuery = true)
    List<Object[]> PersonaBuscarSkillList(@Param("nombreSkill") String nombreSkill);

    @Query(value = " select persona.id_persona, " +
            " persona.nombre, " +
            " persona.apellido_paterno, " +
            " persona.apellido_materno, " +
            " direccion.pais " +
            " from persona inner join " +
            " direccion  on persona.id_direccion = direccion.id_direccion " +
            " where direccion.pais like %:nombrePais% ", nativeQuery = true)
    List<Object[]> PersonaBuscarPaisList(@Param("nombrePais") String nombrePais);


}