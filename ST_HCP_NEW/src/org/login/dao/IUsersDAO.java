package org.login.dao;

import java.util.List;

import nMarket.vo.Users;


@SuppressWarnings("unchecked")
public interface IUsersDAO {

	public boolean checkLogin(Users user);
	
	public boolean saveUser(Users user);
	
	public boolean deleteUser(Integer id);
	
	public boolean updateUser(Users user);
	
	public List<Users> findAllUsers();
	
	public Users getUserById(Integer id);
}
