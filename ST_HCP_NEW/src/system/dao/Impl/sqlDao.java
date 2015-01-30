package system.dao.Impl;

import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nMarket.vo.Users;

import org.apache.struts2.ServletActionContext;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import system.ConnPool.ConnectionPool;
import system.dao.IPublicDAO;
import system.dao.ISqlDAO;
import system.jdbc.SqlSupport;

import model.TbGysinfo;

import java.sql.Connection;
public class sqlDao extends BaseDAO implements ISqlDAO {

	private IPublicDAO publicDao = null;

	 
	public IPublicDAO getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(IPublicDAO publicDao) {
		this.publicDao = publicDao;
	}
//com.microsoft.sqlserver.jdbc.SQLServerDriver
	protected static String dbClassName = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	protected static String dbUrl = "jdbc:microsoft:sqlserver://localhost:1433;"
			+ "DatabaseName=ST_HCP_NEWDATA;SelectMethod=Cursor";
	protected static String dbUser = "ST_HCP_NEWADMIN";
	protected static String dbPwd = "ST_HCP_NEWADMIN";
	protected static String second = null;
	public static Connection conn = null;
	 

	
	
	private sqlDao() {

		conn= getConn();
	}
	public static Connection getConn()  {
		try {
			if (conn == null) {
//				 Class.forName(dbClassName).newInstance();
//				 conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
//				 conn =Connection2000();
				conn=getConnectionXml2000();
				// conn =getConnectionXml2000();
				if (conn == null) {
					System.out.println("Connection sql   失败 请检查连接数据 用户和密码是否正确!"); // 如果连接成功
				}else
				{
					System.out.println("Connection sql   成功!"); // 如果连接成功
				}
				//conn=Connection2005();
			}
		} catch (Exception ee) {
			 conn =getConnectionXml2005();
			if (conn == null) {
				System.out.println("Connection sql 2005 失败 ！请检查连接数据 用户和密码是否正确！"); // 如果连接成功
			}else
			{
				System.out.println("Connection sql 2005 成功!"); // 如果连接成功
			}
		}
		return  conn;
	}
	

	/**
	 * 连接sql2000 的数据库
	 * @return
	 */

    public static Connection getConnectionXml2000()
    {
        try
        {
        	
        	Connection conn = null;
        	  String driverClassName2="";
        	  String url2="";
        	  String username2="";
        	  String password2="";
    			try {
    				SAXBuilder sb=new SAXBuilder();
    			    String file=Thread.currentThread().getContextClassLoader().getResource("../datasource2000.xml").getPath();
    			    Document doc = sb.build(file);
    			    Element root=doc.getRootElement(); //获取根元素
    			    Element nodes=(Element)root.getChildren().get(0);//取名字为beans的所有元素
    			    List node = nodes.getChildren();
    			    for(int i=0;i<node.size();i++){
    			    	Element nod =(Element)node.get(i);
    			    	String name=nod.getAttributeValue("name"); 
    			    	   String value=nod.getAttributeValue("value"); 
    			    	   if(name.equals("driverClassName")){
    			    		   driverClassName2=value;
    			    	   }else if(name.equals("url")){
    			    		   url2=value;
    			    	   }else if(name.equals("username")){
    			    		   username2=value;
    			    	   }else if(name.equals("password")){
    			    		   password2=value;
    			    	   }
    			    }
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
        	
    			//Class.forName(driverClassName2).newInstance(); 
//        		Class.forName(driverClassName2);
//        	conn = DriverManager.getConnection(url2,username2,password2);
    			//启用连接池
    			 ConnectionPool connPool = new ConnectionPool( driverClassName2, url2,username2, password2);
				System.out.println(url2+"");
				System.out.println(username2+""+password2);
   			  connPool.createPool();
   			  conn = connPool.getConnection();
        	return conn;
        }
        catch(Exception e)
        {
            System.err.println("\u5F02\u5E38:" + e.getMessage());
        }
        return null;
    }
	

    /**
	 * 连接sql2005 的数据库
	 * @return
	 */

    public static Connection getConnectionXml2005()
    {
        try
        {
        	
        	Connection conn = null;
        	 
        	  String driverClassName2="";
        	  String url2="";
        	  String username2="";
        	  String password2="";
    			try {
    				SAXBuilder sb=new SAXBuilder();
    			    String file=Thread.currentThread().getContextClassLoader().getResource("../datasource2005.xml").getPath();
    			    Document doc = sb.build(file);
    			    Element root=doc.getRootElement(); //获取根元素
    			    Element nodes=(Element)root.getChildren().get(0);//取名字为beans的所有元素
    			    List node = nodes.getChildren();
    			    for(int i=0;i<node.size();i++){
    			    	Element nod =(Element)node.get(i);
    			    	String name=nod.getAttributeValue("name"); 
    			    	   String value=nod.getAttributeValue("value"); 
    			    	   if(name.equals("driverClassName")){
    			    		   driverClassName2=value;
    			    	   }else if(name.equals("url")){
    			    		   url2=value;
    			    	   }else if(name.equals("username")){
    			    		   username2=value;
    			    	   }else if(name.equals("password")){
    			    		   password2=value;
    			    	   }
    			    }
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
        	
//        	Class.forName(driverClassName2).newInstance(); 
//        	Class.forName(driverClassName2);
//        	conn = DriverManager.getConnection(url2,username2,password2);
        	
        	  ConnectionPool connPool = new ConnectionPool( driverClassName2, url2,username2, password2);

			  connPool.createPool();
			  conn = connPool.getConnection();
			  
        	return conn;
        }
        catch(Exception e)
        {
            System.err.println("\u5F02\u5E38:" + e.getMessage());
        }
        return null;
    }

    /**
	 * 连接ora 的数据库
	 * @return
	 */

    public static Connection getConnectionXmlOrcl()
    {
        try
        {

        	/*Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); 
        	String url = "jdbc:oracle:thin:@10.1.121.252:1521:atic";//CInitParam.getConnStr(); //orcl为数据库的SID 
        	String user = "atic";//CInitParam.getUsername();
        	String password = "atic";//CInitParam.getPassword();
        	conn = DriverManager.getConnection(url,user,password);
        	return conn;*/
        	Connection conn = null;
        	 
        	  String driverClassName2="";
        	  String url2="";
        	  String username2="";
        	  String password2="";
    			try {
    				SAXBuilder sb=new SAXBuilder();
    			    String file=Thread.currentThread().getContextClassLoader().getResource("../datasource.xml").getPath();
    			    Document doc = sb.build(file);
    			    Element root=doc.getRootElement(); //获取根元素
    			    Element nodes=(Element)root.getChildren().get(0);//取名字为beans的所有元素
    			    List node = nodes.getChildren();
    			    for(int i=0;i<node.size();i++){
    			    	Element nod =(Element)node.get(i);
    			    	String name=nod.getAttributeValue("name"); 
    			    	   String value=nod.getAttributeValue("value"); 
    			    	   if(name.equals("driverClassName")){
    			    		   driverClassName2=value;
    			    	   }else if(name.equals("url")){
    			    		   url2=value;
    			    	   }else if(name.equals("username")){
    			    		   username2=value;
    			    	   }else if(name.equals("password")){
    			    		   password2=value;
    			    	   }
    			    }
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
        	
         	Class.forName(driverClassName2).newInstance(); 
//        	Class.forName(driverClassName2);
        	conn = DriverManager.getConnection(url2,username2,password2);
        	return conn;
        }
        catch(Exception e)
        {
            System.err.println("\u5F02\u5E38:" + e.getMessage());
        }
        return null;
    }
    
 
	
	/**
	 * 用sql 语句查询 返回List结果
	 */
	public List queryWithForList(String sql) {
		List<List> list = new ArrayList<List>();
		ResultSet rs = findForResultSet(sql);
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {
					String str = rs.getString(i);
					if (str != null && !"".equals(str))
						str = str.trim();
					row.add(str);
				}
				list.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
/**
 * 分页查询
 * @param sql
 * @param args
 * @param pageNO
 * @param countPerPage
 * @return
 */
	  public List queryForListWithSql(String sql, Object[] args, int pageNO, int countPerPage)
	  {
	    String sqlQuery = SqlSupport.formatSql(sql, pageNO, countPerPage);
	    return queryWithForList(sqlQuery );
	  }

	public List queryListBySqlNoSession(String Sql)
	{
		List<Map> list = new ArrayList<Map>();
		try {
			ResultSet rs = findForResultSet(Sql);

			list = resultToList(rs);

			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<Map> resultToList(ResultSet rs) throws Exception {
		List<Map> list = new ArrayList<Map>();
		while (rs.next()) {
			Map map = new HashMap();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String strColumnName = rsmd.getColumnName(i);
				strColumnName = strColumnName.toLowerCase();
				String strColumnValue = publicDao.NullToStr(rs
						.getString(strColumnName));
				map.put(strColumnName, strColumnValue);

			}
			list.add(map);
		}
		return list;
	}

	/**
	 * 执行操作语句
	 * 
	 * @param sql
	 * @return
	 */
	public int updateWithSql(String strSql) {
		int result = 0;
		try {
			conn= getConn();
			if(conn==null)
			{
			}
			if (conn == null)
				return 0;
			
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(strSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 执行插入语句
	 */
	public boolean insertWithSql(String sql) {
		boolean result = false;
		try {
			conn= getConn();
			if(conn==null)
			{
			}
			if (conn == null)
				return false;
			Statement stmt = conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取更类主表最大ID
	 * 
	 * @param table
	 * @param idName
	 * @return
	 */
	public int getTableMaxId(String table, String idName) {
		String sql = "select max(" + idName + ") from " + table + "  ";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseId = baseId == null ? "1000" : baseId;
		int idNum = Integer.parseInt(baseId) + 1;
		// id += String.format("%03d", idNum);
		return idNum;
	}
	/**
	 * 获取当前案例
	 * @return
	 */
	public String getSourseID()
	{
		int CASEID=getTableMaxIdSql("select  max(t.caseid)  from n_marketcase t  where  CASETYPE='1'");
		CASEID=CASEID-1;
		return  String.valueOf(CASEID);
	}
	
	
	public  Users  gerUserInfo(HttpServletRequest request)
	{
		if(request==null)
		{
			return new Users();
		}
		 HttpSession session = request.getSession(false);
		 Users users = null;
		 if(session!=null){
			 users = (Users)session.getAttribute("userInfo");
			 if(users!=null)
			 {

					request.setAttribute("usertype", users.getUsertype());
			   return users;
			 }
		 }
		 if(users==null)
		 {
		  
			 try { 	
				    String newPath=  request.getContextPath() + "/jsp/login/login.jsp";
	
				    String strContent="   window.parent.parent.parent.location.href='"+newPath+"';  window.location.href='"+newPath+"';   ";//
				    HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					response.getWriter().write("<script>"+strContent+"</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 return  new Users();
	}
	/**
	 * 获取更类主表最大ID
	 * 
	 * @param table
	 * @param idName
	 * @return
	 */
	public int getTableMaxIdSql(String sql) { 
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseId = baseId == null ? "10000" : baseId;
		int idNum = Integer.parseInt(baseId) + 1;
		// id += String.format("%03d", idNum);
		return idNum;
	}

	/**
	 * 获取更类主表最大ID
	 * 
	 * @param date
	 *            date, "tb_sell_main", "XS", "sellID"
	 * @param table
	 * @param idChar
	 * @param idName
	 * @return
	 */
	public String getMainTypeTableMaxId(Date date, String table, String idChar,
			String idName) {
		String dateStr = date.toString().replace("-", "");
		String id = idChar + dateStr;
		String sql = "select max(" + idName + ") from " + table + " where "
				+ idName + " like '" + id + "%'";
		ResultSet set = query(sql);
		String baseId = null;
		try {
			if (set.next())
				baseId = set.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseId = baseId == null ? "000" : baseId.substring(baseId.length() - 3);
		int idNum = Integer.parseInt(baseId) + 1;
		id += String.format("%03d", idNum);
		return id;
	}

	// 执行指定查询
	public ResultSet query(String QueryStr) {
		ResultSet set = findForResultSet(QueryStr);
		return set;
	}

	public ResultSet findForResultSet(String sql) {
//		PoolMan poolMan=new PoolMan();
//		poolMan.queryWithForList(sql);
		
		conn= getConn();
		if(conn==null)
		{
		}
		if (conn == null)
			return null;
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 获取退货最大ID
	public String getRkthMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_rkth_main", "RT", "rkthId");
	}

	// 获取销售主表最大ID
	public String getSellMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_sell_main", "XS", "sellID");
	}

	public String getXsthMainMaxId(Date date) {
		return getMainTypeTableMaxId(date, "tb_xsth_main", "XT", "xsthID");
	}

}