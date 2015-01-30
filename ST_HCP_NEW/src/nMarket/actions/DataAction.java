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

		//��ѯ����
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
				String  strStatusName="��Ϊ��ǰ����";
                if("1".equals(strType)){
                	strStatusName="��ǰʹ�ð���";
                }
				if("1".equals(strType)){strType="��ʹ��";}else {strType="δʹ��";}
				

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

				if("��ʹ��".equals(strType)){
				   sb.append("<td  class=\"STYLE2\"><div> <span class=\"STYLE1\"> [</span>"+strStatusName+"<span class=\"STYLE1\">]</span>" +
				   		"<span class=\"STYLE1\"> [</span><a href=\"#\"  onclick=\"editCase('" +
							""+request.getContextPath() +"/editCase.action?caseId="+strCaseId+"')\">�༭��ע</a><span class=\"STYLE1\">]</span></div></td>");
				}else {

					sb.append("<td  class=\"STYLE2\"><div><span class=\"STYLE1\"> [</span><a href=\"#\"  onclick=\"updateCase('" +
							""+request.getContextPath() +"/updateCase.action?caseId="+strCaseId+"&intYear="+intYear+"&intMonth="+intMonth+"')\">"+strStatusName+"</a><span class=\"STYLE1\">]</span>" +
									"<span class=\"STYLE1\"> [</span><a href=\"#\"  onclick=\"editCase('" +
							""+request.getContextPath() +"/editCase.action?caseId="+strCaseId+"')\">�༭��ע</a><span class=\"STYLE1\">]</span>" +
									"<span class=\"STYLE1\"> [</span><a href=\"#\"  onclick=\"deleteCase('" +
							""+request.getContextPath() +"/deleteCase.action?caseId="+strCaseId+"&intYear="+intYear+"&intMonth="+intMonth+"')\">ɾ��</a><span class=\"STYLE1\">]</span>" +
								"	</div></td>");
					
				}
				//sb.append("<td  class=\"STYLE2\"><span class=\"STYLE2\"><img src=\""+request.getContextPath() +"/jsp/web/tab/images/010.gif\" width=\"9\" height=\"9\" /> </span><span class=\"STYLE1\">[</span><a href=\"#\">ɾ��</a><span class=\"STYLE1\">]</span></div></td>");
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
		
			request.setAttribute("message", " alert('���óɹ���');   window.location.href='queryCase.action?intYear="+intYear+"&intMonth="+intMonth+"';");
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
		
			request.setAttribute("message", " alert('����ɹ���');   window.close();");
		}
		return returnDfault;
	}
	//��ȡ�û���Ϣ
	public  String getMarketInfo_1()
	{
		String strPKID =publicDao.NullToStr( request.getParameter("PKID")); 
		getMarketInfo_s(strPKID);
		return returnDfault;
	}
	//��ȡ�û���Ϣ
	private  void getMarketInfo_s(String strPKID )
	{
		if(strPKID!=null&&!"".equals(strPKID))
		{
			 DecimalFormat df = new DecimalFormat("0.0"); 
			   
			Users userInfo=sqlDao.gerUserInfo(request);
			//List listSys =	publicDateDAO.querySysLists(strPKID, request);
			List listSys =publicDateDAO.querySysList(request); 
			//List listSys = publicDateDAO.querySysList(request);
			 String[]  strResource= {  "QXX,������", "NTS_ALL,�����ܽ��", "XSZZ_ALL,���۾������ܶ�"};
			// List listSys=publicDateDAO.querySysLists_now(strPKID,request); 
			 if (listSys != null && listSys.size() > 0) 
				{//������
				 
				    for (int i = 0; i < strResource.length; i++)
					{//���ֶ�
						String strFieldNames = publicDao.NullToStr(strResource[i]);
						String strFieldName=strFieldNames;
						String strFieldCName=strFieldNames;
						if(strFieldName.split(",").length>1)
						{
							 strFieldName=strFieldNames.split(",")[0];//Ӣ������
							  strFieldCName=strFieldNames.split(",")[1];//��������
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
	 * ��ȡҽ��������Ϣ
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
		{//������
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
				 if(WHOLE.length()>20){WHOLE=WHOLE.substring(0, 20)+"��";}
				 String INTRODUCE_MY=publicPageDAO.GetFieldValue(listMerket, "INTRODUCE_MY", j);
				 if(INTRODUCE_MY.length()>20){INTRODUCE_MY=INTRODUCE_MY.substring(0, 20)+"��";}
				 
				 
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
//					sb.append("					<span style=\"font-size: 12px; font-weight: bold;\">Ŀǰ���۶"); 
//					sb.append("					</span><span style=\"font-size: 12px;\">"+RESULT+"Ԫ/��</span>"); 
//					sb.append("				</td>"); 
//					sb.append("			</tr>"); 
//					sb.append("			<tr>"); 
//					sb.append("				<td>"); 
//					sb.append("					<span style=\"font-size: 12px; font-weight: bold;\">���۾������</span><span"); 
//					sb.append("						style=\"font-size: 12px;\">"+XSZZ+"Ԫ/��</span>"); 
//					sb.append("				</td>"); 
//					sb.append("			</tr>"); 
//					sb.append("			<tr>"); 
//					sb.append("				<td>"); 
//					sb.append("					<span style=\"font-size: 12px; font-weight: bold;\">��˾����Ŀ�꣺</span><span"); 
//					sb.append("					 style=\"font-size: 12px;\">"+COMPANYKPI+"Ԫ/��</span>"); 
//					sb.append("				</td>"); 
//					sb.append("			</tr>"); 
//					sb.append("			<tr>"); 
//					sb.append("				<td>"); 
//					sb.append("					<span style=\"font-size: 12px; font-weight: bold;\">���۶�VS����Ŀ�꣺</span><span"); 
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
	//�����û���Ϣ
	public  String saveMarket()
	{
		int strCaseId =publicDao.NullToNumber(   request.getParameter("caseId")); 
		String NOTE =publicDao.NullToStr(request.getParameter("NOTE"));
		if(strCaseId!=0)
		{
			Users userInfo=sqlDao.gerUserInfo(request);
		
			String  strSql="update n_marketcase  set NOTE='"+NOTE.replace("'", "")+"'        where    caseid='"+strCaseId+"'   ";
			sqlDao.insertWithSql(strSql);
		
			request.setAttribute("message", " alert('����ɹ���');   window.close();");
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
		
			request.setAttribute("message", " alert('ɾ���ɹ���');   window.location.href='queryCase.action?intYear="+intYear+"&intMonth="+intMonth+"';");
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
	 * �����ж��ƻ�
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
	 * �����ж��ƻ�
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
		{//������
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
	 * �������
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
		{//������
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
										" onblur=\"checkIsNum(this);checkIntegerMaxMin(this,'12','0' ,'��������');stringLengthCheck(this,'2','����Ľ�����ܳ���2���ַ���')\"/> </td>");
				//sb.append("<td style=\"display:none;\">"+strParamID+" </td>");
				sb.append("</tr>");
				
			}
			sb.append(" <tr>  <td colspan=\"2\"  style=\"width: 120px;text-align:center;\"> <input type=\"button\" name=\"btnSave1\" value=\"���沢�ر�\" onclick=\"save();\" class=\"pt_long_button\" style=\"display: ;\" /></td>  </tr>");
				sb.append(" <tr>  <td colspan=\"2\"  style=\"width: 120px;text-align:left;color:red;\"></td>  </tr>");//�����������һ�Σ������������һ��ȷ�Ϻ��޷��޸�
			/*	if(isAdd||true)
				{
					 }else
			{
				sb.append(" <tr>  <td colspan=\"2\"  style=\"width: 120px;text-align:center;\"> <input type=\"button\" name=\"btnSave1\" value=\"�ر�\" onclick=\"window.close();\" class=\"pt_long_button\" style=\"display: ;\" /></td>  </tr>");
				sb.append(" <tr>  <td colspan=\"2\"  style=\"width: 120px;text-align:left;color:red;\">���������ù�����ǰ�޷��޸�</td>  </tr>");
			}*/
		} 
		
		request.setAttribute("filedHtml", sb.toString());
		return returnDfault;
		
		
		//return sb.toString();
	}
	/**
	 * ������Ա����
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
		request.setAttribute("message", " alert('����ɹ���');  window.close();");
		return returnDfault;

	}
	
	
	/**
	 * ��Ա��������   �������˺�����
	 * @return
	 */
	public String  queryXiaoShouShuJu()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK");
		String struserName =publicDao.NullToStr(  request.getParameter("userName"));
		String strPKID =publicDao.NullToStr(  request.getParameter("PKID"));
	 
	    List listMerket=publicDateDAO.queryHisList_YouXiaoXing(strPKID); 
		StringBuilder sbUser = new StringBuilder();
		StringBuilder sbHead = new StringBuilder();
		
		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='' subcaption='ҽԺ��������'   xaxisname='' yaxisname='���۽��'  hovercapbg='DEDEBE' hovercapborder='889E6D' rotateNames='0' yAxisMaxValue='60' numdivlines='9'     decimalPrecision='0' showAlternateHGridColor='1' AlternateHGridAlpha='30'  showvalues='1' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5' divLineAlpha='60'     numberPrefix='' baseFont='����' baseFontSize='12'   alternateHGridColor='f8f8f8' showNames='1'  showPercentageInLabel='0'  >"); 
	    sbHead.append(" <categories font='����' fontSize='12' fontColor='9D080D'>");
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
						 Float strNTS=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "RESULT", i));//���۽��
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
		  // �����ؽ��
		  return null;
		
		
	//	return returnDfault;
		
	}

	/**
	 * ��Ա����Ԥ������   �������˺�����
	 * @return
	 */
	public String  queryXiaoShouYuGu()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK");
	 	String struserName =publicDao.NullToStr(  request.getParameter("userName"));
		String strPKID =publicDao.NullToStr(  request.getParameter("PKID"));
		String strType =publicDao.NullToStr(  request.getParameter("type"));//type=1 Ԥ��
	 
		
		String  strFile="result";
		if("1".equals(strType))
		{
			 strFile="XSYC_NEXT";
		}
	    List listMerket=publicDateDAO.queryMarketList(strPKID); 
		StringBuilder sbUser = new StringBuilder();
		StringBuilder sbHead = new StringBuilder();
		
		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='' subcaption=''   xaxisname='' yaxisname='ռ����'  hovercapbg='DEDEBE' hovercapborder='889E6D' rotateNames='0' yAxisMaxValue='60' numdivlines='9'     decimalPrecision='0' showAlternateHGridColor='1' AlternateHGridAlpha='30'  showvalues='1' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5' divLineAlpha='60'     numberPrefix='' baseFont='����' baseFontSize='12'   alternateHGridColor='f8f8f8' showNames='1'  showPercentageInLabel='0'  >"); 
	    sbHead.append(" <categories font='����' fontSize='12' fontColor='9D080D'>");
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
						 
						 Float strRESULT=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, strFile, i));//����Ԥ�����
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
		  // �����ؽ��
		return null;  
	}
	
	/**
	 * �������۷���
	 * @return
	 */
	public String  querySell_analysis()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK"); 
	 
	    //List listMerket=publicDateDAO.querySysList(request); 

		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		StringBuilder sbHead = new StringBuilder();
		StringBuilder sbNTS = new StringBuilder();
		StringBuilder sbXSZZ = new StringBuilder();//�������� NET Growth
		//StringBuilder sbACH= new StringBuilder();//ACH,����ָ������
		
		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='' PYAxisName='ë����' SYAxisName='����'   numberPrefix='' showvalues='0'  numDivLines='4' formatNumberScale='0' decimalPrecision='0'  anchorSides='10' anchorRadius='3' anchorBorderColor='009900'  baseFont='����' baseFontSize='12'>"); 
	   // sbHead.append(" <categories font='����' fontSize='12' fontColor='9D080D'>");
	    String strColors[]= PublicConstant.COLORS_LIST;

	    sbHead.append("   <categories  > "); 
		 sbXSZZ.append(" <dataset seriesName='���۾�������' color='F6BD0F' showValues='0' > "); 
		// sbACH.append("<dataset seriesName='����ָ������' color='8BBA00' showValues='0'  parentYAxis='S'> "); 
		// sbNTS.append(" <dataset seriesName='���۽��  NTS' color='AFD8F8' showValues='0' > "); 
	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				  //Float  NTS=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "NTS", j));//����Ԥ�����
				  Float QXX=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "QXX", j));//������
				 // Float ACH=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "ACH_ALL", j));//�������� NET Growth
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
		  // �����ؽ��
		return null;  
	}

	/**
	 * ����Ǳ�� �������� ������
	 * @return
	 */
	public String  queryQianLiStatic()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK"); 

	 	String strType =PublicMethod.NullToStr(  request.getParameter("type"));
	 	String strTitle="Ǳ��",strFiledName="HZGM";
		if( "xsgn".equals(strType))
		{
			strTitle="��������";
			strFiledName="XSGN";
		}
		if( "qxx".equals(strType))
		{
			strTitle="������(ͼʾ���ݱ��Ŵ�100��)";
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
		sbHead.append("divLineAlpha='60'    numberPrefix=''  baseFont='����'   ");
		sbHead.append(" baseFontSize='12'  showAlternateHGridColor='1' alternateHGridColor='f8f8f8' showNames='1'   ");
		sbHead.append("  showPercentageInLabel='0'  decimalPrecision='0' >"); 
	    String strColors[]= PublicConstant.COLORS_LIST;
	   // sbHead.append("<set name='' value='6000' color='D64646' /> ");
	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				  String  strVs=   publicPageDAO.GetFieldValue(listSys, strFiledName, j);//Ǳ��
				 

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
		  // �����ؽ��
		return null;  
	}
 
	/**
	 * ������Ч�Է���
	 * @return
	 */
	public String  staticYouXiaoXing_FenXi()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����      
	   //	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("UTF-8"); 
	 
//	    List listSys=publicDateDAO.querySysList(request); 

		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		StringBuilder sbHead = new StringBuilder();

		sbHead.append("<?xml version=\"1.0\" encoding=\"gb2312\"?> "); 
		sbHead.append("  <graph title=\"������Ч����ͼ\" displaytitle=\"true\" linepoint=\"false\" defaultrow=\"1\" newline=\"true\" graphtitle=\"value\" markposition=\"top\" xName=\"����\" yName=\"������ֵ\" >"); 
	    request.setAttribute("listSys", listSys);
	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				  Float  HZGM=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "HZGM", j));//Ǳ��
				  sbHead.append("<Row title=\""+strName+"\" grptype=\"curve\">");
				  
				  String[]  strResource= publicSourceDAO.strYouXiaoXing;
					for (int i = 0; i < strResource.length; i++)
					{//���ֶ�
						String strFieldNames = publicDao.NullToStr(strResource[i]);
						String strFieldName=strFieldNames;
						String strFieldCName=strFieldNames;
						if(strFieldName.split(",").length>1)
						{
							 strFieldName=strFieldNames.split(",")[0];//Ӣ������
							  strFieldCName=strFieldNames.split(",")[1];//��������
						}
						if (!"".equals(strFieldName))
						{

							String strValue=  publicPageDAO.GetFieldValue(listSys, strFieldName, j);
							sbHead.append("  <column title=\""+(i+1)*3+"��\" value=\""+strValue+"\" lineTitle=\"�Ϻ��ɼ�"+j+"\" endLine=\""+(i+2)*3+"��\"></column>");
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
		  // �����ؽ��
        request.setAttribute("filedHtml", sbHead.toString());
		return null;  
	}
	

	/**
	 * �������� ���������Է���
	 * @return
	 */
	public String  queryXiaoShouJieGuoStatic()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK"); 
	 
//	    List listSys=publicDateDAO.querySysList(request); 

		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		StringBuilder sbHead = new StringBuilder();

		sbHead.append("<?xml version=\"1.0\" encoding=\"GBK\"?>"); 
		sbHead.append(" <graph caption='���۽��' subCaption='' xAxisName='' yAxisName='Ǳ��'   ");
		sbHead.append("showvalues='1' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5'    ");
		sbHead.append("divLineAlpha='60'    numberPrefix=''  baseFont='����'   ");
		sbHead.append(" baseFontSize='12'  showAlternateHGridColor='1' alternateHGridColor='f8f8f8' showNames='1'   ");
		sbHead.append("  showPercentageInLabel='0'  decimalPrecision='0' >"); 
	    String strColors[]= PublicConstant.COLORS_LIST;

	    if(listSys!=null&&listSys.size()>0)
		{ 
			for (int j = 0; j < listSys.size(); j++) 
			{ 
				 String strName=publicPageDAO.GetFieldValue(listSys, "NAME", j);
				  Float  HZGM=publicDao.NullToFloatr(   publicPageDAO.GetFieldValue(listSys, "HZGM", j));//Ǳ��
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
		  // �����ؽ��
		return returnDfault;  
	}

	/**
	 * �������۽�������
	 * @return
	 */
	public String  queryDaChengLv()   
	{
 
	    HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����      
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
		sbHead.append(" <graph caption='�����' subCaption='' xAxisName='' yAxisName='�����'   ");
		sbHead.append("showvalues='100' bgAlpha='70' bgcolor='' showColumnShadow='0' divlinecolor='c5c5c5'    ");
		sbHead.append("divLineAlpha='60'    numberPrefix=''  baseFont='����'   ");
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
				
				  Double  RESULT=publicDao.NullToDouble(   publicPageDAO.GetFieldValue(listSys, "RESULT", j));//Ǳ��
				  RESULT=publicDao.NullToDouble( request.getParameter("RESULT"+Marketid));
					 Double  COMPANYKPI=publicDao.NullToDouble(   publicPageDAO.GetFieldValue(listSys, "COMPANYKPI", j));//Ǳ��
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
		  // �����ؽ��
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
		{//������
			sbHead.append("<tr   class=\"tableHead\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
				for (int i = 0; i < strResource.length; i++)
				{//���ֶ�
					String strFieldNames = publicDao.NullToStr(strResource[i]);
					String strFieldName=strFieldNames;
					String strFieldCName=strFieldNames;
					if(strFieldName.split(",").length>1)
					{
						 strFieldName=strFieldNames.split(",")[0];//Ӣ������
						  strFieldCName=strFieldNames.split(",")[1];//��������
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
							
							     String strPara="";//����
								 
							 
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
