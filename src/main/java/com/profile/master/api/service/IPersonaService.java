package com.profile.master.api.service;

import com.profile.master.api.model.Persona;
import com.profile.master.api.repo.IGenericRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonaService extends ICRUD<Persona, Integer> {

    Page<Persona> listarPageable(Pageable page);
}
