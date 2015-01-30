package nMarket.actions;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import nMarket.jchar.BubbleChartDemo2;
import nMarket.jchar.JfreeChartTest;
import nMarket.vo.Users;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RefineryUtilities;

import system.dao.IPublicDAO;
import system.dao.IPublicSourceDAO;
import system.dao.ISqlDAO;
import system.dao.Impl.PublicDateDAO;
import system.dao.Impl.PublicPageDAO;
import system.dao.Impl.PublicSourceDAO;
import system.publicClass.PublicConstant;
import system.publicClass.PublicMethod;

import com.opensymphony.xwork2.ActionSupport;


public class DataAction extends ActionSupport implements ServletRequestAware {

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

  
	public String  queryCase() {

		int intYear_now = publicDao.getCurrentDateYear(0);
		int intMont_now = publicDao.getCurrentDateMonth(0);

		//查询条件
//		int intYear_s =publicDao.NullToNumber(  request.getParameter("intYear"));
//		int intMonth_s =publicDao.NullToNumber(  request.getParameter("intMonth"));
//		if(intYear_s!=0)
//		{
//			intYear_now=intYear_s;
//		}
//		if( intMonth_s!=0)
//		{
//			intMont_now=intMonth_s;
//		}
		
		List listCase = publicDateDAO.queryCaseList(intYear_now,intMont_now, request);
		StringBuilder sb = new StringBuilder();
		if(listCase!=null&&listCase.size()>0)
		{ 
			for (int j = 0; j < listCase.size(); j++) 
			{
				String strType=publicPageDAO.GetFieldValue(listCase, "CASETYPE", j);
				String  strStatusName="设为当前案例";
                if("1".equals(strType)){
                	strStatusName="当前使用案例";
                }
				if("1".equals(strType)){strType="正使用";}else {strType="未使用";}
				

				String strCaseId =publicPageDAO.GetFieldValue(listCase, "caseid", j);
				String intYear =publicPageDAO.GetFieldValue(listCase, "YEAR", j);
				String intMonth =publicPageDAO.GetFieldValue(listCase, "MONTH", j);
				String casenum =publicPageDAO.GetFieldValue(listCase, "casenum", j);
				sb.append("<tr   class=\"caserow\"  >");
				sb.append("<td   class=\"STYLE2\"><div align=\"center\" class=\"STYLE2 STYLE1\">"+ (1+ j)+"</div></td>");
				sb.append("<td  class=\"STYLE2\"><div align=\"center\" class=\"STYLE2 STYLE1\">"+casenum+"</div></td>");
				//sb.append("<td  class=\"STYLE2\"><div align=\"center\" class=\"STYLE2 STYLE1\">"+publicPageDAO.GetFieldValue(listCase, "CASENAME", j)+"</div></td>");
				sb.append("<td  class=\"STYLE2\"><div align=\"center\" class=\"STYLE2 STYLE1\">"+publicPageDAO.GetFieldValue(listCase, "NOTE", j)+"</div></td>");
				sb.append("<td  class=\"STYLE2\"><div align=\"center\" class=\"STYLE2 STYLE1\">"+intYear+"</div></td>");
				sb.append("<td  class=\"STYLE2\"><div align=\"center\" class=\"STYLE2 STYLE1\">"+intMonth+"</div></td>");

				if("正使用".equals(strType)){
				   sb.append("<td  class=\"STYLE2\"><div> <span class=\"STYLE1\"> [</span>"+strStatusName+"<span class=\"STYLE1\">]</span>" +
				   		"<span class=\"STYLE1\"> [</span><a href=\"#\"  onclick=\"editCase('" +
							""+request.getContextPath() +"/editCase.action?caseId="+strCaseId+"')\">编辑备注</a><span class=\"STYLE1\">]</span></div></td>");
				}else {

					sb.append("<td  class=\"STYLE2\"><div><span class=\"STYLE1\"> [</span><a href=\"#\"  onclick=\"updateCase('" +
							""+request.getContextPath() +"/updateCase.action?caseId="+strCaseId+"&intYear="+intYear+"&intMonth="+intMonth+"')\">"+strStatusName+"</a><span class=\"STYLE1\">]</span>" +
									"<span class=\"STYLE1\"> [</span><a href=\"#\"  onclick=\"editCase('" +
							""+request.getContextPath() +"/editCase.action?caseId="+strCaseId+"')\">编辑备注</a><span class=\"STYLE1\">]</span>" +
									"<span class=\"STYLE1\"> [</span><a href=\"#\"  onclick=\"deleteCase('" +
							""+request.getContextPath() +"/deleteCase.action?caseId="+strCaseId+"&intYear="+intYear+"&intMonth="+intMonth+"')\">删除</a><span class=\"STYLE1\">]</span>" +
								"	</div></td>");
					
				}
				//sb.append("<td  class=\"STYLE2\"><span class=\"STYLE2\"><img src=\""+request.getContextPath() +"/jsp/web/tab/images/010.gif\" width=\"9\" height=\"9\" /> </span><span class=\"STYLE1\">[</span><a href=\"#\">删除</a><span class=\"STYLE1\">]</span></div></td>");
				sb.append("</tr>");
			}
		}
		request.setAttribute("PageContent", sb.toString()); 
		return returnDfault;
		
	}
	
	public  String updateCase()
	{
		int strCaseId =publicDao.NullToNumber(   request.getParameter("caseId"));
		String intYear =publicDao.NullToStr(  request.getParameter("intYear"));
		String intMonth =publicDao.NullToStr(  request.getParameter("intMonth"));
		if(strCaseId!=0)
		{
			Users userInfo=sqlDao.gerUserInfo(request);
			int intYear_1 = publicDao.getCurrentDateYear(1);
			int intMonth_1 = publicDao.getCurrentDateMonth(1);
		    String strCaseId_1=publicDateDAO.getCaseID(  intYear_1 ,  intMonth_1,  request );
			int intYear_2 = publicDao.getCurrentDateYear(2);
			int intMonth_2 = publicDao.getCurrentDateMonth(2);
		    String strCaseId_2=publicDateDAO.getCaseID(  intYear_2 ,  intMonth_2,  request );
			int intYear_3 = publicDao.getCurrentDateYear(3);
			int intMonth_3 = publicDao.getCurrentDateMonth(3);
		    String strCaseId_3=publicDateDAO.getCaseID(  intYear_3 ,  intMonth_3,  request );
			String strSql="update n_marketcase    set CASETYPE='0'      where   ";
			strSql+="        YEAR='" + intYear + "'  and   MONTH='" + intMonth + "'   " +
					" and  userid='"+userInfo.getId()+"'  or  caseid='"+strCaseId_1+"'   or  caseid='"+strCaseId_2+"'   or  caseid='"+strCaseId_3+"'     ";
			sqlDao.insertWithSql(strSql);
			  strSql="update n_marketcase  set CASETYPE='1'        where 1=1   ";
			strSql+="  and  ( caseid='"+strCaseId+"'   or sameCaseId='"+strCaseId+"'  or  sameCaseId='"+strCaseId+"'  )  ";
			sqlDao.insertWithSql(strSql);
		
			request.setAttribute("message", " alert('设置成功！');   window.location.href='queryCase.action?intYear="+intYear+"&intMonth="+intMonth+"';");
		}
		return returnDfault;
	}

	public  String editCase()
	{
		int strCaseId =publicDao.NullToNumber(   request.getParameter("caseId")); 
		if(strCaseId!=0)
		{
			Users userInfo=sqlDao.gerUserInfo(request);
		
			String  strSql="select NOTE  from n_marketcase        where    caseid='"+strCaseId+"'   ";
			List listCase =sqlDao.queryListBySqlNoSession(strSql);
			StringBuilder sb = new StringBuilder();
			if(listCase!=null&&listCase.size()>0)
			{ 
				String strNOTE=publicPageDAO.GetFieldValue(listCase, "NOTE", 0);
				request.setAttribute("NOTE",strNOTE);
			}
		}
		return returnDfault;
	}
	public  String saveCase()
	{
		int strCaseId =publicDao.NullToNumber(   request.getParameter("caseId")); 
		String NOTE =publicDao.NullToStr(request.getParameter("NOTE"));
		if(strCaseId!=0)
		{
			Users userInfo=sqlDao.gerUserInfo(request);
		
			String  strSql="update n_marketcase  set NOTE='"+NOTE.replace("'", "")+"'        where    caseid='"+strCaseId+"'   ";
			sqlDao.insertWithSql(strSql);
		
			request.setAttribute("message", " alert('保存成功！');   window.close();");
		}
		return returnDfault;
	}
	//读取用户信息
	public  String getMarketInfo_1()
	{
		String strPKID =publicDao.NullToStr( request.getParameter("PKID")); 
		getMarketInfo_s(strPKID);
		return returnDfault;
	}
	//读取用户信息
	private  void getMarketInfo_s(String strPKID )
	{
		if(strPKID!=null&&!"".equals(strPKID))
		{
			 DecimalFormat df = new DecimalFormat("0.0"); 
			   
			Users userInfo=sqlDao.gerUserInfo(request);
			//List listSys =	publicDateDAO.querySysLists(strPKID, request);
			List listSys =publicDateDAO.querySysList(request); 
			//List listSys = publicDateDAO.querySysList(request);
			 String[]  strResource= {  "QXX,倾向性", "NTS_ALL,销售总金额", "XSZZ_ALL,销售净增长总额"};
			// List listSys=publicDateDAO.querySysLists_now(strPKID,request); 
			 if (listSys != null && listSys.size() > 0) 
				{//列数量
				 
				    for (int i = 0; i < strResource.length; i++)
					{//行字段
						String strFieldNames = publicDao.NullToStr(strResource[i]);
						String strFieldName=strFieldNames;
						String strFieldCName=strFieldNames;
						if(strFieldName.split(",").length>1)
						{
							 strFieldName=strFieldNames.split(",")[0];//英文名称
							  strFieldCName=strFieldNames.split(",")[1];//中午名称
						}
						 
						if (!"".equals(strFieldName))
						{
							for (int j = 0; j < listSys.size(); j++) 
							{
								String strPKID_1=	publicPageDAO.GetFieldValue(listSys, "masterid", j);
								if(strPKID_1.equals(strPKID))
								{
									 String strValues=publicPageDAO.GetFieldValue(listSys, strFieldName, j);
									 if ("NTS_ALL".equals(strFieldName)||"XSZZ_ALL".equals(strFieldName))
										{
										 strValues=df.format(PublicMethod.NullToDouble(publicPageDAO.GetFieldValue(listSys, strFieldName, j))/10000);
										}
									 request.setAttribute(strFieldName,strValues)	;
								}
							}
						}
					}
				    
				 
				}
//			 request.setAttribute("dblv", df.format( publicDao.NullToDouble(mapResult.get("dblv"))));
			 
		}
		
	}
	/**
	 * 获取医生介绍信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getMarketInfo_Body() {
	 
		//List listMerket=publicDateDAO.querySysList(request);
		int	intYear=publicDao.getCurrentDateYear(0);
		int	intMonth = publicDao.getCurrentDateMonth(0);
		List listMerket=publicDateDAO.queryMarketList( "") ;
		String basePath=getUrl(request);
		StringBuilder sb = new StringBuilder(); 
		if (listMerket != null && listMerket.size() > 0) 
		{//列数量
			String strFieldName="USERORDER";
			boolean isAdd=true;
			String strStatus="";

			sb.append("<tr style=\"padding-top: 3px;\"  >");
			for (int j = 0; j < listMerket.size(); j++) 
			{
				 String strParamID=publicPageDAO.GetFieldValue(listMerket, "masterid", j);
				 String strName=publicPageDAO.GetFieldValue(listMerket, "NAME", j);
				 String TOUXIANG=publicPageDAO.GetFieldValue(listMerket, "TOUXIANG", j);
				 String strValue=publicPageDAO.GetFieldValue(listMerket, strFieldName, j);

				 Double COMPANYKPI=publicDao.NullToDouble( publicPageDAO.GetFieldValue(listMerket, "COMPANYKPI", j));
				 Double RESULT=publicDao.NullToDouble( publicPageDAO.GetFieldValue(listMerket, "RESULT", j));
				 if(RESULT==0D){RESULT=10000000000000D;}
				 String RESULT_LV=publicDao.DecimalFormat_OBJ(  RESULT/COMPANYKPI*100);
				 String XSZZ=publicPageDAO.GetFieldValue(listMerket, "XSZZ", j);
				 String WHOLE=publicPageDAO.GetFieldValue(listMerket, "WHOLE", j);
				 if(WHOLE.length()>20){WHOLE=WHOLE.substring(0, 20)+"…";}
				 String INTRODUCE_MY=publicPageDAO.GetFieldValue(listMerket, "INTRODUCE_MY", j);
				 if(INTRODUCE_MY.length()>20){INTRODUCE_MY=INTRODUCE_MY.substring(0, 20)+"…";}
				 
				 
				 if(j%4==0&&j!=0)
				 {
					 sb.append(" </tr>");

					  sb.append("<tr style=\"height: 3px\"> <td colspan=\"7\"></td> </tr>");

						sb.append("<tr style=\"padding-top: 0px;\"  >");
				 }
			 
				 sb.append("<td valign=\"top\" style=\"width: 65px;  cursor: hand;background: url("+basePath+TOUXIANG+") no-repeat; \"  	"); 
					sb.append("onclick=\"javascript:g_OpenModalReturnWindow('"+basePath+"getMarketInfo.action?PKID="+strParamID+"&userName="+strName+"',660,460);\""); 
					sb.append("	onmouseover=\" this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; \""); 
					sb.append("		onmouseout=\"  this.style.borderStyle='none'\" valign=\"top\">"); 
					sb.append("<div 	style=\"width: 60px;  \">"); 
					sb.append("	<div class=\"divInfo\">"); 
					sb.append("		<table class=\"myTable\" style=\"width: 60px; height:50px;\">"); 
					sb.append("			<tr  style=\"width: 50px;height:30px;  \" >"); 
					sb.append("				<td   >"); 
					sb.append("					<span style=\"font-size: 12px; padding-left:0px;\">"); 
					sb.append("						"+strName+"</span>"); 
					sb.append("				</td>"); 
					sb.append("			</tr>"); 
					sb.append("			<tr  style=\"width: 50px;height:30px;  \" >"); 
					sb.append("				<td>"); 
					sb.append("					<span style=\"font-size: 12px; padding-left:0px;\">"+INTRODUCE_MY+"</span>"); 
					sb.append("				</td>"); 
					sb.append("			</tr>"); 
					sb.append("			<tr  style=\"width: 50px;height:30px;  \" >"); 
					sb.append("				<td>");  
					sb.append("				</td>"); 
					sb.append("			</tr>"); 
//					sb.append("			<tr>"); 
//					sb.append("				<td>"); 
//					sb.append("					<span style=\"font-size: 12px; font-weight: bold;\">目前销售额："); 
//					sb.append("					</span><span style=\"font-size: 12px;\">"+RESULT+"元/月</span>"); 
//					sb.append("				</td>"); 
//					sb.append("			</tr>"); 
//					sb.append("			<tr>"); 
//					sb.append("				<td>"); 
//					sb.append("					<span style=\"font-size: 12px; font-weight: bold;\">销售净增长额：</span><span"); 
//					sb.append("						style=\"font-size: 12px;\">"+XSZZ+"元/月</span>"); 
//					sb.append("				</td>"); 
//					sb.append("			</tr>"); 
//					sb.append("			<tr>"); 
//					sb.append("				<td>"); 
//					sb.append("					<span style=\"font-size: 12px; font-weight: bold;\">公司销售目标：</span><span"); 
//					sb.append("					 style=\"font-size: 12px;\">"+COMPANYKPI+"元/月</span>"); 
//					sb.append("				</td>"); 
//					sb.append("			</tr>"); 
//					sb.append("			<tr>"); 
//					sb.append("				<td>"); 
//					sb.append("					<span style=\"font-size: 12px; font-weight: bold;\">销售额VS销售目标：</span><span"); 
//					sb.append("						style=\"font-size: 12px;\">"+RESULT_LV+"%</span>"); 
//					sb.append("				</td>"); 
//					sb.append("			</tr>"); 
					sb.append("		</table>"); 
					sb.append("	</div>"); 
					sb.append("</div>"); 
					sb.append("</td>");  
					sb.append("				<td style=\"width:3px;\"  >&nbsp;");  
					sb.append("				</td>"); 
				
			}
			 
				
				sb.append(" </tr>");
		} 
		
		request.setAttribute("filedHtml", sb.toString());
		return returnDfault;
		
		
		//return sb.toString();
	}
	//保存用户信息
	public  String saveMarket()
	{
		int strCaseId =publicDao.NullToNumber(   request.getParameter("caseId")); 
		String NOTE =publicDao.NullToStr(request.getParameter("NOTE"));
		if(strCaseId!=0)
		{
			Users userInfo=sqlDao.gerUserInfo(request);
		
			String  strSql="update n_marketcase  set NOTE='"+NOTE.replace("'", "")+"'        where    caseid='"+strCaseId+"'   ";
			sqlDao.insertWithSql(strSql);
		
			request.setAttribute("message", " alert('保存成功！');   window.close();");
		}
		return returnDfault;
	}
	public  String deleteCase()
	{
		int strCaseId =publicDao.NullToNumber(   request.getParameter("caseId"));
		String intYear =publicDao.NullToStr(  request.getParameter("intYear"));
		String intMonth =publicDao.NullToStr(  request.getParameter("intMonth"));
		if(strCaseId!=0)
		{
			Users userInfo=sqlDao.gerUserInfo(request);
		
			String strSql =" update  n_marketcase set delStatus='1'    where caseid='"+strCaseId+"'   ";
			sqlDao.insertWithSql(strSql);
		
			request.setAttribute("message", " alert('删除成功！');   window.location.href='queryCase.action?intYear="+intYear+"&intMonth="+intMonth+"';");
		}
		return returnDfault;
	}
	public  String insertCase()
	{
//		int intYear =publicDao.NullToNumber( request.getParameter("intYear"));
//		int intMonth =publicDao.NullToNumber(  request.getParameter("intMonth"));
//		if(intYear==0)
//		{
//		}
//		if(intMonth==0)
//		{
//		}
// ;
		 for(int n=3;n>-1;n--)
		 {
	
				int	intYear=    publicDao.getCurrentDateYear(n);
				int	intMonth =	 publicDao.getCurrentDateMonth(n);
				    publicDateDAO.inserCaseID(  intYear ,  intMonth,"",  request ) ;
		 }
		int	intYear=    publicDao.getCurrentDateYear(0);
		int	intMonth =	 publicDao.getCurrentDateMonth(0);
		request.setAttribute("message", "   window.location.href='queryCase.action?intYear="+intYear+"&intMonth="+intMonth+"';");
		return returnDfault;
	}
 
	

	/**
	 * 设置行动计划
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getMarketInfo() {
		

		String strPKID =publicDao.NullToStr(  request.getParameter("PKID"));
		List listMarket = publicDateDAO.queryMarketList(strPKID);
		 String filedHtml = publicPageDAO.setPageValue(listMarket, "KPIID", publicSourceDAO.strMarketInfo); 
		 request.setAttribute("filedHtml", filedHtml);
		
		return returnDfault;
	}
	
	
	
	
	
	/**
	 * 设置行动计划
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getXingDongJiHuaList() {
	 
		List listDict = publicDateDAO.queryDictList("jihua"); 
		request.setAttribute("list", listDict);
		StringBuilder sb = new StringBuilder(); 
		sb.append("<option></option>");
		if (listDict != null && listDict.size() > 0) 
		{//列数量
			for (int j = 0; j < listDict.size(); j++) 
			{ 
				sb.append("<tr style=\"height: 26px;\">");
				sb.append("<td style=\"width: 40px\"><input name=\"chk\" type=\"radio\"   onclick=\"javascript:SetGVCheck('"+publicPageDAO.GetFieldValue(listDict, "ID", j)+"','"+publicPageDAO.GetFieldValue(listDict, "CODEID", j)+"');\" value=\"0\" /></td> ");
				//sb.append(publicPageDAO.GetFieldValue(listDict, "CODEID", j)+" ");
				sb.append("<td style=\"width:60px;\">"+publicPageDAO.GetFieldValue(listDict, "bigtype", j)+" </td>");  
				sb.append("<td style=\"width:*;\">"+publicPageDAO.GetFieldValue(listDict, "DICTNAME", j)+" </td>");
				sb.append("<td style=\"display:none;\">"+publicPageDAO.GetFieldValue(listDict, "ID", j)+" </td>");
				sb.append("</tr>");
			}
		}
		sb.append("");
		
		request.setAttribute("filedHtml", sb.toString());
		return returnDfault;
		
		
		//return sb.toString();
	}
	
	/**
	 * 总体分析
	 * 
	 * @return
	 * @throws Exception
	 */
	public String staticZongTiFenXi_Tu() {
	 
		//List listMerket=publicDateDAO.querySysList(request);  

		int	intYear=PublicMethod.getCurrentDateYear(0);
		int	intMonth = PublicMethod.getCurrentDateMonth(0);//2011-12
		List listMerket =publicDateDAO.querySysList(intYear,intMonth,request);
		StringBuilder sb = new StringBuilder(); 
		if (listMerket != null && listMerket.size() > 0) 
		{//列数量
			String strFieldName="USERORDER";
			boolean isAdd=true;
			String strStatus="";
			for (int j = 0; j < listMerket.size(); j++) 
			{
				 String strParamID=publicPageDAO.GetFieldValue(listMerket, "masterid", j);
				 String strName=publicPageDAO.GetFieldValue(listMerket, "NAME", j);
				 String strValue=publicPageDAO.GetFieldValue(listMerket, strFieldName, j);
				if("".equals(strValue))
				{
					strValue=""+(j+1);
					isAdd=true;
				}else
				{
					isAdd=false;
					// strStatus="readonly='true'";
				}
				sb.append("<tr style=\"height: 26px;\">");
				sb.append("<td style=\"width: 70px;text-align:right;\">");
				sb.append(""+strName+"</td> ");
//			     sb.append("<div style=\"display:none;\">");
//				 sb.append("<input  name =\"XSYC_NEXT" + strParamID  + "\"   id =\"XSYC_NEXT" +strParamID  + "\"  " +
//	 		          " value=\"" +strValue+ "\"  /></div>");
										
				//sb.append(publicPageDAO.GetFieldValue(listDict, "CODEID", j)+" ");
				sb.append("<td style=\"width:*;\"> <input style=\"width: 30px\" "+strStatus+"  name =\""
								+  strFieldName+strParamID +"\"   id =\""
								+ strFieldName+strParamID + "\"   value=\""
								+ strValue + "\"  onmounthdown=\"onmousedown(this);\"   " +
										" onblur=\"checkIsNum(this);checkIntegerMaxMin(this,'12','0' ,'输入的序号');stringLengthCheck(this,'2','输入的结果不能超过2个字符！')\"/> </td>");
				//sb.append("<td style=\"display:none;\">"+strParamID+" </td>");
				sb.append("</tr>");
				
			}
			sb.append(" <tr>  <td colspan=\"2\"  style=\"width: 120px;text-align:center;\"> <input type=\"button\" name=\"btnSave1\" value=\"保存并关闭\" onclick=\"save();\" class=\"pt_long_button\" style=\"display: ;\" /></td>  </tr>");
				sb.append(" <tr>  <td colspan=\"2\"  style=\"width: 120px;text-align:left;color:red;\"></td>  </tr>");//排序仅能设置一次，请谨慎操作，一旦确认后将无法修改
			/*	if(isAdd||true)
				{
					 }else
			{
				sb.append(" <tr>  <td colspan=\"2\"  style=\"width: 120px;text-align:center;\"> <input type=\"button\" name=\"btnSave1\" value=\"关闭\" onclick=\"window.close();\" class=\"pt_long_button\" style=\"display: ;\" /></td>  </tr>");
				sb.append(" <tr>  <td colspan=\"2\"  style=\"width: 120px;text-align:left;color:red;\">排序已设置过，当前无法修改</td>  </tr>");
			}*/
		} 
		
		request.setAttribute("filedHtml", sb.toString());
		return returnDfault;
		
		
		//return sb.toString();
	}
	/**
	 * 保存人员排序
	 * 
	 * @return
	 */
	public String saveZonti_FenXi_Tu() {
		//List listSys = publicDateDAO.querySysList(request);

		int	intYear=PublicMethod.getCurrentDateYear(0);
		int	intMonth = PublicMethod.getCurrentDateMonth(0);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		String[] strSaveField={"USERORDER"};
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
				strSaveField, request,0);
		request.setAttribute("message", " alert('保存成功！');  window.close();");
		return returnDfault;

	}
	
	
	/**
	 * 人员销售趋势   包括个人和整体
	 * @return
	 */
	public String  queryXiaoShouShuJu()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //取response对象      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK");
		String struserName =publicDao.NullToStr(  request.getParameter("userName"));
		String strPKID =publicDao.NullToStr(  request.getParameter("PKID"));
	 
	    List listMerket=publicDateDAO.queryHisList_YouXiaoXing(strPKID); 
		StringBuilder sbUser = new StringBuilder();
		StringBuilder sbHead = new StringBuilder();
		
		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='' subcaption='医院销售趋势'   xaxisname='' yaxisname='销售金额'  hovercapbg='DEDEBE' hovercapborder='889E6D' rotateNames='0' yAxisMaxValue='60' numdivlines='9'     decimalPrecision='0' showAlternateHGridColor='1' AlternateHGridAlpha='30'  showvalues='1' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5' divLineAlpha='60'     numberPrefix='' baseFont='宋体' baseFontSize='12'   alternateHGridColor='f8f8f8' showNames='1'  showPercentageInLabel='0'  >"); 
	    sbHead.append(" <categories font='宋体' fontSize='12' fontColor='9D080D'>");
	    String strColors[]= PublicConstant.COLORS_LIST; 
		if(listMerket!=null&&listMerket.size()>0)
		{ 
			for (int j = 0; j < listMerket.size(); j++) 
			{
				 String strMarketID=publicPageDAO.GetFieldValue(listMerket, "MASTERID", j);
				 String strName=publicPageDAO.GetFieldValue(listMerket, "NAME", j);
				 List listSys=publicDateDAO.querySysLists(strMarketID,request); 
				 sbUser.append("   <dataset seriesname='"+strName+"' color='"+strColors[j]+"'> "); 
				if(listSys!=null&&listSys.size()>0)
				{ 
					for (int i = 0; i < listSys.size(); i++) 
					{

						 int  intMonth=publicDao.NullToNumber(  publicPageDAO.GetFieldValue(listSys, "MONTH", i));
						 String strYear=publicPageDAO.GetFieldValue(listSys, "YEAR", i);
						 Float strNTS=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "RESULT", i));//销售金额
						if(j==0)
						{
						   sbHead.append("      <category name='"+MONTH_LIST.get(intMonth-1)+"-"+strYear.substring(strYear.length()-2,strYear.length())+"'  />"); 
						}
						 sbUser.append("<set value='"+strNTS+"' />");
					}
					
				}
				 sbUser.append("   </dataset>"); 
				
			}
			
		}
		sbHead.append("   </categories> ");
		sbHead.append(sbUser.toString());
		
		sbHead.append("</graph>"); 
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 out.print(sbHead.toString());
		//request.setAttribute("PageContent", sb.toString()); 
		 
		        out.flush();
		        out.close();
		  // 不返回结果
		  return null;
		
		
	//	return returnDfault;
		
	}

	/**
	 * 人员销售预估趋势   包括个人和整体
	 * @return
	 */
	public String  queryXiaoShouYuGu()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //取response对象      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK");
	 	String struserName =publicDao.NullToStr(  request.getParameter("userName"));
		String strPKID =publicDao.NullToStr(  request.getParameter("PKID"));
		String strType =publicDao.NullToStr(  request.getParameter("type"));//type=1 预估
	 
		
		String  strFile="result";
		if("1".equals(strType))
		{
			 strFile="XSYC_NEXT";
		}
	    List listMerket=publicDateDAO.queryMarketList(strPKID); 
		StringBuilder sbUser = new StringBuilder();
		StringBuilder sbHead = new StringBuilder();
		
		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='' subcaption=''   xaxisname='' yaxisname='占有率'  hovercapbg='DEDEBE' hovercapborder='889E6D' rotateNames='0' yAxisMaxValue='60' numdivlines='9'     decimalPrecision='0' showAlternateHGridColor='1' AlternateHGridAlpha='30'  showvalues='1' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5' divLineAlpha='60'     numberPrefix='' baseFont='宋体' baseFontSize='12'   alternateHGridColor='f8f8f8' showNames='1'  showPercentageInLabel='0'  >"); 
	    sbHead.append(" <categories font='宋体' fontSize='12' fontColor='9D080D'>");
	    String strColors[]= PublicConstant.COLORS_LIST;
		if(listMerket!=null&&listMerket.size()>0)
		{ 
			for (int j = 0; j < listMerket.size(); j++) 
			{
				 String strMarketID=publicPageDAO.GetFieldValue(listMerket, "MASTERID", j);
				 String strName=publicPageDAO.GetFieldValue(listMerket, "NAME", j);
				 List listSys=new ArrayList();
				 if("1".equals(strType))
				{
					 listSys=publicDateDAO.querySysLists(strMarketID,request);
				}else
				{
					 listSys=publicDateDAO.querySysLists_now(strMarketID,request); 
				}
				 sbUser.append("   <dataset seriesname='"+strName+"' color='"+strColors[j]+"'> "); 
				if(listSys!=null&&listSys.size()>0)
				{ 
					for (int i = 0; i < listSys.size(); i++) 
					{ 
						 int  intMonth=publicDao.NullToNumber(  publicPageDAO.GetFieldValue(listSys, "MONTH", i));
						 String strYear=publicPageDAO.GetFieldValue(listSys, "YEAR", i); 
						 
						 Float strRESULT=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, strFile, i));//销售预估金额
						if(j==0)
						{
						   sbHead.append("      <category name='"+MONTH_LIST.get(intMonth-1)+"-"+strYear.substring(strYear.length()-2,strYear.length())+"'  />"); 
						}
						 sbUser.append("<set value='"+strRESULT+"' />");
					}
					
				}
				 sbUser.append("   </dataset>"); 
			}
		}
		sbHead.append("   </categories> ");
		sbHead.append(sbUser.toString());
		
		sbHead.append("</graph>"); 
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    out.print(sbHead.toString());
        out.flush();
        out.close();
		  // 不返回结果
		return null;  
	}
	
	/**
	 * 本月销售分析
	 * @return
	 */
	public String  querySell_analysis()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //取response对象      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK"); 
	 
	    //List listMerket=publicDateDAO.querySysList(request); 

		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		StringBuilder sbHead = new StringBuilder();
		StringBuilder sbNTS = new StringBuilder();
		StringBuilder sbXSZZ = new StringBuilder();//销售增长 NET Growth
		//StringBuilder sbACH= new StringBuilder();//ACH,销售指标达成率
		
		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='' PYAxisName='毛收入' SYAxisName='利润'   numberPrefix='' showvalues='0'  numDivLines='4' formatNumberScale='0' decimalPrecision='0'  anchorSides='10' anchorRadius='3' anchorBorderColor='009900'  baseFont='宋体' baseFontSize='12'>"); 
	   // sbHead.append(" <categories font='宋体' fontSize='12' fontColor='9D080D'>");
	    String strColors[]= PublicConstant.COLORS_LIST;

	    sbHead.append("   <categories  > "); 
		 sbXSZZ.append(" <dataset seriesName='销售净增长额' color='F6BD0F' showValues='0' > "); 
		// sbACH.append("<dataset seriesName='销售指标达成率' color='8BBA00' showValues='0'  parentYAxis='S'> "); 
		// sbNTS.append(" <dataset seriesName='销售金额  NTS' color='AFD8F8' showValues='0' > "); 
	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				  //Float  NTS=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "NTS", j));//销售预估金额
				  Float QXX=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "QXX", j));//倾向性
				 // Float ACH=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "ACH_ALL", j));//销售增长 NET Growth
				 if(QXX==0.0){QXX=1f;};
				 sbHead.append("      <category name='"+strName+"'   color='"+strColors[j]+"'/>"); 
				 //sbNTS.append("<set value='"+NTS+"' />");
				 sbXSZZ.append("<set value='"+QXX+"' />");
				 //sbACH.append("<set value='"+ACH+"' />");
			}
		}
		sbHead.append("   </categories> ");

		//sbNTS.append("   </dataset>"); 
		sbXSZZ.append("   </dataset>"); 
		//sbACH.append("   </dataset>"); 

		//sbHead.append(sbNTS.toString());
		sbHead.append(sbXSZZ.toString());
		//sbHead.append(sbACH.toString());
		
		sbHead.append("</graph>"); 
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    out.print(sbHead.toString());
        out.flush();
        out.close();
		  // 不返回结果
		return null;  
	}

	/**
	 * 本月潜力 处方观念 倾向性
	 * @return
	 */
	public String  queryQianLiStatic()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //取response对象      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK"); 

	 	String strType =PublicMethod.NullToStr(  request.getParameter("type"));
	 	String strTitle="潜力",strFiledName="HZGM";
		if( "xsgn".equals(strType))
		{
			strTitle="处方观念";
			strFiledName="XSGN";
		}
		if( "qxx".equals(strType))
		{
			strTitle="倾向性(图示数据被放大100倍)";
			strFiledName="QXX";
		}
		
		
		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
	   // List listSys=publicDateDAO.querySysList(request); 
		StringBuilder sbHead = new StringBuilder();

		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='"+strTitle+"' subCaption='' xAxisName='' yAxisName='"+strTitle+"'   ");
		sbHead.append("showvalues='100' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5'    ");
		sbHead.append("divLineAlpha='60'    numberPrefix=''  baseFont='宋体'   ");
		sbHead.append(" baseFontSize='12'  showAlternateHGridColor='1' alternateHGridColor='f8f8f8' showNames='1'   ");
		sbHead.append("  showPercentageInLabel='0'  decimalPrecision='0' >"); 
	    String strColors[]= PublicConstant.COLORS_LIST;
	   // sbHead.append("<set name='' value='6000' color='D64646' /> ");
	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				  String  strVs=   publicPageDAO.GetFieldValue(listSys, strFiledName, j);//潜力
				 

				  System.out.println(strVs);
				  if( "qxx".equals(strType))
					{
					  strVs= PublicMethod.NullToDouble(strVs)*100+"";
					}
				  sbHead.append("<set name='"+strName+"' value='"+strVs+"' color='"+strColors[j]+"' /> ");
			}
		} 
		
		sbHead.append("</graph>"); 
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    out.print(sbHead.toString());
        out.flush();
        out.close();
		  // 不返回结果
		return null;  
	}
 
	/**
	 * 本月有效性分析
	 * @return
	 */
	public String  staticYouXiaoXing_FenXi()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //取response对象      
	   //	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("UTF-8"); 
	 
//	    List listSys=publicDateDAO.querySysList(request); 

		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		StringBuilder sbHead = new StringBuilder();

		sbHead.append("<?xml version=\"1.0\" encoding=\"gb2312\"?> "); 
		sbHead.append("  <graph title=\"销售有效分析图\" displaytitle=\"true\" linepoint=\"false\" defaultrow=\"1\" newline=\"true\" graphtitle=\"value\" markposition=\"top\" xName=\"日期\" yName=\"生产总值\" >"); 
	    request.setAttribute("listSys", listSys);
	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				  Float  HZGM=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "HZGM", j));//潜力
				  sbHead.append("<Row title=\""+strName+"\" grptype=\"curve\">");
				  
				  String[]  strResource= publicSourceDAO.strYouXiaoXing;
					for (int i = 0; i < strResource.length; i++)
					{//行字段
						String strFieldNames = publicDao.NullToStr(strResource[i]);
						String strFieldName=strFieldNames;
						String strFieldCName=strFieldNames;
						if(strFieldName.split(",").length>1)
						{
							 strFieldName=strFieldNames.split(",")[0];//英文名称
							  strFieldCName=strFieldNames.split(",")[1];//中午名称
						}
						if (!"".equals(strFieldName))
						{

							String strValue=  publicPageDAO.GetFieldValue(listSys, strFieldName, j);
							sbHead.append("  <column title=\""+(i+1)*3+"号\" value=\""+strValue+"\" lineTitle=\"上海股价"+j+"\" endLine=\""+(i+2)*3+"号\"></column>");
						}
						  
					}
				  
				  sbHead.append("  </Row>");
				// sbHead.append("<set name='"+strName+"' value='"+HZGM+"' color='"+strColors[j]+"' /> ");
			}
		} 
		
		sbHead.append("</graph>"); 
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	    out.print(sbHead.toString());
        out.flush();
        out.close();
		  // 不返回结果
        request.setAttribute("filedHtml", sbHead.toString());
		return null;  
	}
	

	/**
	 * 本月总体 销售倾向性分析
	 * @return
	 */
	public String  queryXiaoShouJieGuoStatic()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //取response对象      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK"); 
	 
//	    List listSys=publicDateDAO.querySysList(request); 

		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		StringBuilder sbHead = new StringBuilder();

		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='销售结果' subCaption='' xAxisName='' yAxisName='潜力'   ");
		sbHead.append("showvalues='1' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5'    ");
		sbHead.append("divLineAlpha='60'    numberPrefix=''  baseFont='宋体'   ");
		sbHead.append(" baseFontSize='12'  showAlternateHGridColor='1' alternateHGridColor='f8f8f8' showNames='1'   ");
		sbHead.append("  showPercentageInLabel='0'  decimalPrecision='0' >"); 
	    String strColors[]= PublicConstant.COLORS_LIST;

	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				  Float  HZGM=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "HZGM", j));//潜力
				 sbHead.append("<set name='"+strName+"' value='"+HZGM+"' color='"+strColors[j]+"' /> ");
			}
		} 
		
		sbHead.append("</graph>"); 
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    out.print(sbHead.toString());
        out.flush();
        out.close();
		  // 不返回结果
		return returnDfault;  
	}

	/**
	 * 本月销售结果达成率
	 * @return
	 */
	public String  queryDaChengLv()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //取response对象      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK"); 
	 
 	    List listSys=publicDateDAO.querySysList(request); 

//		int	intYear=publicDao.getCurrentDateYear(0);
//		int	intMonth = publicDao.getCurrentDateMonth(0);//2011-12
//		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		StringBuilder sbHead = new StringBuilder();
		StringBuilder sbACH = new StringBuilder();
		
		DecimalFormat df = new DecimalFormat("0.1");  
		
 

		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='达成率' subCaption='' xAxisName='' yAxisName='达成率'   ");
		sbHead.append("showvalues='100' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5'    ");
		sbHead.append("divLineAlpha='60'    numberPrefix=''  baseFont='宋体'   ");
		sbHead.append(" baseFontSize='12'  showAlternateHGridColor='1' alternateHGridColor='f8f8f8' showNames='1'   ");
		sbHead.append("  showPercentageInLabel='0'  decimalPrecision='0' >"); 
	    String strColors[]= PublicConstant.COLORS_LIST;
	   // sbHead.append("<set name='' value='6000' color='D64646' /> ");
	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				 String Marketid=publicPageDAO.GetFieldValue(listSys, "MARKETID", j);
					//String  Marketid =publicDao.NullToStr( request.getParameter("MARKETID"));
				
				  Double  RESULT=publicDao.NullToDouble(   publicPageDAO.GetFieldValue(listSys, "RESULT", j));//潜力
				  RESULT=publicDao.NullToDouble( request.getParameter("RESULT"+Marketid));
					 Double  COMPANYKPI=publicDao.NullToDouble(   publicPageDAO.GetFieldValue(listSys, "COMPANYKPI", j));//潜力
					 COMPANYKPI=publicDao.NullToDouble( request.getParameter("COMPANYKPI"+Marketid));

					 //Double  SALESUM=publicDao.NullToDouble( request.getParameter("SALESUM"+Marketid));
						//System.out.println(RESULT+"   "+ COMPANYKPI);-SALESUM
				  sbHead.append("<set name='"+strName+"' value='"+df.format( RESULT/COMPANYKPI*100)+"' color='"+strColors[j]+"' /> ");
			}
		} 
		
		sbHead.append("</graph>"); 
		
		 PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    out.print(sbHead.toString());
        out.flush();
        out.close();
		  // 不返回结果
		return returnDfault;  
	}
	
	
	public   String youXiaoXing_person() {
		 String strPKField="RESOURCEID";
		 String strParamField="masterid";
		String strMarketID =publicDao.NullToStr(  request.getParameter("PKID"));
		List rsList=publicDateDAO.queryHisList_YouXiaoXing(strMarketID); 
		List  paraList=	publicDateDAO.queryParaList(request);
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		String[]  strResource=publicSourceDAO.youXiaoXing_person;
		if (rsList != null && rsList.size() > 0) 
		{//列数量
			sbHead.append("<tr   class=\"tableHead\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
				for (int i = 0; i < strResource.length; i++)
				{//行字段
					String strFieldNames = publicDao.NullToStr(strResource[i]);
					String strFieldName=strFieldNames;
					String strFieldCName=strFieldNames;
					if(strFieldName.split(",").length>1)
					{
						 strFieldName=strFieldNames.split(",")[0];//英文名称
						  strFieldCName=strFieldNames.split(",")[1];//中午名称
					}
					 
					if (!"".equals(strFieldName))
					{
						sb.append("<tr class=\"trMoveRow\" >");
						for (int j = 0; j < rsList.size(); j++) 
						{
							String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
							String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
							String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
							String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
							String strValue=  publicPageDAO.GetFieldValue(rsList, strFieldName, j);
							 int  intMonth=publicDao.NullToNumber(  publicPageDAO.GetFieldValue(rsList, "MONTH", j));
							 String strYear=publicPageDAO.GetFieldValue(rsList, "YEAR",j);
							
							     String strPara="";//参数
								 
							 
							if(j==0)
							{
								sb.append("<td  class=\"tdFieldLable\">"+strFieldCName);
							    sb.append("<input type=\"hidden\"  name =\""+ strPKField+strParamID +"\"   id =\""+ strPKField+strParamID + "\"   value=\""+ strPKID
									+ "\" />");
								sb.append("</td>");
							}
							if(i==0)
							{
							   sbHead.append("<td  style=\"text-align: left;\"> "+MONTH_LIST.get(intMonth-1)+"-"+strYear.substring(strYear.length()-2,strYear.length())+ "</td>");
							}
//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> "+ strValue); 

							if("ACH".equals(strFieldName)||"ABFGL".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName))
						{
							sb.append("%");
						}
						  sb.append("</td>");
					}
						sb.append("</tr>  ");
				}
			}
				sbHead.append("</tr>  ");
		} 
		   
		request.setAttribute("filedHtml",  sbHead.toString()+ sb.toString());
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
