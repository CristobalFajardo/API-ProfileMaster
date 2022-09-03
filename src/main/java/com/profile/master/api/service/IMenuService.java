package com.profile.master.api.service;

import com.profile.master.api.model.Menu;

import java.util.List;

public interface IMenuService extends ICRUD<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
