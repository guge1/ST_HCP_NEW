package system.dao.Impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nMarket.vo.Users;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.login.dao.IUsersDAO; 

import system.dao.IPublicDAO;

@SuppressWarnings("unchecked")
public class PublicDAO extends BaseDAO implements IPublicDAO {
	 

	private HttpServletResponse response = null;
	private HttpServletRequest request = null;
	
	
	public boolean checkLogin(Users user) {
		 
		HttpServletRequest request =ServletActionContext.getRequest();
		HttpSession longinsession = request.getSession(); 
		if (longinsession!=null) {
			longinsession.invalidate(); //ɾ������session�б���ļ� 
			longinsession.getAttribute("USERID"); 
			longinsession.getAttribute("USERNAME");  
			return true;
		}
		return false;	
	}

	
	public boolean deleteUser(Integer id) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			Users user = (Users)session.get(Users.class, id);
			session.delete(user);
			tx.commit();
			return true;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	
	/**
	 * ��������
	 */
	
	public boolean save(Object object) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
			return true;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	/**
	 * ���¶���
	 */
	
	public boolean update(Object object) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.update(object);
			tx.commit();
			return true;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	/**
	 * ��ѯ����List
	 */
	public List  findAllList(String  strSql) {
		
		List  allList = new  ArrayList();
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
		 
			Query query = session.createQuery(strSql);
			allList = query.list();
			tx.commit();
			return allList;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return allList;
		
	}
	 

	
	public Users getUserById(Integer id) {
		Session session = null;
		session = getSession();
		String hql = "from Users u where u.id = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		List list = query.list();
		Users user = null;
		if (list.size()>0) {
			user = (Users)list.get(0);
		}
		session.close();
		return user;	
	}
	
	/**
	 * ��ʾ��Ϣ�����
	 */
	public void responseMessage(HttpServletResponse response,String strContent) {
		try { 	

			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().write("<script>"+strContent+"</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 /***************************����У�鷽��*********************************************************************

	/**
	 * ���ֶ���ǿת�ַ��� nullʱ���ؿ�
	 */
	   public   String NullToStr(Object obj) {
           if (obj != null) {
               return obj.toString().trim();
           } else {
               return "";
           }
       }
	   /**
	    * ������ǿת�� int ������ ��������ʱ����0
	    */
       public   int NullToNumber(Object obj)
       {
           if (obj != null)
           {
               try
               {
                   return   Integer.parseInt(obj.toString().trim());

               }
               catch(Exception e)
               {
                   return 0;
               }
           }
           else
           {
               return 0;
           }
       }
       

	   /**
	    * ������ǿת�� float ������ ��������ʱ����0
	    */
       public   float NullToFloatr(Object obj)
       {
           if (obj != null)
           {
               try
               {
                   return   Float.parseFloat(obj.toString().trim());

               }
               catch(Exception e)
               {
                   return 0;
               }
           }
           else
           {
               return 0;
           }
       }
       /**
	  
       /**
	    * ������ǿת�� Double������ ��������ʱ����0
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
        * ������תΪ ����һλ 
        * @param obj
        * @return
        */
       public   String  DecimalFormat_OBJ(Object obj)
       {
    	   String  returnVs="";
		   DecimalFormat df = new DecimalFormat("0"); 
		   returnVs=df.format( NullToDouble(obj));
    	   return returnVs;
       }
       /**
	    * ��Date����ǿת�� ����yyyy-MM-dd�ַ����� �����ص�ǰʱ��
	    */
       public   String  DateToShortStr(Date date)
       {
           if (date != null)
           { 
        	   try
               { 
       			Timestamp CREATEDATE=	new Timestamp(date.getTime());
       			String  strCudrrentDate=CREATEDATE.toString().substring(0,19);
           	    return strCudrrentDate;
                 	 
               }
               catch(Exception e)
               {
                   return "";
               }
           } else
           {
        	   return "";
           } 
       }
       /**\
        * ������ת����  yyyy-MM-dd hh:mm:ss  ��ʽ����
        * @param objDate
        * @return
        */
       public   Date  strToLongDate(Object objDate)
       {

    	   String strDate=NullToStr(objDate);
    	   if("".equals( strDate))
    	   {
    		   return  null;
    	   }
 		  SimpleDateFormat  sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
 		  Date date  =new  Date();  
 		  try {
			date  =sdf1.parse(  strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
 		   return  null;
		 }
 		  return  date;
       }
       
       /**
	    * ��Date����ǿת�� ����yyyy-mm-dd hh24:mi:ss�ַ����� �����ص�ǰʱ��
	    */
       public   String  DateToLongStr(Date date)
       {
//   			SimpleDateFormat sdfT=new SimpleDateFormat("yyyy-MM-dd");
//   	        java.sql.Date STATDATE =new  java.sql.Date(8);  
//   	        java.sql.Date ENDDATE =new  java.sql.Date(8);
    	   if (date != null)
           { 
        	   try
               { 
       			Timestamp CREATEDATE=	new Timestamp(date.getTime());
       			String  strCudrrentDate=CREATEDATE.toString().substring(0,10);
           	    return strCudrrentDate;
                 	 
               }
               catch(Exception e)
               {
                   return "";
               }
           } else
           {
        	   return "";
           }   
       }
       /**
	    * ��ȡ��ǰ����yyyy-MM-dd�ַ����� �����ص�ǰ����
	    */
       public   String  getCurrentDateTostr()
       {
			Timestamp CREATEDATE=	new Timestamp(Calendar.getInstance().getTime().getTime());
			String  strCudrrentDate=CREATEDATE.toString().substring(0,19);
    	    return strCudrrentDate;
       }


       /**
	    * ��ȡ��ǰ�������
	    */
       public   int  getCurrentDateYear( int addMonth)
       {
//			Timestamp CREATEDATE=	new Timestamp(Calendar.getInstance().getTime().getTime());
//			String  strCudrrentDate=CREATEDATE.toString().substring(0,19);
//			int intYear =  NullToNumber(strCudrrentDate.substring(0, 4));
//			int strMont =NullToNumber(strCudrrentDate.substring(5, 7))+1;
    	  
    	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			
			Date date=new Date();
			try {
				date = simpleDateFormat.parse("20111231");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   
           Calendar calender = Calendar.getInstance();
           calender.setTime(date);
           calender.add(Calendar.MONTH,  addMonth+1);
		   int intYear=(calender.get(Calendar.YEAR));
           simpleDateFormat.format(calender.getTime());
           String ss=   simpleDateFormat.format(calender.getTime()).toString() ; 
//           if(addMonth==0){intYear=2011;}//��������Ϊ10��
//    	   if(addMonth==1){intYear=2011;}//����������Ϊ10��
    	    return intYear;
       }

       /**
	    * ��ȡ��ǰ�����·�
	    */
       public   int  getCurrentDateMonth(int addMonth)
       {
    	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
           Date date =new  Date();
           try {
				date = simpleDateFormat.parse("20111231");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           Calendar calender = Calendar.getInstance();
           calender.setTime(date);
           calender.add(Calendar.MONTH,  addMonth+1);
           int month = (calender.get(Calendar.MONTH))+1;
           simpleDateFormat.format(calender.getTime());
           String ss=   simpleDateFormat.format(calender.getTime()).toString() ; 
//    	   if(addMonth==0){month=10;}//��������Ϊ10��
//    	   if(addMonth==1){month=11;}//����������Ϊ10��
    	    return month;
       }
       
       
       
       
       
       
       /**
	    * ��ȡ��ǰ����yyyy-mm-dd hh24:mi:ss�ַ����� �����ص�ǰʱ��
	    */
       public   String  getCurrentTimeTostr()
       {
			Timestamp CREATEDATE=	new Timestamp(Calendar.getInstance().getTime().getTime());
			String  strCudrrentTime=CREATEDATE.toString().substring(0,19);
    	    return strCudrrentTime;
       }
       /**
        * �ַ���ʱ��ıȽ�
        */
       public   int compare_date(String DATE1, String DATE2) {

    	   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	   try {
    	   Date dt1 = df.parse(DATE1);
    	   Date dt2 = df.parse(DATE2);
    	   if (dt1.getTime() > dt2.getTime()) {
    	           // System.out.println("dt1 ��dt2ǰ");
    	            return 1;
    	   } else if (dt1.getTime() < dt2.getTime()) {
    	         // System.out.println("dt1��dt2��");
    	       return -1;
    	   } else {
    	          return 0;
    	   }
    	   } catch (Exception exception) {
    	        exception.printStackTrace();
    	   }
    	   return 0;
      } 
       /***
        * ʱ��β�ѯ
        */
       public String     getSearchDate(String strFiledName,String strStarDate ,String strEndDate)
       { 
            if (strStarDate != "" && strEndDate != "")
            {
                if (compare_date(strStarDate,strEndDate) <1)
                    return " and   "+strFiledName+"  between to_date('" + strStarDate + "','yyyy-mm-dd') and to_date('" + strEndDate + "','yyyy-mm-dd') ";
                else
                    return
                        " and   "+strFiledName+"   between to_date('" + strEndDate + "','yyyy-mm-dd') and to_date('" + strStarDate + "','yyyy-mm-dd') ";
            }
            else
            {
                if (strStarDate == "" && strEndDate == "")
                    return "";
                else
                {
                    if (strStarDate != "")
                        return " and   "+strFiledName+"   = to_date('" + strStarDate + "','yyyy-mm-dd') ";
                    else
                        return " and   "+strFiledName+"   = to_date('" + strEndDate + "','yyyy-mm-dd') ";
                }

            } 
       }
       /***
        * ���ַ�Χ�ڲ�ѯ
        */
       public String     getSearchInt(String strFiledName,int intStarNum ,int intEndNum)
       { 
    	   if("".equals(strFiledName)||strFiledName==null)
    	   {
    		   return  "";
    	   }
            if (intStarNum != 0 && intEndNum != 0)
            {
                if (intStarNum<intEndNum)
                    return " and  trunc( "+strFiledName+",0)  between  '" + intStarNum + "'  and  '" + intEndNum + "'  ";
                else
                    return
                        " and    trunc( "+strFiledName+"   between  '" + intEndNum + "'  and  '" + intStarNum + "'  ";
            }
            else
            {
                if (intStarNum == 0 && intEndNum == 0)
                    return "";
                else
                {
                    if (intStarNum != 0)
                        return " and    trunc( "+strFiledName+"   between  '" + intEndNum + "'  and  '" + intStarNum + "'  ";
                    else
                        return " and  trunc( "+strFiledName+",0)  between  '" + intStarNum + "'  and  '" + intEndNum + "'  ";
                } 
            } 
       }
       
	
	
 
}
