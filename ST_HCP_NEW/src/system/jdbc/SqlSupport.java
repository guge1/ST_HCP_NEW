package system.jdbc;

import java.util.ArrayList;
public class SqlSupport {
	 public static String formatSql(String sql, int pageNO, int countPerPage)
	  {
	    StringBuffer sql_page = new StringBuffer();
	    if (pageNO <= 1)
	      sql_page.append("select * from (").append(sql).append(
	        ") where rownum <= "+countPerPage);
	    else {
	      sql_page.append(
	        "select  *  from ( select row_.*, rownum rownum_  from (")
	        .append(sql).append(
	        ") row_  where rownum <= "+pageNO*countPerPage+"  )  where rownum_ > "+pageNO*(countPerPage-1)+"");
	    }
	    return sql_page.toString();
	  }

	  public static String formatSql(String sql, int pageFrom, int pageTo, int countPerPage)
	  {
	    if (pageTo > 0) {
	      StringBuffer sql_page = new StringBuffer();
	      sql_page.append(
	        "select  *  from ( select row_.*, rownum rownum_  from (")
	        .append(sql).append(
	        ") row_  where rownum <= ? )  where rownum_ > ?");
	      return sql_page.toString();
	    }
	    return formatSql(sql, pageFrom, countPerPage);
	  }

	  public static Object[] formatParament(Object[] args, int pageFrom, int pageTo, int countPerPage)
	  {
	    if (pageTo > 0) {
	      ArrayList list = new ArrayList();
	      if (args != null) {
	        for (int i = 0; i < args.length; ++i) {
	          list.add(args[i]);
	        }
	      }
	      list.add(new Integer(pageTo * countPerPage));
	      list.add(new Integer((pageFrom - 1) * countPerPage));

	      return list.toArray();
	    }
	    return formatParament(args, pageFrom, countPerPage);
	  }

	  public static Object[] formatParament(Object[] args, int pageNO, int countPerPage)
	  {
	    ArrayList list = new ArrayList();
	    if (args != null) {
	      for (int i = 0; i < args.length; ++i) {
	        list.add(args[i]);
	      }
	    }
	    if (pageNO <= 1) {
	      list.add(new Integer(countPerPage));
	    } else {
	      list.add(new Integer(pageNO * countPerPage));
	      list.add(new Integer((pageNO - 1) * countPerPage));
	    }
	    return list.toArray();
	  }
}
