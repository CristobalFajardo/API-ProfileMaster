package com.profile.master.api.service.impl;

import com.profile.master.api.model.Skill;
import com.profile.master.api.repo.IGenericRepo;
import com.profile.master.api.repo.ISkillRepo;
import com.profile.master.api.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl extends CRUDImpl<Skill, Integer> implements ISkillService {

    @Autowired
    private ISkillRepo repo;

    @Override
    protected IGenericRepo<Skill, Integer> getRepo() {
        return repo;
    }


}
