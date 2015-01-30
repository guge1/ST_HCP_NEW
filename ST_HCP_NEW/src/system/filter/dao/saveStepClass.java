package system.filter.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nMarket.vo.Users;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import system.dao.IPublicDAO;
import system.dao.ISqlDAO;
import system.dao.Impl.PublicDateDAO;
import system.dao.Impl.PublicPageDAO;
import system.dao.Impl.PublicSourceDAO;
import system.publicClass.PublicMethod;

public class saveStepClass extends ActionSupport implements ServletRequestAware  {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IPublicDAO publicDao = null;
	private ISqlDAO  sqlDao=null;
	
	private PublicDateDAO publicDateDAO=null;
	public PublicDateDAO getPublicDateDAO() {
		return publicDateDAO;
	}

	public void setPublicDateDAO(PublicDateDAO publicDateDAO) {
		this.publicDateDAO = publicDateDAO;
	}
	
	private PublicPageDAO publicPageDAO = null;


	public IPublicDAO getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(IPublicDAO publicDao) {
		this.publicDao = publicDao;
	}

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

	
	private HttpServletRequest Request = null;
	public void setServletRequest(HttpServletRequest Request) {
		this.Request = Request;
	}
	
	 

	/**
	 * 根据 月份和年份
	 * @param intYear
	 * @param intMonth
	 * @param strUserID
	 * @param request
	 * @return
	 */
	public  boolean quryCaseStepID(String  strUrl, HttpServletRequest request, HttpServletResponse response ) {  

		  boolean isTrue=true;
	        String[] strLeftUrl=	  PublicSourceDAO.strLeftUrl;
	        for (int n = 0; n < strLeftUrl.length; n++)
			{//行字段
	        	String strFieldNames = publicDao.NullToStr(strLeftUrl[n]);
				String url=strFieldNames;
				String strFieldCName=strFieldNames;
				if(url.split(",").length>1)
				{
					 url=strFieldNames.split(",")[0];//英文名称
					  strFieldCName=strFieldNames.split(",")[1];//中午名称
				}
				
				if("queryNextYueFen_JianKong.action".equals(strUrl))
				{
					String strType=PublicMethod.NullToStr( request.getParameter("type"));
					if(!"".equals(strType))
					{
					  strUrl=strUrl+"?type="+PublicMethod.NullToStr( request.getParameter("type"));
					}
				}
				 if(strUrl.indexOf(url) >-1&&!"".equals(url))
				 {
						Users userInfo=sqlDao.gerUserInfo( request);
						
						int preInt=0;
						int	intYear=publicDao.getCurrentDateYear(preInt);
						int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
						 
						String	strUserID=  userInfo.getId()+"";
						 
						String strSql="select   s.caseid   caseid,CASESAVE  from n_marketcase s  where  CASETYPE='1'    ";
						strSql+="  and   (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "' ) " +
						"and  userid='"+strUserID+"' and  CASETYPE='1'  and  (delStatus!='1' or delStatus is  null or delStatus='')  ";
						List listList =   sqlDao.queryListBySqlNoSession(strSql);
						String strCaseID="";
						if(listList!=null&&listList.size()>0)
						{
							strCaseID=	publicPageDAO.GetFieldValue(listList, "caseid", 0);
						    Integer 	CASESAVE= PublicMethod.NullToNumber(publicPageDAO.GetFieldValue(listList, "CASESAVE", 0));
						    request.setAttribute("CASESAVE", CASESAVE);//判断项目是否保存了

							StringBuilder sb=new StringBuilder();
						    if(n> CASESAVE&&n>0 )
					        {
					        	
					        	strFieldNames = publicDao.NullToStr(strLeftUrl[CASESAVE]);
								 url=strFieldNames;
								 strFieldCName=strFieldNames;
								if(url.split(",").length>1)
								{
									 url=strFieldNames.split(",")[0];//英文名称
									  strFieldCName=strFieldNames.split(",")[1];//中午名称
								}
								sb.append(" alert('【"+strFieldCName+"】还未填写！当前不能操作！');  window.location.href='"+url+"';");
					        	response.setCharacterEncoding("UTF-8");
								response.setContentType("text/html; charset=utf-8");
								 
								isTrue=false;
								
					        }
					        if(n<=CASESAVE&&CASESAVE>0)
					        {//设置只读
					        
								isTrue=true;
								sb.append(" var Objbuttons=document.getElementsByTagName('input'); "); 
								sb.append(" 	 for(i=0;i<Objbuttons.length;i++){ ");
								sb.append("   if(Objbuttons[i].type=='' ||  Objbuttons[i].type=='text' ){ ");
								sb.append("   Objbuttons[i].disabled=true; ");
								sb.append("  Objbuttons[i].backgroundcolor='#C3CCDB';");
								sb.append("   }}");
					        }
							response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html; charset=utf-8");
							//response.getWriter().write("<script>"+strContent+"</script>");
							try {
								response.getWriter().write(" <script type=\"text/javascript\">"+sb.toString()+"</script>");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return isTrue;
						}
						
		           } 
			}
	        String[] strLeftUrl_save=	  PublicSourceDAO.strLeftUrl_save;
			 for (int n = 0; n < strLeftUrl_save.length; n++)
				{//行字段
		        	String strFieldNames = publicDao.NullToStr(strLeftUrl_save[n]);
					String url=strFieldNames;
					String strFieldCName=strFieldNames;
					if(url.split(",").length>1)
					{
						 url=strFieldNames.split(",")[0];//英文名称
						  strFieldCName=strFieldNames.split(",")[1];//中午名称
					}
					 if(strUrl.indexOf(url) >-1&&!"".equals(url))
					 {	
						int preInt=0;
						int	intYear=publicDao.getCurrentDateYear(preInt);
						int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
					   // String		strCaseID=	 publicDateDAO.quryCaseID(intYear, intMonth, "", request);

						Users userInfo=sqlDao.gerUserInfo( request);
					    String	strUserID=  userInfo.getId()+"";
						 
						String strSql="select   s.caseid   caseid,CASESAVE  from n_marketcase s  where  CASETYPE='1'    ";
						strSql+="  and   (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "' ) " +
						"and  userid='"+strUserID+"' and  CASETYPE='1'  and  (delStatus!='1' or delStatus is  null or delStatus='')  ";
						List listList =   sqlDao.queryListBySqlNoSession(strSql);
						String strCaseID="";
						if(listList!=null&&listList.size()>0)
						{
							strCaseID=	publicPageDAO.GetFieldValue(listList, "caseid", 0);
						    Integer 	CASESAVE= PublicMethod.NullToNumber(publicPageDAO.GetFieldValue(listList, "CASESAVE", 0));
						    request.setAttribute("CASESAVE", CASESAVE);//判断项目是否保存了
						    if(CASESAVE<n+1)
						    {
							    String  strSaveSql="update n_marketcase  set CASESAVE='"+(n+1)+"'        where    caseid='"+strCaseID+"'   ";
								sqlDao.insertWithSql(strSaveSql);
								request.setAttribute("CASESAVE", n);//判断项目是否保存了
						    }
						
						}
						break;
					 }	
				}

				return isTrue;
		 
	}
}
 