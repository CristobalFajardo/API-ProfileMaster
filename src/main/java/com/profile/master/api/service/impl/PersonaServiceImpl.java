package com.profile.master.api.service.impl;

import com.profile.master.api.model.Persona;
import com.profile.master.api.repo.IGenericRepo;
import com.profile.master.api.repo.IPersonaRepo;
import com.profile.master.api.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
