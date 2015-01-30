package nMarket.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import system.dao.IPublicDAO;
import system.dao.ISqlDAO;
import system.dao.Impl.PublicDateDAO;
import system.dao.Impl.PublicPageDAO;
import system.dao.Impl.PublicSourceDAO;
import system.publicClass.PublicMethod;

import com.opensymphony.xwork2.ActionSupport;

 
public class StaticAction extends ActionSupport implements ServletRequestAware {

	private static final String UPDATE = "update";
	public static List<String> MONTH_LIST = Arrays.asList("Jan", "Feb", "Mar",  
			   "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");  
	public String returnDfault = "default";
	private HttpServletRequest request = null;
	private IPublicDAO publicDao = null;
	private PublicPageDAO publicPageDAO = null;
	private PublicSourceDAO publicSourceDAO = null;

	private ISqlDAO sqlDao = null;
	private PublicDateDAO publicDateDAO=null;
	public PublicDateDAO getPublicDateDAO() {
		return publicDateDAO;
	}

	public void setPublicDateDAO(PublicDateDAO publicDateDAO) {
		this.publicDateDAO = publicDateDAO;
	}
	public IPublicDAO getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(IPublicDAO publicDao) {
		this.publicDao = publicDao;
	}

	public PublicPageDAO getPublicPageDAO() {
		return publicPageDAO;
	}

	public void setPublicPageDAO(PublicPageDAO publicPageDAO) {
		this.publicPageDAO = publicPageDAO;
	}

	public PublicSourceDAO getPublicSourceDAO() {
		return publicSourceDAO;
	}

	public void setPublicSourceDAO(PublicSourceDAO publicSourceDAO) {
		this.publicSourceDAO = publicSourceDAO;
	}


	public ISqlDAO getSqlDao() {
		return sqlDao;
	}

	public void setSqlDao(ISqlDAO sqlDao) {
		this.sqlDao = sqlDao;
	}

  
	public String  queryDclStatic() {
 
		String strSql = "select p.*  from   users  p   where id  not in(10000,10002) order by id  ";
		//System.out.println(strSql);
		List listUser = sqlDao.queryListBySqlNoSession(strSql);
		StringBuffer sbSqlWhere=new StringBuffer();

		StringBuffer sb=new StringBuffer();
		StringBuffer sbHead=new StringBuffer();
 
		sb.append("    <colgroup>");
		sb.append("        <col width=\"80px\" />");
		sbHead.append("    <tr  height=\"28\"   style=\"height: 28px;\">");
		sbHead.append("    <td    background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\" > <div align=\"center\" >");
		 sbHead.append("轮次");
		 sbHead.append("    </div></td>"); 
		if(listUser!=null&&listUser.size()>0)
		{ 
			for(int i=0;i<listUser.size();i++)
			{
				sb.append("        <col width=\"80px\" />");
				String strUserID=	 publicPageDAO.GetFieldValue(listUser, "id", i);
				String username=	 publicPageDAO.GetFieldValue(listUser, "username", i);
				sbSqlWhere.append(username+"=isnull(sum(case userid when '"+strUserID+"' then a.ZDCL end),0)  , ");
				sbHead.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
				sbHead.append(username);
				sbHead.append("    </div></div></td>"); 
			}
		}
		sbHead.append("    </colgroup>");
		 sbHead.append("    </tr>");
		 sb.append(sbHead.toString());
		 
		sbSqlWhere.append(" ''aa ");
		List listResult = publicDateDAO.queryDclList(sbSqlWhere.toString(), request);
		Map contentMap=new HashMap();
		//组装内容
		if(listResult!=null&&listResult.size()>0)
		{ 
			String strUserID="";
			String username="";
			String dcl="";
			for (int j = 0; j < listResult.size(); j++) 
			{
				contentMap=(Map)listResult.get(j);
				 sb.append("    <tr  height=\"28\" >"); 
				 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
				 sb.append("第"+(j+1)+"轮");
				 sb.append("    </div></td>"); 
				if(listUser!=null&&listUser.size()>0)
				{ 
					for(int i=0;i<listUser.size();i++)
					{
						 strUserID=	 publicPageDAO.GetFieldValue(listUser, "id", i);
						 username=	 publicPageDAO.GetFieldValue(listUser, "username", i);
						 dcl= PublicMethod.NullToStr(contentMap.get(username));

						 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
						 sb.append(dcl);
						 sb.append("%</div></td>"); 
					}
				}
				 sb.append("    </tr>");
			}
		}
		request.setAttribute("PageContent", sb.toString()); 
		return returnDfault;
	}
	/**
	 * 表二：客户优先顺序排序							
	 * @return
	 */
	public String  queryOrderStatic() {
      
		String  strpreInt=request.getParameter("preInt")==null?"3":request.getParameter("preInt").toString();
		int preInt=PublicMethod.NullToNumber(strpreInt);
		String strSql = "select p.*  from   users  p  where id  not in(10000,10002)   order by id  ";
		//System.out.println(strSql);
		List listUser = sqlDao.queryListBySqlNoSession(strSql);
		StringBuffer sbSqlWhere=new StringBuffer();

		StringBuffer sb=new StringBuffer();
		StringBuffer sbHead=new StringBuffer();
 
		sb.append("    <colgroup>");
		sb.append("        <col width=\"80px\" />");
		sb.append("        <col width=\"80px\" />");
		sbHead.append("    <tr  height=\"28\"   style=\"height: 28px;\">");
		sbHead.append("    <td    background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\" > <div align=\"center\" >");
		 sbHead.append("序号");
		 sbHead.append("    </div></td>"); 
			sbHead.append("    <td    background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\" > <div align=\"center\" >");
			 sbHead.append("代表");
			 sbHead.append("    </div></td>"); 
		if(listUser!=null&&listUser.size()>0)
		{ 
			for(int i=0;i<listUser.size();i++)
			{
				sb.append("        <col width=\"80px\" />");
				String strUserID=	 publicPageDAO.GetFieldValue(listUser, "id", i);
				String username=	 publicPageDAO.GetFieldValue(listUser, "username", i);
				sbSqlWhere.append(username+"=isnull(sum(case userid when '"+strUserID+"' then a.ZDCL end),0)  , ");
				sbHead.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
				sbHead.append(username);
				sbHead.append("    </div></div></td>"); 
			}
		}
		sbHead.append("    </colgroup>");
		 sbHead.append("    </tr>");
		 sb.append(sbHead.toString());
		 
		sbSqlWhere.append(" ''aa ");
		List listResult = publicDateDAO.queryOrderStatic(preInt,sbSqlWhere.toString(), request);
		Map contentMap=new HashMap();
		//组装内容
		if(listResult!=null&&listResult.size()>0)
		{ 
			String strUserID="";
			String username="";
			String dcl="";
			String MARKETID="";
			for (int j = 0; j < listResult.size(); j++) 
			{
				contentMap=(Map)listResult.get(j);
				 sb.append("    <tr  height=\"28\" >"); 
				 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
				 sb.append(""+(j+1)+"");
				 sb.append("    </div></td>"); 
				 MARKETID=	 publicPageDAO.GetFieldValue(listResult, "NAME", j);
				 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
				 sb.append(""+MARKETID+"");
				 sb.append("    </div></td>"); 
				if(listUser!=null&&listUser.size()>0)
				{ 
					for(int i=0;i<listUser.size();i++)
					{
						 strUserID=	 publicPageDAO.GetFieldValue(listUser, "id", i);
						 username=	 publicPageDAO.GetFieldValue(listUser, "username", i);
						 dcl= PublicMethod.NullToStr(contentMap.get(username));

						 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
						 sb.append(dcl);
						 sb.append("%</div></td>"); 
					}
				}
				 sb.append("    </tr>");
			}
		}
		request.setAttribute("PageContent", sb.toString()); 
		return returnDfault;
	}
	/**
	 * 表三 优先顺序前6名的客户资源分配及达成					
	 * @return
	 */
	public String  queryYouStatic() {

		String  strpreInt=request.getParameter("preInt")==null?"3":request.getParameter("preInt").toString();
		int preInt=PublicMethod.NullToNumber(strpreInt);
		String strSql = "select p.*  from   users  p   where id  not in(10000,10002)  order by id  ";
		//System.out.println(strSql);
		List listUser = sqlDao.queryListBySqlNoSession(strSql);
		StringBuffer sbSqlWhere=new StringBuffer();
		
		StringBuffer sb=new StringBuffer();
		StringBuffer sbHead=new StringBuffer();
		

		sb.append("    <tr  height=\"28\"   style=\"height: 28px;\">");
		
		if(listUser!=null&&listUser.size()>0)
		{ 
			List listResult=new ArrayList();
			

			String strUserID="";
			String username="";
			Map contentMap=new HashMap();
			for(int i=0;i<listUser.size();i++)
			{
				if(i%6==0&&i!=0)
				{

					sb.append("    </tr >");
					sb.append("    <tr >");
				}
				
				sb.append("    <td >");
				sb.append("    <table width=\"155px\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">");
				sb.append("    <colgroup>");
				sb.append("        <col width=\"55px\" />");
				sb.append("        <col width=\"50px\" />");
				sb.append("        <col width=\"50px\" />"); 
				sb.append("    </colgroup>");
				
				 username=	 publicPageDAO.GetFieldValue(listUser, "username", i);
				sb.append("    <tr  height=\"28\"   style=\"height: 28px;\">");
				sb.append("   </div> <td colspan=\"3\" class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"><div align=\"center\" >"+username);
				 sb.append("    </td>");
				sb.append("    </tr>");
				
//				sb.append("        <col width=\"80px\" />");
//				String username=	 publicPageDAO.GetFieldValue(listUser, "username", i);
//				sbSqlWhere.append(username+"=isnull(sum(case userid when '"+strUserID+"' then a.ZDCL end),0)  , ");
//				sbHead.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//				sbHead.append(username);
//				sbHead.append("    </div></div></td>"); 
//				
				

				  strUserID=	 publicPageDAO.GetFieldValue(listUser, "id", i);
				  listResult = publicDateDAO.queryYouStatic(preInt,strUserID, request);
				  if(listResult!=null&&listResult.size()>0&&listResult.size()==6)
					{ 
						String dcl="";
						String MARKETID="";
						String ZIYUAN="";

						 sb.append("    <tr  height=\"28\" >");  

						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
						 sb.append("客户");
						 sb.append("    </div></td>"); 
						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
						 sb.append("资源");
						 sb.append("    </div></td>"); 
						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
						 sb.append("达成率");
						 sb.append("    </div></td>"); 
						 sb.append("    </tr>");
						for (int j = 0; j < listResult.size(); j++) 
						{
							 sb.append("    <tr  height=\"28\" >"); 
							contentMap=(Map)listResult.get(j);
//							 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
//							 sb.append(""+(j+1)+"");
//							 sb.append("    </div></td>"); 
							 
									MARKETID=	 publicPageDAO.GetFieldValue(listResult, "MARKETID", j);
									 strUserID=	 publicPageDAO.GetFieldValue(listResult, "id", j);
									 ZIYUAN=	 publicPageDAO.GetFieldValue(listResult, "LASTRESULT", j);
									 dcl=	 publicPageDAO.GetFieldValue(listResult, "ZDCL", j);
									 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append(MARKETID);
									 sb.append("    </div></td>"); 
									 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
									 sb.append(ZIYUAN);
									 sb.append("%</div></td>"); 
									 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
									 sb.append(dcl);
									 sb.append("%</div></td>"); 
									 sb.append("    </tr>");
						}
						 
					}else
					{
						String dcl="";
						String MARKETID="";
						String ZIYUAN="";
						 sb.append("    <tr  height=\"28\" >");  

						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
						 sb.append("客户");
						 sb.append("    </div></td>"); 
						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
						 sb.append("资源");
						 sb.append("    </div></td>"); 
						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
						 sb.append("达成率");
						 sb.append("    </div></td>"); 
						 sb.append("    </tr>");
						for (int j = 0; j < 6; j++) 
						{
							 sb.append("    <tr  height=\"28\" >"); 
//							 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
//							 sb.append(""+(j+1)+"");
//							 sb.append("    </div></td>"); 
						 
								 

									 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append(MARKETID);
									 sb.append("    </div></td>"); 
									 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append(ZIYUAN);
									 sb.append("    </div></td>"); 
									 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append(dcl);
									 sb.append("    </div></td>"); 
									 sb.append("    </tr>");
							}
						}

					 sb.append("    </table>");
					 sb.append("    </td>");
					}
			}
		

		 sb.append("    </tr>");
		sb.append(sbHead.toString());
		 
		request.setAttribute("PageContent", sb.toString()); 
		return returnDfault;
	}
	/**
	 * 表四：单个客户资源分配分析（数量）						
	 * @return
	 */
	public String  querySingleStatic() {

		String  strpreInt=request.getParameter("preInt")==null?"3":request.getParameter("preInt").toString();
		int preInt=PublicMethod.NullToNumber(strpreInt);
		String strSql = "select p.*  from   users  p   where id  not in(10000,10002)   order by id  ";
		//System.out.println(strSql);
		List listUser = sqlDao.queryListBySqlNoSession(strSql);
		StringBuffer sbSqlWhere=new StringBuffer();
		
		StringBuffer sb=new StringBuffer();
		StringBuffer sbHead=new StringBuffer();
		

		sb.append("    <tr  height=\"28\"   style=\"height: 28px;\">");
		
		if(listUser!=null&&listUser.size()>0)
		{ 
			List listResult=new ArrayList();
			

			String strUserID="";
			String username="";
			Map contentMap=new HashMap();
			for(int i=0;i<listUser.size();i++)
			{

			   int count=1;

				int usercount=0;
				sb.append("    <td  valign=\"top\">");
				 if(i==0)
				  {
					  count=1;
						sb.append("    <table width=\"260px\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">");
				  }else
				  {

						sb.append("    <table width=\"60px\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">");
				  }
				sb.append("    <colgroup>");
//				sb.append("        <col width=\"60px\" />");
				 if(i==0)
				  {
						sb.append("        <col width=\"140px\" />");
						sb.append("        <col width=\"60px\" />");
				  }
				
				sb.append("    </colgroup>");
				
				 username=	 publicPageDAO.GetFieldValue(listUser, "username", i);
				 
				sb.append("    <tr  height=\"28\"   style=\"height: 28px;\">");
				if(i==0)
				  {

					sb.append("    <td colspan=\""+count+"\" class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"><div align=\"center\" >分配项目");
					 sb.append("    </div></td>");
				  }
				sb.append("    <td colspan=\""+count+"\" class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"><div align=\"center\" >"+username);
				 sb.append("    </div></td>");
				sb.append("    </tr>");
				
//				sb.append("        <col width=\"80px\" />");
//				String username=	 publicPageDAO.GetFieldValue(listUser, "username", i);
//				sbSqlWhere.append(username+"=isnull(sum(case userid when '"+strUserID+"' then a.ZDCL end),0)  , ");
//				sbHead.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//				sbHead.append(username);
//				sbHead.append("    </div></div></td>"); 
//				
//				 sb.append("    <tr  height=\"28\" >");  
//
//				 sb.append("    <td class=\"STYLE2\"  rowspan=\"12\"  background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//				 sb.append("客户");
//				 sb.append("    </div></td>"); 
//
//				 sb.append("    </tr>");

			
				
				  strUserID=	 publicPageDAO.GetFieldValue(listUser, "id", i);
				  listResult = publicDateDAO.querySingleStatic(preInt,strUserID, request);

					String strFild="%";
				  if(preInt==3)
					{
						strFild="";
					} 
				  if(listResult!=null&&listResult.size()>0&&listResult.size()==12)
					{ 
						String dcl="";
						String MARKETID="";
						String ZIYUAN="";
						String LASTRESULT="";
						String XF="";
						String KNH="";
						String HD="";
						String XSTGF="";
						String SCBTGF="";

//						 sb.append("    <tr  height=\"28\" >");  
//
//						 sb.append("    <td class=\"STYLE2\"  rowspan=\"12\"  background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//						 sb.append("客户");
//						 sb.append("    </div></td>"); 
//
//						 sb.append("    </tr>");
//						 sb.append("    <tr  height=\"28\" >"); 
//						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//						 sb.append("拜访");
//						 sb.append("    </div></td>"); 
//						 sb.append("    </tr>");
//						 sb.append("    <tr  height=\"28\" >"); 
//						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//						 sb.append("院内会");
//						 sb.append("    </div></td>"); 
//						 sb.append("    </tr>");
//						 sb.append("    <tr  height=\"28\" >"); 
//						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//						 sb.append("科室会");
//						 sb.append("    </div></td>"); 
//						 sb.append("    </tr>");
//						 sb.append("    <tr  height=\"28\" >"); 
//						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//						 sb.append("圆桌会");
//						 sb.append("    </div></td>"); 
//						 sb.append("    </tr>");
//						 sb.append("    <tr  height=\"28\" >"); 
//						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//						 sb.append("费用");
//						 sb.append("    </div></td>");
//						 sb.append("    </tr>");
//						 sb.append("    <tr  height=\"28\" >");  
//						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//						 sb.append("总体资源分配比例");
//						 sb.append("    </div></td>"); 
//						 sb.append("    </tr>");
//						 sb.append("    <tr  height=\"28\" >"); 
//					
//						 sb.append("    <td class=\"STYLE2\"   background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//						 sb.append("达成率");
//						 sb.append("    </div></td>"); 
//						 sb.append("    </tr>");
						
						
						for (int j = 0; j < listResult.size(); j++) 
						{
							contentMap=(Map)listResult.get(j);
//							 sb.append("    <td class=\"STYLE2\"> <div align=\"center\" >");
//							 sb.append(""+(j+1)+"");
//							 sb.append("    </div></td>"); 
							 
									MARKETID=	 publicPageDAO.GetFieldValue(listResult, "MARKETID", j);
									 strUserID=	 publicPageDAO.GetFieldValue(listResult, "id", j);
									 ZIYUAN=	 publicPageDAO.GetFieldValue(listResult, "ZIYUAN", j);
									 LASTRESULT=	 publicPageDAO.GetFieldValue(listResult, "LASTRESULT", j);
									 dcl=	 publicPageDAO.GetFieldValue(listResult, "ZDCL", j);
									 XF=	 publicPageDAO.GetFieldValue(listResult, "XF", j);
									 KNH=	 publicPageDAO.GetFieldValue(listResult, "KNH", j);
									 HD=	 publicPageDAO.GetFieldValue(listResult, "HD", j);
									 XSTGF=	 publicPageDAO.GetFieldValue(listResult, "XSTGF", j);
									 SCBTGF=	 publicPageDAO.GetFieldValue(listResult, "SCBTGF", j);
								
									 
									 if(i==0)
									  {
										 sb.append("<tr  height=\"28\" >"); 
										 sb.append("<td    bgcolor=\"#FF9D6F\"   colspan=\""+count+"\"    > <div align=\"center\" >");
										 sb.append(MARKETID);
										 sb.append("</div></td>");
										 sb.append("<td    bgcolor=\"#FF9D6F\"   colspan=\""+count+"\"    > <div align=\"center\" >");
										 sb.append("</div></td>");
										 sb.append("</tr>");
										 
//										 sb.append("<tr  height=\"28\" >"); 
//										 sb.append("<td class=\"STYLE2\"  rowspan=\"8\"  background=\""+request.getContextPath()+"/jsp/web/tab/images/tab_14.gif\"> <div align=\"center\" >");
//										 sb.append("客户");
//										 sb.append("</div></td>"); 
//										 sb.append("<td class=\"STYLE2\" rowspan=\"8\" > <div align=\"center\" >&nbsp;");
//										 sb.append(MARKETID);
//										 sb.append("</div></td>"); 
//										 sb.append("</tr>");
										 sb.append("<tr  height=\"28\" >"); 
										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
										 sb.append("拜访");
										 sb.append("</div></td>");
										 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
										 sb.append(XF);
										 sb.append(strFild);
										 sb.append("</div></td>"); 
										 sb.append("</tr>");
										 sb.append("<tr  height=\"28\" >"); 
										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
										 sb.append("院内会");
										 sb.append("</div></td>"); 
										 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
										 sb.append(XSTGF);
										 sb.append(strFild);
										 sb.append("</div></td>"); 
										 sb.append("</tr>");
										 sb.append("<tr  height=\"28\" >"); 
										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
										 sb.append("科室会");
										 sb.append("</div></td>"); 
										 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
										 sb.append(KNH);
										 sb.append(strFild);
										 sb.append("</div></td>"); 
										 sb.append("</tr>");
										 sb.append("<tr  height=\"28\" >");  
										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
										 sb.append("圆桌会");
										 sb.append("</div></td>"); 
										 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
										 sb.append(HD);
										 sb.append(strFild);
										 sb.append("</div></td>"); 
										 sb.append("</tr>");
										 sb.append("<tr  height=\"28\" >"); 
										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
										 sb.append("费用");
										 sb.append("</div></td>");
										 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
										 sb.append(SCBTGF);
										 sb.append(strFild);
										 sb.append("</div></td>"); 
										 sb.append("</tr>");
										 sb.append("<tr  height=\"28\" >"); 
										 sb.append("<td class=\"STYLE2\"   ><div align=\"center\" >");
										 sb.append("总体资源分配比例");
										 sb.append("</div></td>"); 
										 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
										 sb.append(LASTRESULT);
										 sb.append("%</div></td>"); 
										 sb.append("</tr>");
										 sb.append("<tr  height=\"28\" >"); 
										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
										 sb.append("达成率");
										 sb.append("    </div></td>"); 
										 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
										 sb.append(dcl);
										 sb.append("%</div></td>"); 
										 sb.append("</tr>");
										 
//										 sb.append("</tr>");
//										 sb.append("<tr  height=\"28\" >"); 
//										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
//										 sb.append("拜访");
//										 sb.append("</div></td>"); 
//										 sb.append("</tr>");
//										 sb.append("<tr  height=\"28\" >"); 
//										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
//										 sb.append("院内会");
//										 sb.append("</div></td>"); 
//										 sb.append("</tr>");
//										 sb.append("<tr  height=\"28\" >"); 
//										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
//										 sb.append("科室会");
//										 sb.append("</div></td>"); 
//										 sb.append("</tr>");
//										 sb.append("<tr  height=\"28\" >"); 
//										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
//										 sb.append("圆桌会");
//										 sb.append("</div></td>"); 
//										 sb.append("</tr>");
//										 sb.append("<tr  height=\"28\" >"); 
//										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
//										 sb.append("费用");
//										 sb.append("</div></td>");
//										 sb.append("</tr>");
//										 sb.append("<tr  height=\"28\" >");  
//										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
//										 sb.append("总体资源分配比例");
//										 sb.append("</div></td>"); 
//										 sb.append("</tr>");
//										 sb.append("<tr  height=\"28\" >"); 
//									
//										 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
//										 sb.append("达成率");
//										 sb.append("</div></td>"); 
//										 sb.append("</tr>");
									  }else
									  {
										  sb.append("<tr  height=\"28\" >"); 
											 sb.append("<td   bgcolor=\"#FF9D6F\"  colspan=\""+count+"\"    > <div align=\"center\" >");
											 sb.append("");
											 sb.append("</div></td>");
											 sb.append("</tr>");
											 
										  
											 sb.append("<tr  height=\"28\" >"); 
		//									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
		//									 sb.append("拜访");
		//									 sb.append("</div></td>");
											 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
											 sb.append(XF);
											 sb.append(strFild);
											 sb.append("</div></td>"); 
											 sb.append("</tr>");
											 sb.append("<tr  height=\"28\" >"); 
		//									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
		//									 sb.append("院内会");
		//									 sb.append("</div></td>"); 
											 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
											 sb.append(XSTGF);
											 sb.append(strFild);
											 sb.append("</div></td>"); 
											 sb.append("</tr>");
											 sb.append("<tr  height=\"28\" >"); 
		//									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
		//									 sb.append("科室会");
		//									 sb.append("</div></td>"); 
											 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
											 sb.append(KNH);
											 sb.append(strFild);
											 sb.append("</div></td>"); 
											 sb.append("</tr>");
											 sb.append("<tr  height=\"28\" >");  
		//									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
		//									 sb.append("圆桌会");
		//									 sb.append("</div></td>"); 
											 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
											 sb.append(HD);
											 sb.append(strFild);
											 sb.append("</div></td>"); 
											 sb.append("</tr>");
											 sb.append("<tr  height=\"28\" >"); 
		//									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
		//									 sb.append("费用");
		//									 sb.append("</div></td>");
											 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
											 sb.append(SCBTGF);
											 sb.append(strFild);
											 sb.append("</div></td>"); 
											 sb.append("</tr>");
											 sb.append("<tr  height=\"28\" >"); 
		//									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
		//									 sb.append("总体资源分配比例");
		//									 sb.append("</div></td>"); 
											 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
											 sb.append(LASTRESULT);
											 sb.append("%</div></td>"); 
											 sb.append("</tr>");
											 sb.append("<tr  height=\"28\" >"); 
		//									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
		//									 sb.append("达成率");
		//									 sb.append("</div></td>"); 
											 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
											 sb.append(dcl);
											 sb.append("</div></td>"); 
											 sb.append("</tr>");
		//									 sb.append("<tr  height=\"0.5px\" >"); 
		//									 sb.append("<td  height=\"0.5px\"></td>"); 
		//									 sb.append("</tr>");
									  }
						}
						 
					}else
					{
						String dcl="";
						String MARKETID="";
						String ZIYUAN="";
//						 sb.append("<tr  height=\"28\" >");  
//
//						 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
//						 sb.append("客户");
//						 sb.append("</div></td>"); 
//						 sb.append(<td class=\"STYLE2\"   > <div align=\"center\" >");
//						 sb.append("资源");
//						 sb.append(</div></td>"); 
//						 sb.append(<td class=\"STYLE2\"   > <div align=\"center\" >");
//						 sb.append("达成率");
//						 sb.append(</div></td>"); 
//						 sb.append(</tr>");
						
						
						 
							for (int j = 0; j < 12; j++) 
							{
								 if(i==0)
								  {
									 sb.append("<tr  height=\"28\" >"); 
									 sb.append("<td    bgcolor=\"#FF9D6F\"   colspan=\""+count+"\"    > <div align=\"center\" >");
									 sb.append(MARKETID);
									 sb.append("</div></td>");
									 sb.append("</tr>"); 
									 sb.append("<tr  height=\"28\" >"); 
									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
									 sb.append("拜访");
									 sb.append("</div></td>");
									 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append("</div></td>"); 
									 sb.append("</tr>");
									 sb.append("<tr  height=\"28\" >"); 
									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
									 sb.append("院内会");
									 sb.append("</div></td>"); 
									 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append("</div></td>"); 
									 sb.append("</tr>");
									 sb.append("<tr  height=\"28\" >"); 
									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
									 sb.append("科室会");
									 sb.append("</div></td>"); 
									 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append("</div></td>"); 
									 sb.append("</tr>");
									 sb.append("<tr  height=\"28\" >");  
									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
									 sb.append("圆桌会");
									 sb.append("</div></td>"); 
									 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append("</div></td>"); 
									 sb.append("</tr>");
									 sb.append("<tr  height=\"28\" >"); 
									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
									 sb.append("费用");
									 sb.append("</div></td>");
									 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append("</div></td>"); 
									 sb.append("</tr>");
									 sb.append("<tr  height=\"28\" >"); 
									 sb.append("<td class=\"STYLE2\"   ><div align=\"center\" >");
									 sb.append("总体资源分配比例");
									 sb.append("</div></td>"); 
									 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append("</div></td>"); 
									 sb.append("</tr>");
									 sb.append("<tr  height=\"28\" >"); 
									 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
									 sb.append("达成率");
									 sb.append("    </div></td>"); 
									 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
									 sb.append(dcl);
									 sb.append("</div></td>"); 
									 sb.append("</tr>");
									  
									 sb.append("</tr>");
								  }else{
	//							 sb.append(<td class=\"STYLE2\"> <div align=\"center\" >");
	//							 sb.append(""+(j+1)+"");
	//							 sb.append("</div></td>"); 
							 
								  sb.append("<tr  height=\"28\" >"); 
									 sb.append("<td    bgcolor=\"#FF9D6F\" colspan=\""+count+"\"    > <div align=\"center\" >");
									 sb.append("");
									 sb.append("</div></td>");
									 sb.append("</tr>");
	
//								 if(i==0)
//								  {
//									 sb.append("<tr  height=\"28\" >"); 
//	//								 sb.append("<td class=\"STYLE2\"  rowspan=\"7\"  > <div align=\"center\" >");
//	//								 sb.append("客户");
//	//								 sb.append("</div></td>"); 
//									 sb.append("<td class=\"STYLE2\" rowspan=\"8\" > <div align=\"center\" >&nbsp;");
//									 sb.append(MARKETID);
//									 sb.append("</div></td>"); 
//									 sb.append("</tr>");
//								  }
								 sb.append("<tr  height=\"28\" >"); 
	//							 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
	//							 sb.append("拜访");
	//							 sb.append("</div></td>");
								 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
								 sb.append(ZIYUAN);
								 sb.append("</div></td>"); 
								 sb.append("</tr>");
								 sb.append("<tr  height=\"28\" >"); 
	//							 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
	//							 sb.append("院内会");
	//							 sb.append("</div></td>"); 
								 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
								 sb.append(ZIYUAN);
								 sb.append("</div></td>"); 
								 sb.append("</tr>");
								 sb.append("<tr  height=\"28\" >"); 
	//							 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
	//							 sb.append("科室会");
	//							 sb.append("</div></td>"); 
								 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
								 sb.append(ZIYUAN);
								 sb.append("</div></td>"); 
								 sb.append("</tr>");
								 sb.append("<tr  height=\"28\" >");  
	//							 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
	//							 sb.append("圆桌会");
	//							 sb.append("</div></td>"); 
								 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
								 sb.append(ZIYUAN);
								 sb.append("</div></td>"); 
								 sb.append("</tr>");
								 sb.append("<tr  height=\"28\" >"); 
	//							 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
	//							 sb.append("费用");
	//							 sb.append("</div></td>");
								 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
								 sb.append(ZIYUAN);
								 sb.append("</div></td>"); 
								 sb.append("</tr>");
								 sb.append("<tr  height=\"28\" >"); 
	//							 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
	//							 sb.append("总体资源分配比例");
	//							 sb.append("</div></td>"); 
								 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
								 sb.append(ZIYUAN);
								 sb.append("</div></td>"); 
								 sb.append("</tr>");
								 sb.append("<tr  height=\"28\" >"); 
	//							 sb.append("<td class=\"STYLE2\"   > <div align=\"center\" >");
	//							 sb.append("达成率");
	//							 sb.append("</div></td>"); 
								 sb.append("<td class=\"STYLE2\"> <div align=\"center\" >&nbsp;");
								 sb.append(dcl);
								 sb.append("</div></td>"); 
								 sb.append("</tr>");
	//							 sb.append("<tr  height=\"0.5px\" >"); 
	//							 sb.append("<td  height=\"0.5px\"></td>"); 
	//							 sb.append("</tr>");
								}
							}
					   }
					 sb.append("</table>");
					 sb.append("</td>");
					}
			}
		

		 sb.append("</tr>");
		request.setAttribute("PageContent", sb.toString()); 
		return returnDfault;
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
	 
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
