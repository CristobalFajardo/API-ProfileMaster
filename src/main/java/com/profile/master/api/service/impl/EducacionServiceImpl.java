package com.profile.master.api.service.impl;


import com.profile.master.api.model.Educacion;
import com.profile.master.api.repo.IEducacionRepo;
import com.profile.master.api.repo.IGenericRepo;
import com.profile.master.api.service.IEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionServiceImpl extends CRUDImpl<Educacion, Integer> implements IEducacionService {
    @Autowired
    private IEducacionRepo repo;

    @Override
    protected IGenericRepo<Educacion, Integer> getRepo() {
        return repo;
    }


}
