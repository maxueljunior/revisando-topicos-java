package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilMySQL {
	
	private static final EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory("loja-mysql");

	public static EntityManager getEntityManager() { 
		return FACTORY.createEntityManager();
	}
	
}
