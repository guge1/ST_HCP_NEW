package org.login.service.Impl;

import java.util.List;

import nMarket.vo.Users;

import org.login.dao.IUsersDAO;
import org.login.service.IUsersService;

import system.dao.IPublicDAO;

@SuppressWarnings("unchecked")
public class UsersService implements IUsersService {

	private IUsersDAO userDAO = null;
	private IPublicDAO publicDao=null;
	
	
	public IUsersDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IPublicDAO getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(IPublicDAO publicDao) {
		this.publicDao = publicDao;
	}

	public boolean checkLogin(Users user) {
		
		return userDAO.checkLogin(user);
	}

	
	public boolean deleteUser(Integer id) {
		
		return userDAO.deleteUser(id);
	}

	
	public boolean saveUser(Users user) {
		
		return userDAO.saveUser(user);
	}

	
	public boolean updateUser(Users user) {
		
		return userDAO.updateUser(user);
	}

	
	public List<Users> findAllUsers() {
		return	publicDao.findAllList(" from Users u ");
	//	return userDAO.findAllUsers();
	}

	
	public Users getUserById(Integer id) {
		
		return userDAO.getUserById(id);
	}

}
