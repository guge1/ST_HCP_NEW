package system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import system.filter.dao.saveStepClass;

import nMarket.vo.Users;

 
 

public class SecurityFilter implements Filter{

	private FilterConfig filterConfig;
	public void destroy() {
		 
	}

	/**
	 * 登录超时
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest)req;
		 HttpServletResponse response = (HttpServletResponse)res;
		 HttpSession session = request.getSession(false);
		 
		 Users users = null;
		 if(session!=null){
			 users = (Users)session.getAttribute("userInfo");
		 }
		 
		 String currentURI = request.getRequestURI();
		//String  ss= getUrl(request) ;
		 currentURI=currentURI==null?"":currentURI.toLowerCase();
		   // System.out.println(" "+currentURI);
		 if(currentURI.endsWith("/jsp/login/login.jsp")||currentURI.endsWith("/hcp/")||currentURI.endsWith("/")||currentURI.endsWith("userexit.action")){//index.jsp
			 chain.doFilter(request, response);
			 return;
		 }
		 if(currentURI.endsWith(".jsp")||currentURI.endsWith(".action"))
		 {
			//  System.out.println("dddddddddddddddddd"+currentURI);
		 }
		
		 if(currentURI.endsWith("/jsp/login/login.jsp")||currentURI.endsWith("userexit.action")||currentURI.endsWith("logon.action")||currentURI.endsWith("logon.action")||currentURI.endsWith("/")
				 ||currentURI.endsWith(".gif") ||currentURI.endsWith(".css")||currentURI.endsWith(".js")
				 ||currentURI.endsWith(".bmp")||currentURI.endsWith(".png")||currentURI.endsWith(".jpg")
				 ||currentURI.endsWith(".htm")||currentURI.endsWith(".html")||currentURI.endsWith(".swf")){
			 chain.doFilter(request, response);
		 }else{
			 if(users==null){
				 String path = request.getContextPath();//getUrl(request) +
				 String  url= getUrl(   request);
				 System.out.println(" "+url);
				 String newPath= url+ "userExit.action";
				    String strContent=" try{window.location.href='"+newPath+"';   window.parent.parent.location.href='"+newPath+"';  window.parent.parent.parent.location.href='"+newPath+"'; }catch(e){ }   ";//alert('登录用户信息过期，请重新登录'); 
				    try { 	

						response.setCharacterEncoding("UTF-8");
						response.setContentType("text/html; charset=utf-8");
						response.getWriter().write("<script>"+strContent+"</script>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				// response.sendRedirect(path + "/jsp/login/login.jsp"); 
			 }else{
				 boolean isTrue=setSaveStatus(  request.getRequestURI(), request,response);
				// isTrue=true;
				 if(isTrue)
				 {
				       chain.doFilter(request, response);
			     }
			 }
		 }
	}
	public  boolean   setSaveStatus( String strUrl,HttpServletRequest request, HttpServletResponse response)
	{	
		boolean isTrue=true;
		try {
			system.publicClass.PublicInit publicInit=new system.publicClass.PublicInit(filterConfig);
			 //PublicDateDAO 	publicDateDAO = (PublicDateDAO)getBeanByFilterConfigParameterName("DaoName");
			// ISqlDAO sqlDao =(ISqlDAO)publicInit.getBeanByFilterConfigParameterName("DaoName");
			 //PublicDateDAO PublicDateDAO =(PublicDateDAO)publicInit.getBeanByFilterConfigParameterName("DateDAO");
			saveStepClass saveStepClass =(saveStepClass)publicInit.getBeanByFilterConfigParameterName("DateDAO");
			// PublicDateDAO.quryCaseStepID(2011, 1, "", 1, request);
			// Users userInfo=sqlDao.gerUserInfo( request);
			// saveStepClass saveStepClass=new saveStepClass(sqlDao);
			//publicDateDAO.quryCaseStepID(2011, 1, "", 2, request);
			  isTrue=	saveStepClass.quryCaseStepID( strUrl, request,response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return   isTrue;
	
}
	public  String getUrl( HttpServletRequest request)
	{
		String strPrjName="/ST_HCP_NEW";
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()   ;
		if(!"".equals( request.getServerPort()))
		{
		   basePath+=  ":" + request.getServerPort() ;
		}
		if(strPrjName.equals(path))
		{
		   basePath+= path + "/";
		}else
		{
			 basePath+= "/";
		}
		return basePath;
	}
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		
	}

}
