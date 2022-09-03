package com.profile.master.api.service;

import com.profile.master.api.dto.PersonaDTO;
import com.profile.master.api.dto.PersonaPaisDTO;
import com.profile.master.api.dto.PersonaSkillDTO;
import com.profile.master.api.dto.PersonaTipoEducacionDTO;
import com.profile.master.api.model.Persona;
import com.profile.master.api.repo.IGenericRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonaService extends ICRUD<Persona, Integer> {

    Page<Persona> listarPageable(Pageable page);

    List<PersonaDTO> openToWorkList();

    List<PersonaTipoEducacionDTO> personaPregadoList();

    List<PersonaTipoEducacionDTO> personaMasterDoctoradoList();

    List<PersonaSkillDTO> personaAnosExperienciaList(int anosExperiencia);

    List<PersonaSkillDTO> personaBuscarSkillList(String nombreSkill);

     List<PersonaPaisDTO> personaBuscarPaisList(String nombrePais);
}
