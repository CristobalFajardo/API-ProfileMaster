


package com.profile.master.api.service.impl;

import com.profile.master.api.model.ExperienciaLaboral;
import com.profile.master.api.repo.IExperienciaLaboralRepo;
import com.profile.master.api.service.IExperienciaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.profile.master.api.repo.IGenericRepo;



@Service
public class ExperienciaLaboralServiceImpl extends CRUDImpl<ExperienciaLaboral, Integer> implements IExperienciaLaboralService {

    @Autowired
    private IExperienciaLaboralRepo repo;

    @Override
    protected IGenericRepo<ExperienciaLaboral, Integer> getRepo() {
        return repo;
    }


}

