package com.profile.master.api.service.impl;

import com.profile.master.api.model.Persona;
import com.profile.master.api.model.Rol;

import com.profile.master.api.repo.IGenericRepo;

import com.profile.master.api.repo.IPersonaRepo;
import com.profile.master.api.repo.IRolRepo;
import com.profile.master.api.service.IRolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends CRUDImpl<Rol, Integer> implements IRolService {

    @Autowired
    private IRolRepo repo;

    @Override
    protected IGenericRepo<Rol, Integer> getRepo() {
        return repo;
    }


}
