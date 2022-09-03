package com.profile.master.api.service.impl;

import com.profile.master.api.dto.PersonaDTO;
import com.profile.master.api.dto.PersonaPaisDTO;
import com.profile.master.api.dto.PersonaSkillDTO;
import com.profile.master.api.dto.PersonaTipoEducacionDTO;
import com.profile.master.api.model.Persona;
import com.profile.master.api.repo.IGenericRepo;
import com.profile.master.api.repo.IPersonaRepo;
import com.profile.master.api.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

    @Autowired
    private IPersonaRepo repo;

    @Override
    protected IGenericRepo<Persona, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Persona> listarPageable(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public List<PersonaDTO> openToWorkList() {
        //List<Object[]>
        //[2,	"12/02/2022"]
        //[2,	"19/02/2022"]
        //[3,	"29/01/2022"]
        List<PersonaDTO> personaDTOList = new ArrayList<>();

        repo.openToWorkList().forEach(x -> {
            PersonaDTO cr = new PersonaDTO();
            cr.setIdPersona(Integer.parseInt(String.valueOf(x[0])));
            cr.setApellidoMaterno(String.valueOf(x[1]));
            cr.setApellidoPaterno(String.valueOf(x[2]));
            cr.setCorreo(String.valueOf(x[3]));
            cr.setEstado(Boolean.valueOf(x[4].toString()));
            //cr.setFechaCreacion(LocalDateTime.parse(x[5]));
            //cr.setFechaNacimiento(String.valueOf(x[6]));
            cr.setNombre(String.valueOf(x[7]));
            cr.setOpenToWork(Boolean.valueOf(x[8].toString()));




            personaDTOList.add(cr);
        });

        return personaDTOList;
    }

    @Override
    public List<PersonaTipoEducacionDTO> personaPregadoList() {
        //List<Object[]>
        //[2,	"12/02/2022"]
        //[2,	"19/02/2022"]
        //[3,	"29/01/2022"]
        List<PersonaTipoEducacionDTO> PersonaTipoEducacionDTOList = new ArrayList<>();

        repo.PersonaPregradoList().forEach(x -> {
            PersonaTipoEducacionDTO cr = new PersonaTipoEducacionDTO();
            cr.setIdPersona(Integer.parseInt(String.valueOf(x[0])));
            cr.setNombre(String.valueOf(x[1]));
            cr.setApellidoMaterno(String.valueOf(x[2]));
            cr.setApellidoPaterno(String.valueOf(x[3]));
            cr.setCorreo(String.valueOf(x[4]));
            cr.setNombreTitulo(String.valueOf(x[5].toString()));
            cr.setUniversidad(String.valueOf(x[6]));
            cr.setNombreTipoEducacion(String.valueOf(x[7]));





            PersonaTipoEducacionDTOList.add(cr);
        });

        return PersonaTipoEducacionDTOList;
    }

    @Override
    public List<PersonaTipoEducacionDTO> personaMasterDoctoradoList() {
        //List<Object[]>
        //[2,	"12/02/2022"]
        //[2,	"19/02/2022"]
        //[3,	"29/01/2022"]
        List<PersonaTipoEducacionDTO> PersonaTipoEducacionDTOList = new ArrayList<>();

        repo.PersonaMasterDoctoradoList().forEach(x -> {
            PersonaTipoEducacionDTO cr = new PersonaTipoEducacionDTO();
            cr.setIdPersona(Integer.parseInt(String.valueOf(x[0])));
            cr.setNombre(String.valueOf(x[1]));
            cr.setApellidoMaterno(String.valueOf(x[2]));
            cr.setApellidoPaterno(String.valueOf(x[3]));
            cr.setCorreo(String.valueOf(x[4]));
            cr.setNombreTitulo(String.valueOf(x[5].toString()));
            cr.setUniversidad(String.valueOf(x[6]));
            cr.setNombreTipoEducacion(String.valueOf(x[7]));





            PersonaTipoEducacionDTOList.add(cr);
        });

        return PersonaTipoEducacionDTOList;
    }
    @Override
    public List<PersonaSkillDTO> personaAnosExperienciaList(int anosExperiencia) {

        List<PersonaSkillDTO> PersonaSkillDTOList = new ArrayList<>();

        repo.PersonaAnosExperienciaList(anosExperiencia).forEach(x -> {
            PersonaSkillDTO cr = new PersonaSkillDTO();
            cr.setIdPersona(Integer.parseInt(String.valueOf(x[0])));
            cr.setNombre(String.valueOf(x[1]));;
            cr.setApellidoPaterno(String.valueOf(x[2]));;
            cr.setApellidoMaterno(String.valueOf(x[3]));;
            cr.setNombreSkill(String.valueOf(x[4]));;
            cr.setAnosExperiencia(String.valueOf(String.valueOf(x[5])));

            PersonaSkillDTOList.add(cr);
        });

        return PersonaSkillDTOList;
    }

    @Override
    public List<PersonaSkillDTO> personaBuscarSkillList(String nombreSkill) {

        List<PersonaSkillDTO> PersonaSkillDTOList = new ArrayList<>();

        repo.PersonaBuscarSkillList(nombreSkill).forEach(x -> {
            PersonaSkillDTO cr = new PersonaSkillDTO();
            cr.setIdPersona(Integer.parseInt(String.valueOf(x[0])));
            cr.setNombre(String.valueOf(x[1]));;
            cr.setApellidoPaterno(String.valueOf(x[2]));;
            cr.setApellidoMaterno(String.valueOf(x[3]));;
            cr.setNombreSkill(String.valueOf(x[4]));;
            cr.setAnosExperiencia(String.valueOf(String.valueOf(x[5])));

            PersonaSkillDTOList.add(cr);
        });

        return PersonaSkillDTOList;
    }

    @Override
    public List<PersonaPaisDTO> personaBuscarPaisList(String nombrePais) {

        List<PersonaPaisDTO> PersonaPaisDTOList = new ArrayList<>();

        repo.PersonaBuscarPaisList(nombrePais).forEach(x -> {
            PersonaPaisDTO cr = new PersonaPaisDTO();
            cr.setIdPersona(Integer.parseInt(String.valueOf(x[0])));
            cr.setNombre(String.valueOf(x[1]));;
            cr.setApellidoPaterno(String.valueOf(x[2]));;
            cr.setApellidoMaterno(String.valueOf(x[3]));;
            cr.setPais(String.valueOf(x[4]));;


            PersonaPaisDTOList.add(cr);
        });

        return PersonaPaisDTOList;
    }



}
