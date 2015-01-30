package system.publicClass;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
/**
 * 公共常量
 *  gzhj  2012-3-30
 */
@SuppressWarnings("unchecked")
public class PublicConstant   {
	 
	 
	/**
	 *  1-12 月简写
	 */
	public static List<String> MONTH_LIST = Arrays.asList("Jan", "Feb", "Mar",  
			   "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");  
	/**
	 * 颜色
	 */
	public static  String COLORS_LIST[]={"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E","D64646","8E468E","588526","B3AA00","008ED6","9D080D","A186BE","CC6600","FDC689","ABA000","F26D7D","FFF200","0054A6","F7941C","CC3300","006600","663300","6DCFF6","","","","","","","","","","","","","",""};

}
