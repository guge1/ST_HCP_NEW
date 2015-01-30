package nMarket.actions;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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

@SuppressWarnings( { "serial", "unchecked" })
public class Market_sys extends ActionSupport implements ServletRequestAware {
 

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
	private String strCaseID = "10000";

	public String getStrCaseID() {
		return strCaseID;
	}

	public void setStrCaseID(String strCaseID) {
		this.strCaseID = "10000";
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


	/**
	 *   ��ȡҽԺǱ��
	 * @return
	 */
	public String editMarketSize()
	{
		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		
		
       String[]  fieldENames= publicSourceDAO.strZontTiFenxi;
		String filedHtml = getZongtiFenXiPageHtml(listSys, "MASTERID","masterid",
				fieldENames,"editMarketSize"); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}
	
	
	/**
	 * ����Ǳ��
	 * 
	 * @return
	 */
	public String saveMarketSize() {

//		int	intYear=publicDao.getCurrentDateYear(-1);
//		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
//		 List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
////		publicPageDAO.savePageValue(listSys,"N_MARKET_USER", "MASTERID","masterid",
////		publicSourceDAO.strMarketSize, request,0);
////		 publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid", publicSourceDAO.strZontTiFenxi, request,0);
//
//			String strSql = "select p.*  from   users  p    ";
//			//System.out.println(strSql);
//			//List listUser = sqlDao.queryListBySqlNoSession(strSql);
//			if(listSys!=null&&listSys.size()>0)
//			{ 
//				for(int i=0;i<listSys.size();i++)
//				{
//					String strUserID=	 publicPageDAO.GetFieldValue(listSys, "MASTERID", i);
//					String  HZGM=publicDao.NullToStr(request.getParameter("HZGM"+strUserID));
//					String strUpdateSql="update  N_MARKET_USER set HZGM='"+HZGM+"'  where  MARKETID='"+strUserID+"' ";
//					//System.out.println(strUpdateSql);
//					sqlDao.updateWithSql(strUpdateSql);
//				}
//			
//			}
		
		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		 publicPageDAO.savePageValue(listSys,"N_MARKET_USER", "MASTERID","MASTERID", publicSourceDAO.strZontTiFenxi, request,-1);
	
		request.setAttribute("message", "alert('����ɹ���');  window.location.href='editMarketSize.action';");
		return returnDfault;

	}
	

	/**
	 *   ��ȡҽԺ�����׼ֵ
	 * @return
	 */
	public String editBiaoZhun()
	{
		List listMarket =publicDateDAO.queryMarketList("");
       String[]  fieldENames= publicSourceDAO.strEditBiaoZhun;
		String filedHtml = getZongtiFenXiPageHtml(listMarket, "MASTERID","masterid",
				fieldENames,"editBiaoZhun"); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}
	
	
	/**
	 * ����ҽԺ�����׼ֵ
	 * 
	 * @return
	 */
	public String saveEditBiaoZhun() {
		List listMarket =publicDateDAO.queryMarketList("");
		publicPageDAO.savePageValue(listMarket,"N_MARKET_USER", "MASTERID","masterid",
		publicSourceDAO.strEditBiaoZhun, request,0);
		request.setAttribute("message", "alert('����ɹ���');  window.location.href='editBiaoZhun.action';");
		return returnDfault;

	}
	
	
	/**
	 *   ��ȡ����Ŀ�����
	 * @return
	 */
	public String editHostory()
	{ 

		int intYear_now = publicDao.getCurrentDateYear(0);
		int intMont_now = publicDao.getCurrentDateMonth(0);
		//��ѯ����
		int intYear_s =publicDao.NullToNumber(  request.getParameter("intYear"));
		int intMonth_s =publicDao.NullToNumber(  request.getParameter("intMonth"));
		String strType =publicDao.NullToStr( request.getParameter("type"));//1 ��ʱ������Ч����ʷ����
		if(intYear_s!=0)
		{
			intYear_now=intYear_s;
		}
		if( intMonth_s!=0)
		{
			intMont_now=intMonth_s;
		}
		//List listSys =publicDateDAO.querySysList(intYear_now,intMont_now,request);
		// List listSys=publicDateDAO.querySysLists("",request); 
       String[]  fieldENames= publicSourceDAO.strEditHistory;
       if("1".equals(strType))
       {//��Ч�Ե���ʷ����
    	   fieldENames=publicSourceDAO.youXiaoXing_person;
       }
		String filedHtml = getEditHistoryPageHtml(  "RESOURCEID","MASTERID,year,month", fieldENames,strType); 
		//List listSys =publicDateDAO.querySysList(request); 

		int	intYear=publicDao.getCurrentDateYear(-1);
		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
	    //List hisList=	publicDateDAO.queryAllHistory("",request);
		
		List listSys =publicDateDAO.querySysList_1(intYear,intMonth,request);
		 String[]  TARGET= { "TARGET,����Ԥ��", "NTS_ALL,�����ܽ��"};
		 if(!"1".equals(strType))
	       {//��Ч�Ե���ʷ����
	       
	       }
		     getEditHistoryPageHtml_Target(listSys, "RESOURCEID","MASTERID",TARGET); 
	      
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}
	private void saveOrder(List listSys) {
		
		   
	}
	/**
	 * �������Ŀ�����
	 * 
	 * @return
	 */
	public String saveEditHostory() {

		int intYear_now = publicDao.getCurrentDateYear(0);
		int intMont_now = publicDao.getCurrentDateMonth(0);
		//��ѯ����
		int intYear_s =publicDao.NullToNumber(  request.getParameter("intYear"));
		int intMonth_s =publicDao.NullToNumber(  request.getParameter("intMonth"));
		if(intYear_s!=0)
		{
			intYear_now=intYear_s;
		}
		if( intMonth_s!=0)
		{
			intMont_now=intMonth_s;
		}
		
		
		String strType =publicDao.NullToStr( request.getParameter("type"));//1 ��ʱ������Ч����ʷ����
		//List listSys =publicDateDAO.querySysList(intYear_now,intMont_now,request);
		
		String[]  fieldENames= publicSourceDAO.strEditHistory_Save;
       if("1".equals(strType))
       {//��Ч�Ե���ʷ����
    	   fieldENames=publicSourceDAO.youXiaoXing_person;
       }
       String strSql = "select p.*  from   N_MARKET_USER  p  order by  MASTERID   ";
		//System.out.println(strSql);
		List listUser = sqlDao.queryListBySqlNoSession(strSql);
		if(listUser!=null&&listUser.size()>0)
		{ 
			for(int i=0;i<listUser.size();i++)
			{
				String strUserID=	 publicPageDAO.GetFieldValue(listUser, "MASTERID", i);
				 //List listSys=publicDateDAO.querySysLists_user(strUserID,request); 
					int m=-12;
					 if("1".equals(strType))
				       {//��Ч�Ե���ʷ����
						   m=-3;
				       }
					for(int n=m;n<0;n++)
					{
						//sbHead.append("<tr   class=\"tableHead\">");
						//sbHead.append("<td> &nbsp;&nbsp;</td>");
						int	intYear=publicDao.getCurrentDateYear(n);

						request.setAttribute("intYear", intYear);//��ǰ���
						int	intMonth = publicDao.getCurrentDateMonth(n);
						List rsList=publicDateDAO.queryHisList(  intYear,  intMonth,strUserID,  request) ;
						
							if (rsList != null && rsList.size() > 0) 
							{//������
								//publicPageDAO.savePageValue(rsList,"N_MARKETANALYSIS", "RESOURCEID","MARKETID,year,month",
										//fieldENames, request,n);
								publicPageDAO.savePageValue(rsList,"N_MARKET_HIS", "HISID","MARKETID,year,month",
										fieldENames, request,0);
							}
							
					}
//				publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","MARKETID,year,month",
//						fieldENames, request,0);
			}
		
		}
		if(!"1".equals(strType))
	    {//����ʷ����
			//����Ԥ��Ŀ��
			List listSys_now =publicDateDAO.querySysList(request); 
			 String[]  TARGET= { "TARGET,����Ԥ��","ACH_ALL,����ָ������", "NTS_ALL,�����ܽ��"};
			publicPageDAO.savePageValue(listSys_now,"N_MARKET_USER", "MASTERID","MASTERID", TARGET, request,0);
			  //  request.setAttribute("message", " alert('����ɹ���');  window.location.href='editHostory.action';");//?intYear="+intYear_now+"&intMonth="+intMont_now+"
	     }
		  request.setAttribute("message", " alert('����ɹ���');  window.location.href='editHostory.action?type="+strType+"';");//?intYear="+intYear_now+"&intMonth="+intMont_now+"
			
		return returnDfault;

	}

	/**
	 *   ��ȡ�������
	 * @return
	 */
	public String queryZongTi_FenXi()
	{

		int	intYear=publicDao.getCurrentDateYear(0);
		int	intMonth = publicDao.getCurrentDateMonth(0);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
        String[]  fieldENames= publicSourceDAO.strZontTiFenxi;
		String filedHtml = getZongtiFenXiPageHtml(listSys, "RESOURCEID","masterid",
				fieldENames,"queryZongTi_FenXi"); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}
	
	
	/**
	 * �����������
	 * 
	 * @return
	 */
	public String saveZongTi_FenXi() {
		//List listSys = publicDateDAO.querySysList(request);
		int	intYear=publicDao.getCurrentDateYear(0);
		int	intMonth = publicDao.getCurrentDateMonth(0);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		//publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid", publicSourceDAO.strZontTiFenxi, request,0);
		request.setAttribute("message", "alert('����ɹ���');  window.location.href='queryQianLi_FenXi.action';");
		return returnDfault;

	}
	/**
	 *   ��ȡ�����Է���
	 * @return
	 */
	public String queryJieGuo_FenXi()
	{
		List listSys = publicDateDAO.querySysList(request);
       String[]  fieldENames= publicSourceDAO.strJieGuoFenxi;
		String filedHtml = getJieGuoFenXiPageHtml(listSys, "RESOURCEID","masterid",
				fieldENames); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}

	/**
	 * ���������Է���
	 * 
	 * @return
	 */
	public String saveJieGuo_FenXi() {
		List listSys = publicDateDAO.querySysList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.strJieGuoFenxi, request,0);
		request.setAttribute("message", "  alert('����ɹ���');  window.location.href='queryYouXiaoXing_FenXi.action'");
		return returnDfault;

	}


	/**
	 *   ��ȡǱ������
	 * @return
	 */
	public String queryQianLi_FenXi()
	{
		List listSys = publicDateDAO.querySysList(request);
       String[]  fieldENames= publicSourceDAO.strQianLiFenxi;
		String filedHtml = getJieGuoFenXiPageHtml(listSys, "RESOURCEID","masterid",
				fieldENames); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}

	/**
	 * ����Ǳ������
	 * 
	 * @return
	 */
	public String saveQianLi_FenXi() {
		List listSys = publicDateDAO.querySysList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.strQianLiFenxi, request,0);
		request.setAttribute("message", " alert('����ɹ���');  window.location.href='queryJieGuo_FenXi.action';");
		return returnDfault;

	}


	/**
	 *   ��ȡ��Ч�Է���
	 * @return
	 */
	public String queryYouXiaoXing_FenXi()
	{
		List listSys = publicDateDAO.querySysList(request);
       String[]  fieldENames= publicSourceDAO.strYouXiaoXingFenxi;
		String filedHtml = getJieGuoFenXiPageHtml(listSys, "RESOURCEID","masterid",
				fieldENames); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}

	/**
	 * ������Ч�Է���
	 * 
	 * @return
	 */
	public String saveYouXiaoXing_FenXi() {
		List listSys = publicDateDAO.querySysList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.strYouXiaoXingFenxi, request,0); 
		request.setAttribute("message", " alert('����ɹ���');  window.location.href='queryChanChu_MuBiao.action';");
		return returnDfault;

	}


	/**
	 *   ��ȡ����Ŀ�����
	 * @return
	 */
	public String queryChanChu_MuBiao()
	{
		List listSys = publicDateDAO.querySysList(request);
       String[]  fieldENames= publicSourceDAO.strChanChu_MuBiao;
		String filedHtml = getChanChuMuBiaoPageHtml(listSys, "RESOURCEID","masterid",
				fieldENames); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}

	/**
	 * �������Ŀ�����
	 * 
	 * @return
	 */
	public String saveChanChu_MuBiao() {
		List listSys = publicDateDAO.querySysList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.strChanChu_MuBiao_Save, request,0);

		///HttpServletResponse response = ServletActionContext.getResponse();
		//publicDao.responseMessage(response, "  window.close(); ");
		request.setAttribute("message", " alert('����ɹ���');  window.location.href='queryTouRu_MuBiao.action';");
		return returnDfault;

	}

	/**
	 *   ��ȡͶ��Ŀ�����
	 * @return
	 */
	public  String queryTouRu_MuBiao()
	{
		List listSys = publicDateDAO.querySysList(request);
       String[]  fieldENames= publicSourceDAO.strTouRuMuBiao;
		String filedHtml = getTouRuMuBiaoPageHtml(listSys, "RESOURCEID","masterid", fieldENames); 

//		int	intYear=publicDao.getCurrentDateYear(-1);
//		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
//		List listSys_Pre =publicDateDAO.querySysList(intYear,intMonth,request);
		setMarketPageHtml(listSys,"touru"); 
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}

	/**
	 * ����Ͷ�����
	 * 
	 * @return
	 */
	public String saveTouRu_MuBiao() {
		List listSys = publicDateDAO.querySysList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.strTouRuMuBiao, request,0); 
		request.setAttribute("message", "  alert('����ɹ���');  window.location.href='queryZiYuan_FenPei.action';");
		return returnDfault;
	}
	/**
	 *   ��ȡ��Դ����
	 * @return
	 */
	public String queryZiYuan_FenPei()
	{
		List listSys = publicDateDAO.querySysList(request);
       String[]  fieldENames= publicSourceDAO.strZiYuan_FenPei;
		String filedHtml = getZiYuanFenPeiPageHtml_new(listSys, "RESOURCEID","masterid",
				fieldENames); 
 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml); 
		int preInt=0; 
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
 
	 
		publicDateDAO.quryCaseInfoByID(intYear,intMonth,"",request);//��ȡ��Ŀ��Ϣ
		
		return returnDfault;
	}
	
	
	/**
	 * ������Դ����
	 * 
	 * @return
	 */
	public String saveZiYuan_FenPei() {
		List listSys = publicDateDAO.querySysList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.strZiYuan_FenPei_Save, request,0);
		int intYear = publicDao.getCurrentDateYear(0);
		int intMonth = publicDao.getCurrentDateMonth(0);
//		publicDateDAO.updateCaseStatus(intYear, intMonth, "", request);
		updateBiaoZhun(  intYear,  intMonth,  request);//�������
		request.setAttribute("message", "alert('����ɹ���');  window.location.href='queryXingDong_JiHua.action';");
		return returnDfault;

	}
	/**
	 *   ��ȡ�ж��ƻ�
	 * @return
	 */
	public String queryXingDong_JiHua()
	{
		List listSys = publicDateDAO.querySysList(request);
       String[]  fieldENames= publicSourceDAO.XingDong_JiHua;
		String filedHtml = getXingDongJiHuaPageHtml(listSys, "RESOURCEID","masterid", fieldENames); 
//
//		int	intYear=publicDao.getCurrentDateYear(-1);
//		int	intMonth = publicDao.getCurrentDateMonth(-1);//2011-12
//		List listSys_pre =publicDateDAO.querySysList(intYear,intMonth,request);
		setMarketPageHtml(listSys,"xingdongjihua"); 
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}

	/**
	 * �����ж��ƻ�
	 * 
	 * @return
	 */
	public String saveXingDong_JiHua() {
		List listSys = publicDateDAO.querySysList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.XingDong_JiHua_Save, request,0); 
		request.setAttribute("message", "alert('����ɹ���');  window.location.href='queryMonth_YuCe.action';");
		return returnDfault;
	}

	/**
	 *   ��ȡ�·�Ԥ�����
	 * @return
	 */
	public String queryMonth_YuCe()
	{
		List listSys = publicDateDAO.querySysList(request);
       String[]  fieldENames= publicSourceDAO.strMonth_YuCe;
		String filedHtml = getMonth_YuCePageHtml(listSys, "RESOURCEID","masterid", fieldENames); 
		//setMarketPageHtml(listSys,"xingdongjihua"); 
		request.setAttribute("filedHtml", filedHtml);
		return returnDfault;
	}

	/**
	 * �����·�Ԥ��
	 * 
	 * @return
	 */
	public String saveMonth_YuCe() {
		List listSys = publicDateDAO.querySysList(request);
		String StrSaveYuCe[]={"RESULT"};
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
				StrSaveYuCe, request,0); 
		request.setAttribute("message", "alert('����ɹ���');  window.location.href='queryYueFen_JianKong.action';");
		return returnDfault;
	}


	/**
	 *   ��ȡ�·ݼ��
	 * @return
	 */
	public String queryYueFen_JianKong()
	{ 
		List listSys = publicDateDAO.queryNextSysList(request);
       String[]  fieldENames= publicSourceDAO.strYue_JianKong;
		String filedHtml = getYueJianKongPageHtml(listSys, "RESOURCEID","masterid",
				fieldENames); 
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		
	    String JianKongJieGuo=	getJianKongJieGuoPageHtml(  listSys, "RESOURCEID", "masterid",false);

		int preInt=1;
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
 

		publicDateDAO.quryCaseInfoByID(intYear,intMonth,"",request);//��ȡ��Ŀ��Ϣ
	    request.setAttribute("JianKongJieGuo", JianKongJieGuo);
	    
		return returnDfault;
	}

	/**
	 * �����ȡ�·ݼ��
	 * 
	 * @return
	 */
	public String saveYueFen_JianKong() {
		List listSys = publicDateDAO.queryNextSysList(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.strYue_JianKong_save, request,1);

		int intYear = publicDao.getCurrentDateYear(1);
		int intMonth = publicDao.getCurrentDateMonth(1);
		publicDateDAO.updateCaseStatus(intYear, intMonth, "", request);
		///HttpServletResponse response = ServletActionContext.getResponse();
		//publicDao.responseMessage(response, "  window.close(); ");
		request.setAttribute("message", " alert('����ɹ���');  window.location.href='queryNextYueFen_JianKong.action?type=1';");
		return returnDfault;

	}

	/**
	 *   ��ȡ�����·ݼ��
	 * @return
	 */
	public String queryNextYueFen_JianKong()
	{
		List listSys = publicDateDAO.queryNextSysList_1(request);
       String[]  fieldENames= publicSourceDAO.strYue_JianKong;
		String filedHtml = getYueJianKongPageHtml(listSys, "RESOURCEID","masterid",
				fieldENames); 
		
		request.setAttribute("fieldENames", fieldENames.toString());
		request.setAttribute("filedHtml", filedHtml);
		

	    String JianKongJieGuo=	getJianKongJieGuoPageHtml(  listSys, "RESOURCEID", "masterid",true);
	    
	    request.setAttribute("JianKongJieGuo", JianKongJieGuo);
	   
	    int preInt=2;
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
 
		publicDateDAO.quryCaseInfoByID(intYear,intMonth,"",request);//��ȡ��Ŀ��Ϣ
		return returnDfault;
	}

	/**
	 * �����ȡ�����·ݼ��
	 * 
	 * @return
	 */
	public String saveNextYueFen_JianKong() {
		List listSys = publicDateDAO.queryNextSysList_1(request);
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
		publicSourceDAO.strYue_JianKong_save, request,2);

		int intYear = publicDao.getCurrentDateYear(2);
		int intMonth = publicDao.getCurrentDateMonth(2);
		publicDateDAO.updateCaseStatus(intYear, intMonth, "", request);
		///HttpServletResponse response = ServletActionContext.getResponse();
		//publicDao.responseMessage(response, "  window.close(); ");
		request.setAttribute("message", " alert('����ɹ���лл��');  window.location.href='queryNextYueFen_JianKong.action?type=1';");
		return returnDfault;

	}

	/**
	 *   ��ȡ�·�Ԥ�� ---�ܵ�
	 * @return
	 */
	public String queryYue_YuCe()
	{
		//queryMonth_YuCe();
		int preInt=3;
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		//List listSys = publicDateDAO.querySysList(request);

	        
		String filedHtml = getMonth_YuCePageHtml(listSys, "RESOURCEID","masterid", publicSourceDAO.strYue_YuCe_1); 
		//setMarketPageHtml(listSys,"xingdongjihua"); 
		request.setAttribute("filedHtml", filedHtml);
		
		
        String[]  fieldENames= publicSourceDAO.strYue_YuCe;
		String filedHtml_1 = getYue_YuCePageHtml(listSys, "RESOURCEID","masterid", fieldENames); 
		setMarketPageHtml(listSys,"xingdongjihua"); 
		request.setAttribute("filedHtml_1", filedHtml_1);
		publicDateDAO.quryCaseInfoByID(intYear,intMonth,"",request);//��ȡ��Ŀ��Ϣ
		
		return returnDfault;
	}

	/**
	 * �����·�Ԥ��
	 * 
	 * @return
	 */
	public String saveYue_YuCe() {
		int preInt=3;
		int	intYear=publicDao.getCurrentDateYear(preInt);
		int	intMonth = publicDao.getCurrentDateMonth(preInt);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
		//List listSys = publicDateDAO.querySysList(request);
		 
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
				publicSourceDAO.strYue_YuCe_save, request,preInt); 

		publicDateDAO.updateCaseStatus(intYear, intMonth, "", request);
		request.setAttribute("message", "  window.location.href='queryYue_YuCe.action';");
		return returnDfault;
	}
	
	
	public  String getUrl()
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
	/**
	 * ��װ��ʷ��������ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getEditHistoryPageHtml( String strPKField, String strParamField,String[]  strResource,String strType) {
		StringBuilder sb = new StringBuilder(); 
//		StringBuilder sbHead = new StringBuilder(); 
//		StringBuilder sbAll= new StringBuilder(); 
		//boolean isRead=true;

//		sbAll.append("<tr   class=\"tableHead\">");
//		sbAll.append("<td> &nbsp;&nbsp;</td>");

//		Double  countResult=0D;
		Map mapCountResult =new HashMap();
		int m=-12;
		 if("1".equals(strType))
	       {//��Ч�Ե���ʷ����
			   m=-3;
	       }
		for(int n=m;n<0;n++)
		{
			//sbHead.append("<tr   class=\"tableHead\">");
			//sbHead.append("<td> &nbsp;&nbsp;</td>");
			int	intYear=publicDao.getCurrentDateYear(n);

			request.setAttribute("intYear", intYear);//��ǰ���
			int	intMonth = publicDao.getCurrentDateMonth(n);
			List rsList=publicDateDAO.queryHisList(  intYear,  intMonth,"",  request) ;
			
				if (rsList != null && rsList.size() > 0) 
				{//������
					 sb.append(" <tr style=\"height:30px;color:black;background-color: #F3FFE3;text-algin:left;\"><td >"+intYear+"-"+intMonth+"</td><td colspan=\""+rsList.size()+"\"></td></tr>");
// 				sb.append(" <tr style=\"height:300px;width:100%\"><td> <fieldset class=\"tdLegendFieldset\"> ");
// 				    sb.append("	<legend class=\"Legend_Style\">"+intYear+"-"+intMonth+"</legend><table style=\"width: 100%; margin-top: auto; margin-left: auto;   \">");
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
								String strHeight="  style=\"height: 33px;line-height: 33px; \"  ";

								
								if("HZGM".equals(strFieldName))
								{
									strHeight="  style=\"height: 60px; line-height: 60px;\"  ";
								}
								if("ACH".equals(strFieldName)||"XSZZ".equals(strFieldName))
								{
									strHeight="  style=\"height: 48px; line-height: 48px;\"  ";
								}
								 
								if(i>3)
								{
		
									strHeight="  style=\"height: 30px; line-height: 30px;\"  ";
								}
								sb.append("<tr class=\"trMoveRow\" "+strHeight+" >");
//								String strYear="",strMonth="";
//								String strYear_1="",strMonth_1="";
								for (int j = 0; j < rsList.size(); j++) 
								{
									String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
									mapCountResult.put(strPKID, publicDao.NullToDouble(mapCountResult.get(strPKID))+  publicDao.NullToDouble( publicPageDAO.GetFieldValue(rsList, "RESULT", j)));
									String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
									String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
//									strYear=publicPageDAO.GetFieldValue(rsList, "YEAR", j);
//									strMonth= publicPageDAO.GetFieldValue(rsList, "MONTH", j);
//								 if(strMonth_1.equals(strMonth)&&!"".equals(strMonth_1))
//								 {// ������
//	//								 n=0;
//		//							 sb.append("</tr>");
//		//							 sb.append("<tr    class=\"trMoveRow\" >");
//		//								sb.append("<td> &nbsp;&nbsp;</td>");
//								 }
//								 strMonth_1=strMonth;
								 String strParamID="";
								    for (int k = 0; k < strParamField.split(",").length; k++)
									{
									   String strParam =publicPageDAO.NullToStr(strParamField.split(",")[k]);
									   String strVs=publicPageDAO.GetFieldValue(rsList, strParam, j);
									   if("year".equals(strParam))
									   {
										   strVs=intYear+"";
									   }
									   if("month".equals(strParam))
									   {
										   strVs=intMonth+"";
										   
									   }
										strParamID=strParamID+strVs;
									    
									}  
									//String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);//+strYear+strMonth
									String strValue=  publicPageDAO.GetFieldValue(rsList, strFieldName, j);
									String COMPANYKPI=  publicPageDAO.GetFieldValue(rsList, "COMPANYKPI", j);
									if(j==0)
									{
										sb.append("<td  class=\"tdFieldLable\">"+strFieldCName);
									   // sb.append("<input type=\"hidden\"  name =\""+ strPKField+strParamID + "\"   id =\""+ strPKField+strParamID + "\"   value=\""+ strPKID + "\" />");
										sb.append("</td>");
									}
//									if(i==0&&n==-12)
//									{
//									   sbHead.append("<td  style=\"text-align: left;cursor: hand;\" >"+strUserName);
//									   sbHead.append(" </td>");
//									  
////									   sbAll.append("<td  style=\"text-align: left;cursor: hand;\" >");
////									   sbAll.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 60px\"  name =\"TARGET"
////												+ publicPageDAO.GetFieldValue(rsList, strParamField, j)+ "\"   id =\"TARGET"
////												+ publicPageDAO.GetFieldValue(rsList, strParamField, j)+ "\"   value=\""
////												+ strValue + "\"  onmounthdown=\"onmousedown(this);\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���')\"/>"); 
////										
////									   sbAll.append(" </td>");
//									}
		//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
									if("XSZZ".equals(strFieldName))
									{
										if("".equals(strValue))
										{
											strValue=COMPANYKPI;
										}
//									   sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 60px\"  name =\""
//										+ strFieldName+strParamID + "\"   id =\""
//										+ strFieldName+strParamID + "\"   value=\""
//										+ strValue + "\"  onmounthdown=\"onmousedown(this);\"   onblur=\"checkIsNum_All(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���')\"/>"); 
									} 
									else
									{}
									String strMothed_New="";
									if("ACH".equals(strFieldName)||"XSZZ".equals(strFieldName)||"NTS".equals(strFieldName))
									{
										String strParam =publicPageDAO.NullToStr("masterid");
										strHeight="  style=\"height: 48px; line-height: 48px;\"  ";
										strParam=publicPageDAO.GetFieldValue(rsList, strParam, j);
										strMothed_New=" setAllVs('"+strParam+"') ;";
									}
									 
									String strMothed="";
									if("RESULT".equals(strFieldName))
									{
										strMothed="  setResult('"+ publicPageDAO.GetFieldValue(rsList, "masterid", j)+"');  ";
									}
									if("XSZZ".equals(strFieldName))
									{
										strMothed="checkIsNum_All(this);";
										sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 60px\"  name =\""
												+ strFieldName+strParamID + "\"   id =\""
												+ strFieldName+strParamID + "\"   value=\""
												+ strValue + "\"  onmounthdown=\"onmousedown(this);\"   onblur=\""+strMothed_New+""+strMothed+"stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���')\"/>"); 
										
									}else
									{
										sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 60px\"  name =\""
												+ strFieldName+strParamID + "\"   id =\""
												+ strFieldName+strParamID + "\"   value=\""
												+ strValue + "\"  onmounthdown=\"onmousedown(this);\"   onblur=\""+strMothed_New+strMothed+"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���')\"/>"); 
									}
									
										if("ACH".equals(strFieldName)||"ACH_ALL".equals(strFieldName)||"ABFGL".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName))
									{
										sb.append("%");
									}
										if("RESULT".equals(strFieldName)){
										  sb.append("<div style=\"display:none;\">");
											sb.append("<input  name =\"XSYC_NEXT" + strParamID  + "\"   id =\"XSYC_NEXT" +strParamID  + "\"   value=\"" +publicPageDAO.GetFieldValue(rsList, "XSYC_NEXT", j)+ "\"  /></div>");
										}
								sb.append("</td>");
							}
								sb.append("</tr>  ");
						}
					} 	
//					 sb.append("</table> </fieldset> </td> </tr>");	
					 if(n==-12)
					 {
						// sb.append(	 sbHead.toString()); 
					 }
				} 
		}
		request.setAttribute("mapCountResult", mapCountResult);//����1-12 ���ܺ�
//		sbHead.append("</tr>  ");
		//request.setAttribute("headRow", sbHead.toString());//ͷ��
		return  sb.toString();
	}
	

	/**
	 * ��װ�������ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String  getEditHistoryPageHtml_Target(List rsList, String strPKField, String strParamField,String[]  strResource) {
			StringBuilder sb = new StringBuilder(); 
			StringBuilder sbHead = new StringBuilder(); 
			boolean isRead=true;
			String strQuYu="";
			Map mapCountResult =new HashMap();
			mapCountResult=(Map)	(request.getAttribute("mapCountResult")==null?new HashMap() :request.getAttribute("mapCountResult"));//����1-12 ���ܺ�
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
							 
							sb.append("<tr class=\"trMoveRow\"   >");
							for (int j = 0; j < rsList.size(); j++) 
							{
								String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
								String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
								String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
								String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
								String strValue=  publicPageDAO.GetFieldValue(rsList, strFieldName, j);
								if(j==0)
								{
									sb.append("<td  class=\"tdFieldLable\">"+strFieldCName);
								  
									sb.append("</td>");
								}
								if(i==0)
								{ 
									  strQuYu+=strParamID+",";
									  sbHead.append("<td  style=\"text-align: left;cursor: hand;\" ><a  href=\"#\" onclick=\"javascript:g_OpenModalReturnWindow('"+getUrl()+"getMarketInfo.action?PKID="+strParamID+"&userName="+strUserName+"',860,560);\"><span class=\"span_style1\"> "+strUserName+"</span></a>");
									  sb.append("<div style=\"display:none;\">");
										sb.append("<input  name =\"NTS" + strParamID + "\"   id =\"NTS" +strParamID + "\"   value=\"" +publicDao.NullToDouble( mapCountResult.get(strPKID) )+ "\"  /></div>");
										

									  sbHead.append(" </td>");
								}
//							 
								String	strStatus=" readonly=\"readonly\" style=\"background-color: #C3CCDB\" ";
									sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 60px\"  name =\""
											+ strFieldName+strParamID + "\"   id =\""
											+ strFieldName+strParamID + "\"   value=\""
											+ strValue + "\" "+strStatus+" onmounthdown=\"onmousedown(this);\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���')\"/>"); 
									if("ACH".equals(strFieldName)||"ACH_ALL".equals(strFieldName)||"ABFGL".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName))
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
			request.setAttribute("quYuDaiBiao", strQuYu);
		    request.setAttribute("headRow", sbHead.toString()+sb.toString());//ͷ��
			return  sb.toString();
		}
	/**
	 * ��װ�������ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getZongtiFenXiPageHtml(List rsList, String strPKField, String strParamField,String[]  strResource,String strType) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		boolean isRead=true;
		String	strStatus="";
		if("queryZongTi_FenXi".equals(strType))
		{//��������� ֻ��

			 strStatus=" readonly=\"readonly\" style=\"background-color: #C3CCDB\" ";
		}
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
						String strHeight="  style=\"height: 33px;line-height: 33px; \"  ";
						
						
//						if("KNH".equals(strFieldName))
//						{
//							strHeight="  style=\"height: 115px; line-height: 115px;\"  ";
//						}
//						if("HZGM".equals(strFieldName))
//						{
//							strHeight="  style=\"height: 115px; line-height: 115px;\"  ";
//						} 
//						if("XSGN".equals(strFieldName))
//						{
//							strHeight="  style=\"height: 115px; line-height: 115px;\"  ";
//						} 

						if(i>2)
						{}
 
						
						sb.append("<tr class=\"trMoveRow\" "+strHeight+" >");
						for (int j = 0; j < rsList.size(); j++) 
						{
							String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
							String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
							String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
							String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
							String strValue=  publicPageDAO.GetFieldValue(rsList, strFieldName, j);
							if(j==0)
							{
								sb.append("<td  class=\"tdFieldLable\">"+strFieldCName); 
								sb.append("</td>");
							}
							if(i==0)
							{
							   sbHead.append("<td  style=\"text-align: left;cursor: hand;\" ><a  href=\"#\" onclick=\"javascript:g_OpenModalReturnWindow('"+getUrl()+"getMarketInfo.action?PKID="+strParamID+"&userName="+strUserName+"',640,460);\"> <span class=\"span_style1\">"+strUserName+"</span></a>");
							    sbHead.append(" </td>");
							}
//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
							if("XSZZ".equals(strFieldName))
							{
							   sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 70px\"  name =\""
								+ strFieldName+strParamID + "\"   id =\""
								+ strFieldName+strParamID + "\"  "+strStatus+"   value=\""
								+ strValue + "\"  onmounthdown=\"onmousedown(this);\"   onblur=\"checkIsNum_All(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���')\"/>"); 
							}else  if("ABFGL".equals(strFieldName))
							{
								
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 70px\"  name =\""
										+ strFieldName+strParamID + "\"  "+strStatus+"   id =\""
										+ strFieldName+strParamID + "\"   value=\""
										+ strValue + "\"  onmounthdown=\"onmousedown(this);\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���')\"/>"); 
							}
							else
							{
								String strOnclick="";
								if("KNH".equals(strFieldName))
								{
									strOnclick="checkIntegerMaxMin(this,100,0 ,'ʵ�ع��������ı�ֵ');";	
								}
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 70px\"  name =\""
										+ strFieldName+strParamID + "\"  "+strStatus+"  id =\""
										+ strFieldName+strParamID + "\"   value=\""
										+ strValue + "\"  onmounthdown=\"onmousedown(this);\"   onblur=\"checkIsNum(this);"+strOnclick+"stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���')\"/>"); 
								
							}
							if("ACH".equals(strFieldName)||"ACH_ALL".equals(strFieldName)||"ABFGL".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName)||"KNH".equals(strFieldName))
							{
								//sb.append("%");
							}
						sb.append("</td>");
					}
						sb.append("</tr>  ");
				}
			}
				sbHead.append("</tr>  ");
		} 
		request.setAttribute("headRow", sbHead.toString());//ͷ��
		return  sb.toString();
	}
	public   void main(String args[])
	{
	 String ss=  queryTouRu_MuBiao();
	}
	/**
	 * ��װҽԺ�л���ǩ����
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String setMarketPageHtml(List rsList,String strType) {
		StringBuilder sb = new StringBuilder(); //ҽԺ����
		StringBuilder sbUserInfo = new StringBuilder(); //ҽԺ��Ϣ
		List  paraList=	publicDateDAO.queryParaList(request);
		if (rsList != null && rsList.size() > 0) 
		{//������ 
			 
			for (int j = 0; j < rsList.size(); j++) 
			{ 
		     	String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j); 
		     	String strMASTERID=	publicPageDAO.GetFieldValue(rsList, "MASTERID", j); 
				String strStatus=" ";
				String strImg="tabbg_on0.gif";
				if(j!=0)
				{
					strStatus="style=\"  display:none;\"";
					 strImg="tabbg_off0.gif";
				}else
				{
					request.setAttribute("firstMarketid", strMASTERID);
					request.setAttribute("countUser", rsList.size());
					
				} 
				sb.append(" <td id=\"001_"+strMASTERID+"\" title=\"\" style=\"width: 100px; height: 22px; background-image: url("+request.getContextPath()+"/jsp/Market/bar/"+strImg+");");
				sb.append("  font-size: 12px; text-align: center; cursor: pointer;\" onclick=\"__ChangeTab('001','0',"+rsList.size()+",'"+strMASTERID+"','text','',0)\">");
				sb.append(strUserName+"</td> ");   
				
				 sbUserInfo.append("<div id=\"Tab_001_"+strMASTERID+"\"  "+strStatus+">");
				 sbUserInfo.append("<fieldset class=\"tdLegendFieldset\" style=\"margin-left: 10px; margin-right: 10px; width: 800px;\">");
				 sbUserInfo.append("	<legend class=\"Legend_Style\" style=\"\"></legend>");
				 sbUserInfo.append("<table class=\"tbDragTable\" style=\"margin-top: 0px; margin-left: 0px;   background-color: #CFE8E2; width:100%;");
				 sbUserInfo.append("              \" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
				 sbUserInfo.append("    <colgroup>");
				 sbUserInfo.append("        <col width=\"130px\" />");
				 sbUserInfo.append("        <col width=\"130px\" />");
				 sbUserInfo.append("        <col width=\"130px\" />");
				 sbUserInfo.append("        <col width=\"130px\" />");
				 sbUserInfo.append("        <col width=\"130px\" />");
				 sbUserInfo.append("        <col width=\"130px\" />");
				 sbUserInfo.append("        <col width=\"130px\" />");
				 sbUserInfo.append("    </colgroup>");
				 sbUserInfo.append("    <tr   style=\"height: 20px;\">");
				 sbUserInfo.append("        <td style=\"display:none;\">");
				 sbUserInfo.append("            ҽԺ��"+publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j)+" ");
				 sbUserInfo.append("        </td>");
				 sbUserInfo.append("        <td>");
				 sbUserInfo.append("            "+publicPageDAO.GetFieldValue(rsList, "NAME", j)+"");
				 sbUserInfo.append("        </td>");
				 sbUserInfo.append("        <td>");
				 sbUserInfo.append("           Ǳ����"+publicPageDAO.GetFieldValue(rsList, "HZGM", j)+"");
				 sbUserInfo.append("        </td>");
				 sbUserInfo.append("        <td>");
				 sbUserInfo.append("            �����ԣ�"+publicPageDAO.GetFieldValue(rsList, "QXX", j)+"");
				 sbUserInfo.append("        </td>");
				 sbUserInfo.append("        <td>");
				 sbUserInfo.append("            �������"+publicPageDAO.GetFieldValue(rsList, "XSGN", j)+"");
				 sbUserInfo.append("        </td>");
				 sbUserInfo.append("        <td>");
				 sbUserInfo.append("           ָ����䣺"+publicPageDAO.GetFieldValue(rsList, "COMPANYKPI", j)+"");
				 sbUserInfo.append("        </td>");
				 sbUserInfo.append("        <td>");
				 sbUserInfo.append("            ����Ԥ�⣺"+publicPageDAO.GetFieldValue(rsList, "XSYC", j)+"");
				 sbUserInfo.append("        </td>");
				 sbUserInfo.append("    </tr>");
				 sbUserInfo.append("</table>");
				 sbUserInfo.append("</fieldset>");
				 
				 if("xingdongjihua".equals(strType))
				 {//�ж��ƻ��� ��������Դ��Ϣ 
					  sbUserInfo.append(" 	<fieldset class=\"tdLegendFieldset\"");
					  sbUserInfo.append("style=\"margin-left: 10px; margin-right: 10px; width: 800px;\">");
					  sbUserInfo.append("<legend class=\"Legend_Style\">");
					  sbUserInfo.append("	������Դ");
					  sbUserInfo.append("</legend>");
					  sbUserInfo.append("<table class=\"tbDragTable\"");
					  sbUserInfo.append("	style=\"margin-top: 0px; margin-left: 0px;  background-color: #FEF6C7; width: 100%;\"");
					  sbUserInfo.append("	border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
					  sbUserInfo.append("	<colgroup>");
					  sbUserInfo.append("		<col width=\"100px\" />");
					  sbUserInfo.append("		<col width=\"100px\" />");
					  sbUserInfo.append("		<col width=\"100px\" />");
					  sbUserInfo.append("		<col width=\"150px\" />");
					  sbUserInfo.append("		<col width=\"120px\" />");
					  sbUserInfo.append("		<col width=\"100px\" />");
					 // sbUserInfo.append("		<col width=\"200px\" />");
					  sbUserInfo.append("	</colgroup>");
					  sbUserInfo.append("	<tr class=\"tbInfo\" style=\"height: 20px;\">");
//					  Map aa=(Map)rsList.get(j);
//					  System.out.println(aa); 
					  String strResource_ZiYuan[]=publicSourceDAO.strZiYuan;
					  
					  for (int i = 0; i < strResource_ZiYuan.length; i++)
						{//���ֶ�
							String strFieldNames = publicDao.NullToStr(strResource_ZiYuan[i]);
							String strFieldName=publicDao.NullToStr(strFieldNames);
							String strFieldCName=strFieldNames;
							if(strFieldName.split(",").length>1)
							{
								 strFieldName=strFieldNames.split(",")[0];//Ӣ������
								  strFieldCName=strFieldNames.split(",")[1];//��������

								 String	strVs= publicPageDAO.GetFieldValue(rsList,strFieldName, j);//����
								  sbUserInfo.append("		<td>"+strFieldCName+":<span>"+  publicDao.NullToNumber( strVs) +"</span></td>");
								 
							}
							
						}
//					       sbUserInfo.append("	</tr>");
					  sbUserInfo.append("</table>");
					  sbUserInfo.append("</fieldset>"); 

					 
				 }
				 
				 sbUserInfo.append("</div>"); 
           }
				sb.append("  <td style=\"border-bottom: solid 1px #86CBF7; font-size: 12px; text-align: right;\"  width=\"*\"> &nbsp; </td>");
		} 

		request.setAttribute("userHtml", sb.toString());
		request.setAttribute("UserInfoHtml", sbUserInfo.toString());
		return sbUserInfo.toString()+ sb.toString();
	}


	/**
	 * ��װ�����Է���ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getJieGuoFenXiPageHtml(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		//StringBuilder sbHead = new StringBuilder(); 
		if (rsList != null && rsList.size() > 0) 
		{//������ 
			for (int j = 0; j < rsList.size(); j++) 
			{
				
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
								String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
								String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
								String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
								String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
								String strValue=publicPageDAO.GetFieldValue(rsList, strFieldName, j);
								if(i==0)
								{
									sb.append("<td> <fieldset class=\"tdLegendFieldset\">");
								    sb.append("	<legend class=\"Legend_Style\">"+strUserName+"</legend>");
								    sb.append("<table class=\"tbDragTable\" style=\"width: 100%; margin-top: 0px; margin-left: 0px; \">");
								} 
								sb.append("<tr class=\"trMoveRow\" style=\"height:42px\" >");
									sb.append("<td  class=\"tdFieldLable\"  >"+strFieldCName);
								    sb.append("<input type=\"hidden\"  name =\""+ strPKField+strParamID + "\"   id =\""+ strPKField+strParamID + "\"   value=\""+ strPKID
										+ "\" />");
									sb.append("</td>");
								 sb.append("<td  class=\"tdFieldInput\"  colspan=\"5\"  style=\"text-align: left;\"> <textarea style=\"width:98%;overflow-y:visible;height:40px;\"  name =\""
									+ strFieldName+strParamID + "\"   id =\""
									+ strFieldName+strParamID + "\"   onblur=\"stringLengthCheck(this,'290','����Ľ�����ܳ���300���ַ���')\"  value=\""
									+ strValue + "\"  >"+ strValue +"</textarea></td>"); 
							sb.append("</td>");
						}
						sb.append("</tr>  ");
				}
				 sb.append("</table> </fieldset> </td> </tr>");
			} 
		} 
		return   sb.toString();
	}

	/**
	 * ��װ����Ŀ��ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getChanChuMuBiaoPageHtml(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		String strQuYu="";

		   DecimalFormat df = new DecimalFormat("0.0"); 
		if (rsList != null && rsList.size() > 0) 
		{//������
			sbHead.append("<tr   class=\"tableHead\" style=\"height:40px;\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
			for (int j = 0; j < rsList.size(); j++) 
			{
			    sb.append("<tr class=\"trMoveRow\" >");
				String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
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
					String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
					String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
					String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
					String strValue=publicPageDAO.GetFieldValue(rsList, strFieldName, j);
					String COMPANYKPI=publicPageDAO.GetFieldValue(rsList, "COMPANYKPI", j);
					String strTarget=	publicPageDAO.GetFieldValue(rsList, "target", j);
					if("".equals(COMPANYKPI)){}
						COMPANYKPI=publicDao.DecimalFormat_OBJ(publicDao.NullToDouble(    strTarget)/0.8)+"";
					
					if(i==0)
					{
						strQuYu+=strParamID+",";
						sb.append("<td  class=\"tdFieldLable\">"+  strUserName);
					    sb.append("<input type=\"hidden\"  name =\""+ strPKField+strParamID + "\"   id =\""+ strPKField+strParamID + "\"   value=\""+ strPKID
							+ "\" />");

                        sb.append("<div style=\"display:none;\">");
						sb.append("<input  name =\"target_" + strParamID + "\"   id =\"target_" +strParamID + "\"   value=\"" + strTarget + "\"  />");
						sb.append("<input  name =\"COMPANYKPI" + strParamID + "\"   id =\"COMPANYKPI" +strParamID + "\"   value=\"" + COMPANYKPI + "\"  />");
						sb.append("</div></td>");
					}
					if(j==0)
					{
						String strColor="";
						 
						sbHead.append("<td  style=\"text-align: left;"+strColor+"\"> "+strFieldCName+"</td>"); 
					}
//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
					if( "XSYC".equals(strFieldName) )
					{
						strValue=strTarget;
					}
					if( "COMPANYKPI".equals(strFieldName) )
					{
						strValue=COMPANYKPI;
					}
							if("XSYG_TEST".equals(strFieldName))
							{
								
								

							    String	strStatus=" readonly=\"readonly\" style=\"background-color: #C3CCDB\" ";
							    strStatus="";
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> <input style=\"width: 60px\"  name =\""
										+ strFieldName+strParamID + "\"   id =\""
										+ strFieldName+strParamID + "\"   value=\""
										+ strValue + "\" "+strStatus+"  onblur=\"checkIsNum(this);stringLengthCheck(this,'50','����Ľ�����ܳ���50���ַ���')\"/>"); 
									
							}else
							{
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: right;\">  "
									+ strValue + " "); 
							}
							
							if("ACH".equals(strFieldName)||"ACH_ALL".equals(strFieldName)||"ABFGL".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName))
					{
						sb.append("%");}
					
				sb.append("</td>");
				}
			}
			 
				sb.append("</tr>  ");
						
						
				
			}
		 
				sbHead.append("</tr>  ");
		} 
		request.setAttribute("quYuDaiBiao", strQuYu);
		return sbHead.toString()+ sb.toString();
	}
	

	/**
	 * ��װ�¼��ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getYueJianKongPageHtml(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		StringBuilder sbHead1 = new StringBuilder(); 
		String[] titles={"����","����","�˴�","����","����","����","","","","","","","",""};
		StringBuilder sbFoot = new StringBuilder(); 
		StringBuilder sbFoot1 = new StringBuilder(); 
		String strQuYu="";
		List listMarket =publicDateDAO.queryMarketList("");
		List  paraList=	publicDateDAO.queryParaList(request);
		float strXF_BIAOZHUN=0;
	    float strKNH_BIAOZHUN=0;
	    float strHD_BIAOZHUN=0;
	    float strXSTGF_BIAOZHUN=0;
	    float strSCBTGF_BIAOZHUN=0;
	    float strPXHD_BIAOZHUN=0;
	    float strPXKC_BIAOZHUN=0;
	    float strCPKS_BIAOZHUN=0;

		float strXF_LV=0;
	    float strKNH_LV=0;
	    float strHD_LV=0;
	    float strXSTGF_LV=0;
	    float strSCBTGF_LV=0;
	    float strPXHD_LV=0;
	    float strPXKC_LV=0;
	    float strCPKS_LV=0;
		if(paraList!=null&&paraList.size()>0)
		{//��Դ
	 

			
		    
		    
				//Ȩ��

				strXF_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "XF_LV", 0));//Э��(����)
				strKNH_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "KNH_LV", 0));//���һ�(����)
				strHD_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "HD_LV", 0));//�(����)
				strXSTGF_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "XSTGF_LV", 0));//�����ƹ����
				strSCBTGF_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "SCBTGF_LV", 0));//�г����ƹ����
				strPXHD_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXHD_LV", 0));//��ѵ�
			 
		}
		 
		if (rsList != null && rsList.size() > 0) 
		{//������
			sbHead.append("<tr   class=\"tableHead\" style=\"height:40px;background-color:#3930A5;\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
			sbHead.append("<td style=\"height:40px;background-color:#3930A5;\">����</td>");
			sbHead.append("<td style=\"height:50px;background-color:#3930A5;\" >�����</td>");
			
			sbHead1.append("<tr   class=\"tableHead\" style=\"height:40px;\">");
			sbHead1.append("<td>����</td>");
			sbHead1.append("<td>����</td>");
			sbHead1.append("<td >�����</td>");
			sbFoot.append("<tr   class=\"\" style=\"height:26px;font-size:12px;\">");
			sbFoot.append("<td  style=\"text-align: right;background-color: #ECE9D8;\">�Ѿ�����</td>");
			sbFoot.append("<td style=\"text-align: right;background-color: #ECE9D8;\"> </td>");
			sbFoot.append("<td  style=\"text-align: right;background-color: #ECE9D8;\"id=\"whole\">�����</td>");
			sbFoot1.append("<tr   class=\"\" style=\"height:26px;font-size:12px;\">");
			sbFoot1.append("<td  style=\"text-align: right;background-color: #ECE9D8;\">������</td>");
			sbFoot1.append("<td  style=\"text-align: right;background-color: #ECE9D8;\"></td>");
			sbFoot1.append("<td style=\"text-align: right;background-color: #ECE9D8;\"></td>");
			for (int j = 0; j < rsList.size(); j++) 
			{
			    sb.append("<tr class=\"trMoveRow\" >");
				String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
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
					String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
					String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
					String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
					String strValue=publicDao.NullToStr(   publicPageDAO.GetFieldValue(rsList, strFieldName, j))+"";
					String strValue_LV=publicDao.NullToStr(   publicPageDAO.GetFieldValue(rsList, strFieldName+"_LV", j))+"";

					Double dbTarget=publicPageDAO.NullToDouble( 	publicPageDAO.GetFieldValue(rsList, "target", j));
				    Double dbRESULT=publicDao.NullToDouble(publicPageDAO.GetFieldValue(rsList, "RESULT", j));//���۽��
				    String  strWholeValue=publicDao.NullToStr(  publicPageDAO.GetFieldValue(rsList, "LASTRESULT", j));
					 int intPara=1;//��Դ����
						if(paraList!=null&&paraList.size()>0)
						{
							intPara=publicDao.NullToNumber(  publicPageDAO.GetFieldValue(paraList, publicDao.NullToStr(strFieldName).replace("_LV", ""), 0));//����
						}	
	                     if(intPara==0){intPara=1;}
	                     if( "WHOLE".equals(strFieldName))
	 					{
	                    	 intPara=100; 
	 					}
					if(i==0)
					{
						//��׼ֵ

						strXF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "XF_BIAOZHUN", j));//Э��(����)
						strKNH_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "KNH_BIAOZHUN", j));//���һ�(����)
						strHD_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "HD_BIAOZHUN", j));//�(����)
						strXSTGF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "XSTGF_BIAOZHUN", j));//�����ƹ����
						strSCBTGF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "SCBTGF_BIAOZHUN", j));//�г����ƹ����
						strPXHD_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "PXHD_BIAOZHUN", j));//��ѵ�
						//strPXKC_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXKC_BIAOZHUN", 0));//��ѵ�γ�
						//strCPKS_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "CPKS_BIAOZHUN", 0));//��Ʒ����
						
						strQuYu+=strParamID+",";
						sb.append("<td  class=\"tdFieldLable\">"+  strUserName);

						sb.append("<div style=\"display:none;\">"); 
					
							sb.append("<input  name =\"XF_BIAOZHUN\"   id =\"XF_BIAOZHUN\"   value=\"" + strXF_BIAOZHUN + "\"  />");
						sb.append("<input  name =\"KNH_BIAOZHUN\"   id =\"KNH_BIAOZHUN\"   value=\"" + strKNH_BIAOZHUN + "\"  />");
						sb.append("<input  name =\"HD_BIAOZHUN\"   id =\"HD_BIAOZHUN\"   value=\"" + strHD_BIAOZHUN + "\"  />");
						sb.append("<input  name =\"XSTGF_BIAOZHUN\"   id =\"XSTGF_BIAOZHUN\"   value=\"" + strXSTGF_BIAOZHUN + "\"  />");
						sb.append("<input  name =\"SCBTGF_BIAOZHUN\"   id =\"SCBTGF_BIAOZHUN\"   value=\"" + strSCBTGF_BIAOZHUN + "\"  />");
						sb.append("<input  name =\"PXHD_BIAOZHUN\"   id =\"PXHD_BIAOZHUN\"   value=\"" + strPXHD_BIAOZHUN+ "\"  />");
						
						sb.append("<input  name =\"XF_LV\"   id =\"XF_LV\"   value=\"" + strXF_LV + "\"  />");
						sb.append("<input  name =\"KNH_LV\"   id =\"KNH_LV\"   value=\"" + strKNH_LV + "\"  />");
						sb.append("<input  name =\"HD_LV\"   id =\"XF_LV\"   value=\"" + strHD_LV + "\"  />");
						sb.append("<input  name =\"XSTGF_LV\"   id =\"XF_LV\"   value=\"" + strXSTGF_LV + "\"  />");
						sb.append("<input  name =\"SCBTGF_LV\"   id =\"SCBTGF_LV\"   value=\"" + strSCBTGF_LV + "\"  />");
						sb.append("<input  name =\"PXHD_LV\"   id =\"PXHD_LV\"   value=\"" + strPXHD_LV+ "\"  />");
					    sb.append("<input  name =\""+ strPKField+strParamID + "\"   id =\""+ strPKField+strParamID + "\"   value=\""+ strPKID + "\" />");
					
					    sb.append("<input  name =\"target_" + strParamID + "\"   id =\"target_" +strParamID + "\"   value=\"" + dbTarget + "\"  />");
					    sb.append("<input  name =\"RESULT" + strParamID + "\"   id =\"RESULT" +strParamID + "\"   value=\"" + dbRESULT + "\"  />");
					    sb.append("</div></td>");
					    
					    String USERORDER=publicPageDAO.GetFieldValue(rsList, "USERORDER", j);
					    
						if("".equals( USERORDER) )
						{
							USERORDER=""+(j+1);
						}

						sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\">");
						sb.append("<input style=\"width: 30px\"    name =\"USERORDER"+strParamID + "\"   id =\"USERORDER"
								+strParamID + "\"   value=\""
								+ USERORDER+ "\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'2','����Ľ�����ܳ���2���ַ���');\"/>"); 

						sb.append("</td>");
					    
					    sb.append("<td  style=\"text-align: left;\"   id=\"LASTRESULT_" +strParamID + "\" >"); 
						
						sb.append(" <input style=\"width: 60px\"  name =\"LASTRESULT"+strParamID + "\"   id =\"");
						sb.append("LASTRESULT"+strParamID + "\"   value=\""
							+ strWholeValue + "\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���');setPageVsOne('"+strParamID+"','1');setBili('"+strFieldName+"','1');\"/>"); 
						sb.append("</td>");
					}
					
					if(j==0)
					{ 
						String strColor="";
						if("COMPANYKPI".equals(strFieldName)||"XSYC".equals(strFieldName))
						{
							strColor="background-color: #FFF0DB;";
						} 
						String ss="colspan=2  ";
						if("USERORDER".equals(strFieldName))
						{
							ss="   ";
						}else
						{}
							sbHead1.append("<td  style=\"text-align:center;width:40px;background-color:#FFCF9C;\"  title=\"����Դ��"+intPara+"\"  >%</td>");

							sbHead1.append("<td  style=\"text-align:center;width:40px;font-family:����;\"  title=\"����Դ��"+intPara+"\"  >"+titles[i]+"</td>");
							sbFoot.append("<td  style=\"text-align: left;background-color: #ECE9D8;\" id=\"YF_"+strFieldName+"\"></td>"); 
							sbFoot.append("<td  style=\"text-align: center;background-color: #ECE9D8;\" id=\"YFS_"+strFieldName+"\"></td>"); 
							sbFoot1.append("<td  style=\"text-align: left;background-color: #ECE9D8;\" id=\"DF_"+strFieldName+"\"></td>"); 
							sbFoot1.append("<td  style=\"text-align: center;background-color: #ECE9D8;\" id=\"DFS_"+strFieldName+"\"></td>");
						
						sbHead.append("<td  "+ss+" style=\"text-align: center;background-color:#3930A5;\"> "+strFieldCName);
						sbHead.append("<div style=\"display:none;\">");
						sbHead.append("<input    name =\""+strFieldName+ "PRAM\"   id =\""+strFieldName+ "PRAM\" value=\""+ intPara + "\"    />");
						
						sbHead.append("<input   name =\"ZIYUAN_"+  strFieldName+ "\"     id =\"ZIYUAN_"+  strFieldName+"\"   value=\"" + intPara + "\"  /></div>");
						sbHead.append("</td>");
						
						
						 
						 
					}
//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
					

					   String BIAOZHUN="";// publicPageDAO.GetFieldValue(listMarket, strFieldName+"_BIAOZHUN", j);//Э��(����)��׼ֵ��"+BIAOZHUN+"
					
						if (listMarket != null && listMarket.size() > 0) 
						{//������

				            for (int n = 0; n < listMarket.size(); n++) 
							{
								String strParamID_1=	publicPageDAO.GetFieldValue(listMarket, strParamField, n);
								if(strParamID_1.equals(strParamID))
								{
									BIAOZHUN=publicPageDAO.GetFieldValue(listMarket, strFieldName+"_BIAOZHUN", n);
									break;
								}
							}
						}
					   
					   sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\">");
					   sb.append("<div style=\"display:none;\">");
					   sb.append("<input style=\"width: 40px\"   title=\"����Դ��"+intPara+" ;\"   name =\""+ strFieldName+strParamID + "\"   id =\""
									+ strFieldName+strParamID + "\"   value=\""
									+ strValue + "\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���');setPageVsOne('"+strParamID+"','1');setBili('"+strFieldName+"','1');\"/>"); 
								
					   sb.append("</div>");
					   sb.append("<div style=\"display:none;\"><input  name =\""+strFieldName+strParamID+"_BIAOZHUN\"   id =\""+strFieldName+strParamID+"_BIAOZHUN\"   value=\""+BIAOZHUN+"\"  /></div>");
						 
							   sb.append("<input style=\"width: 40px\"   title=\"����Դ��"+intPara+" ;\"   name =\""+ strFieldName+"_LV"+strParamID + "\"   id =\""
										+ strFieldName+"_LV"+strParamID + "\"   value=\""
										+ strValue_LV + "\"   onblur=\"stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���');setPageVsOne('"+strParamID+"','1');setBili('"+strFieldName+"','1');\"/>"); 

								sb.append("");
								sb.append("</td>");

								 sb.append("<td  id =\""+  strFieldName+""+strParamID + "VS\"  class=\"tdFieldInput\" style=\"text-align: center;\">");
								 sb.append("aaaaa</td>");
						   
				 
					
				
					  
				}
			}
				 

				String ORDER1=	publicPageDAO.GetFieldValue(rsList, "ORDER1", j);
				String ORDER2=	publicPageDAO.GetFieldValue(rsList, "ORDER2", j);
				String ORDER3=	publicPageDAO.GetFieldValue(rsList, "ORDER3", j);
				String ORDER4=	publicPageDAO.GetFieldValue(rsList, "ORDER4", j);
				String ORDER5=	publicPageDAO.GetFieldValue(rsList, "ORDER5", j);

				String ACTIONPLAN1=	publicPageDAO.GetFieldValue(rsList, "ACTIONPLAN1", j);
				String ACTIONPLAN2=	publicPageDAO.GetFieldValue(rsList, "ACTIONPLAN2", j);
				String ACTIONPLAN3=	publicPageDAO.GetFieldValue(rsList, "ACTIONPLAN3", j);
			    float 	LASTRESULT=publicDao.NullToFloatr( publicPageDAO.GetFieldValue(rsList, "LASTRESULT", j));
				sb.append("<td  class=\"tdFieldLable\" id =\"" +strParamID + "FP\"  >10%</td>");
				sb.append("<td  class=\"tdFieldLable\"  style=\"text-align: left;width:160px;\">" +
						"<input name=\"bt1\" type=\"button\" value=\""+publicDateDAO.changeDictIdToCode(ORDER1)+"\" class=\"pt_small_Input\" value=\"\" onclick=\"javascript:getXingDongJiHua(this,'ORDER1"+strParamID+"');\" />" +
						  "<input name=\"bt1\" type=\"button\" value=\""+publicDateDAO.changeDictIdToCode(ORDER2)+"\" class=\"pt_small_Input\" value=\"\" onclick=\"javascript:getXingDongJiHua(this,'ORDER2"+strParamID+"');\" />" +
	                        "<input name=\"bt1\" type=\"button\" value=\""+publicDateDAO.changeDictIdToCode(ORDER3)+"\" class=\"pt_small_Input\" value=\"\" onclick=\"javascript:getXingDongJiHua(this,'ORDER3"+strParamID+"');\" />" +
	                        "<input name=\"bt1\" type=\"button\" value=\""+publicDateDAO.changeDictIdToCode(ORDER4)+"\" class=\"pt_small_Input\" value=\"\" onclick=\"javascript:getXingDongJiHua(this,'ORDER4"+strParamID+"');\" />" +
	                        "<input name=\"bt1\" type=\"button\" value=\""+publicDateDAO.changeDictIdToCode(ORDER5)+"\" class=\"pt_small_Input\" value=\"\" onclick=\"javascript:getXingDongJiHua(this,'ORDER5"+strParamID+"');\" />" +
	                        "<div style=\"display:none;\"><input name=\"ORDER1"+strParamID+"\"  id=\"ORDER1"+strParamID+"\"    value=\""+ORDER1+"\"   />" +
	                        "<input name=\"ORDER2"+strParamID+"\"  id=\"ORDER2"+strParamID+"\"    value=\""+ORDER2+"\"  />" +
	                        "<input name=\"ORDER3"+strParamID+"\"  id=\"ORDER3"+strParamID+"\"   value=\""+ORDER3+"\"  />" +
	                        "<input name=\"ORDER4"+strParamID+"\"  id=\"ORDER4"+strParamID+"\"    value=\""+ORDER4+"\"  />" +
	                        "<input name=\"ORDER5"+strParamID+"\"  id=\"ORDER5"+strParamID+"\"   value=\""+ORDER5+"\"  />" +
	                        "<input name=\"ACTIONPLAN1"+strParamID+"\"  id=\"ACTIONPLAN1"+strParamID+"\"   value=\""+ACTIONPLAN1+"\"  />" +
	                        "<input name=\"ACTIONPLAN2"+strParamID+"\"  id=\"ACTIONPLAN2"+strParamID+"\"   value=\""+ACTIONPLAN2+"\"  />" +
	                        "<input name=\"ACTIONPLAN3"+strParamID+"\"  id=\"ACTIONPLAN3"+strParamID+"\"   value=\""+ACTIONPLAN3+"\"  />" +
	                        "<input name=\"LASTRESULT"+strParamID+"\"  id=\"LASTRESULT"+strParamID+"\"   value=\""+LASTRESULT+"\"  />" +
								"</div></td>");
				sb.append("</tr>  ");
						
						
				
			}

			sbHead.append("<td  style=\"text-align: left;\">��������Դ����</td>");
			sbHead.append("<td    style=\"text-align: left;width:160px;\">�ж��ƻ�(������Ҫ�̶�����) </td>");
			sbHead.append("</tr>  ");

			sbHead1.append("<td  style=\"text-align: left;\">%</td>");
			sbHead1.append("<td  style=\"text-align: left;\"> </td>");
			sbHead1.append("</tr>  ");
			
			sbFoot.append("<td  style=\"text-align: right;background-color: #ECE9D8;\" id=\"last\"></td>");
			sbFoot.append("<td    style=\"text-align: left;background-color: #ECE9D8;\"><input name=\"doOver\"  id=\"doOver\" type=\"button\" value=\"�������\" class=\"pt_Long_button\" value=\"\" onclick=\"saveOrder();\" /></td>");
			sbFoot.append("</tr>  ");
			sbFoot1.append("<td  style=\"text-align: left;background-color: #ECE9D8;\"></td>");
			sbFoot1.append("<td    style=\"text-align: left;background-color: #ECE9D8;\"></td>");
			sbFoot1.append("</tr>  ");
		} 
		sb.append(sbFoot.toString());
		sb.append(sbFoot1.toString());
		request.setAttribute("quYuDaiBiao", strQuYu);
		return sbHead.toString()+sbHead1.toString()+ sb.toString();
	}
	/**
	 * ��װ����Ŀ��ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getTouRuMuBiaoPageHtml(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		String []strYaoDianFenxi=publicSourceDAO.strYaoDianFenxi;//�����Է��� 
		if (rsList != null && rsList.size() > 0) 
		{//������
			sbHead.append("<tr   class=\"tableHead\" style=\"height:40px;\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
			for (int j = 0; j < rsList.size(); j++) 
			{
				String strStatus=" "; 
		     	String strMASTERID=	publicPageDAO.GetFieldValue(rsList, "MASTERID", j);
//		     	System.out.println(strMASTERID);
				if(j!=0)
				{
					strStatus="style=\"  display:none;\"";
					
				}else
				{
					request.setAttribute("firstMASTERID", strMASTERID);
				} 
				sb.append("<div  id=\"div_List_"+strMASTERID+"\"  "+strStatus+">");
				sb.append("<table style=\"width: 100%;\" class=\"tbDragTable\">");
						for (int i = 0; i < strResource.length; i++)
						{//���ֶ�
							String strJieGuo="";
							String strJieGuoVs="";
							if(i<strYaoDianFenxi.length)
							{
								strJieGuo=strYaoDianFenxi[i];
								if(strJieGuo.split(",").length>1)
								{
									strJieGuo=strJieGuo.split(",")[0];//Ӣ������
								}	
								strJieGuoVs=publicPageDAO.GetFieldValue(rsList, strJieGuo, j);
							} 
						    sb.append("<tr class=\"trMoveRow\" >");
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
							String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
							String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
							String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
							String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
							String strValue=publicPageDAO.GetFieldValue(rsList, strFieldName, j);
							if(i==0)
							{
//								sb.append("<td  class=\"tdFieldLable\">"+  strUserName);
//							    sb.append("<input type=\"hidden\"  name =\""+ strPKField+strParamID + "\"   id =\""+ strPKField+strParamID + "\"   value=\""+ strPKID
//									+ "\" />");
//								sb.append("</td>");
							}
							if(i==0)
							{
								String strColor="";
								if("COMPANYKPI".equals(strFieldName)||"XSYC".equals(strFieldName))
								{
									strColor="background-color: #FFF0DB;";
								}
							} 
							sb.append("<td  class=\"tdFieldLable\" style=\"text-align: right; width:15%;\"> "+strFieldCName+"</td>");
						
						    sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"> ");
							sb.append("<div style=\"background-color: #FFE0C0;\" title=\""+strJieGuoVs+" \"> "+strJieGuoVs+" </div>");
							sb.append("<input style=\"width: 98%;\"  name =\""	+ strFieldName+strParamID + "\"   id =\""
									+ strFieldName+strParamID + "\"   value=\""
									+ strValue + "\"   onblur=\"__isQuoteIn(this);stringLengthCheck(this,'120','����Ľ�����ܳ���120���ַ���')\"/>"); 
							 
							if("ACH".equals(strFieldName)||"ACH_ALL".equals(strFieldName)||"ABFGL".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName))
							{
								sb.append("%");
							}
						sb.append("</td>");
						sb.append("</tr>  ");
						}
					}
				sb.append("</table>");
				sb.append("</div>");
				
			}
				sbHead.append("</tr>  ");
		} 
		return  sb.toString();
	}
	/**
	 * ��װ�������ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getZiYuanFenPeiPageHtml_new(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		StringBuilder sbHead1 = new StringBuilder(); 
		StringBuilder sbFoot = new StringBuilder(); 
		StringBuilder sbFoot1 = new StringBuilder(); 
		StringBuilder sbFoot2 = new StringBuilder(); 
		List  paraList=	publicDateDAO.queryParaList(request);

		List listMarket =publicDateDAO.queryMarketList("");
		String strQuYu="";
		String[] titles={"����","����","����","����","����","����","����","","","","","","","",""};
		if (rsList != null && rsList.size() > 0) 
		{//������
			sbHead.append("<tr   class=\"tableHead\" style=\"height:40px;\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
			sbHead.append("<td style=\"text-align:center;\">�����</td>");
			sbHead1.append("<tr   class=\"tableHead\" style=\"height:40px;\">");
			sbHead1.append("<td>����</td>");
			sbHead1.append("<td>%</td>");
			sbFoot.append("<tr   class=\"\" style=\"height:20px;font-size:12px;\">");
			sbFoot.append("<td  style=\"text-align: right;color: red;\">�Ѿ�����</td>");
			sbFoot.append("<td  style=\"text-align: right;\" id=\"whole\">�����</td>");
			sbFoot1.append("<tr   class=\"\" style=\"height:20px;font-size:12px;\">");
			sbFoot1.append("<td  style=\"text-align: right;color: red;\">������</td>");
			sbFoot1.append("<td  style=\"text-align: right;color: red;\"></td>");
			sbFoot2.append("<tr   class=\"\" style=\"height:20px;font-size:12px;\">");
			sbFoot2.append("<td  style=\"text-align: right;color: red;\">ʣ��</td>");
			sbFoot2.append("<td  style=\"text-align: right;color: red;\"></td>");
			for (int j = 0; j < rsList.size(); j++) 
			{
			    sb.append("<tr class=\"trMoveRow\" >");
				String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
				String strTarget=	publicPageDAO.GetFieldValue(rsList, "target", j);

				String COMPANYKPI=	publicPageDAO.GetFieldValue(rsList, "COMPANYKPI", j);
				    COMPANYKPI=publicDao.DecimalFormat_OBJ(publicDao.NullToDouble(    strTarget)/0.8)+"";
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
						String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
						String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
						String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
						String  strValue=publicDao.NullToStr(  publicPageDAO.GetFieldValue(rsList, strFieldName, j));
						String  strValue_LV=publicDao.NullToStr(  publicPageDAO.GetFieldValue(rsList, strFieldName+"_LV", j));
						String  strWholeValue=publicDao.NullToStr(  publicPageDAO.GetFieldValue(rsList, "LASTRESULT", j));
						String  RESULT=publicDao.NullToStr(  publicPageDAO.GetFieldValue(rsList, "RESULT", j));



						String intPara="0";//��Դ����
						float quanZhong=0;//��ԴȨ�ز���
						if(paraList!=null&&paraList.size()>0)
						{
							if("HZGM".equals(strFieldName))
							{
								//strFieldName="SCGM";
							}
							intPara=publicDao.NullToStr(  publicPageDAO.GetFieldValue(paraList, publicDao.NullToStr(strFieldName).replace("_LV", ""), 0));//����
							quanZhong=publicDao.NullToFloatr( publicPageDAO.GetFieldValue(paraList, publicDao.NullToStr(strFieldName), 0));//����
						}
						if(i==0)
						{
							strQuYu+=strParamID+",";
							sb.append("<td  class=\"tdFieldLable\" style=\"text-align:center;\"><span class=\"span_style"+(j%2+1)+"\">"+  strUserName+"</span>");
						    sb.append("<div style=\"display:none;\">" );
						   if (listMarket != null && listMarket.size() > 0) 
							{//������

					            for (int m = 0; m < listMarket.size(); m++) 
								{
									String strParamID_1=	publicPageDAO.GetFieldValue(listMarket, strParamField, m);
									if(strParamID_1.equals(strParamID))
									{		
									     String strResource_BiaoZhun[]=publicSourceDAO.strEditBiaoZhun;//��׼ֵ
										  for (int n = 0; n < strResource_BiaoZhun.length; n++)
											{//���ֶ�
												String strFieldNames_BiaoZhun= publicDao.NullToStr(strResource_BiaoZhun[n]);
												String strFieldName_BiaoZhun=publicDao.NullToStr(strFieldNames_BiaoZhun);
												String strFieldCName_BiaoZhun=strFieldNames_BiaoZhun;
												if(strFieldNames_BiaoZhun.split(",").length>1)
												{
													strFieldName_BiaoZhun=strFieldNames_BiaoZhun.split(",")[0];//Ӣ������
													strFieldCName_BiaoZhun=strFieldNames_BiaoZhun.split(",")[1];//��������
													 String	strVs= publicPageDAO.GetFieldValue(listMarket,strFieldName_BiaoZhun, m);//����
													 sb.append("<input  name =\"" +strFieldName_BiaoZhun+ strParamID + "\"   id =\""+strFieldName_BiaoZhun +strParamID + "\"   value=\"" + strVs + "\"  />");
												}
												
											}
									 }
									
								 }
							}
						   String PXHD=	publicPageDAO.GetFieldValue(rsList, "PXHD", j);//������Դ����ٷֱȽ��
							  

						   sb.append("<input    name =\"PXHD"+strParamID + "\"   id =\"PXHD"+strParamID + "\"   value=\""+ PXHD + "\"    />");
						 								
							sb.append("<input  name =\"COMPANYKPI" + strParamID + "\"   id =\"COMPANYKPI" +strParamID + "\"   value=\"" + COMPANYKPI + "\"  />");
						    sb.append("<input  name =\"target_" + strParamID + "\"   id =\"target_" +strParamID + "\"   value=\"" + intPara + "\"  />");
							sb.append("<input  name =\"target_" + strParamID + "\"   id =\"target_" +strParamID + "\"   value=\"" + strTarget + "\"  />");
							//��
							sb.append(" <input style=\"width: 60px\"  name =\"RESULT_"+strParamID + "\"   id =\"RESULT_"+strParamID + "\"   value=\""+ RESULT + "\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���');\"/>"); 
								
							sb.append("</div></td>");
							sb.append("<td  style=\"text-align: left;\"   id=\"LASTRESULT_" +strParamID + "\" >"); 
							
							sb.append(" <input style=\"width: 60px\"  name =\"LASTRESULT"+strParamID + "\"   id =\"");
							sb.append("LASTRESULT"+strParamID + "\"   value=\""
								+ strWholeValue + "\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���');\"/>"); 

						
							sb.append("</td>");
							
						}
						if(j==0)
						{
							
							sbHead.append("<td colspan=\"2\" style=\"text-align:center;background-color:#3930A5;\"  title=\"����Դ��"+intPara+"\"  > "+strFieldCName); 
							sbHead.append("<div style=\"display:none;\">");
							sbHead.append("<input    name =\""+strFieldName+ "PRAM\"   id =\""+strFieldName+ "PRAM\" value=\""+ intPara + "\"    />");
							sbHead.append("<input   name =\"ZIYUAN_"+  strFieldName+ "\"     id =\"ZIYUAN_"+  strFieldName+"\"   value=\"" + intPara + "\"  />");
							sbHead.append("<input   name =\"ZIYUAN_"+  strFieldName+ "QZ\"     id =\"ZIYUAN_"+  strFieldName+"QZ\"   value=\"" + quanZhong + "\"  />");
							sbHead.append("</div></td>");
							sbHead1.append("<td  style=\"text-align:center;width:40px;background-color:#FFCF9C;\"  title=\"����Դ��"+intPara+"\"  >%</td>");

							sbHead1.append("<td  style=\"text-align:center;font-family:����;\"  title=\"����Դ��"+intPara+"\"  >"+titles[i]+"</td>");
							

							sbFoot.append("<td  style=\"text-align: left;background-color: #C6C7C6;\" id=\"YF_"+strFieldName+"\">0%</td>"); 
							sbFoot.append("<td  style=\"text-align: left;background-color: #C6C7C6;\" id=\"YFS_"+strFieldName+"\">0</td>"); 
							sbFoot1.append("<td  style=\"text-align: left;background-color: #C6C7C6;\" id=\"DF_"+strFieldName+"\">100</td>"); 
							sbFoot1.append("<td  style=\"text-align: left;background-color: #C6C7C6;\" id=\"DFS_"+strFieldName+"\">"+intPara+"</td>"); 
									
							sbFoot2.append("<td  style=\"text-align: left;background-color: #C6C7C6;\" id=\"SY_"+strFieldName+"\">100%</td>"); 
							sbFoot2.append("<td  style=\"text-align: left;background-color: #C6C7C6;\" id=\"SYS_"+strFieldName+"\">0</td>"); 
							
						}
	//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
						

							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;background-color:#FFCF9C\" >");
							sb.append(" <input style=\"width: 60px\"  name =\""+  strFieldName+"_LV"+strParamID + "\"  title=\"����Դ��"+intPara+"\"  id =\"");
							sb.append( strFieldName+"_LV"+strParamID + "\"   value=\""
								+ strValue_LV + "\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���');setPageVsOne_BL('"+strFieldName+"');setPageVsByIDOne_BL('"+strParamID+"');\"/>"); 
							sb.append("<div style=\"display:none;\">");
							sb.append(" <input style=\"width: 60px\"  readonly=\"readonly\" name =\""+  strFieldName+strParamID + "\"  title=\"����Դ��"+intPara+"\"  id =\"");
							sb.append( strFieldName+strParamID + "\"   value=\""
								+ strValue + "\"  />"); // onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���');setPageVsOne('"+strFieldName+"');setPageVsByIDOne('"+strParamID+"');\"
						 	//sb.append("%");
							
							sb.append("</div>");
							sb.append("</td>\n");
							sb.append("<td  id =\""+  strFieldName+""+strParamID + "VS\"  class=\"tdFieldInput\" style=\"text-align:center;background-color:#FFFFC6\">");
							
							
					        sb.append("</td>");
				}
			}

			sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\" id=\""+strParamID+"FP\">0%</td>");
			sb.append("</tr>  ");
		 }

		sbHead.append("<td  style=\"text-align: left;background-color:#3930A5;\">���</td>"); 
		sbHead.append("</tr>  ");

		sbHead1.append("<td  style=\"text-align: center;background-color:#FFCF9C;\">%</td>"); 
		sbHead1.append("</tr>  ");
		sbFoot.append("<td  style=\"text-align: left;\" id=\"last\"  ></td>"); 
		sbFoot.append("</tr>  "); 
		sbFoot1.append("<td  style=\"text-align: left;\"  id=\"DP\"  ></td>"); 
		sbFoot1.append("</tr>  ");
		sbFoot2.append("<td  style=\"text-align: left;\"  id=\"SY\"  ></td>"); 
		sbFoot2.append("</tr>  ");
		} 
		request.setAttribute("quYuDaiBiao", strQuYu);
	    sb.append(sbFoot.toString());
		sb.append(sbFoot1.toString());	
		sb.append(sbFoot2.toString());	
		return sbHead.toString()+sbHead1.toString()+ sb.toString();
	}
	/**
	 * ��װ�������ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getZiYuanFenPeiPageHtml(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		String strQuYu="";
		List  paraList=	publicDateDAO.queryParaList(request);
		if (rsList != null && rsList.size() > 0) 
		{//������
			sbHead.append("<tr   class=\"tableHead\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
				for (int i = 0; i < strResource.length; i++)
				{//���ֶ�
					String strFieldNames = publicDao.NullToStr(strResource[i]);
					String strFieldName=publicDao.NullToStr(strFieldNames);
					String strFieldCName=strFieldNames;
					if(strFieldName.split(",").length>1)
					{
						 strFieldName=strFieldNames.split(",")[0];//Ӣ������
						  strFieldCName=strFieldNames.split(",")[1];//��������
					}
					 
					if (!"".equals(strFieldName))
					{
						String strPara="";//����
						if(paraList!=null&&paraList.size()>0)
						{
							strPara=publicPageDAO.GetFieldValue(paraList, publicDao.NullToStr(strFieldName).replace("_LV", ""), 0);//����
						}
						if("WHOLE".equals(strFieldName))
						{
							strPara="100";
						}
						StringBuilder sbOrder = new StringBuilder(); 
						sb.append("<tr class=\"trMoveRow\" >");
						for (int j = 0; j < rsList.size(); j++) 
						{
							String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
							String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
							String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
							String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
							String strValue=publicPageDAO.GetFieldValue(rsList, strFieldName, j);
							if(j==0)
							{
								sb.append("<td  class=\"tdFieldLable\">"+strFieldCName);
							    sb.append("<input type=\"hidden\"  name =\""+ strPKField+strParamID + "\"   id =\""+ strPKField+strParamID + "\"   value=\""+ strPKID
									+ "\" />");
								sb.append("</td>");
								
							}
							if(i==0)
							{
								strQuYu+=strParamID+",";
							   sbHead.append("<td  style=\"text-align: left;\"> "+strUserName+"</td>");
							}
	//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"   > ");
							if(i>3&&i!=(strResource.length-1))
							{
								if(j==0)
								{
									sbOrder.append("<tr class=\"trMoveRow\" >");
									sbOrder.append("<td  class=\"tdFieldLable\">��ռ����");
									sbOrder.append("</td>");
								}

								   String BIAOZHUN= publicPageDAO.GetFieldValue(rsList, strFieldName+"_BIAOZHUN", j);//Э��(����)��׼ֵ��"+BIAOZHUN+"
								sb.append("<input style=\"width: 60px\"  title=\"�ɷ�����Դ��"+strPara+";\"  name =\""
								+ strFieldName+strParamID + "\"   id =\""
								+ strFieldName+strParamID + "\"   value=\""
								+publicDao.NullToNumber( strValue) + "\"   onblur=\"javascript:checkIsNum(this);stringLengthCheck(this,'4','����Ľ�����ܳ���4���ַ���');setPageVsByIDOne('"+strParamID+"');setPageVsOne('"+strFieldName+"');  \"/>"); 

								sbOrder.append("<td  class=\"tdFieldLable\" style=\" background-color:#FFFFBF;\" canshu=\""+(0.01 * publicDao.NullToNumber( strPara))+"\"  id=\"JZ"+strFieldName+strParamID+"\">"+ new BigDecimal(publicDao.NullToNumber( strValue)*0.01 * publicDao.NullToNumber( strPara)).setScale(1, BigDecimal.ROUND_HALF_UP) );
								sbOrder.append("</td>");
							}else
							{ 
								if("LASTRESULT".equals(strFieldName))
								{
									sb.append("<label	 id =\"label" + strParamID + "\">"+strValue+"  </label>");
									  sb.append("<div style=\"display:none;\">");
									  sb.append("<input  name =\"" +strFieldName+ strParamID + "\"   id =\"" +strFieldName +strParamID + "\"   value=\"" + strValue + "\"  /></div>");
								} else
								{
									
								   sb.append(strValue);
								}
								 
							}
							if("ACH".equals(strFieldName)||"ACH_ALL".equals(strFieldName)||"ABFGL".equals(strFieldName)||"LASTRESULT".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName))
							{
								sb.append("%");
							}
						    sb.append("</td>");
					}//j
						String strColor=""; 
						if(i>3)
						{//��Чֵ
							
							if("WHOLE".equals(strFieldName)||"LASTRESULT".equals(strFieldName))
							{
								strColor=" background-color:#CBCBCB;";
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;"+strColor+"\"  id=\""+strFieldName+"YJ\"></td>");
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;display:none;"+strColor+"\"  id=\""+strFieldName+"KY\"></td>");
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;"+strColor+"\"  id=\""+strFieldName+"SY\"></td>");
							}else
							{
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"  id=\""+strFieldName+"YJ\"></td>");
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;display:none;\"  id=\""+strFieldName+"KY\">100%</td>");
								sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\"  id=\""+strFieldName+"SY\">100%</td>");
								 
							
								 
							}
							if(i>3&&i!=(strResource.length-1))
							{
								sbOrder.append("<td  class=\"tdFieldInput\" style=\"text-align: left;background-color:#FFFFBF;\"  id=\"JZ"+strFieldName+"YJ\">0</td>");
								sbOrder.append("<td  class=\"tdFieldInput\" style=\"text-align: left;display:none;background-color:#FFFFBF;\"  id=\"JZ"+strFieldName+"KY\">0</td>");
								sbOrder.append("<td  class=\"tdFieldInput\" style=\"text-align: left;background-color:#FFFFBF;\"  id=\"JZ"+strFieldName+"SY\">0</td>");
								sbOrder.append("</tr>  ");
								
							}
						}
						else
						{
							strColor=" background-color:#CBCBCB;";
							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;"+strColor+"\"  id=\""+strFieldName+"YJ\"></td>");
							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;display:none;"+strColor+"\"  id=\""+strFieldName+"KY\"></td>");
							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;"+strColor+"\"  id=\""+strFieldName+"SY\"></td>");
						
						}
						sb.append("</tr>  ");

						if(i==3)
						{
							sb.append("<tr   style=\"\">  ");
							sb.append("<td   class=\"tdFieldLable\">����</td>  ");
							for (int k = 0; k < rsList.size(); k++) 
							{
								String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, k);
								String strUserorder=	publicPageDAO.GetFieldValue(rsList, "USERORDER", k);
								 if("".equals(strUserorder))
									{ 
									  strUserorder=""+(k+1);
									}
 
								sb.append("<td class=\"tdFieldInput\" style=\"text-align: left;color��#400000; font-weight:bold;\">");//+(k+1)
									 sb.append("<input readonly=\"readonly\" style=\"width: 60px;background-color: #C3CCDB;\"  title=\"�������\"  name =\"USERORDER"+strParamID + "\"   id =\""+ strFieldName+strParamID + "\"   value=\""
												+publicDao.NullToNumber( strUserorder) + "\"  />"); // onblur=\"javascript:checkIsNum(this);stringLengthCheck(this,'2','����Ľ�����ܳ���2���ַ���'); \"

									 sb.append(" </td>  ");
							}

							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: center;color��#400000; font-weight:bold;\">�ѷ���</td>");
							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: center;color��#400000; font-weight:bold;display:none;\">���õ�</td>");
							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: center;color��#400000; font-weight:bold;\">ʣ���</td>");
							sb.append("</tr>  ");
						}
						sb.append(sbOrder.toString());
				}
			}
				sbHead.append("</tr>  ");
		} 
		request.setAttribute("quYuDaiBiao", strQuYu);
		return sbHead.toString()+ sb.toString();
	}
	/**
	 * ��װ�ж��ƻ�ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getXingDongJiHuaPageHtml(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		String []strYaoDianFenxi=publicSourceDAO.strYaoDianFenxi;//�����Է��� 
		String []strTouRuMuBiao=publicSourceDAO.strTouRuMuBiao;//Ͷ��Ŀ��
		String []XingDong_JiHua_QiXian=publicSourceDAO.XingDong_JiHua_QiXian;//Ͷ��Ŀ��
		if (rsList != null && rsList.size() > 0) 
		{//������
			sbHead.append("<tr   class=\"tableHead\" style=\"height:40px;\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
			for (int j = 0; j < rsList.size(); j++) 
			{
				String strStatus=" "; 
				String strMASTERID=	publicPageDAO.GetFieldValue(rsList, "MASTERID", j);
				if(j!=0)
				{
					strStatus="style=\"  display:none;\"";
					
				}else
				{
					request.setAttribute("firstMarketid", strMASTERID);
				} 
				sb.append("<div  id=\"div_List_"+strMASTERID+"\"  "+strStatus+">");
				sb.append("<table style=\"width: 100%;\" class=\"tbDragTable\" name=\"contentTable\">");
				 sb.append("<tr class=\"trMoveRow\" style=\"height:37px;display:none;\" ><td width=\"15%\"></td><td width=\"85%\"></td></tr>");
						for (int i = 0; i < strResource.length; i++)
						{//���ֶ�
							String strJieGuo="";
							String strJieGuoVs="";
							if(i<strYaoDianFenxi.length)
							{
								strJieGuo=strYaoDianFenxi[i];
								if(strJieGuo.split(",").length>1)
								{
									strJieGuo=strJieGuo.split(",")[0];//Ӣ������
								}	
								strJieGuoVs=publicPageDAO.GetFieldValue(rsList, strJieGuo, j);
							} 
							String strTouRu="";
							String strTouRuVs="";
							if(i<strTouRuMuBiao.length)
							{
								strTouRu=strTouRuMuBiao[i];
								if(strTouRu.split(",").length>1)
								{
									strTouRu=strTouRu.split(",")[0];//Ӣ������
								}	
								strTouRuVs=publicPageDAO.GetFieldValue(rsList, strTouRu, j);
							} 
							

							String strQiXian="";
							String strQiXianVs="";
							if(i<strTouRuMuBiao.length)
							{
								strQiXian=XingDong_JiHua_QiXian[i];
								if(strQiXian.split(",").length>1)
								{
									strQiXian=strQiXian.split(",")[0];//Ӣ������
								}	
								strQiXianVs=publicPageDAO.GetFieldValue(rsList, strQiXian, j);
							} 
							
							
						    sb.append("<tr class=\"trMoveRow\" >");
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
								String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
								String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
								String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
								String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
								String strValue=publicPageDAO.GetFieldValue(rsList, strFieldName, j);
								sb.append("<td  class=\"tdFieldLable\" style=\"text-align:right; width:120px;\"> "+strFieldCName+"</td>");
							    sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;width:850px;\"> ");
							    sb.append("<div nowrap class=\"col_div\"  style=\"background-color: #FFE0C0;width:100%;white-space:nowrap ;\">");
							    
								sb.append("<div nowrap class=\"col_div\"  style=\"background-color: #FFE0C0;width:50%;white-space:nowrap; \" title=\"Ҫ�㣺"+strJieGuoVs+"\">Ҫ�㣺"+strJieGuoVs+" </div>");
								sb.append("<div nowrap class=\"col_div\"  style=\"background-color: #FFE9C0;width:49%;white-space:nowrap ;float: right;\"  title=\"Ͷ��Ŀ�꣺"+strTouRuVs+"\">Ͷ��Ŀ�꣺"+strTouRuVs+" </div>");
								sb.append("<div nowrap  class=\"col_div\"  style=\"background-color: #FFE0C0;width:100%;white-space:nowrap ;\">");
								sb.append("<div nowrap  class=\"col_div\"  style=\"background-color: #FFE0C0;width:70%;white-space:nowrap; \">");
//								sb.append("<input style=\"width: 98%;\"  name =\""	+ strFieldName+strParamID + "\"   id =\""+ strFieldName+strParamID + "\"   value=\""
//										+ strValue + "\"   onblur=\"__isQuoteIn(this);stringLengthCheck(this,'120','����Ľ�����ܳ���120���ַ���')\"/>"); 
								sb.append("<select size=\"1\"  name =\""+ strFieldName+strParamID + "\" id =\""	+ strFieldName+strParamID + "\"   style=\"width: 100%;\">");
								sb.append(publicDateDAO.queryDictDrop("jihua",strValue));
								sb.append("</select>");
								if("ACH".equals(strFieldName)||"ACH_ALL".equals(strFieldName)||"ABFGL".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName))
								{
									sb.append("%");
								}

								sb.append("</div> <div nowrap  class=\"col_div\"  style=\"background-color: #FFE0C0;width:30%;white-space:nowrap; \">");
								sb.append("���ޣ�<select size=\"1\"  name =\""+ strQiXian+strParamID + "\" id =\""	+ strQiXian+strParamID + "\"   style=\"width:80px; \">");
								sb.append(publicDateDAO.queryDictDrop("qixian",strQiXianVs));
								sb.append("</select>");
								sb.append("</div></div>");
								sb.append("</td>");
								sb.append("</tr>  ");
						   }
					}
				sb.append("</table>");
				sb.append("</div>");
				
			}
				sbHead.append("</tr>  ");
		} 
		return  sb.toString();
	}


	
	/**
	 * ��װҳ���¶�Ԥ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getMonth_YuCePageHtml(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		boolean isRead=true;
		String strQuYu="";

		   DecimalFormat df = new DecimalFormat("0"); 
		List  paraList=	publicDateDAO.queryParaList(request);
//		float strXF=0;
//	    float strKNH=0;
//	    float strHD=0;
//	    float strXSTGF=0;
//	    float strSCBTGF=0;
//	    float strPXHD=0;
//	    float strPXKC=0;
//	    float strCPKS=0;
//	    
//	    
//		float strXF_LV=0;
//	    float strKNH_LV=0;
//	    float strHD_LV=0;
//	    float strXSTGF_LV=0;
//	    float strSCBTGF_LV=0;
//	    float strPXHD_LV=0;
//	    float strPXKC_LV=0;
//	    float strCPKS_LV=0;
//	    
//
//		float strXF_BIAOZHUN=0;
//	    float strKNH_BIAOZHUN=0;
//	    float strHD_BIAOZHUN=0;
//	    float strXSTGF_BIAOZHUN=0;
//	    float strSCBTGF_BIAOZHUN=0;
//	    float strPXHD_BIAOZHUN=0;
//	    float strPXKC_BIAOZHUN=0;
//	    float strCPKS_BIAOZHUN=0;
//
//	   float strXF_SYS=0;
//	   float strKNH_SYS=0;
//	   float strHD_SYS=0;
//	   float strXSTGF_SYS=0;
//	   float strSCBTGF_SYS=0;
//	   float strPXHD_SYS=0;
//	    float strPXKC_SYS=0;
//	    float strCPKS_SYS=0;
	    
	   
	   float allBiLI=0; 
//		if(paraList!=null&&paraList.size()>0)
//		{//��Դ
//			strXF=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "XF", 0));//Э��(����)
//			strKNH=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "KNH", 0));//���һ�(����)
//			strHD=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "HD", 0));//�(����)
//			strXSTGF=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "XSTGF", 0));//�����ƹ����
//			strSCBTGF=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "SCBTGF", 0));//�ճ���������
//			strPXHD=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXHD", 0));//��ѵ�
//			//strPXKC=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXKC", 0));//��ѵ�γ�
//			//strCPKS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "CPKS", 0));//��Ʒ����
//			
//			//Ȩ��
//
//			strXF_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "XF_LV", 0));//Э��(����)
//			strKNH_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "KNH_LV", 0));//���һ�(����)
//			strHD_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "HD_LV", 0));//�(����)
//			strXSTGF_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "XSTGF_LV", 0));//�����ƹ����
//			strSCBTGF_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "SCBTGF_LV", 0));//�ճ���������
//			strPXHD_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXHD_LV", 0));//��ѵ�
//			//strPXKC_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXKC_LV", 0));//��ѵ�γ�
//			//strCPKS_LV=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "CPKS_LV", 0));//��Ʒ����
//			
//			 
//		 	}
		if (rsList != null && rsList.size() > 0) 
		{//������

			//sbHead.append("   <colgroup>");
			//sbHead.append("  <col width=\"80px\" />  ");  
			for (int j = 0; j < rsList.size(); j++) 
			{ 
			//	sbHead.append("   <col width=\"70px\" /> "); 
			} 
		//	sbHead.append("   </colgroup>");
			sbHead.append("<tr    class=\"tableHead\" style=\"height:36px;\" >");
			sbHead.append("<td  style=\" width:80px;\"><div style=\" width:80px;\"> &nbsp;&nbsp; </div></td>");
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
						sb.append("<tr   >");
						for (int j = 0; j < rsList.size(); j++) 
						{
							String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
							String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
							String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
							String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
							String strValue=publicPageDAO.GetFieldValue(rsList, strFieldName, j);
							String strTarget=	publicPageDAO.GetFieldValue(rsList, "target", j);
							String COMPANYKPI=	publicPageDAO.GetFieldValue(rsList, "COMPANYKPI", j);
//							if("".equals(COMPANYKPI)){
//								COMPANYKPI=publicDao.DecimalFormat_OBJ(publicDao.NullToDouble(    strTarget)/0.8)+"";
//							}
							    COMPANYKPI=publicDao.DecimalFormat_OBJ(publicDao.NullToDouble(    strTarget)/0.8)+"";
							if( "XSYC".equals(strFieldName) )//
							{
								strValue=publicDao.DecimalFormat_OBJ(strTarget)+"";
							}
							if( "COMPANYKPI".equals(strFieldName) )//
							{
								strValue=publicDao.DecimalFormat_OBJ(COMPANYKPI)+"";
							}
							if(j==0)
							{
								sb.append("<td   style=\"width:105px; height: 41px;background:#F8B03A;font-size:14px;color: white;font-weight:bold;text-align:center;\" >"+strFieldCName);
								
								sb.append("</td>");
							}
							if(i==0)
							{ 
							   strQuYu+=strParamID+",";
							   sbHead.append("<td  style=\"text-align: left;width:80px;\"><span class=\"span_style1\"> "+strUserName+"</span>");
							   sbHead.append("<div style=\"display:none;\">");
							   //sbHead.append("<input  name =\"target_" + strParamID + "\"   id =\"target_" +strParamID + "\"   value=\"" + strTarget + "\"  /> ");
							
							   String SALESUM=	publicPageDAO.GetFieldValue(rsList, "SALESUM", j);//������Դ���ս��
							   String PXHD=	publicPageDAO.GetFieldValue(rsList, "PXHD", j);//������Դ����ٷֱȽ��
							   sbHead.append("<input    name =\"SALESUM"+strParamID + "\"   id =\"SALESUM"+strParamID + "\"   value=\""+ SALESUM + "\"    />");
							   sbHead.append("<input    name =\"PXHD"+strParamID + "\"   id =\"PXHD"+strParamID + "\"   value=\""+ PXHD + "\"    />");
								
							   sbHead.append("<input  name =\"target_" + strParamID + "\"   id =\"target_" +strParamID + "\"   value=\"" + strTarget + "\"  />");
									
//								 sb.append("<input  name =\"XF_" + strParamID + "\"   id =\"XF_" +strParamID + "\"   value=\"" + strXF_SYS + "\"  />");
//								 sb.append("<input  name =\"KNH_" + strParamID + "\"   id =\"KNH_" +strParamID + "\"   value=\"" + strKNH_SYS + "\"  />");
//								 sb.append("<input  name =\"HD_" + strParamID + "\"   id =\"HD_" +strParamID + "\"   value=\"" + strHD_SYS + "\"  />");
//								 sb.append("<input  name =\"XSTGF_" + strParamID + "\"   id =\"XSTGF_" +strParamID + "\"   value=\"" + strXSTGF_SYS + "\"  />");
//								 sb.append("<input  name =\"SCBTGF_" + strParamID + "\"   id =\"SCBTGF_" +strParamID + "\"   value=\"" + strSCBTGF_SYS + "\"  />");

								 sbHead.append("<input  name =\"allBiLI_" + strParamID + "\"   id =\"allBiLI__" +strParamID + "\"   value=\"" + allBiLI + "\"  />");
								 sbHead.append("</div></td>");
							}
							String strStatus="";
							if("RESULT".equals(strFieldName))
							{
								 //��׼ֵ
//								strXF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "XF_BIAOZHUN", j));//Э��(����)
//								strKNH_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "KNH_BIAOZHUN", j));//���һ�(����)
//								strHD_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "HD_BIAOZHUN", j));//�(����)
//								strXSTGF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "XSTGF_BIAOZHUN", j));//�����ƹ����
//								strSCBTGF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "SCBTGF_BIAOZHUN", j));//�ճ���������
//								strPXHD_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "PXHD_BIAOZHUN", j));//��ѵ�
								//strPXKC_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXKC_BIAOZHUN", 0));//��ѵ�γ�
								//strCPKS_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "CPKS_BIAOZHUN", 0));//��Ʒ����
								
								 //��Դ
//								   strXF_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "XF", j));//Э��(����)
//									strKNH_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "KNH", j));//���һ�(����)
//									strHD_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "HD", j));//�(����)
//									strXSTGF_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "XSTGF", j));//�����ƹ����
//									strSCBTGF_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "SCBTGF", j));//�ճ���������
//									strPXHD_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "PXHD", j));//��ѵ�
									//strPXKC_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXKC", 0));//��ѵ�γ�
									//strCPKS_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "CPKS", 0));//��Ʒ����

//									
									
									   
//									   float bili=0;
//                                     if(strXF_BIAOZHUN!=0.0) 
//                                     {
//                                    	 bili=0;
//                                    	 bili=strXF_SYS/strXF_BIAOZHUN;
//                                    	 bili=bili>2?2:bili;
//									     strXF_SYS= Math.abs(bili*strXF_LV/100) ;
//                                     }else
//                                     {
//                                    	 if(strXF_SYS==0.0)
//                                    	 {//�����׼��=0,  a�����ʵ��Ͷ��Ҳ����0
//                                    		 strXF_SYS=Math.abs(strXF_LV/100);
//                                    	 }else
//                                    	 {//�����׼��=0,  b��ʵ��Ͷ�����
//                                    		 strXF_SYS=Math.abs((1+0.05f)*strXF_LV/100);
//                                    	 }
//                                     }
//                                     if(strKNH_BIAOZHUN!=0.0) 
//                                     {
//                                    	 bili=0;
//                                    	 bili=(strKNH_SYS)/strKNH_BIAOZHUN;
//                                    	 bili=bili>2?2:bili;
//									     strKNH_SYS= Math.abs(bili*strKNH_LV/100);
//                                     }else
//                                     {
//                                    	 if(strKNH_SYS==0.0)
//                                    	 {
//                                    		 strKNH_SYS=Math.abs(strKNH_LV/100);
//                                    	 }else
//                                    	 {
//                                    		 strKNH_SYS=Math.abs((1+0.05f)*strKNH_LV/100);
//                                    	 }
//                                     }
//                                     if(strHD_BIAOZHUN!=0.0) 
//                                     {
//                                    	 bili=0;
//                                    	 bili=(strHD_SYS)/strHD_BIAOZHUN;
//                                    	 bili=bili>2?2:bili;
//									     strHD_SYS= Math.abs(bili*strHD_LV/100);
//                                     }else
//                                     {
//                                    	 if(strHD_SYS==0.0)
//                                    	 {
//                                    		 strHD_SYS=Math.abs(strHD_LV/100);
//                                    	 }else
//                                    	 {
//                                    		 strHD_SYS=Math.abs((1+0.05f)*strHD_LV/100);
//                                    	 }
//                                     }
//                                     if(strXSTGF_BIAOZHUN!=0.0) 
//                                     {
//                                    	 bili=0;
//                                    	 bili=(strXSTGF_SYS)/strXSTGF_BIAOZHUN;
//                                    	 bili=bili>2?2:bili;
//									    strXSTGF_SYS= Math.abs(bili*strXSTGF_LV/100);
//                                     }else
//                                     {
//                                    	 if(strXSTGF_SYS==0.0)
//                                    	 {
//                                    		 strXSTGF_SYS=Math.abs(strXSTGF_LV/100);
//                                    	 }else
//                                    	 {
//                                    		 strXSTGF_SYS=Math.abs((1+0.05f)*strXSTGF_LV/100);
//                                    	 }
//                                     }
//                                     if(strSCBTGF_BIAOZHUN!=0.0) 
//                                     {
//                                    	 bili=0;
//                                    	 bili=(strSCBTGF_SYS)/strSCBTGF_BIAOZHUN;
//                                    	 bili=bili>2?2:bili;
//									     strSCBTGF_SYS= Math.abs(bili*strSCBTGF_LV/100); 
//                                     }else
//                                     {
//                                    	 if(strSCBTGF_SYS==0.0)
//                                    	 {
//                                    		 strSCBTGF_SYS=Math.abs(strSCBTGF_LV/100);
//                                    	 }else
//                                    	 {
//                                    		 strSCBTGF_SYS=Math.abs((1+0.05f)*strSCBTGF_LV/100);
//                                    	 }
//                                     }
//                                     if(strPXHD_BIAOZHUN!=0.0) 
//                                     {
//                                    	 bili=0;
//                                    	 bili=(strPXHD_SYS)/strPXHD_BIAOZHUN;
//                                    	 bili=bili>2?2:bili;
//									     strPXHD_SYS= Math.abs(bili*strPXHD_LV/100); 
//                                     }else
//                                     {
//                                    	 if(strPXHD_SYS==0.0)
//                                    	 {
//                                    		 strPXHD_SYS=Math.abs(strPXHD_LV/100);
//                                    	 }else
//                                    	 {
//                                    		 strPXHD_SYS=Math.abs((1+0.05f)*strPXHD_LV/100);
//                                    	 }
//                                     }
//                                      
//									   allBiLI= Math.abs(strXF_SYS+strKNH_SYS+strHD_SYS+strXSTGF_SYS+strSCBTGF_SYS+strPXHD_SYS) ;
//								

								  allBiLI=	getResult_Bill(   paraList,  rsList,  j);
								  strValue= df.format(  Math.abs(publicDao.NullToDouble(strTarget)*(allBiLI*0.07+1)))+"";
								  // System.out.println( "Ŀ��ֵ��"+strTarget+";Ӱ��ֵ��"+allBiLI+";�����"+strValue+"="+strTarget+"*("+allBiLI+"*007+1)");
							}
								strStatus=" readonly=\"readonly\" style=\"background-color:;width: 70px\" ";
 
//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
							sb.append("<td    style=\"text-align: left; \"> <input  name =\""
								+ strFieldName+strParamID + "\"   id =\""
								+ strFieldName+strParamID + "\"   value=\""
								+ strValue + "\"  "+strStatus+" />"); 
							if("DACL".equals(strFieldName)||"ACH".equals(strFieldName)||"ACH_ALL".equals(strFieldName)||"ABFGL".equals(strFieldName)||"BFJH".equals(strFieldName)||"BFJH_T".equals(strFieldName))
							{
								sb.append("%");
							}
						sb.append("</td>");
					}
						sb.append("</tr>  ");
						sb.append(" <tr style=\"height:1px;background-color: #000;  border:1px #F7F3F7 solid;\"><td colspan=\""+(rsList.size()+1)+"\"></td></tr>");
						
				}
			}
				sbHead.append("</tr>  ");
				request.setAttribute("quYuDaiBiao", strQuYu);
		} 
		return sbHead.toString()+ sb.toString();
	}
	
	/**
	 * ��װ�¶�ҳ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getYue_YuCePageHtml(List rsList, String strPKField, String strParamField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		StringBuilder sbFoot = new StringBuilder(); 
		StringBuilder sbFoot1 = new StringBuilder(); 
		List  paraList=	publicDateDAO.queryParaList(request);

		List listMarket =publicDateDAO.queryMarketList("");
		String strQuYu="";
		if (rsList != null && rsList.size() > 0) 
		{//������
			sbHead.append("<tr   class=\"tableHead\" style=\"height:40px;\">");
			sbHead.append("<td> &nbsp;&nbsp;</td>");
			sbFoot.append("<tr   class=\"\" style=\"height:20px;font-size:12px;\">");
			sbFoot.append("<td  style=\"text-align: right;color: red;\">�Ѿ�����</td>");
			sbFoot1.append("<tr   class=\"\" style=\"height:20px;font-size:12px;\">");
			sbFoot1.append("<td  style=\"text-align: right;color: red;\">������</td>");
			for (int j = 0; j < rsList.size(); j++) 
			{
			    sb.append("<tr class=\"trMoveRow\" >");
				String strParamID=	publicPageDAO.GetFieldValue(rsList, strParamField, j);
				String strTarget=	publicPageDAO.GetFieldValue(rsList, "target", j);
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
						String strPKID=	publicPageDAO.GetFieldValue(rsList, strPKField, j);
						String strMarketName=	publicPageDAO.GetFieldValue(rsList, "MARKETNAME", j);
						String strUserName=	publicPageDAO.GetFieldValue(rsList, "NAME", j);
						int  strValue=publicDao.NullToNumber(  publicPageDAO.GetFieldValue(rsList, strFieldName, j));
						String LASTRESULT=publicDao.NullToStr(  publicPageDAO.GetFieldValue(rsList, "LASTRESULT", j));

					

						int intPara=0;//��Դ����
						float quanZhong=0;//��ԴȨ�ز���
						if(paraList!=null&&paraList.size()>0)
						{
							intPara=publicDao.NullToNumber(  publicPageDAO.GetFieldValue(paraList, publicDao.NullToStr(strFieldName).replace("_LV", ""), 0));//����
							quanZhong=publicDao.NullToFloatr( publicPageDAO.GetFieldValue(paraList, publicDao.NullToStr(strFieldName+"_LV"), 0));//����
						}
						if(i==0)
						{
							strQuYu+=strParamID+",";
							sb.append("<td  class=\"tdFieldLable\" style=\"text-align:left;\"><span class=\"span_style"+(j%2+1)+"\">"+  strUserName+"</span>");
						    sb.append("<div style=\"display:none;\">" );
						   if (listMarket != null && listMarket.size() > 0) 
							{//������

					            for (int m = 0; m < listMarket.size(); m++) 
								{
									String strParamID_1=	publicPageDAO.GetFieldValue(listMarket, strParamField, m);
									if(strParamID_1.equals(strParamID))
									{		
									     String strResource_BiaoZhun[]=publicSourceDAO.strEditBiaoZhun;//��׼ֵ
										  for (int n = 0; n < strResource_BiaoZhun.length; n++)
											{//���ֶ�
												String strFieldNames_BiaoZhun= publicDao.NullToStr(strResource_BiaoZhun[n]);
												String strFieldName_BiaoZhun=publicDao.NullToStr(strFieldNames_BiaoZhun);
												String strFieldCName_BiaoZhun=strFieldNames_BiaoZhun;
												if(strFieldNames_BiaoZhun.split(",").length>1)
												{
													strFieldName_BiaoZhun=strFieldNames_BiaoZhun.split(",")[0];//Ӣ������
													strFieldCName_BiaoZhun=strFieldNames_BiaoZhun.split(",")[1];//��������
													 String	strVs= publicPageDAO.GetFieldValue(listMarket,strFieldName_BiaoZhun, m);//����
													 sb.append("<input  name =\"" +strFieldName_BiaoZhun+ strParamID + "\"   id =\""+strFieldName_BiaoZhun +strParamID + "\"   value=\"" + strVs + "\"  />");
												}
												
											}
									 }
									
								 }
							}
						   sb.append("<input   name =\"LASTRESULT"+  strParamID+ "\"     id =\"LASTRESULT"+  strParamID+"\"   value=\"" + LASTRESULT + "\"  />");
							
							  sb.append("<input  name =\"target_" + strParamID + "\"   id =\"target_" +strParamID + "\"   value=\"" + strTarget + "\"  />");
							sb.append("</div></td>");
						}
						if(j==0)
						{
							
							sbHead.append("<td  style=\"text-align: left;\"  title=\"����Դ��"+intPara+"\"  > "+strFieldCName); 
							sbHead.append("<div style=\"display:none;\">");
							sbHead.append("<input    name =\""+strFieldName+ "PRAM\"   id =\""+strFieldName+ "PRAM\" value=\""+ intPara + "\"    />");
								
							sbHead.append("<input   name =\"ZIYUAN_"+  strFieldName+ "\"     id =\"ZIYUAN_"+  strFieldName+"\"   value=\"" + intPara + "\"  />");
							sbHead.append("<input   name =\"ZIYUAN_"+  strFieldName+ "QZ\"     id =\"ZIYUAN_"+  strFieldName+"QZ\"   value=\"" + quanZhong + "\"  />");
							sbHead.append("</div></td>");
							
							sbFoot.append("<td  style=\"text-align: left;background-color: #ECE9D8;\" id=\"YF_"+strFieldName+"\">0%</td>"); 
							sbFoot1.append("<td  style=\"text-align: left;background-color: #ECE9D8;\" id=\"DF_"+strFieldName+"\">100%</td>"); 
									
						}
	//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
						
	
							sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\">");
							
							sb.append(" <input style=\"width: 60px\"  name =\""+  strFieldName+strParamID + "\"  title=\"����Դ��"+intPara+"\"  id =\"");
							sb.append( strFieldName+strParamID + "\"   value=\""
								+ strValue + "\"   onblur=\"checkIsNum(this);stringLengthCheck(this,'20','����Ľ�����ܳ���20���ַ���');setPageVsOne('"+strParamID+"');setBili('"+strFieldName+"');\"/>"); 
						 	// sb.append("%");
					 sb.append("</td>");
				}
			}

			sb.append("<td  class=\"tdFieldInput\" style=\"text-align: left;\" id=\""+strParamID+"FP\">0%</td>");
			sb.append("</tr>  ");
		 }

		sbHead.append("<td  style=\"text-align: left;\">������<br>��Դ����</td>"); 
		sbHead.append("</tr>  ");
		sbFoot.append("<td  style=\"text-align: left;\" id=\"YP\"  ></td>"); 
		sbFoot.append("</tr>  "); 
		sbFoot1.append("<td  style=\"text-align: left;\"  id=\"DP\"  ></td>"); 
		sbFoot1.append("</tr>  ");
		} 
		request.setAttribute("quYuDaiBiao", strQuYu);
	    sb.append(sbFoot.toString());
		sb.append(sbFoot1.toString());	
		return sbHead.toString()+ sb.toString();
	}
	

	/**
	 * ��װҳ���ؽ��
	 * @param rsList  ����
	 * @param strPKField ����ID
	 * @param strResource  ��Ҫ�������ֶ�
	 * @param strPre  tdǰ�������
	 * @param strEnd   td�����������
	 * @return  ���ؽ��
	 */
	public   String getJianKongJieGuoPageHtml(List rsList, String strPKField, String strParamField ,boolean isNext) {
		List<String> MONTH_LIST = Arrays.asList("Jan", "Feb", "Mar",  
				   "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");  
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbHead = new StringBuilder(); 
		 StringBuilder sbDaCLv = new StringBuilder(); //�����
		 StringBuilder sbMuBiao = new StringBuilder(); //Ŀ��
		  StringBuilder sbKPI = new StringBuilder(); //Ŀ��
			int intYear = publicDao.getCurrentDateYear(0);// 
			int intMonth = publicDao.getCurrentDateMonth(0); 
			int intYear_pre = publicDao.getCurrentDateYear(0);// 
			int intMonth_pre = publicDao.getCurrentDateMonth(0); 
//		List  paraList=	publicDateDAO.queryParaList();

			List listMarket =publicDateDAO.queryMarketList("");
		int  EndVs=2;
		int count=5;//�·��ܸ���
		if(isNext)
		{//���¸���
			EndVs=3;
			count=6;
		}
		
		   DecimalFormat df = new DecimalFormat("0.0"); 
			List  paraList=	publicDateDAO.queryParaList(request);
//			float strXF=0;
//		    float strKNH=0;
//		    float strHD=0;
//		    float strXSTGF=0;
//		    float strSCBTGF=0;
//		    float strPXHD=0;
//		    float strPXKC=0;
//		    float strCPKS=0;
//		    
//		    
//			float strXF_LV=0;
//		    float strKNH_LV=0;
//		    float strHD_LV=0;
//		    float strXSTGF_LV=0;
//		    float strSCBTGF_LV=0;
//		    float strPXHD_LV=0;
//		    float strPXKC_LV=0;
//		    float strCPKS_LV=0;
//		    
//
//			float strXF_BIAOZHUN=0;
//		    float strKNH_BIAOZHUN=0;
//		    float strHD_BIAOZHUN=0;
//		    float strXSTGF_BIAOZHUN=0;
//		    float strSCBTGF_BIAOZHUN=0;
//		    float strPXHD_BIAOZHUN=0;
//		    float strPXKC_BIAOZHUN=0;
//		    float strCPKS_BIAOZHUN=0;
//
//		   float strXF_SYS=0;
//		   float strKNH_SYS=0;
//		   float strHD_SYS=0;
//		   float strXSTGF_SYS=0;
//		   float strSCBTGF_SYS=0;
//		   float strPXHD_SYS=0;
//		    float strPXKC_SYS=0;
//		    float strCPKS_SYS=0;
		    
		   
		   float allBiLI=0; 
	 
		
		if (rsList != null && rsList.size() > 0) 
		{//������
			String []  strDaCShu= new String [rsList.size()];

			 sb.append("   <colgroup><col width=\"80px\" /> ");
			for (int j = 0; j < rsList.size(); j++) 
			{ 
				 sb.append("   <col width=\"80px\" /> "); 
			} 
			 sb.append("  <col width=\"120px\" />  </colgroup>");
		

			 sbDaCLv.append("<tr   class=\"tdFieldLable\"  >");
			 sbDaCLv.append("<td> �����</td>");

			 sbKPI.append("<tr   class=\"tdFieldLable\" style=\"display:none\" >");
			 sbKPI.append("<td>ָ�����</td>");
			 
			

			intYear_pre=publicDao.getCurrentDateYear(EndVs-2);
			intMonth_pre = publicDao.getCurrentDateMonth(EndVs-2);
			List listSys_pre =publicDateDAO.querySysList_new(intYear_pre,intMonth_pre,request);
			
			for(int i=0;i<EndVs;i++)
			{//���ֶ� 
				intYear=publicDao.getCurrentDateYear(i);
				intMonth = publicDao.getCurrentDateMonth(i);
                 String strYear=publicDao.NullToStr(intYear);
						sb.append("<tr   >");

						List listSys =publicDateDAO.querySysList_new(intYear,intMonth,request);
						if(i==0)
						{
							sbHead.append("<tr   >");
							sbHead.append("<td> &nbsp;&nbsp;</td>");
							for (int j = 0; j < listSys.size(); j++) 
							{
								String strUserName=	publicPageDAO.GetFieldValue(listSys, "NAME", j);
								sbHead.append("<td  style=\"text-align: left;\"> "+strUserName+"");
								sbHead.append("</td>");
							}
							sbHead.append("<td  style=\"text-align: left;\"> ҽԺ�ܼ�");
							sbHead.append("</td>");
							sbHead.append("</tr>  ");
						}
						
						Double  CountResult_Target=0D;//����Ŀ��
						Double  CountResult_Pre=0D;//�������۽��
						Double  CountResult=0D;//���۽��
						Double  CountKPI=0D;//ָ�����
							//float  CountResult_1=0.0f;
							for (int j = 0; j < listSys.size(); j++) 
							{ 
								float  CountXingDongYX=0;//�ж�Ӱ��
								Double mubiao=0D;
							  String strParamID=	publicPageDAO.GetFieldValue(listSys, strParamField, j); 
							 
							  Double dbRESULT=publicDao.NullToDouble(publicPageDAO.GetFieldValue(listSys, "RESULT", j));//���۽��
							  Double intTarget=publicDao.NullToDouble(	publicPageDAO.GetFieldValue(listSys, "target", j));//����ֵ
							  
							  Double COMPANYKPI=publicDao.NullToDouble(publicDao.DecimalFormat_OBJ(    intTarget/0.8));//����Ԥ��
							  Double  dbPreResult=0d;
							  if (listSys_pre != null && rsList.size() == listSys_pre.size()) 
								{
							           dbPreResult=publicDao.NullToDouble(	publicPageDAO.GetFieldValue(listSys_pre, "RESULT", j));//�������۽��
								}
							  Double LASTRESULT=publicDao.NullToDouble(publicPageDAO.GetFieldValue(listSys, "LASTRESULT", j));//��Դ��Ӱ��
//							  ACTIONPLAN1,�ж�����ƻ�1
							  String intACTIONPLAN1= publicPageDAO.GetFieldValue(listSys, "ACTIONPLAN1", j);
							  String intACTIONPLAN2= publicPageDAO.GetFieldValue(listSys, "ACTIONPLAN2", j);
							  String intACTIONPLAN3= publicPageDAO.GetFieldValue(listSys, "ACTIONPLAN3", j);
							  
							  String ORDER1=	publicPageDAO.GetFieldValue(listSys, "ORDER1", j);
							  String ORDER2=	publicPageDAO.GetFieldValue(listSys, "ORDER2", j);
							  String ORDER3=	publicPageDAO.GetFieldValue(listSys, "ORDER3", j);
							  String ORDER4=	publicPageDAO.GetFieldValue(listSys, "ORDER4", j);
							  String ORDER5=	publicPageDAO.GetFieldValue(listSys, "ORDER5", j);
//						      if(intACTIONPLAN1.equals(ORDER1)&&intACTIONPLAN2.equals(ORDER2))
//						      {//��Ҫ����Ҫ�ж���Ŀ��ѡ����ȷ��˳����ȷ����Ӱ��+10%��
//						    	  CountXingDongYX+=0.1f;
//						      }else
//						      {
//						    	  //��Ҫ�ж�����Ŀ��ѡ�񣬵�δ��������λ�������ڴ�λӰ��+3%��������3-5λӰ��+2%��
//						    	  if(intACTIONPLAN1.equals(ORDER2))
//						    	  {
//						    		  CountXingDongYX+=0.03f;
//						    	  } 
//						    	  if(intACTIONPLAN1.equals(ORDER3)||intACTIONPLAN1.equals(ORDER4)||intACTIONPLAN1.equals(ORDER5))
//						    	  {
//						    		  CountXingDongYX+=0.02f;
//						    	  } 
//						    	  //��Ҫ�ж�����Ŀ��ѡ�񣬵�δ�����ڴ�λ����������λӰ��+3%��������3-5λӰ��+2%��
//						    	  if(intACTIONPLAN2.equals(ORDER1))
//						    	  {
//
//						    		  CountXingDongYX+=0.03f;
//						    	  }
//						    	  if(intACTIONPLAN2.equals(ORDER3)||intACTIONPLAN2.equals(ORDER4)||intACTIONPLAN2.equals(ORDER5))
//						    	  {
//						    		  CountXingDongYX+=0.02f;
//						    	  } 
//						      }
							  CountKPI+=COMPANYKPI;
							  CountResult+=dbRESULT;
							  CountResult_Target+=intTarget;
							  CountResult_Pre+=dbPreResult;
//							  if(dbRESULT<intResult-200000)
//							  {//���۽�����Ԥ�� ������
//								  strDaCShu[k]=""+(publicDao.NullToNumber(strDaCShu[k])+1);
//							  }
							 
							if(j==0)
							{//������
								sb.append("<td   class=\"tdFieldLable\" >"+MONTH_LIST.get(intMonth-1)+"-"+strYear.substring(strYear.length()-2,strYear.length()));
								
								sb.append("</td>");
							}
//							//sb.append("<td  class=\"tdFieldLable\">"+strFieldCName+"</td>");
							 
								if(1!=i&&2!=i)
								{
									String  strAtt="";
									if(( !isNext&&0==i))
									{//���¼���·ݵ���һ����
										 strAtt=" preResult=\""+dbPreResult+"\"    id=\"preResult"+strParamID+"\" ";
										
									}
									sb.append("<td   style=\"text-align: left;background-color: #ECE9D8;\"  "+strAtt+"    > " );
									sb.append("<div style=\"display:none;\">");
									
									String PXHD=	publicPageDAO.GetFieldValue(rsList, "PXHD", j);//������Դ����ٷֱȽ��
									sb.append("<input    name =\"PXHD"+strParamID + "\"   id =\"PXHD"+strParamID + "\"   value=\""+ PXHD + "\"    />");
																
									sb.append("<input  name =\"COMPANYKPI" + strParamID  + "\"   id =\"COMPANYKPI" +strParamID  + "\"   value=\"" +COMPANYKPI+ "\"  /></div>");
										
									sb.append(  dbRESULT +"" );
								}else
								{
									if((isNext&&2==i)||( !isNext&&1==i))
									{//���һ����
									   sb.append("<td   style=\"text-align: left;background-color: #ECE9D8;\"  id=\"JISHU_"+strParamID+"\"> " ); //����·��ϸ��µ����۽��
									   
//									    strXF_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "XF", k));//Э��(����)
//										strKNH_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "KNH", k));//���һ�(����)
//										strHD_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "HD", k));//�(����)
//										strXSTGF_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "XSTGF", k));//�����ƹ����
//										strSCBTGF_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "SCBTGF", k));//�ճ���������
//										strPXHD_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(rsList, "SCBTGF", k));//��ѵ�
										//strPXKC_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "PXKC", 0));//��ѵ�γ�
										//strCPKS_SYS=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(paraList, "CPKS", 0));//��Ʒ����


//										��ʽ��IF(N56>0,MIN(N46/N56,$N$63)*$N$54,IF(N46=0,1,(1+$N$64))*$N$54) �ĺ����У�
//										1�������׼��>0��ȡ ʵ��ֵ�±�׼�𰸡�Ȩ�أ�ͬʱ����� ʵ��ֵ�±�׼��>2, �� ʵ��ֵ�±�׼�𰸣�2
//										2�������׼��=0,  a�����ʵ��Ͷ��Ҳ����0�� ȡ 100����Ȩ�أ�b�����ʵ��Ͷ�����0��ȡ��1��5������Ȩ��
//										   float bili=0;
//	                                     if(strXF_BIAOZHUN!=0.0) 
//	                                     {
//	                                    	 bili=0;
//	                                    	 bili=strXF_SYS/strXF_BIAOZHUN;
//	                                    	 bili=bili>2?2:bili;
//										     strXF_SYS= Math.abs(bili*strXF_LV/100) ;
//	                                     }else
//	                                     {
//	                                    	 if(strXF_SYS==0)
//	                                    	 {//�����׼��=0,  a�����ʵ��Ͷ��Ҳ����0
//	                                    		 strXF_SYS=Math.abs(strXF_LV/100);
//	                                    	 }else
//	                                    	 {//�����׼��=0,  b��ʵ��Ͷ�����
//	                                    		 strXF_SYS=Math.abs((1+0.05f)*strXF_LV/100);
//	                                    	 }
//	                                     }
//	                                     if(strKNH_BIAOZHUN!=0.0) 
//	                                     {
//	                                    	 bili=0;
//	                                    	 bili=(strKNH_SYS)/strKNH_BIAOZHUN;
//	                                    	 bili=bili>2?2:bili;
//										     strKNH_SYS= Math.abs(bili*strKNH_LV/100);
//	                                     }else
//	                                     {
//	                                    	 if(strXF_SYS==0)
//	                                    	 {
//	                                    		 strKNH_SYS=Math.abs(strKNH_LV/100);
//	                                    	 }else
//	                                    	 {
//	                                    		 strKNH_SYS=Math.abs((1+0.05f)*strKNH_LV/100);
//	                                    	 }
//	                                     }
//	                                     if(strHD_BIAOZHUN!=0.0) 
//	                                     {
//	                                    	 bili=0;
//	                                    	 bili=(strHD_SYS)/strHD_BIAOZHUN;
//	                                    	 bili=bili>2?2:bili;
//										     strHD_SYS= Math.abs(bili*strHD_LV/100);
//	                                     }else
//	                                     {
//	                                    	 if(strXF_SYS==0)
//	                                    	 {
//	                                    		 strHD_SYS=Math.abs(strHD_LV/100);
//	                                    	 }else
//	                                    	 {
//	                                    		 strHD_SYS=Math.abs((1+0.05f)*strHD_LV/100);
//	                                    	 }
//	                                     }
//	                                     if(strXSTGF_BIAOZHUN!=0.0) 
//	                                     {
//	                                    	 bili=0;
//	                                    	 bili=(strXSTGF_SYS)/strXSTGF_BIAOZHUN;
//	                                    	 bili=bili>2?2:bili;
//										    strXSTGF_SYS= Math.abs(bili*strXSTGF_LV/100);
//	                                     }else
//	                                     {
//	                                    	 if(strXF_SYS==0)
//	                                    	 {
//	                                    		 strXSTGF_SYS=Math.abs(strXSTGF_LV/100);
//	                                    	 }else
//	                                    	 {
//	                                    		 strXSTGF_SYS=Math.abs((1+0.05f)*strXSTGF_LV/100);
//	                                    	 }
//	                                     }
//	                                     if(strSCBTGF_BIAOZHUN!=0.0) 
//	                                     {
//	                                    	 bili=0;
//	                                    	 bili=(strSCBTGF_SYS)/strSCBTGF_BIAOZHUN;
//	                                    	 bili=bili>2?2:bili;
//										     strSCBTGF_SYS= Math.abs(bili*strSCBTGF_LV/100); 
//	                                     }else
//	                                     {
//	                                    	 if(strXF_SYS==0)
//	                                    	 {
//	                                    		 strSCBTGF_SYS=Math.abs(strSCBTGF_LV/100);
//	                                    	 }else
//	                                    	 {
//	                                    		 strSCBTGF_SYS=Math.abs((1+0.05f)*strSCBTGF_LV/100);
//	                                    	 }
//	                                     }
//	                                     if(strPXHD_BIAOZHUN!=0.0) 
//	                                     {
//	                                    	 bili=0;
//	                                    	 bili=(strPXHD_SYS)/strPXHD_BIAOZHUN;
//	                                    	 bili=bili>2?2:bili;
//										     strPXHD_SYS= Math.abs(bili*strPXHD_LV/100); 
//	                                     }else
//	                                     {
//	                                    	 if(strXF_SYS==0)
//	                                    	 {
//	                                    		 strPXHD_SYS=Math.abs(strPXHD_LV/100);
//	                                    	 }else
//	                                    	 {
//	                                    		 strPXHD_SYS=Math.abs((1+0.05f)*strPXHD_LV/100);
//	                                    	 }
//	                                     }
//	                                      
//										   allBiLI=Math.abs( strXF_SYS+strKNH_SYS+strHD_SYS+strXSTGF_SYS+strSCBTGF_SYS+strPXHD_SYS) ;

//										allBiLI=	getResult_Bill(   paraList,  rsList,  j);  
//									    dbPreResult=   Math.abs(dbPreResult  *	(allBiLI*0.07+1) ) ;
//									     sb.append(  df.format( dbPreResult) );
									}else
									{
										String  strAtt="";
										if((isNext&&1==i) )
										{//���¼���·ݵ���һ����
											 strAtt=" preResult=\""+dbPreResult+"\"  KPI=\""+COMPANYKPI+"\"  id=\"preResult"+strParamID+"\"  ";
										}
										  sb.append("<td   style=\"text-align: left;background-color: #ECE9D8;\"  "+strAtt+"     > " ); 
										  sb.append(  dbRESULT +"");//���¼�ص����۽��
									}
									 
								}
								 
							    sb.append("</td>");
                              
							 if(EndVs-i==1)
							 {//����ʵļ���  ������һ��
								 if(j==0)
								 {
									 sbMuBiao.append("<tr><td   class=\"tdFieldLable\" >"+MONTH_LIST.get(intMonth-1)+"-"+strYear.substring(strYear.length()-2,strYear.length())+"Ŀ�꣺");
									  
									 sbMuBiao.append("</td>");
								 } 
									sbMuBiao.append("<td     style=\"text-align: left;background-color: #ECE9D8;\" id=\"TARGET_"+strParamID+"\"   >");
									sbMuBiao.append(new BigDecimal(COMPANYKPI).setScale(1, BigDecimal.ROUND_HALF_UP));
									sbMuBiao.append("</td>");
									
									 sbKPI.append("<td  style=\"text-align: left;background-color: #ECE9D8;\"  id=\"KPI_"+strParamID+"\"    >");//+new BigDecimal(CountResult_1).setScale(1, BigDecimal.ROUND_HALF_UP)/5+"%"
									
									 sbKPI.append(COMPANYKPI +"");
									 sbKPI.append("</td>");

									 sbDaCLv.append("<td  style=\"text-align: left;background-color: #ECE9D8;\"  id=\"DACLV_"+strParamID+"\">");//+new BigDecimal(CountResult_1).setScale(1, BigDecimal.ROUND_HALF_UP)/5+"%"
									// sbDaCLv.append( new BigDecimal(COMPANYKPI).setScale(1, BigDecimal.ROUND_HALF_UP) +"%");
									 sbDaCLv.append("</td>");
									 
							  }
								if(j==listSys_pre.size()-1)
								{//���ܺͼ���

									if( 2!=i&& 1!=i)
									{
										sb.append("<td   style=\"text-align: left;background-color: #ECE9D8;\"     > " ); 
										sb.append(   PublicMethod.DecimalFormat_OBJ(CountResult,"0.0") );
									}else
									{
										if((isNext&&2==i)||( !isNext&&1==i))
										{//���һ����   ��
										    sb.append("<td   style=\"text-align: left;background-color: #ECE9D8;\"   id=\"Last_All\"  > " ); 
										   
										   //  sb.append( df.format( 	CountResult_Pre)+"");
										}else
										{// ���¼��   2�����ۺ� 
											sb.append("<td   style=\"text-align: left;background-color: #ECE9D8;\"     >" ); 
											sb.append(PublicMethod.DecimalFormat_OBJ(  	CountResult,"0.0"));
										}
									}
								    sb.append("</td>");
								    if(EndVs-i==1)
									 {  sbMuBiao.append("<td   style=\"text-align: left;background-color: #ECE9D8;\"   id=\"Count"+strParamID+"\"> " ); 
								        sbMuBiao.append(  CountKPI );
								        sbMuBiao.append("</td>");

										 sbDaCLv.append("<td  style=\"text-align: left;background-color: #ECE9D8;\" id=\"DACLV_COUNT\" > ");//+new BigDecimal(CountResult_1).setScale(1, BigDecimal.ROUND_HALF_UP)/5+"%"
										// sbDaCLv.append(CountKPI);
										  sbDaCLv.append("</td>");
										  

										  sbKPI.append("<td  style=\"text-align: left;background-color: #ECE9D8;\" >");//+new BigDecimal(CountResult_1).setScale(1, BigDecimal.ROUND_HALF_UP)/5+"%"
										 sbKPI.append(CountKPI);
										 sbKPI.append("</td>");
									 }

								}
						//sb.append(" <tr style=\"height:1px;background-color: #000;  border:1px #F7F3F7 solid;\"><td colspan=\""+(rsList.size()+1)+"\"></td></tr>");
				       }
				 sb.append("</tr>  ");
			}

		 	sbDaCLv.append("</tr>  "); 
			sbMuBiao.append("</tr>  ");
			
		request.setAttribute("strDaCShu", strDaCShu) ;
			
		} 
		return sbHead.toString()+ sb.toString()+sbMuBiao.toString()+sbKPI.toString()+sbDaCLv.toString();//
	}
	
	/**
	 * �����ж��ƻ�����
	 * 
	 * @return
	 */
	public String saveXingDongOrder() {

		String strType =publicDao.NullToStr(  request.getParameter("type"));
		List listSys = publicDateDAO.querySysList(request);
		String[] strSaveField={"ORDER1","ORDER2","ORDER3","ORDER4","ORDER5" };
		publicPageDAO.savePageValue(listSys,"N_MARKETANALYSIS", "RESOURCEID","masterid",
				strSaveField, request,0);
		 if("1".equals(strType))
		 {//���¼��
			 request.setAttribute("message", " alert('����ɹ���');  window.close(); window.location.href='queryNextYueFen_JianKong.action?type=1';");
				
		 }else{
		    request.setAttribute("message", " alert('����ɹ���');  window.close(); window.location.href='queryYueFen_JianKong.action';");
		
		 }
		return returnDfault;

	}
	
	public float  getResult_Bill(List  paraList,List rsList,int j)
	{
		float Result_Bill=0 ;
		  String strZiYuan[]=publicSourceDAO.strZiYuan;
		  String name=  publicPageDAO.GetFieldValue(rsList,"name", j);
		  for (int z = 0; z < strZiYuan.length; z++)
			{//���ֶ�
				String strFieldNames_ZiYuan = publicDao.NullToStr(strZiYuan[z]);
				String strFieldName_ZiYuan=publicDao.NullToStr(strFieldNames_ZiYuan);
				String strFieldCName_ZiYuan="";
				//String strFieldCName_ZiYuan=strFieldNames_ZiYuan;
				if(strFieldNames_ZiYuan.split(",").length>1)
				{
					strFieldName_ZiYuan=strFieldNames_ZiYuan.split(",")[0];//Ӣ������
					 strFieldCName_ZiYuan=strFieldNames_ZiYuan.split(",")[1];//��������
				}
				//��ǰ����ֵ
				float	strVs_SYS=PublicMethod.NullToFloatr(  publicPageDAO.GetFieldValue(rsList,strFieldName_ZiYuan, j));//��׼
				 //��׼ֵ
				float	strVs_BIAOZHUN=PublicMethod.NullToFloatr(  publicPageDAO.GetFieldValue(rsList,strFieldName_ZiYuan+"_BIAOZHUN ", j));//��׼
				 //Ȩ��
				float	strVs_LV= PublicMethod.NullToFloatr( publicPageDAO.GetFieldValue(paraList,strFieldName_ZiYuan+"_LV", 0));//Ȩ��
//				��ʽ��IF(N56>0,MIN(N46/N56,$N$63)*$N$54,IF(N46=0,1,(1+$N$64))*$N$54) �ĺ����У�
//				1�������׼��>0��ȡ ʵ��ֵ�±�׼�𰸡�Ȩ�أ�ͬʱ����� ʵ��ֵ�±�׼��>2, �� ʵ��ֵ�±�׼�𰸣�2
//				2�������׼��=0,  a�����ʵ��Ͷ��Ҳ����0�� ȡ 100����Ȩ�أ�b�����ʵ��Ͷ�����0��ȡ��1��5������Ȩ��
				   float bili=0;
				   float reult=0;
				if(strVs_BIAOZHUN!=0.0) 
                 {
                	 bili=0;
                	 bili=strVs_SYS/strVs_BIAOZHUN;
                	 bili=bili>2?2:bili;
                	 reult= Math.abs(bili*strVs_LV/100) ;
                 }else
                 {
                	 if(strVs_SYS==0.0)
                	 {//�����׼��=0,  a�����ʵ��Ͷ��Ҳ����0
                		 reult=Math.abs(strVs_LV/100);
                	 }else
                	 {//�����׼��=0,  b��ʵ��Ͷ�����
                		 reult=Math.abs((1+0.05f)*strVs_LV/100);
                	 }
                 } 
				  System.out.println(name+" "+strFieldCName_ZiYuan+"  ��Դ����ֵ��"+strVs_SYS+";��׼ֵ��"+strVs_BIAOZHUN+";Ȩ��ֵ��"+strVs_LV+";���ֵ��"+reult);
				Result_Bill+=reult;
	    }
		  System.out.println("��ֵ��"+Result_Bill);
		  return Result_Bill;
	}
	public String   updateBiaoZhun(int intYear,int intMonth,HttpServletRequest request)
	{
	    List rsList=	publicDateDAO.querySysList(intYear, intMonth, request);
		List  paraList=	publicDateDAO.queryParaList(request);
		
		  String strZiYuan[]=publicSourceDAO.strZiYuan;
		  for (int j = 0; j <  rsList.size(); j++) 
			{
			  float Result_Bill=0 ;
			  String whole="";
			    String RESOURCEID=PublicMethod.NullToStr(  publicPageDAO.GetFieldValue(rsList,"RESOURCEID", j));//
				  for (int z = 0; z < strZiYuan.length; z++)
					{//���ֶ�
						String strFieldNames_ZiYuan = publicDao.NullToStr(strZiYuan[z]);
						String strFieldName_ZiYuan=publicDao.NullToStr(strFieldNames_ZiYuan);
						//String strFieldCName_ZiYuan=strFieldNames_ZiYuan;
						if(strFieldNames_ZiYuan.split(",").length>1)
						{
							strFieldName_ZiYuan=strFieldNames_ZiYuan.split(",")[0];//Ӣ������
							//strFieldCName_ZiYuan=strFieldNames_ZiYuan.split(",")[1];//��������
						}
						//��ǰ����ֵ
						float	strVs_Pra=PublicMethod.NullToFloatr(  publicPageDAO.GetFieldValue(paraList,strFieldName_ZiYuan, 0));//��׼
						//��ǰ����ֵ
						float	strVs_SYS=PublicMethod.NullToFloatr(  publicPageDAO.GetFieldValue(rsList,strFieldName_ZiYuan, j));//��׼
						 //��׼ֵ
						float	strVs_BIAOZHUN=PublicMethod.NullToFloatr(  publicPageDAO.GetFieldValue(rsList,strFieldName_ZiYuan+"_BIAOZHUN ", j));//��׼
						 //Ȩ��
						float	strVs_LV= PublicMethod.NullToFloatr( publicPageDAO.GetFieldValue(paraList,strFieldName_ZiYuan+"_LV", 0));//Ȩ��
		//				��ʽ��IF(N56>0,MIN(N46/N56,$N$63)*$N$54,IF(N46=0,1,(1+$N$64))*$N$54) �ĺ����У�
		//				1�������׼��>0��ȡ ʵ��ֵ�±�׼�𰸡�Ȩ�أ�ͬʱ����� ʵ��ֵ�±�׼��>2, �� ʵ��ֵ�±�׼�𰸣�2
		//				2�������׼��=0,  a�����ʵ��Ͷ��Ҳ����0�� ȡ 100����Ȩ�أ�b�����ʵ��Ͷ�����0��ȡ��1��5������Ȩ��
						   float bili_1=0;
						   float bili_2=0;
						  
						if(strVs_Pra!=0.0) 
		                 {
		                	 bili_1=0;
		                	 bili_1=strVs_BIAOZHUN/ strVs_Pra; 
		                	 bili_2=strVs_SYS/ strVs_Pra; 
		                 }else
		                 {
 
		                	 bili_1=0;
		                	 bili_2=0;
		                 } 
						Result_Bill+=(bili_1-bili_2);
			    }
				  System.out.println(PublicMethod.DecimalFormat_OBJ(  Math.abs( Result_Bill/5*100), "0.0")  +"ddddddddd");
				  String strUpdateSql="update  N_MARKETANALYSIS set SALESUM='"+PublicMethod.DecimalFormat_OBJ(  Math.abs( Result_Bill/5*100), "0.0")  +"'  where  RESOURCEID='"+RESOURCEID+"' ";
				  sqlDao.insertWithSql(strUpdateSql);
			}
		  return "";
	}
	
	public  void  getBiaoZhun(List  listMarket,String strParamID,String strParamField,int k)
	{
		
		//��Դ
		 //��׼ֵ
			if (listMarket != null && listMarket.size() > 0) 
			{//������

	            for (int n = 0; n < listMarket.size(); n++) 
				{
					String strParamID_1=	publicPageDAO.GetFieldValue(listMarket, strParamField, n);
					if(strParamID_1.equals(strParamID))
					{

//						strXF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(listMarket, "XF_BIAOZHUN", k));//Э��(����)
//						strKNH_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(listMarket, "KNH_BIAOZHUN", k));//���һ�(����)
//						strHD_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(listMarket, "HD_BIAOZHUN", k));//�(����)
//						strXSTGF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(listMarket, "XSTGF_BIAOZHUN", k));//�����ƹ����
//						strSCBTGF_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(listMarket, "SCBTGF_BIAOZHUN", k));//�ճ���������
//						strPXHD_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(listMarket, "PXHD_BIAOZHUN", k));//��ѵ�
						//strPXKC_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(listMarket, "PXKC_BIAOZHUN", 0));//��ѵ�γ�
						//strCPKS_BIAOZHUN=publicDao.NullToFloatr(publicPageDAO.GetFieldValue(listMarket, "CPKS_BIAOZHUN", 0));//��Ʒ����
						
						break;
					}
				}
			}
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
