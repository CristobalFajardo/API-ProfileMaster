package com.profile.master.api.service.impl;

import com.profile.master.api.model.Usuario;
import com.profile.master.api.repo.IGenericRepo;
import com.profile.master.api.repo.IUsuarioRepo;
import com.profile.master.api.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

    @Autowired
    private IUsuarioRepo repo;

    @Override
    protected IGenericRepo<Usuario, Integer> getRepo() {
        return repo;
    }


}
