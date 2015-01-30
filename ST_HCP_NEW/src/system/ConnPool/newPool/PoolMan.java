package system.ConnPool.newPool;

/** 
 * Title: ConnectionPool.java 
 * Description: ���ݿ���� 
 * Copyright: Copyright (c) 2002/12/25 
 * Company: 
 * Author : 
 * remark : ����ָ��ع� 
 * Version 2.0 
 */

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.net.*;

public class PoolMan extends ConnectionPool {

	private ConnectionPool connMgr;
	private Statement stmt;
	private Connection con;
	private ResultSet rst;

	
	
	/**
	 *�������ӳ�ʼ��
	 * */

	public Connection getPool(String name) throws Exception {
		try {
			connMgr = ConnectionPool.getInstance();
			con = connMgr.getConnection(name);
		} catch (Exception e) {
			System.err.println("���ܴ�������!�볢������Ӧ�÷�����");

		}
		return con;
	}

	/**
	 *ͬ���Ϸ���,�������ӿ��еȴ�ʱ�� ���÷���
	 * */

	public Connection getPool_t(String name, long time) throws Exception {
		try {
			connMgr = ConnectionPool.getInstance();
			con = connMgr.getConnection(name, time);
		} catch (Exception e) {
			System.err.println("���ܴ�������!");

		}
		return con;
	}

	/**
	 * ��sql ����ѯ ����List���
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
	protected static String second = null;
	public ResultSet findForResultSet(String sql) {
 System.out.println("  dd");
		if(con==null)
		{
		}
		if (con == null)
			return null;
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		try {
			Statement stmt = null;
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	 *ִ�в�ѯ����1
	 * */
	public ResultSet executeQuery(String SqlStr) throws Exception {
		ResultSet result = null;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(SqlStr);
			// here add one line by jnma 12.11
			con.commit();
		} catch (java.sql.SQLException e) {
			throw new Exception("ִ�в�ѯ������");
		}
		return result;
	}

	/**
	 *ִ�в�ѯ����2
	 * */
	public ResultSet getRst(String SqlStr) throws Exception {
		// ResultSet result = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rst = stmt.executeQuery(SqlStr);
			// here add one line by jnma 12.11
			con.commit();
		} catch (java.sql.SQLException e) {
			throw new Exception("ִ�в�ѯ������");
		}
		return rst;
	}

	/**
	 *ִ�и���
	 * */
	public int Update(String SqlStr) throws Exception {
		int result = -1;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			result = stmt.executeUpdate(SqlStr);
			// here add one line by jnma 12.11
			con.commit();
			if (result == 0)
				System.out.println("ִ��delete,update,insert SQL����");
		} catch (java.sql.SQLException e) {
			System.err.println("ִ��delete,update,insert SQL����");
		}
		return result;
	}

	/**
	 *ִ��������
	 * */
	public boolean handleTransaction(Vector SqlArray) throws Exception {
		boolean result = false;
		int ArraySize = SqlArray.size();
		try {
			stmt = con.createStatement();
			con.setAutoCommit(false);
			System.out.println("ArraySize is" + ArraySize);
			for (int i = 0; i < ArraySize; i++) {
				System.out.println(" ��ʼִ�����" + (String) SqlArray.elementAt(i));
				stmt.executeUpdate((String) SqlArray.elementAt(i));
				System.out.println(" ִ�гɹ�");
			}
			con.commit();
			con.setAutoCommit(true);// ����
			System.out.println("����ִ�гɹ�");
			result = true;
		} catch (java.sql.SQLException e) {
			try {
				System.out.println(e.toString());
				System.out.println("���ݿ����ʧ��");
				con.rollback();
			} catch (java.sql.SQLException Te) {
				System.err.println("�������ع��쳣");
			}
		}
		try {
			con.setAutoCommit(true);
		} catch (java.sql.SQLException e) {
			System.err.println("�����Զ��ύʧ��");
		}
		return result;
	}

	/**
	 *�ͷ�����
	 * */
	public void close(String name) throws Exception {
		try {
			if (stmt != null)
				stmt.close();
			if (con != null) {
				connMgr.freeConnection(name, con);

				System.out.println(" [c �����ͷ�һ������ ] ");

			}
		} catch (java.sql.SQLException e) {
			System.err.println("�ͷ����ӳ���");
		}
	}

}
