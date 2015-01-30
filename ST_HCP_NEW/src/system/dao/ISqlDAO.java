package system.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nMarket.vo.Users;


@SuppressWarnings("unchecked")
public interface ISqlDAO {

	/**
	 * 用sql 语句查询 返回List结果
	 */
	public    List queryWithForList(String sql) ;
	/**
	 *  获取更类主表最大ID 
	 * @param table  
	 * @param idName  
	 * @return
	 */
	public  int getTableMaxId( String table,  String idName);
	/**
	 * 获取当前案例
	 * @return
	 */
	public String getSourseID();
	/**
	 * 获取更类主表最大ID
	 * 
	 * @param table
	 * @param idName
	 * @return
	 */
	public int getTableMaxIdSql(String sql);
	/**
	 * 执行插入语句
	 */
	public  boolean insertWithSql(String sql);
	

	/**
	 * 执行操作语句
	 * @param sql
	 * @return
	 */
	public  int updateWithSql(String sql);

	/**
	 * 执行操作语句
	 * @param sql
	 * @return
	 */
	
	 public List queryListBySqlNoSession(String Sql )
	     ;
	 /**
		 * 返回用户信息
		 * @param sql
		 * @return
		 */
		
	 public  Users  gerUserInfo(HttpServletRequest request);
}
