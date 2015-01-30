package org.login.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nMarket.vo.Users;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.login.dao.IUsersDAO;

import system.dao.Impl.BaseDAO;
 
public class UsersDAO extends BaseDAO implements IUsersDAO {
	public boolean checkLogin(Users user) {
		Session session = null;
		session = getSession();
		String hql = "from Users u where u.username = ? and u.password = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List list = query.list();
		session.close();
		if (list.size()>0) {
			Users userMap=(Users)list.get(0);
			HttpServletRequest request =ServletActionContext.getRequest();
			HttpSession longinsession = request.getSession(); 
			longinsession.invalidate(); //删除所有session中保存的键 
//			longinsession.setAttribute("userid", userMap.getId().toString()); 
//			longinsession.setAttribute("username", userMap.getUsername().toString());  
//			longinsession.getAttribute("变量名"); //此时取出来的是Object, 一般需要强转 
//			longinsession.removeAttribute("变量名"); 
			

			return true;
		}
		return false;	
	}

	@Override
	public boolean deleteUser(Integer id) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			Users user = (Users)session.get(Users.class, id);
			session.delete(user);
			tx.commit();
			return true;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean saveUser(Users user) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			return true;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateUser(Users user) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			return true;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Users> findAllUsers() {
		List<Users> users = null;
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			String hsql = "from Users u";
			Query query = session.createQuery(hsql);
			users = query.list();
			tx.commit();
			return users;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	@Override
	public Users getUserById(Integer id) {
		Session session = null;
		session = getSession();
		String hql = "from Users u where u.id = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		List list = query.list();
		Users user = null;
		if (list.size()>0) {
			user = (Users)list.get(0);
		}
		session.close();
		return user;	
	}

}
