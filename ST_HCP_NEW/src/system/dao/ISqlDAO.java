package system.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nMarket.vo.Users;


@SuppressWarnings("unchecked")
public interface ISqlDAO {

	/**
	 * ��sql ����ѯ ����List���
	 */
	public    List queryWithForList(String sql) ;
	/**
	 *  ��ȡ�����������ID 
	 * @param table  
	 * @param idName  
	 * @return
	 */
	public  int getTableMaxId( String table,  String idName);
	/**
	 * ��ȡ��ǰ����
	 * @return
	 */
	public String getSourseID();
	/**
	 * ��ȡ�����������ID
	 * 
	 * @param table
	 * @param idName
	 * @return
	 */
	public int getTableMaxIdSql(String sql);
	/**
	 * ִ�в������
	 */
	public  boolean insertWithSql(String sql);
	

	/**
	 * ִ�в������
	 * @param sql
	 * @return
	 */
	public  int updateWithSql(String sql);

	/**
	 * ִ�в������
	 * @param sql
	 * @return
	 */
	
	 public List queryListBySqlNoSession(String Sql )
	     ;
	 /**
		 * �����û���Ϣ
		 * @param sql
		 * @return
		 */
		
	 public  Users  gerUserInfo(HttpServletRequest request);
}
