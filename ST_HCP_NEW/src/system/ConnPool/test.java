package system.ConnPool;

import java.sql.Connection;


public class test {

	public static void main(String[] args) {
		try {
			// Connection Connection= poolman.getPool("test") ;
			// getInstance();

			ConnectionPool connPool = new ConnectionPool(
					"com.microsoft.sqlserver.jdbc.SQLServerDriver",
					"jdbc:sqlserver://localhost:1433; DatabaseName=ST_HCP_NEWDATA", "ST_HCP_NEWADMIN", "ST_HCP_NEWADMIN");

			connPool.createPool();
			Connection conn = connPool.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
