package com.profile.master.api.service.impl;

import com.profile.master.api.model.Direccion;
import com.profile.master.api.repo.IDireccionRepo;
import com.profile.master.api.repo.IGenericRepo;
import com.profile.master.api.service.IDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 @Service
 public class DireccionServiceImpl extends CRUDImpl<Direccion, Integer> implements IDireccionService {

        @Autowired
        private IDireccionRepo repo;

        @Override
        protected IGenericRepo<Direccion, Integer> getRepo() {
            return repo;
        }


    }
