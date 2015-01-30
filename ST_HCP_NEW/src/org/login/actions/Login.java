package org.login.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nMarket.vo.Users;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.login.service.IUsersService;

import system.dao.IPublicDAO;
import system.dao.ISqlDAO;
import system.dao.Impl.PublicPageDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial","unchecked"})
public class Login extends ActionSupport implements ServletRequestAware {
//return mapping.findForward("error");
	private static final String UPDATE = "update";

	private ISqlDAO sqlDao = null;
	private HttpServletRequest request = null; 

	private IPublicDAO publicDao=null;

	public IPublicDAO getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(IPublicDAO publicDao) {
		this.publicDao = publicDao;
	}

	private PublicPageDAO publicPageDAO = null;
	public ISqlDAO getSqlDao() {
		return sqlDao;
	}

	public void setSqlDao(ISqlDAO sqlDao) {
		this.sqlDao = sqlDao;
	}

	public PublicPageDAO getPublicPageDAO() {
		return publicPageDAO;
	}

	public void setPublicPageDAO(PublicPageDAO publicPageDAO) {
		this.publicPageDAO = publicPageDAO;
	}
	private IUsersService userService = null;
	
	private String id = null;
	private String name = null;
	private String password = null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public IUsersService getUserService() {
		return userService;
	}

	public void setUserService(IUsersService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		Users user = new Users();
		user.setUsername(name);
		user.setPassword(password);

		if("".equals(name)||name==null)
		{
			HttpServletResponse response=ServletActionContext.getResponse();
		    publicDao.responseMessage(response,"alert('对不起用户名为空，请重新登录');self.location.href='userExit.action'; ");
		    return "fail";
		}
		if("".equals(password)||password==null)
		{
			HttpServletResponse response=ServletActionContext.getResponse();
		    publicDao.responseMessage(response,"alert('对不起用户密码为空，请重新登录');self.location.href='userExit.action'; ");
		    return "fail";
		}
		
		if (checkLogin(  user )) {
			return SUCCESS;
		}
		//return INPUT;
		//response.getWriter().write("alert(有)");
		HttpServletResponse response=ServletActionContext.getResponse();
	    publicDao.responseMessage(response,"alert('对不起用户名或者密码错误，请重新登录');self.location.href='userExit.action'; ");
 
		return "fail";
	}
	 
	public boolean checkLogin(Users user ) {
		String strSql = "select p.*  from   users  p where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'  ";
		//System.out.println(strSql);
		List listUser = sqlDao.queryListBySqlNoSession(strSql);
		if(listUser!=null&&listUser.size()>0)
		{ 
			Integer intID= publicDao.NullToNumber(  publicPageDAO.GetFieldValue(listUser, "id", 0));
			String usertype= publicDao.NullToStr(  publicPageDAO.GetFieldValue(listUser, "usertype", 0));
			user.setId(intID);
			user.setUsertype(usertype);
			
			Map session = ActionContext.getContext().getSession();
			session.put("userInfo", user);
		}else
		{
			return false;
		}
		return true;
	}

	public String userExit() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}
	public String returnVoid() throws Exception {
		return "default";
	}
	public String save() throws Exception {
		Users user = new Users();
		user.setUsername(name);
		user.setPassword(password);
		if (getUserService().saveUser(user)) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String update() throws Exception {
		Users user = null;
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		if ("loading".equals(action)) {
			user = new Users();
			user = getUserService().getUserById(Integer.valueOf(id));
			if (null != user) {
				request.setAttribute("user", user);
			}
			return UPDATE;
			
		} else {
			user = new Users();
			user.setUsername(name);
			user.setPassword(password);
			user.setId(Integer.valueOf(id));
			if (getUserService().updateUser(user)) {
				return SUCCESS;
			}
		}
		
		return ERROR;
	}
	
	public String delete() throws Exception {
		String id = request.getParameter("id");
		if (getUserService().deleteUser(Integer.valueOf(id))) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	public String findAllUsers() throws Exception {
		List<Users> list = publicDao.findAllList("  from Users u   "); 
		if (list.size() > 0) {
			for(int i=0;i<list.size();i++)
			{
				Users map=(Users)list.get(i);
				System.out.println(map.getUsername());
			}
			request.setAttribute("list", list);
			return SUCCESS;
		}
		return ERROR;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	 
}
