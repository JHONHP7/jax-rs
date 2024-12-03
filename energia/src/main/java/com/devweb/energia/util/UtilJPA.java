package com.devweb.energia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {

	private static EntityManagerFactory emf;

	public static EntityManager getEm() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("energiaPU");
		}
		return emf.createEntityManager();
	}
}