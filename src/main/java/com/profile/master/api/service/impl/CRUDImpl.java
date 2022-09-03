package com.profile.master.api.service.impl;

import com.profile.master.api.repo.IGenericRepo;
import com.profile.master.api.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID>{

	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T registrar(T p) throws Exception {
		return getRepo().save(p);
	}

	@Override
	public T modificar(T p) throws Exception {
		return getRepo().save(p);
	}

	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}

}
