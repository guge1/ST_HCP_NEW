package nMarket.actions;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import nMarket.vo.Users;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import system.dao.IPublicDAO;
import system.dao.IPublicSourceDAO;
import system.dao.ISqlDAO;
import system.dao.Impl.PublicDateDAO;
import system.dao.Impl.PublicPageDAO;
import system.dao.Impl.PublicSourceDAO;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings( { "serial", "unchecked" })
public class Market extends ActionSupport implements ServletRequestAware {

	private static final String UPDATE = "update";

	public String returnDfault = "default";
	private HttpServletRequest request = null;
	private IPublicDAO publicDao = null;
	private PublicPageDAO publicPageDAO = null;
	private PublicSourceDAO publicSourceDAO = null;

	private PublicDateDAO publicDateDAO=null;
	public PublicDateDAO getPublicDateDAO() {
		return publicDateDAO;
	}

	public void setPublicDateDAO(PublicDateDAO publicDateDAO) {
		this.publicDateDAO = publicDateDAO;
	}

	private ISqlDAO sqlDao = null;
 
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


 
 
	public int getSaveStepID()
	{
		List listSys = publicDateDAO.queryParaList(request);
		int intStepID=0;
		if(listSys!=null&&listSys.size()>0)
		{
			intStepID=publicDao.NullToNumber( publicPageDAO.GetFieldValue(listSys, "SAVESTEP", 0));
			 
		}
		intStepID=intStepID==0?1:intStepID;
		request.setAttribute("intStepID", intStepID);
		return  intStepID;
	}
	public String queryLeft()
	{
		getSaveStepID();
		return returnDfault;
		
	}
	
	public String queryZiYuan()
	{
		List listSys = publicDateDAO.queryParaList(request);
       String[]  fieldENames= publicSourceDAO.strMarketResource;
		String filedHtml = publicPageDAO.setPageValue(listSys, "KPIID",
				fieldENames); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
 

		Users userInfo=sqlDao.gerUserInfo( request);
		
		return returnDfault;
	}

	public String queryZhiBiao() {
		List listSys = publicDateDAO.queryParaList(request);
	     String[]  fieldENames= publicSourceDAO.strMarketZhiBiao;
		String filedHtml = publicPageDAO.setPageValue(listSys, "KPIID",fieldENames);
		request.setAttribute("fieldENames", fieldENames);
		request.setAttribute("filedHtml", filedHtml);

		Users userInfo=sqlDao.gerUserInfo( request);
		return returnDfault;
	}
	
	
	
	

	/**
	 * 保存资源
	 * 
	 * @return
	 */
	public String saveSource() {
		List listSys = publicDateDAO.queryParaList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETPARA", "KPIID","",
				publicSourceDAO.strMarketResource, request,0); 
		request.setAttribute("message", "alert('保存成功！'); window.close();");
		return returnDfault;

	}

	/**
	 * 保存指标参数
	 * 
	 * @return
	 */
	public String saveZhiBiao() {
		List listSys = publicDateDAO.queryParaList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETPARA", "KPIID","",
 			publicSourceDAO.strMarketZhiBiao, request,0);
//		HttpServletResponse response = ServletActionContext.getResponse();
//		publicDao .responseMessage(response, " window.close(); ");
		request.setAttribute("message", "alert('保存成功！');window.close();");
		return returnDfault;

	}
	/**
	 * 设置行动计划
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getXingDongJiHuaList() {
	 
		String strSql=" select  *  from  N_MARKET_DICT  d  where  DICTTYPE='jihua'  order by  CAST(  ORDEX as int)   ";
		   
		List listDict = sqlDao.queryListBySqlNoSession(strSql);
		request.setAttribute("list", listDict);
		StringBuilder sb = new StringBuilder(); 
		sb.append("<option></option>");
		if (listDict != null && listDict.size() > 0) 
		{//列数量
			for (int j = 0; j < listDict.size(); j++) 
			{
				String strSelect=" ";
				sb.append("<tr style=\"height: 26px;\">");
				sb.append("<td style=\"width: 30px;text-align:center;\"><input name=\"chk\" type=\"radio\"   onclick=\"javascript:SetGVCheck('"+publicPageDAO.GetFieldValue(listDict, "ID", j)+"','"+publicPageDAO.GetFieldValue(listDict, "CODEID", j)+"');\" value=\"0\" /></td> ");
				//sb.append(publicPageDAO.GetFieldValue(listDict, "CODEID", j)+" ");
				sb.append("<td style=\"width:80px;text-align:center;\">"+publicPageDAO.GetFieldValue(listDict, "bigtype", j)+" </td>"); 
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
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
