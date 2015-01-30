package system.dao.Impl;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nMarket.vo.Users;

import org.apache.struts2.interceptor.ServletRequestAware;

import system.dao.IPublicDAO;
import system.dao.ISqlDAO;
import system.publicClass.PublicMethod;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial","unchecked"})
public class PublicDateDAO extends ActionSupport implements ServletRequestAware  {

	private IPublicDAO publicDao = null;
	private ISqlDAO  sqlDao=null;
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


	/**
	 * 本月分析资源表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysList( HttpServletRequest request) {
		// List<nMarket> list = publicDao.findAllList(" from nMarket u  ");
		//String strDate = publicDao.getCurrentDateTostr();


		int intYear = publicDao.getCurrentDateYear(0);
		int intMonth = publicDao.getCurrentDateMonth(0);
 
		String	strSql=strGetList(  intYear,  intMonth,  "","",  request);
		strSql+=" order by     CAST(  s.USERORDER as int),CAST( u.MASTERID as int) ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	public List querySysList_per( HttpServletRequest request,String strMarketid) {
		// List<nMarket> list = publicDao.findAllList(" from nMarket u  ");
		//String strDate = publicDao.getCurrentDateTostr();


		int intYear = publicDao.getCurrentDateYear(0);
		int intMonth = publicDao.getCurrentDateMonth(0);

//		String	strCaseID = getCaseID(intYear,intMonth, request);
//
//		String strSql = "select (select  u.TARGET  from  n_market_user  u  where u.masterid=s.MARKETID)target, (select  u.name  from  n_market_user  u  where u.masterid=s.MARKETID)name,  s.*  from    N_MARKETANALYSIS  s  ";
//		strSql = strSql + "   where 1=1  and s.YEAR='" + intYear + "'  and s.MONTH='" + intMonth + "'  ";
//		strSql = strSql + "  and  s.caseid='" + strCaseID + "'  and s.MARKETID='" + strMarketid + "' ";
		

		String	strSql=strGetList(  intYear,  intMonth,  strMarketid,"",  request);
		strSql = strSql + " order by      CAST(  s.USERORDER as int),CAST( u.MASTERID as int)  ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	/**
	 * 下月分析资源表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List queryNextSysList( HttpServletRequest request) {
		int intYear = publicDao.getCurrentDateYear(1);
		int intMonth = publicDao.getCurrentDateMonth(1);
		String	strCaseID = getCaseID(intYear,intMonth,  request); 

		String	strSql=strGetList(  intYear,  intMonth,  "","",  request);
		strSql+=" order by      CAST(  s.USERORDER as int),CAST( u.MASTERID as int) ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}

	/**
	 * 下xia月分析资源表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List queryNextSysList_1( HttpServletRequest request) {
		int intYear = publicDao.getCurrentDateYear(2);
		int intMonth = publicDao.getCurrentDateMonth(2);
 
		String	strSql=strGetList(  intYear,  intMonth,  "","",  request);
		strSql+=" order by      CAST(  s.USERORDER as int),CAST( u.MASTERID as int)  ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	/**
	 * 参数
	 * 
	 * @return
	 * @throws Exception
	 */
	public List queryParaList( HttpServletRequest request) {
		// List<nMarket> list = publicDao.findAllList(" from nMarket u  ");
		int intYear = publicDao.getCurrentDateYear(0);
		int intMont = publicDao.getCurrentDateMonth(0);
		//String	strCaseID = getCaseID(intYear,intMont,  request);
		String strSql = "select p.*  from   N_MARKETPARA  p   where 1=1 ";
		//strSql += 	"and YEAR='"+ intYear + "'  and MONTH='" + intMont + "'  ";
		//strSql += "  and  p.caseid='" + strCaseID + "'  ";
		List listPara = sqlDao.queryListBySqlNoSession(strSql);
		if(listPara==null||listPara.size()<1)
		{
			int  intMaxID=sqlDao.getTableMaxId("N_MARKETPARA","KPIID");
			String  insertSql="  insert  into     N_MARKETPARA (KPIID,CASEID,YEAR,MONTH)  values  ("+intMaxID+",'','"+intYear+"','"+ intMont+"')" ;	
			sqlDao.insertWithSql(insertSql);
			//初始数据
//			String   updateSql= " update    N_MARKETPARA " 
//				+"  set XF='12',KNH='24',HD='10',XSTGF='12000',SCBTGF='8000',PXHD='2',PXKC='1',CPKS='4',ACH='50',NTS='0',XSZZ='50',HZGM='100',PFCS='10',KNHCS='10',TGHDCS='10',ABFGL='15',BFJH='20',BFJH_T='5',CPZS='15',XSJQ='15' "
//				+",XF_LV='25',KNH_LV='10',HD_LV='10',XSTGF_LV='18',SCBTGF_LV='18',PXHD_LV='19'";
//			updateSql += "  where 1=1 ";
//			updateSql += 	"and YEAR='"+ intYear + "'  and MONTH='" + intMont + "'  ";
//			updateSql += "  and  p.caseid='" + strCaseID + "'  ";
//			sqlDao.insertWithSql(updateSql);

			strSql = "select p.*  from   N_MARKETPARA  p   where 1=1 ";
//			strSql += 	"and YEAR='"+ intYear + "'  and MONTH='" + intMont + "'  ";
//			strSql += "  and  p.caseid='" + strCaseID + "'  ";
			listPara = sqlDao.queryListBySqlNoSession(strSql);
		}
		return listPara;
	}

	/**
	 * 下拉字典表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryDictDrop(String strType,String  strValue) {
		String strSql=" select  *  from  N_MARKET_DICT  d  where  DICTTYPE='"+strType+"'  order by  CAST(  ORDEX as int)  ";
		List listDict = sqlDao.queryListBySqlNoSession(strSql);
		StringBuilder sb = new StringBuilder(); 
		sb.append("<option></option>");
		if (listDict != null && listDict.size() > 0) 
		{//列数量
			String  strBigeType_1="";
			for (int j = 0; j < listDict.size(); j++) 
			{
				String strSelect=" ";
				if(publicPageDAO.GetFieldValue(listDict, "ID", j).equals(strValue))
				{
					strSelect="  selected=\"selected\" ";
				}
				String  strBigeType=publicPageDAO.GetFieldValue(listDict, "bigtype", j);
				if(!strBigeType.equals(strBigeType_1))
				{
					sb.append("<OPTGROUP LABEL=\""+strBigeType+"\">");
				}

				sb.append("<option value=\""+publicPageDAO.GetFieldValue(listDict, "ID", j)+"\"  "+strSelect+">"+publicPageDAO.GetFieldValue(listDict, "DICTNAME", j)+"");
				strBigeType_1=strBigeType;
				sb.append("</option>");
			}
		}
		sb.append("");
		return sb.toString();
	}


	/**
	 * 根据 月份和年份
	 * @param intYear
	 * @param intMonth
	 * @param strUserID
	 * @param request
	 * @return
	 */
	public String quryCaseInfoByID(int intYear ,int intMonth,String strUserID, HttpServletRequest request ) {  

		Users userInfo=sqlDao.gerUserInfo( request);

		if(strUserID==null||"".equals( strUserID))
		{
			strUserID=  userInfo.getId()+"";
		}
		String strSql="select   s.caseid   caseid,CASESAVE  from n_marketcase s  where  CASETYPE='1'    ";
		strSql+="  and   (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "' ) " +
		"and  userid='"+strUserID+"' and  CASETYPE='1'  and  (delStatus!='1' or delStatus is  null or delStatus='')  ";
		List listList =   sqlDao.queryListBySqlNoSession(strSql);
		String strCaseID="";
		if(listList!=null&&listList.size()>0)
		{
			strCaseID=	publicPageDAO.GetFieldValue(listList, "caseid", 0);
		    String 	CASESAVE=	publicPageDAO.GetFieldValue(listList, "CASESAVE", 0);
		    request.setAttribute("CASESAVE", CASESAVE);//判断项目是否保存了
		} 
		//System.out.println(intYear +"  "+intMonth);
		return strCaseID;
	}
	
	/**
	 * 下拉字典表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String changeDictIdToCode(String strDictID) {
		int id=publicDao.NullToNumber(strDictID);
		String strSql=" select  *  from  N_MARKET_DICT  d  where  ID='"+id+"'  order by  CAST(  ORDEX as int)  ";
		List listDict = sqlDao.queryListBySqlNoSession(strSql);
		String strCode="";
		if (listDict != null && listDict.size() > 0) 
		{//列数量
			strCode=	publicPageDAO.GetFieldValue(listDict, "CODEID", 0);

		} 
		return strCode;
	}



	/**
	 * 查询案例
	 * @return
	 * @throws Exception
	 */
	public List queryCaseList(int intYear,int intMonth,HttpServletRequest request) {  

		String strSql = "select p.*  from   N_MARKETCASE  p  where 1=1   ";


		strSql += "   and p.YEAR='" + intYear + "'  and p.MONTH='" + intMonth + "' and  (delStatus!='1' or delStatus is  null or delStatus='')   ";

		Users userInfo=sqlDao.gerUserInfo( request);
		strSql +=" and  userid='"+userInfo.getId()+"'   order  by  caseid desc  ";
		List listM = sqlDao.queryListBySqlNoSession(strSql); 
		return listM;
	}

	public String getCaseID_User(int intYear ,int intMonth,String strUserID,HttpServletRequest request ) {  


		String strCaseID="";

		strCaseID=quryCaseID(  intYear ,  intMonth,strUserID,  request );
		if("".equals(strCaseID))
		{
			strCaseID=inserCaseID(  intYear ,  intMonth ,strUserID,  request);
			strCaseID=quryCaseID(  intYear ,  intMonth ,strUserID,  request);//从新读取
		} 
			updateCaseSameID(  intYear ,  intMonth,  request );//设置案例的同步状态
		 
		return strCaseID;
	}
	public String getCaseID(int intYear ,int intMonth,HttpServletRequest request ) {  


		String strCaseID="";

		strCaseID=quryCaseID(  intYear ,  intMonth,"",  request );
		if("".equals(strCaseID))
		{
			inserCaseID(  intYear ,  intMonth,"" ,  request);
			strCaseID=quryCaseID(  intYear ,  intMonth ,"",  request);//从新读取
		} 
			updateCaseSameID(  intYear ,  intMonth,  request );//设置案例的同步状态
		 
		return strCaseID;
	} 
	public String quryCaseID(int intYear ,int intMonth,String strUserID, HttpServletRequest request ) {  

		Users userInfo=sqlDao.gerUserInfo( request);

		if(strUserID==null||"".equals( strUserID))
		{
			strUserID=  userInfo.getId()+"";
		}
		String strSql="select   s.caseid   caseid,CASESAVE  from n_marketcase s  where  CASETYPE='1'    ";
		strSql+="  and   (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "' ) " +
		"and  userid='"+strUserID+"' and  CASETYPE='1'  and  (delStatus!='1' or delStatus is  null or delStatus='')  ";
		List listList =   sqlDao.queryListBySqlNoSession(strSql);
		String strCaseID="";
		if(listList!=null&&listList.size()>0)
		{
			strCaseID=	publicPageDAO.GetFieldValue(listList, "caseid", 0);
		    String 	CASESAVE=	publicPageDAO.GetFieldValue(listList, "CASESAVE", 0);
			request.setAttribute("CASESAVE", CASESAVE);//判断项目是否保存了

		} 
		return strCaseID;
	}
    /**
     * 项目是否已经保存
     * @param intYear
     * @param intMonth
     * @param strUserID
     * @param request
     */
	public  void updateCaseStatus(int intYear ,int intMonth,String strUserID,HttpServletRequest request )
	{   
	    String strCaseId	=getCaseID_User( intYear , intMonth, strUserID, request );
		if(strCaseId!=null)
		{ 
			String  strSql="update n_marketcase  set CASESAVE='1'        where    caseid='"+strCaseId+"'   ";
			sqlDao.insertWithSql(strSql);

			request.setAttribute("CASESAVE", "1");//判断项目是否保存了
		}
	}
	/**
	 * 初始化排序
	 * @param intYear
	 * @param intMonth
	 * @param strUserID
	 * @param request
	 */
	public  void updateOrder(int countInt,HttpServletRequest request )
	{   
		int preInt=1+countInt;
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
		    int n=7;
		    if(CASESAVE!=1)
		    {
//			    String  strSaveSql="update n_marketcase  set CASESAVE='"+(n+1)+"'        where    caseid='"+strCaseID+"'   ";
//				sqlDao.insertWithSql(strSaveSql);
//				request.setAttribute("CASESAVE", n);//判断项目是否保存了
		    

			    String strCaseId	=getCaseID_User( intYear , intMonth, strUserID, request );
		    	String	strSaveSql=" update t1 set t1.USERORDER=t2.USERORDER ";
		    	strSaveSql+="   from ( select  USERORDER,MARKETID from  N_MARKETANALYSIS s1 where   s1.YEAR='"+intYear+"'  and s1.MONTH='"+intMonth+"'    and  s1.caseid='"+strCaseId+"') t1 ";
		    	
		    	preInt=0;
				 	intYear=publicDao.getCurrentDateYear(preInt);
				 	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
				 	strCaseId	=getCaseID_User( intYear , intMonth, strUserID, request );
		    	strSaveSql+="   inner join ( select  USERORDER,MARKETID from  N_MARKETANALYSIS s1 where   s1.YEAR='"+intYear+"'  and s1.MONTH='"+intMonth+"'    and  s1.caseid='"+strCaseId+"') t2 ";
		    	strSaveSql+="   on t1.MARKETID=t2.MARKETID ";
//		    	sqlDao.insertWithSql(strSaveSql);
		    }
		
		}
	}

    /**
     * 设置案例的同步状态
     * @param intYear
     * @param intMonth
     * @param strUserID
     * @param request
     */
	public  void updateCaseSameID(int intYear ,int intMonth,HttpServletRequest request )
	{    
		int intYear_1 = publicDao.getCurrentDateYear(1);
		int intMonth_1 = publicDao.getCurrentDateMonth(1);
	    
		int intYear_2 = publicDao.getCurrentDateYear(2);
		int intMonth_2 = publicDao.getCurrentDateMonth(2);


		int intYear_3 = publicDao.getCurrentDateYear(3);
		int intMonth_3 = publicDao.getCurrentDateMonth(3);
	    String strCaseId_0="";
	    if(intYear_3==intYear&&intMonth_3==intMonth)
	    {//插入的时间是 下月  
			int intYear_0 = publicDao.getCurrentDateYear(0);
			int intMonth_0 = publicDao.getCurrentDateMonth(0);
		        strCaseId_0=getCaseID_1(  intYear_0 ,  intMonth_0,  request );

		 	    String strCaseId_3=getCaseID_1(  intYear_3 ,  intMonth_3,  request );
				String  strSql="update n_marketcase  set sameCaseId ='"+strCaseId_0+"'        where    caseid='"+strCaseId_3+"'   ";
				sqlDao.insertWithSql(strSql);
	    }
//	    if(intYear_1==intYear&&intMonth_1==intMonth)
//	    {//插入的时间是 下月  
//			int intYear_0 = publicDao.getCurrentDateYear(0);
//			int intMonth_0 = publicDao.getCurrentDateMonth(0);
//		        strCaseId_0=getCaseID_1(  intYear_0 ,  intMonth_0,  request );
//
//		 	    String strCaseId_1=getCaseID_1(  intYear_1 ,  intMonth_1,  request );
//				String  strSql="update n_marketcase  set sameCaseId ='"+strCaseId_0+"'        where    caseid='"+strCaseId_1+"'   ";
//				sqlDao.insertWithSql(strSql);
//	    }
	    if(intYear_1==intYear&&intMonth_1==intMonth)
	    {//插入的时间是 下月  
			int intYear_0 = publicDao.getCurrentDateYear(0);
			int intMonth_0 = publicDao.getCurrentDateMonth(0);
		        strCaseId_0=getCaseID_1(  intYear_0 ,  intMonth_0,  request );

		 	    String strCaseId_1=getCaseID_1(  intYear_1 ,  intMonth_1,  request );
				String  strSql="update n_marketcase  set sameCaseId ='"+strCaseId_0+"'        where    caseid='"+strCaseId_1+"'   ";
				sqlDao.insertWithSql(strSql);
	    }

	    if(intYear_2==intYear&&intMonth_2==intMonth)
	    {//插入的时间是 后月的时间时
			int intYear_0 = publicDao.getCurrentDateYear(0);
			int intMonth_0 = publicDao.getCurrentDateMonth(0);
		        strCaseId_0=getCaseID_1(  intYear_0 ,  intMonth_0,  request );
			    String strCaseId_2=getCaseID_1(  intYear_2 ,  intMonth_2,  request );

				String  strSql="update n_marketcase  set sameCaseId ='"+strCaseId_0+"'        where    caseid='"+strCaseId_2+"'   ";
				sqlDao.insertWithSql(strSql);
	    }  
	}
	public String getCaseID_1(int intYear ,int intMonth,HttpServletRequest request ) {  


		String strCaseID="";

		strCaseID=quryCaseID(  intYear ,  intMonth,"",  request );
	 
		 
		return strCaseID;
	} 
	
	public String inserCaseID(int intYear ,int intMonth,String strUserID, HttpServletRequest request ) 
	{ 
		if(intYear==0)
		{
			intYear = publicDao.getCurrentDateYear(0);
		}
		if(intMonth==0)
		{
			intMonth = publicDao.getCurrentDateMonth(0);
		}
		if(strUserID==null||"".equals( strUserID))
		{
			Users userInfo=sqlDao.gerUserInfo( request);
			strUserID=  userInfo.getId()+"";
		}
		String strCaseID="";

		int  intMaxID=sqlDao.getTableMaxId("n_marketcase","caseid");
		
	    
		String strSql="update n_marketcase    set CASETYPE='0'      where  1=1  ";
		strSql+="   and(     YEAR='" + intYear + "'  and   MONTH='" + intMonth + "'   " +
		" and  userid='"+strUserID+"'  )   ";
		sqlDao.insertWithSql(strSql);
		String applynumber = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String  strdayCount="001"; 
		List  dayCountList=	sqlDao.queryListBySqlNoSession("select count(caseid)+1 daycount   from n_marketcase t  where        YEAR='" + intYear + "'  and   MONTH='" + intMonth + "'   " +
				" and  userid='"+strUserID+"' ");
		if(dayCountList!=null&&dayCountList.size()>0)
		{
			Map  contentMap=(Map)dayCountList.get(0);
			int	intdayCount=publicDao.NullToNumber(contentMap.get("daycount"));
			if(intdayCount<10)
			{
				strdayCount="00"+intdayCount;
			}
			if(intdayCount<100&&intdayCount>9)
			{
				strdayCount="0"+intdayCount;
			}
		}
		applynumber =applynumber +"_"+strdayCount ;
		strSql="  insert  into    n_marketcase   (caseid,CASETYPE,YEAR,MONTH,userid,casenum)  values  ('"+intMaxID+"'," +
		"'1','"+intYear+"','"+intMonth+"','"+strUserID+"','"+applynumber+"' )"    ;	
		sqlDao.insertWithSql(strSql);
		strCaseID=intMaxID+"";
		return strCaseID;
	}
	/**
	 * 查询字典
	 * @return
	 * @throws Exception
	 */
	public List queryDictList(String strType) {  
		String strSql=" select  *  from  N_MARKET_DICT  d  where  DICTTYPE='"+strType+"'  order by  CAST(  ORDEX as int)  ";

		List listDict =   sqlDao.queryListBySqlNoSession(strSql);
		return listDict;
	}

	/**
	 * 医院及医生介绍
	 * @return
	 * @throws Exception
	 */
	public List queryMarketList(String strMARKETID) {  

		String strSql="  select     u.*  from    n_market_user  u    where  1=1  ";
		if(strMARKETID!=null&&!"".equals(strMARKETID))
		{
			strSql+=" and u.MASTERID='"+strMARKETID+"'  ";
		}
		strSql+=" order by    CAST( u.MASTERID as int) ";
		List listMarket =   sqlDao.queryListBySqlNoSession(strSql);
		return listMarket;
	}
	
	/**
	 * 本月分析资源表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysList_1( HttpServletRequest request) {
		// List<nMarket> list = publicDao.findAllList(" from nMarket u  ");
		//String strDate = publicDao.getCurrentDateTostr();


		int intYear = publicDao.getCurrentDateYear(0);
		int intMonth = publicDao.getCurrentDateMonth(0);
 
		String	strSql=strGetList(  intYear,  intMonth,  "","",  request); 
		strSql+=" order by    CAST(  s.USERORDER as int),CAST( u.MASTERID as int) ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	/**
	 * 区域及区域代表  历史数据
	 * @return
	 * @throws Exception
	 */
	public List queryHisList(String strMARKETID) {  

		String strSql="  select    *  from N_MARKET_HIS m    where  1=1  ";
		if(strMARKETID!=null&&!"".equals(strMARKETID))
		{
			strSql+=" and m.MARKETID='"+strMARKETID+"'  ";
		}
		strSql+=" order by   YEAR,MONTH , CAST( m.MARKETID as int)  ";
		List listMarket =   sqlDao.queryListBySqlNoSession(strSql);
		return listMarket;
	}
	/**
	 * 区域及区域代表  历史数据
	 * @return
	 * @throws Exception
	 */
	public List queryHisList(int intYear,int intMonth,String strMARKETID,HttpServletRequest request) {  

		String strSql="  select    *  from N_MARKET_HIS m    where  1=1  ";
		if(strMARKETID!=null&&!"".equals(strMARKETID))
		{
			strSql+=" and m.MARKETID='"+strMARKETID+"'  ";
		}

		strSql+="   and(     YEAR='" + intYear + "'  and   MONTH='" + intMonth + "' )  " ;
		strSql+=" order by   YEAR,MONTH , CAST( m.MARKETID as int) ";
		List listMarket =   sqlDao.queryListBySqlNoSession(strSql);
		return listMarket;
	}
	

	/**
	 * 区域及区域代表  历史数据
	 * @return
	 * @throws Exception
	 */
	public List queryHisList_YouXiaoXing(String strMARKETID) {  

		String strSql="  select    *  from N_MARKET_HIS m    where  1=1  ";
		if(strMARKETID!=null&&!"".equals(strMARKETID))
		{
			strSql+=" and m.MARKETID='"+strMARKETID+"'  ";
		}

		strSql+="   and(     YEAR='2011'  and   MONTH>=10 )  " ;
		strSql+=" order by   YEAR,MONTH , CAST( m.MARKETID as int) ";
		List listMarket =   sqlDao.queryListBySqlNoSession(strSql);
		return listMarket;
	}
	
	/**
	 * 查询十ge月内地数据 到下个月
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysLists(String strMARKETID,HttpServletRequest request) {

		int intYear = publicDao.getCurrentDateYear(-12);//前九个月
		int intMonth = publicDao.getCurrentDateMonth(-12); 
		String strWhere="  and  (   ";
		for(int i=-12;i<0 	;i++)
		{
			intYear=publicDao.getCurrentDateYear(i);
			intMonth = publicDao.getCurrentDateMonth(i);
			if(i!=-12)
			{
				strWhere+="  or " ;
			}
			String	strCaseID = getCaseID(intYear,intMonth,  request);
			strWhere+="    (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "'  and  s.caseid='" + strCaseID + "' )  ";
		}
		strWhere+=")"; 

		String strSql="select  s.*  from   N_MARKETANALYSIS  s  where 1=1  ";
		strSql += strWhere;
		//strSql += "  and  s.caseid='" + strCaseID + "'  ";
		if(!"".equals(strMARKETID)&&strMARKETID!=null)
		{
			strSql += "  and  MARKETID='"+strMARKETID+"'";
		}
		strSql +=" order  by   CAST( year as int) ,  CAST(month as int) , CAST(  s.USERORDER as int),CAST( s.MARKETID as int)";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}

	/**
	 * 查询十ge月内地数据 到下个月
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysLists_user(String strUserID,HttpServletRequest request) {

		int intYear = publicDao.getCurrentDateYear(-12);//前九个月
		int intMonth = publicDao.getCurrentDateMonth(-12); 
		String strWhere="  and  (   ";
		for(int i=-12;i<0 	;i++)
		{
			intYear=publicDao.getCurrentDateYear(i);
			intMonth = publicDao.getCurrentDateMonth(i);
			if(i!=-12)
			{
				strWhere+="  or " ;
			}
			String	strCaseID = getCaseID_User(intYear,intMonth,strUserID,  request);//根据用户获取id
			strWhere+="    (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "'  and  s.caseid='" + strCaseID + "' )  ";
			inSertSys(  intYear ,  intMonth,  strCaseID,  request);
			
			}
		strWhere+=")"; 

		String strSql="select  s.*  from   N_MARKETANALYSIS  s  where 1=1  ";
		strSql += strWhere;
		//strSql += "  and  s.caseid='" + strCaseID + "'  ";

		strSql +=" order  by   CAST( year as int) ,  CAST(month as int) , CAST(  s.USERORDER as int),CAST( s.MARKETID as int)  ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	/**
	 * 判断是否有Sys数据 没有就执行插入数据
	 * @param intYear
	 * @param intMonth
	 * @param strCaseID
	 * @param request
	 */
	private  void  inSertSys(int intYear ,int intMonth,String strCaseID,HttpServletRequest request)
	{
		String  strSearchSql="select  s.*  from   N_MARKETANALYSIS  s  where 1=1   and (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "'  and  s.caseid='" + strCaseID + "' ) ";
		List listIsSys = sqlDao.queryListBySqlNoSession(strSearchSql);
		if(listIsSys!=null&&listIsSys.size()<1) {
			List listSys =querySysList(intYear,intMonth,request);
			if (listSys != null && listSys.size() > 0) 
			{
				for (int j = 0; j < listSys.size(); j++) 
				{
                    String strTableName="N_MARKETANALYSIS",strPKField="RESOURCEID";
                    String strValues="";
                    strValues=" '"+ publicPageDAO.GetFieldValue(listSys, "sellerid", j)+"','"+ publicPageDAO.GetFieldValue(listSys, "MASTERID", j)+"','"+ strCaseID+"'";
					strValues+=",'"+intYear+"','"+ intMonth+"'";
					int  intMaxID=sqlDao.getTableMaxId(strTableName,strPKField);
				    String strInserSql=	 "  insert  into      " +strTableName+"  ("+strPKField+",USERID,MARKETID,CASEID,YEAR,MONTH)  values  ("+intMaxID+","+strValues+")"    ;	
					sqlDao.insertWithSql(strInserSql);
				}
			}
			// String[] strJieGuoFenxi = { "RESULTPOINT1,倾向性要点1"};
			// publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid", strJieGuoFenxi, request,i);
			updateMarketSize();//初始化潜力
		}
	}
	/**
	 * 查询十ge月内地数据 到本月月
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysLists_now(String strMARKETID,HttpServletRequest request) {

		int intYear = publicDao.getCurrentDateYear(-12);//前九个月
		int intMonth = publicDao.getCurrentDateMonth(-12); 
		String strWhere="  and  (   ";
		for(int i=-12;i<1;i++)
		{
			intYear=publicDao.getCurrentDateYear(i);
			intMonth = publicDao.getCurrentDateMonth(i);
			if(i!=-12)
			{
				strWhere+="  or " ;
			}

			String	strCaseID = getCaseID(intYear,intMonth,  request);
			strWhere+="    (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "'   and  s.caseid='" + strCaseID + "' )  ";
		}
		strWhere+=")"; 

		String strSql="select  s.*  from   N_MARKETANALYSIS  s  where 1=1  ";
		strSql += strWhere;
		strSql += "   ";
		if(!"".equals(strMARKETID)&&strMARKETID!=null)
		{
			strSql += "  and  MARKETID='"+strMARKETID+"'";
		}
		strSql +=" order  by   CAST( year as int) ,  CAST(month as int) , CAST(  s.USERORDER as int),CAST( s.MARKETID as int)  ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}

	/**
	 * 查询4ge月内地数据 到下个月
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysListsFour(String strMARKETID,HttpServletRequest request) {

		int intYear = publicDao.getCurrentDateYear(-9);//前九个月
		int intMonth = publicDao.getCurrentDateMonth(-9); 
		String strWhere="  and  (   ";
		for(int i=-3;i<0;i++)
		{
			intYear=publicDao.getCurrentDateYear(i);
			intMonth = publicDao.getCurrentDateMonth(i);
			if(i!=-3)
			{
				strWhere+="  or " ;
			}
			String	strCaseID = getCaseID(intYear,intMonth,  request);
			strWhere+="    (    s.YEAR='" + intYear + "'  and  s.MONTH='" + intMonth + "' and  s.caseid='" + strCaseID + "'  )  ";
		}
		strWhere+=")"; 

		String strSql="select  s.*  from   N_MARKETANALYSIS  s  where 1=1  ";
		strSql += strWhere;
		strSql += "   ";

		strSql += "  and  MARKETID='"+strMARKETID+"'";
		strSql +=" order  by   CAST( year as int) ,  CAST(month as int)  , CAST(  s.USERORDER as int),CAST( s.MARKETID as int) ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	/**
	 * 查询指定年份月份的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysList(int intYear,int intMonth,HttpServletRequest request) {

		//String	strCaseID = getCaseID(intYear,intMonth,  request);	 
		String	strSql=strGetList(  intYear,  intMonth,  "","",  request); 
		strSql+=" order by    CAST(  s.USERORDER as int),CAST( u.MASTERID as int) ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	/**
	 * 查询指定年份月份的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysList_new(int intYear,int intMonth,HttpServletRequest request) {

		//String	strCaseID = getCaseID(intYear,intMonth,  request);	 
		String	strSql=strGetList(  intYear,  intMonth,  "","",  request); 
		strSql+=" order by    CAST( u.MASTERID as int) ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	
	public List querySysList_1(int intYear,int intMonth,HttpServletRequest request) {

		//String	strCaseID = getCaseID(intYear,intMonth,  request);	 
		String	strSql=strGetList(  intYear,  intMonth,  "","",  request); 
		strSql+=" order by    CAST(  s.USERORDER as int),CAST( u.MASTERID as int) ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}

	/**
	 * 查询指定年份月份的数据
	 * 
	 * @return
	 * @throws Exception
	 */
//	public List querySysList_PaoPao(int intYear,int intMonth,HttpServletRequest request) {
//
//
//		String	strSql=strGetList(  intYear,  intMonth,  "",  request);
//		strSql+=" order by  CAST(  s.PAOPAO_ORDER as int), CAST(  u.MASTERID as int),u.MASTERID  ";
//		List listSys = sqlDao.queryListBySqlNoSession(strSql);
//
//		return listSys;
//	}
	/**
	 * 查询指定年份月份的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysList_PaoPao(int intYear,int intMonth,String strMarketid,HttpServletRequest request) {
 
		String	strSql=strGetList(  intYear,  intMonth,  strMarketid,"",  request);
		strSql+=" order by  CAST(  s.PAOPAO_ORDER as int),   CAST(  s.USERORDER as int),CAST( u.MASTERID as int)  ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}


	/**
	 * 查询指定年份月份的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List querySysList_user(int intYear,int intMonth,String strUserID,HttpServletRequest request) {
		
 
 
		String	strSql=strGetList(  intYear,  intMonth,  "",strUserID,  request);
		strSql+=" order by     CAST(  s.USERORDER as int),CAST( u.MASTERID as int) ";
		List listSys = sqlDao.queryListBySqlNoSession(strSql);

		return listSys;
	}
	/**
	 * 根据用户id 和代表id
	 * @param intYear
	 * @param intMonth
	 * @param strMarketid 医生介绍id
	 * @param strUserID  登录用户id
	 * @param request
	 * @return
	 */ 
	private   String strGetList(int intYear,int intMonth,String strMarketid,String strUserID,HttpServletRequest request)
	{
		String	strCaseID = getCaseID(intYear,intMonth,  request);		 

		String	strSql="select    s.*,u.*  from ";
		strSql+="(select  u.* ";
//		strSql+="u.MASTERID,u.MARKETNAME,u.GRADE,u.TYPE1,u.MARKETCLASS,u.NOTE,u.STARTDATE,u.SELLERID,u.ORDERINDEX,u.INTRODUCE,u.PINGLUN,u.SHIJIAN,u.RENKOUSHU,u.SUI0,u.SUI25,u.SUI60,u.RJSR,u.COUNTYIYUAN,u.JI3,u.JI2,u.COUNTMENZENG,u.COUNTJINER,u.TOUXIANG";
//		strSql+=" ,u.NAME,u.PASSWORD,u.PHOTO,u.INTRODUCE_MY,u.WHOLE,u.SELF,u.TARGET,u.REQUIREMENT,u.SEX,u.YEJI,u.JIHUA,u.XF_BIAOZHUN,u.KNH_BIAOZHUN,u.HD_BIAOZHUN,u.XSTGF_BIAOZHUN,u.SCBTGF_BIAOZHUN,u.PXHD_BIAOZHUN,u.ACH_ALL,u.NTS_ALL,u.XSZZ_ALL ";
		strSql+="from   n_market_user  u    where  1=1 ";
		if(!"".equals(strMarketid)&&strMarketid!=null)
		{
			strSql+=" and u.MASTERID='"+strMarketid+"' ";
		} 
		strSql+=" ) u  left  join   N_MARKETANALYSIS  s  on  u.MASTERID=s.MARKETID  ";
		strSql += "   and s.YEAR='" + intYear + "'  and s.MONTH='" + intMonth + "'  ";
		strSql += "  and  s.caseid='" + strCaseID + "'   ";
		//System.out.println("  or(    s.YEAR='" + intYear + "'  and s.MONTH='" + intMonth + "'   and  s.caseid='" + strCaseID + "' )  ");
		if(intMonth==2||intMonth==3)
		{
			List listHis = sqlDao.queryListBySqlNoSession(" select * from   N_MARKETANALYSIS  s  where  s.YEAR='2012'  and s.MONTH='"+intMonth+"'    and  s.caseid='"+strCaseID+"' ");
			if(listHis==null||listHis.size()<1)
			{//新增
				  intYear = publicDao.getCurrentDateYear(0);
				  intMonth = publicDao.getCurrentDateMonth(0);
				  strCaseID = getCaseID(intYear,intMonth,  request);		
				 
				  strSql="select    s.*,u.*  from ";
					strSql+="(select  u.* ";
					strSql+="from   n_market_user  u    where  1=1 ";
					if(!"".equals(strMarketid)&&strMarketid!=null)
					{
						strSql+=" and u.MASTERID='"+strMarketid+"' ";
					} 
					strSql+=" ) u  left  join   ( select  '' XF, '' KNH,'' HD,'' XSTGF, '' SCBTGF,''caseid,''YEAR,'' MONTH,sa.MARKETID,sa.USERORDER    from   N_MARKETANALYSIS  sa  where  sa.YEAR='2012'  and sa.MONTH='"+intMonth+"'    and  sa.caseid='"+strCaseID+"')  s  on  u.MASTERID=s.MARKETID  ";
			}
		}

		  return strSql;
	}
	

	/**
	 * 查询指定年份月份的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public List queryAllHistory(String strMarketid,HttpServletRequest request) {
  
		
		int intYear = publicDao.getCurrentDateYear(-12);//前九个月
		int intMonth = publicDao.getCurrentDateMonth(-12); 
		String strWhere="  and  (   ";
		for(int i=-12;i<0 	;i++)
		{
			intYear=publicDao.getCurrentDateYear(i);
			intMonth = publicDao.getCurrentDateMonth(i);
			if(i!=-12)
			{
				strWhere+="  or " ;
			}
			String	strCaseID = getCaseID(intYear,intMonth,  request);
			strWhere+="    (    h.YEAR='" + intYear + "'  and  h.MONTH='" + intMonth + "'  and  h.caseid='" + strCaseID + "' )  ";
		}
		strWhere+=")"; 

		String	strSql="select    h.*,u.*  from ";
		strSql+="(select  u.* "; 
		strSql+=" from   n_market_user  u    where  1=1 ";
		if(!"".equals(strMarketid)&&strMarketid!=null)
		{
			strSql+=" and u.MASTERID='"+strMarketid+"' ";
		} 
		strSql+=" ) u  left  join   N_MARKET_HISTORY  h  on  u.MASTERID=h.MARKETID  ";
		
		strSql+=strWhere;
		strSql+=" order by   CAST(  h.YEAR as int) asc, CAST(  h.MONTH as int) asc,CAST( u.MASTERID as int)  asc ";
		List listHis = sqlDao.queryListBySqlNoSession(strSql);

		return listHis;
	}

	/**
	 * 根据用户id 和代表id
	 * @param intYear
	 * @param intMonth
	 * @param strMarketid 医生介绍id 
	 * @param request
	 * @return
	 */ 
	private   String strGetHistorytList(int intYear,int intMonth,String strMarketid,HttpServletRequest request)
	{
		//String	strCaseID = getCaseID(intYear,intMonth,  request);		 

		String	strSql="select    h.*,u.*  from ";
		strSql+="(select  u.* "; 
		strSql+=" from   n_market_user  u    where  1=1 ";
		if(!"".equals(strMarketid)&&strMarketid!=null)
		{
			strSql+=" and u.MASTERID='"+strMarketid+"' ";
		} 
		strSql+=" ) u  left  join   N_MARKET_HISTORY  h  on  u.MASTERID=h.MARKETID  ";
		strSql += "   and h.YEAR='" + intYear + "'  and h.MONTH='" + intMonth + "'  ";
		//strSql += "  and  h.caseid='" + strCaseID + "'   ";
		return strSql;
	}
	
	public void  updateMarketSize()
	{
		
//		sqlDao.insertWithSql("	update  N_MARKET_USER set HZGM='39222245'  where  MARKETID='10004' ");
//		sqlDao.insertWithSql("		update  N_MARKET_USER set HZGM='35610000'  where  MARKETID='10001'  ");
//		sqlDao.insertWithSql("		update  N_MARKET_USER set HZGM='6151600'  where  MARKETID='10003'  ");
//		sqlDao.insertWithSql("		update  N_MARKET_USER set HZGM='9534645'  where  MARKETID='10002'  ");
//		sqlDao.insertWithSql("	update  N_MARKET_USER set HZGM='5324533'  where  MARKETID='10005'  ");
//		sqlDao.insertWithSql("	update  N_MARKET_USER set HZGM='3831936'  where  MARKETID='10006'  ");
	
		
	}
	/**
	 * 查询案例
	 * @return
	 * @throws Exception
	 */
	public List queryDclList(String sbSqlWhere,HttpServletRequest request) {  
 
//		String strSql = "select p.*  from   N_MARKETCASE  p  where 1=1   ";
//
//
//		strSql += "   and p.YEAR='" + intYear + "'  and p.MONTH='" + intMonth + "' and  (delStatus!='1' or delStatus is  null or delStatus='')   ";
//
//		Users userInfo=sqlDao.gerUserInfo( request);
//		strSql +=" and  userid='"+userInfo.getId()+"'   order  by  caseid desc  ";
		
		//月预测
		int preInt=3;
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
		
		StringBuffer sb=new StringBuffer();
		sb.append("select "+sbSqlWhere +"  from (");//,a.ZDCL,a.CASEID,a.userid,a.username 
		sb.append("select  (select u.username from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) username, s.caseid, ");
		sb.append("   (select c1.userid from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) userid, ");
		sb.append("  convert(numeric(12,1),round(SUM( CAST( s.XSYC_NEXT as float)) /isnull(SUM( CAST( s.COMPANYKPI as float)),10000000000)*100,1))ZDCL    ");
		sb.append("from     N_MARKETANALYSIS  s    where 1=1  and s.YEAR='"+intYear+"'  and s.MONTH='"+intMonth+"'     ");
		sb.append("  and  s.caseid  in(select c.CASEID from N_MARKETCASE c where c.CASETYPE='1' and c.YEAR='"+intYear+"'  and c.MONTH='"+intMonth+"'  and c.userid not in  ('10000','10002') )  ");
		sb.append(" and s.MARKETID  is not null     group by s.caseid ");
		sb.append(" )a");
		sb.append(" union all ");
		
		preInt=0;
		intYear=publicDao.getCurrentDateYear(preInt);
		intMonth = publicDao.getCurrentDateMonth(preInt);
		sb.append("select "+sbSqlWhere +"  from (");//,a.ZDCL,a.CASEID,a.userid,a.username 
		sb.append("select  (select u.username from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) username, s.caseid, ");
		sb.append("   (select c1.userid from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) userid, ");
		sb.append("  convert(numeric(12,1),round(SUM( CAST( s.result as float)) /isnull(SUM( CAST( s.COMPANYKPI as float)),10000000000)*100,1))ZDCL    ");
		sb.append("from     N_MARKETANALYSIS  s    where 1=1  and s.YEAR='"+intYear+"'  and s.MONTH='"+intMonth+"'     ");
		sb.append("  and  s.caseid  in(select c.CASEID from N_MARKETCASE c where c.CASETYPE='1' and c.YEAR='"+intYear+"'  and c.MONTH='"+intMonth+"'  and c.userid not in  ('10000','10002'))  ");
		sb.append(" and s.MARKETID  is not null     group by s.caseid ");
		sb.append(" )a");

		sb.append(" union all ");
		preInt=1;
		intYear=publicDao.getCurrentDateYear(preInt);
		intMonth = publicDao.getCurrentDateMonth(preInt);
		sb.append("select "+sbSqlWhere +"  from (");//,a.ZDCL,a.CASEID,a.userid,a.username 
		sb.append("select  (select u.username from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) username, s.caseid, ");
		sb.append("   (select c1.userid from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) userid, ");
		sb.append("  convert(numeric(12,1),round(SUM( CAST( s.result as float)) /isnull(SUM( CAST( s.COMPANYKPI as float)),10000000000)*100,1))ZDCL    ");
		sb.append("from     N_MARKETANALYSIS  s    where 1=1  and s.YEAR='"+intYear+"'  and s.MONTH='"+intMonth+"'     ");
		sb.append("  and  s.caseid  in(select c.CASEID from N_MARKETCASE c where c.CASETYPE='1' and c.YEAR='"+intYear+"'  and c.MONTH='"+intMonth+"' and c.userid not in  ('10000','10002') )  ");
		sb.append(" and s.MARKETID  is not null     group by s.caseid ");
		sb.append(" )a");

		sb.append(" union all ");
		preInt=2;
		intYear=publicDao.getCurrentDateYear(preInt);
		intMonth = publicDao.getCurrentDateMonth(preInt); 

		sb.append("select "+sbSqlWhere +"  from (");//,a.ZDCL,a.CASEID,a.userid,a.username 
		sb.append("select  (select u.username from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) username, s.caseid, ");
		sb.append("   (select c1.userid from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) userid, ");
		sb.append("  convert(numeric(12,1),round(SUM( CAST( s.result as float)) /isnull(SUM( CAST( s.COMPANYKPI as float)),10000000000)*100,1))ZDCL    ");
		sb.append("from     N_MARKETANALYSIS  s    where 1=1  and s.YEAR='"+intYear+"'  and s.MONTH='"+intMonth+"'     ");
		sb.append("  and  s.caseid  in(select c.CASEID from N_MARKETCASE c where c.CASETYPE='1' and c.YEAR='"+intYear+"'  and c.MONTH='"+intMonth+"' and c.userid not in  ('10000','10002') )  ");
		sb.append(" and s.MARKETID  is not null     group by s.caseid ");
		sb.append(" )a");
		List listM = sqlDao.queryListBySqlNoSession(sb.toString()); 
		return listM;
	}
	
		
	/**
	 * 表二：客户优先顺序排序
	 * @param preInt
	 * @param sbSqlWhere
	 * @param request
	 * @return
	 */
	public List queryOrderStatic(int preInt,String sbSqlWhere,HttpServletRequest request) {  

//		String strSql = "select p.*  from   N_MARKETCASE  p  where 1=1   ";
//
//
//		strSql += "   and p.YEAR='" + intYear + "'  and p.MONTH='" + intMonth + "' and  (delStatus!='1' or delStatus is  null or delStatus='')   ";
//
//		Users userInfo=sqlDao.gerUserInfo( request);
//		strSql +=" and  userid='"+userInfo.getId()+"'   order  by  caseid desc  ";
		
		//月预测
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
		
		StringBuffer sb=new StringBuffer();
		sb.append("  select    mu.NAME ,b.* from  N_MARKET_USER  mu,( ");//,a.ZDCL,a.CASEID,a.userid,a.username 
		sb.append("select "+sbSqlWhere +" ,a.MARKETID from (");//,a.ZDCL,a.CASEID,a.userid,a.username 
		sb.append("select   s.MARKETID  MARKETID ,(select u.username from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) username, s.caseid, ");
		sb.append("   (select c1.userid from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) userid, ");
		
		if(preInt==3)
		{
			 sb.append("  convert(numeric(12,1),round(SUM( CAST( s.XSYC_NEXT as float)) /isnull(SUM( CAST( s.COMPANYKPI as float)),10000000000)*100,1))ZDCL    ");
		
		}else
		{
			sb.append("  convert(numeric(12,1),round(SUM( CAST( s.result as float)) /isnull(SUM( CAST( s.COMPANYKPI as float)),10000000000)*100,1))ZDCL    ");
		}
		sb.append("from     N_MARKETANALYSIS  s    where 1=1  and s.YEAR='"+intYear+"'  and s.MONTH='"+intMonth+"'     ");
		sb.append("  and  s.caseid  in(select c.CASEID from N_MARKETCASE c where c.CASETYPE='1' and c.YEAR='"+intYear+"'  and c.MONTH='"+intMonth+"' and c.userid not in  ('10000','10002'))  ");
		sb.append(" and s.MARKETID  is not null     group by s.caseid,s.MARKETID ");
		sb.append(" )a    group by a.MARKETID   ");
		sb.append(" )b    where CAST(mu.MASTERID as varchar ) = b.MARKETID   order by b.MARKETID  ");
		
		List listM = sqlDao.queryListBySqlNoSession(sb.toString()); 
		return listM;
	}	
	
	public List queryYouStatic(int preInt,String  userId,HttpServletRequest request) {  
 
		//月预测
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
		
		StringBuffer sb=new StringBuffer();
	    String fileName="s.result";
		if(preInt==3)
		{
			fileName="s.XSYC_NEXT";
		
		} 
		  
		sb.append("  select   top 6 a.*   from (");
		sb.append(" 	 select s.MARKETID  MASTERID, s.USERORDER, s.PXHD LASTRESULT,( select  mu.NAME  from  N_MARKET_USER  mu where CAST(mu.MASTERID as varchar ) = s.MARKETID )MARKETID ,(select u.username from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) username");
		sb.append(" 		 , s.caseid,    (select c1.userid from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) userid, ");
		sb.append(" 		   convert(numeric(12,1),round( CAST( "+fileName+" as float) /isnull( CAST( s.COMPANYKPI as float),10000000000)*100,1))ZDCL");
		sb.append(" 	     ,row_number() OVER( ORDER BY  convert(numeric(12,1),round( CAST( "+fileName+" as float) / CAST( s.COMPANYKPI as float)*100,1))desc)ZDCL_NUm");  
		sb.append(" 	      from     N_MARKETANALYSIS  s    where 1=1  and s.YEAR='"+intYear+"'  and s.MONTH='"+intMonth+"'  ");   
		sb.append(" 	        and  s.caseid  in(select c.CASEID from N_MARKETCASE c where c.CASETYPE='1' and c.YEAR='"+intYear+"'  and c.MONTH='"+intMonth+"'   and  userid='"+userId+"' )  ");
		sb.append(" 	         and s.MARKETID  is not null      ");
				         
		sb.append(" 	         )a   where 1=1 order by       CAST(   USERORDER as int),CAST( MASTERID as int)   ");
		

//		 select    ( select  mu.NAME  from  N_MARKET_USER  mu where CAST(mu.MASTERID as varchar ) = s.MARKETID )MARKETID ,
		
//		row_number() OVER(PARTITION BY s.MARKETID ORDER BY 
//			    convert(numeric(12,1),round(SUM( CAST( s.XSYC_NEXT as float)) /SUM( CAST( s.COMPANYKPI as float))*100,1) ) desc)ZDCL_NUm
		List listM = sqlDao.queryListBySqlNoSession(sb.toString()); 
		return listM;
	}					

	public List querySingleStatic(int preInt,String userId,HttpServletRequest request) {  
 
		//月预测
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
		String strFild="XF_lv XF,KNH_LV KNH,HD_LV HD,XSTGF_LV XSTGF,SCBTGF_LV SCBTGF";
		
		StringBuffer sb=new StringBuffer();
	    String fileName="s.result";
		if(preInt==3)
		{
			fileName="s.XSYC_NEXT";
			strFild="XF,KNH,HD,XSTGF,SCBTGF ";
		} 
		  
		sb.append("  select    a.*   from (");
		sb.append(" 	 select   MARKETID id,PXHD LASTRESULT,"+strFild+" ,( select  mu.NAME  from  N_MARKET_USER  mu where CAST(mu.MASTERID as varchar ) = s.MARKETID )MARKETID ,(select u.username from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) username");
		sb.append(" 		 , s.caseid,    (select c1.userid from N_MARKETCASE c1,users u  where c1.userid=CAST( u.id as varchar ) and c1.caseid=s.caseid) userid, ");
		sb.append(" 		   convert(numeric(12,1),round( CAST( "+fileName+" as float) / CAST( s.COMPANYKPI as float)*100,1))ZDCL");
		sb.append(" 	     ,row_number() OVER( ORDER BY  convert(numeric(12,1),round( CAST( "+fileName+" as float) / CAST( s.COMPANYKPI as float)*100,1))desc)ZDCL_NUm");  
		sb.append(" 	      from     N_MARKETANALYSIS  s    where 1=1  and s.YEAR='"+intYear+"'  and s.MONTH='"+intMonth+"'  ");   
		sb.append(" 	        and  s.caseid  in(select c.CASEID from N_MARKETCASE c where c.CASETYPE='1' and c.YEAR='"+intYear+"'  and c.MONTH='"+intMonth+"'   and  userid='"+userId+"' )  ");
		sb.append(" 	         and s.MARKETID  is not null      ");
				         
		sb.append(" 	         )a   where 1=1 order by    id   ");
		

//		 select    ( select  mu.NAME  from  N_MARKET_USER  mu where CAST(mu.MASTERID as varchar ) = s.MARKETID )MARKETID ,
		
//		row_number() OVER(PARTITION BY s.MARKETID ORDER BY 
//			    convert(numeric(12,1),round(SUM( CAST( s.XSYC_NEXT as float)) /SUM( CAST( s.COMPANYKPI as float))*100,1) ) desc)ZDCL_NUm
		List listM = sqlDao.queryListBySqlNoSession(sb.toString()); 
		return listM;
	}					
	
	private HttpServletRequest Request = null;
	public void setServletRequest(HttpServletRequest Request) {
		this.Request = Request;
	}

}
