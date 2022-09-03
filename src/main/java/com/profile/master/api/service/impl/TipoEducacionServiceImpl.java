package com.profile.master.api.service.impl;

import com.profile.master.api.model.TipoEducacion;
import com.profile.master.api.repo.IGenericRepo;
import com.profile.master.api.repo.ITipoEducacionRepo;
import com.profile.master.api.service.ITipoEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoEducacionServiceImpl extends CRUDImpl<TipoEducacion, Integer> implements ITipoEducacionService {

    @Autowired
    private ITipoEducacionRepo repo;

    @Override
    protected IGenericRepo<TipoEducacion, Integer> getRepo() {
        return repo;
    }


}
