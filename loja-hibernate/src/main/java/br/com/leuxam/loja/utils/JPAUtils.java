package br.com.leuxam.loja.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja-hibernate");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
