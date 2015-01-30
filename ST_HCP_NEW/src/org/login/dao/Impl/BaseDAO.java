package org.login.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.login.dao.IBaseDAO;

public class BaseDAO implements IBaseDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		
		return sessionFactory.openSession();
	}

}
