package com.softtek.java.academy.test.services;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value = { "/dataset/default.xml"}, connection = "dbUnitDatabaseConnection", type = DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class UsuarioDaoImplTest {
	
	@Autowired
	UsuarioDao usuarioDao;

	@Test
	@DatabaseSetup(value="/dataset/scenario1.xml", connection="dbUnitDatabaseConnection", type=DatabaseOperation.CLEAN_INSERT)
	public void testGetUsuarioCount() {
		int currentUsers = usuarioDao.getUsuarioCount();
		Assert.assertTrue(currentUsers==1);
	}

}
