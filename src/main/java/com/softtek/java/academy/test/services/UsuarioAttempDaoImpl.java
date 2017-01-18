package com.softtek.java.academy.test.services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.softtek.java.academy.test.domain.UsuarioAttemp;

public class UsuarioAttempDaoImpl implements UsuarioAttempDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate();
		this.jdbcTemplate.setDataSource(dataSource);
	}

	public void addUsuarioAttemp(UsuarioAttemp usuarioAttemp) {
		jdbcTemplate.update("INSERT INTO USUARIO_ATTEMP (usuario_id, counter) VALUES (?, ?)",
				new Object[] { usuarioAttemp.getUsuarioId(),usuarioAttemp.getCounter()});
	}

	public UsuarioAttemp getUsuarioAttempById(int id) {
		UsuarioAttemp usuario = (UsuarioAttemp)jdbcTemplate.queryForObject(
				"SELECT * FROM USUARIO_ATTEMP WHERE id_usuario = ?",new Object[] {id},
				new BeanPropertyRowMapper<UsuarioAttemp>(UsuarioAttemp.class));
		return usuario;
	}

	public void updateUsuarioAttemp(UsuarioAttemp usuarioAttemp) {
		jdbcTemplate.update("update mytable set counter = ? where id = ?",
				usuarioAttemp.getCounter(), usuarioAttemp.getUsuarioId());
		
	}

}
