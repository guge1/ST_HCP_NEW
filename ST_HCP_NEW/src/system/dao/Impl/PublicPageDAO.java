package system.dao.Impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import system.dao.IPublicDAO;
import system.dao.ISqlDAO;
import system.publicClass.PublicMethod;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial","unchecked"})
public class PublicPageDAO extends ActionSupport implements ServletRequestAware  {

	private HttpServletRequest request = null;
	private IPublicDAO publicDao = null;
	  private ISqlDAO  sqlDao=null;
	public IPublicDAO getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(IPublicDAO publicDao) {
		this.publicDao = publicDao;
	}


	private PublicDateDAO publicDateDAO=null;
	public PublicDateDAO getPublicDateDAO() {
		return publicDateDAO;
	}

	public void setPublicDateDAO(PublicDateDAO publicDateDAO) {
		this.publicDateDAO = publicDateDAO;
	}
	public ISqlDAO getSqlDao() {
		return sqlDao;
	}

	public void setSqlDao(ISqlDAO sqlDao) {
		this.sqlDao = sqlDao;
	}

	/**
	 * 将 页面信息  解析到页面
	 * @param rsList  数据
	 * @param strPKField 主键ID
	 * @param strResource  需要解析的字段
	 * @param strPre  td前面的内容
	 * @param strEnd   td后面面的内容
	 * @return  返回结果
	 */
	public   String getPageHtml(List rsList, String strPKField,String[]  strResource,String strPre, String strEnd) {
		StringBuilder sb = new StringBuilder(); 
		if (rsList != null && rsList.size() > 0) 
		{
			for (int j = 0; j < rsList.size(); j++) 
			{
				String strPKID=	GetFieldValue(rsList, strPKField, j);
				for (int i = 0; i < strResource.length; i++) {
					String strFieldName = NullToStr(strResource[i]);
					if(strFieldName.split(",").length>1)
					{
						strFieldName=strFieldName.split(",")[0];
					}
					if (!"".equals(strFieldName))
					{
						sb.append("<td>" + strPre
								+ "<input style=\"width: 60px\"  name =\""
								+ strFieldName + "\"   id =\""
								+ strFieldName + "\"   value=\""
								+ GetFieldValue(rsList, strFieldName, j)
								+ "\" />" + strPre + " ");
						
						if(i==0)
						{
//						 sb.append("<input type=\"hidden\"  name =\""+ strPKField+strPKID + "\"   id =\""+ strPKField+strPKID + "\"   value=\""+ strPKID
//								+ "\" />");
						
						}
						sb.append("</td>");
					}
				}
			}
		}else
		{ 
			for (int i = 0; i < strResource.length; i++) {
				String strFieldName = NullToStr(strResource[i]);
				if (!"".equals(strFieldName))
				{
					sb.append("<td>" + strPre + "<input style=\"width: 60px\"  name =\""+ strFieldName + "\"   id =\""+ strFieldName + "\"  value=\"\" />" + strPre + "</td>");
				}
			}
			
		}
		return sb.toString();
	}

	/**
	 * 设置页面的值
	 * @param rsList
	 * @param strPKField
	 * @param strResource
	 * @return
	 */
	public   String setPageValue(List rsList, String strPKField,String[]  strResource) {
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sbPKID = new StringBuilder(); 
		if (rsList != null && rsList.size() > 0) 
		{
			sb.append("<script>");
			for (int j = 0; j < rsList.size(); j++) 
			{
				sbPKID.append("<input type=\"hidden\"  name =\""+ strPKField +GetFieldValue(rsList, strPKField, j)+ "\"   id =\""+ strPKField  +GetFieldValue(rsList, strPKField, j)+ "\"   value=\""+ GetFieldValue(rsList, strPKField, j)
						+ "\" />");
				for (int i = 0; i < strResource.length; i++) {
					String strFieldNames = NullToStr(strResource[i]);
					String strFieldName=strFieldNames;
					if(strFieldName.split(",").length>1)
					{
						 strFieldName=strFieldNames.split(",")[0];//英文名称
						  //strFieldCName=strFieldNames.split(",")[1];//中午名称
					}
					if (!"".equals(strFieldName))
					{
						sb.append("try{ document.getElementsByName(\""+strFieldName+"\")[0].value='"+GetFieldValue(rsList, strFieldName, j)+"';}catch(e){}");
						sb.append(" try{document.getElementById(\""+strFieldName+"\").value='"+GetFieldValue(rsList, strFieldName, j)+"';  }catch(e){}");
						sb.append(" try{document.getElementById(\""+strFieldName+"\").innerHTML='"+GetFieldValue(rsList, strFieldName, j)+"'; }catch(e){}");
					}
				}
			}
			sb.append("</script>");
		} 
		return sbPKID.toString()+sb.toString();
	}

	

	/**
	 * 设置页面的值
	 * @param rsList
	 * @param strPKField
	 * @param strResource
	 * @return
	 */
	public   void setFiledArribute(List rsList, String strPKField,String[]  strResource,HttpServletRequest request) {
		StringBuilder sbPKID = new StringBuilder(); 
		if (rsList != null && rsList.size() > 0) 
		{ 
			for (int j = 0; j < rsList.size(); j++) 
			{ 
				for (int i = 0; i < strResource.length; i++) {
					String strFieldNames = NullToStr(strResource[i]);
					String strFieldName=strFieldNames;
					if(strFieldName.split(",").length>1)
					{
						 strFieldName=strFieldNames.split(",")[0];//英文名称
						  //strFieldCName=strFieldNames.split(",")[1];//中午名称
					}
					if (!"".equals(strFieldName))
					{
						String strVs=GetFieldValue(rsList, strFieldName, j);
						request.setAttribute(strFieldName, strVs);
					 }
				}
			} 
		}  
	}

	/**
	 * 保存页面数据
	 * @param rsList
	 * @param strTableName
	 * @param strPKField
	 * @param strResource
	 * @param request
	 * @return
	 */
	public   String savePageValue(List rsList,String strTableName,  String strPKField, String strParamField,String[]  strResource,HttpServletRequest request,int intAdd) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strPKIDS="";
		StringBuilder sb = new StringBuilder(); 
		if (rsList != null && rsList.size() > 0) 
		{
			for (int j = 0; j < rsList.size(); j++) 
			{
				sb = new StringBuilder();
				String strPKID=	 GetFieldValue(rsList, strPKField, j);
				String strParam="";
				 
					for (int i = 0; i < strParamField.split(",").length; i++)
					{
					   String strParaFieldName = NullToStr(strParamField.split(",")[i]);
					  strParam=strParam+GetFieldValue(rsList, strParaFieldName, j);
					}  
				 
				//String strParam= GetFieldValue(rsList, strParamField, j);
			   sb = new StringBuilder(); 
			   //  String strPKID=publicDao.NullToStr(request.getParameter(strPKField));
				if("".equals(strPKID))
				{//新增 
					String  strFiles="";
					String strValues="";
					for (int i = 0; i < strResource.length; i++)
					{
						String strFieldName = NullToStr(strResource[i]);
						if(strFieldName.split(",").length>1)
						{
							strFieldName=strFieldName.split(",")[0];
						}
						if (!"".equals(strFieldName))
						{  
							if(i!=0)
							{  
								strFiles+=",";
								strValues+=",";
							}
							strFiles+=strFieldName;
							strValues+= "'"+ NullToStr(request.getParameter(strFieldName+strParam))+"'";
					    } 
				     }
					int  intMaxID=sqlDao.getTableMaxId(strTableName,strPKField);
					if("N_MARKETANALYSIS".equals(strTableName.toUpperCase()))
					{// 添加关联字段
						//String strDate = publicDao.getCurrentDateTostr();
						int strYear = publicDao.getCurrentDateYear(intAdd);
						int strMont = publicDao.getCurrentDateMonth(intAdd);
						String CASEID=publicDateDAO.getCaseID(strYear, strMont, request);
						strFiles+=",USERID,MARKETID,CASEID,YEAR,MONTH";
						strValues+=",'"+ GetFieldValue(rsList, "sellerid", j)+"','"+ GetFieldValue(rsList, "MASTERID", j)+"','"+ CASEID+"'";
						strValues+=",'"+strYear+"','"+ strMont+"'";
					}
					if("N_MARKETPARA".equals(strTableName.toUpperCase()))
					{// 添加关联字段
						String strDate = publicDao.getCurrentDateTostr();
						int strYear = publicDao.getCurrentDateYear(intAdd);
						int strMont = publicDao.getCurrentDateMonth(intAdd);
						String CASEID=publicDateDAO.getCaseID(strYear, strMont, request);
						strFiles+=",CASEID,YEAR,MONTH";
						strValues+=",'"+ CASEID+"'";
						strValues+=",'"+strYear+"','"+ strMont+"'";
					}
					sb.append("  insert  into      " +strTableName+"  ("+strPKField+","+strFiles+")  values  ("+intMaxID+","+strValues+")"     );	
					sqlDao.insertWithSql(sb.toString());
					publicDateDAO.updateMarketSize();//初始化潜力
					}
				else
				{//编辑
					String strValues="";
					for (int i = 0; i < strResource.length; i++)
					{
						String strFieldName = publicDao.NullToStr(strResource[i]);
						if(strFieldName.split(",").length>1)
						{
							strFieldName=strFieldName.split(",")[0];
						}
						if (!"".equals(strFieldName))
						{  	
							if(i!=0)
							{  
								strValues+=",";
							}
							strValues+=strFieldName+"='"+publicDao.NullToStr(request.getParameter(strFieldName+strParam))+"'";	
					     } 
				    }
					sb.append("  update     " +strTableName+"    set   "   +strValues  +"  where "+strPKField+"='"+strPKID+"' ");	
					sqlDao.updateWithSql(sb.toString());
					strPKIDS=strPKIDS+",'"+strPKID+"'";
					//System.out.println(sb.toString());
				} 
			}
		}// System.out.println(strPKIDS);
		return sb.toString();
	}
 


	/**
	 * 获取List  Map中的值
	 * @param list
	 * @param name
	 * @param index
	 * @return
	 */
	public String GetFieldValue(List list, String name, int index) {
		name = publicDao.NullToStr(name).toLowerCase();
		String strReturnVs = "";
		if(list!=null)
		{
			  strReturnVs = publicDao.NullToStr(((Map) list.get(index))
					.get(name));
		}
		return strReturnVs;
	}
 
	/**
	 * 组合List
	 * @param list
	 * @param name
	 * @param url
	 */
	public void setFieldValue(List list, String name, String url) {
		if (name == null) {
			return;
		}
		name = name.toLowerCase();
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			map.put(name, url);
		}
	}

	  /**
	  
    /**
	    * 将对象强转成 Double数字型 不是数字时返回0
	    */
    public   Double NullToDouble(Object obj)
    {
        if (obj != null)
        {
            try
            {
                return   Double.valueOf(obj.toString().trim());

            }
            catch(Exception e)
            {
                return 0D;
            }
        }
        else
        {
            return 0D;
        }
    }
    /**
	 * 将字对象强转字符串 null时返回空
	 */
	   public   String NullToStr(Object obj) {
           if (obj != null) {
               return obj.toString().trim();
           } else {
               return "";
           }
       }
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
}
