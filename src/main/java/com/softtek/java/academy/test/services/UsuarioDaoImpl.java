package com.softtek.java.academy.test.services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.java.academy.test.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate();
		this.jdbcTemplate.setDataSource(dataSource);
	}
	
	public int getUsuarioCount() {
		final int rowCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USUARIO", Integer.class);
		System.out.println("Resultado: " + rowCount);
		return rowCount;
	}

	public Usuario getUsuarioById(int id) {
		Usuario usuario = (Usuario)jdbcTemplate.queryForObject(
				"SELECT * FROM USUARIO WHERE id = ?",new Object[] {id},
				new BeanPropertyRowMapper<Usuario>(Usuario.class));
		return usuario;
	}

	public void addUser(Usuario usuario) {
		jdbcTemplate.update("INSERT INTO USUARIO (id, name, lastname) VALUES (?, ?, ?)",
				new Object[] { usuario.getId(),usuario.getName(),usuario.getLastname()});
	}

	
}
