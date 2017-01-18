package com.softtek.java.academy.test.services;

import com.softtek.java.academy.test.domain.UsuarioAttemp;

public interface UsuarioAttempDao {
	
	void addUsuarioAttemp(UsuarioAttemp usurioAttemp);
	
	UsuarioAttemp getUsuarioAttempById(int id);
	
	void updateUsuarioAttemp(UsuarioAttemp usuarioAttemp);
}
