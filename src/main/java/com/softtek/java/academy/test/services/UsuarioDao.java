package com.softtek.java.academy.test.services;

import com.softtek.java.academy.test.domain.Usuario;

public interface UsuarioDao {

	int getUsuarioCount();
	Usuario getUsuarioById(int id);
	void addUser(Usuario usuario);
}
