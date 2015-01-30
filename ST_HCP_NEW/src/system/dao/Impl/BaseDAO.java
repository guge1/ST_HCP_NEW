package system.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import system.dao.IBaseDAO;

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
