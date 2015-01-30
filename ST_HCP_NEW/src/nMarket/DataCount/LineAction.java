package nMarket.DataCount;

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
import system.publicClass.PublicMethod;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings( { "serial", "unchecked" })
public class LineAction extends ActionSupport implements ServletRequestAware {

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

  
	public String  getLineResult() {
 
		//查询条件
		String  Marketid =publicDao.NullToStr( request.getParameter("Marketid_P"));

//		int intYear_now = publicDao.getCurrentDateYear(0);
		StringBuilder sb = new StringBuilder();
	    int intYear=	PublicMethod.getCurrentDateYear(-1);
		RegressionLine line = new RegressionLine();
		for (int j = 1; j < 13; j++) 
		{
//			List listSys =publicDateDAO.querySysList(2010,j,request);
			
//			if(listSys!=null&&listSys.size()>0)
//			{ 
//				for (int i = 0; i < listSys.size(); i++) 
//				{
//					String strMarketid=	 publicPageDAO.GetFieldValue(listSys, "MASTERID", i) ;
//					if(strMarketid.equals(Marketid))
//					{
//					    float y=publicDao.NullToFloatr( publicPageDAO.GetFieldValue(listSys, "RESULT", i));
//						line.addDataPoint(new DataPoint(j , y )); 
//					}
//				}
//			} 	
			
			  // Double strType=publicDao.NullToDouble( publicPageDAO.GetFieldValue(listSys, "CASETYPE", j));
			
			float y=publicDao.NullToFloatr(  request.getParameter("RESULT"+Marketid+intYear+j));
			line.addDataPoint(new DataPoint(j , y )); 
		}
		 
		request.setAttribute("PageContent", sb.toString()); 
		// System.out.println("/n回归线公式:  y = " + (line.getA0() + line.getA1()*13 ));

		   DecimalFormat df = new DecimalFormat("0"); 
		 String strRestlu= df.format( line.getA0() + line.getA1()*13 )+"";
	    HttpServletResponse response = ServletActionContext.getResponse(); //取response对象      
	   	response.setContentType("text/xml;charset=GBK");  
	 	response.setCharacterEncoding("GBK");
		 PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    out.print(strRestlu);
	        out.flush();
	        out.close();
		return null;
		
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
