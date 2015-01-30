package system.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import nMarket.vo.Users;


@SuppressWarnings("unchecked")
public interface IPublicDAO {

	public boolean checkLogin(Users user);

	public boolean deleteUser(Integer id);

	public boolean save(Object object);

	public boolean update(Object object);

	public Users getUserById(Integer id);

	public void responseMessage(HttpServletResponse response, String strContent);

	public List findAllList(String strSql);

	/***************************
	 * 数据校验方法*******************************************************************
	 * **
	 * 
	 * 
	 * /** 将对象转换成字符串 null 是返回空
	 * 
	 * @param obj
	 * @return
	 */
	public String NullToStr(Object obj);

	/**
	 * \ 将对象转换成 yyyy-MM-dd hh:mm:ss 格式日期
	 * 
	 * @param objDate
	 * @return
	 */
	public Date strToLongDate(Object objDate);

	/**
	 * 将对象转换成数字 出错返回0
	 * 
	 * @param obj
	 * @return
	 */
	public int NullToNumber(Object obj);

	/**
	 * 将对象强转成 float 数字型 不是数字时返回0
	 */
	public float NullToFloatr(Object obj);

	/**
	 * 将对象强转成 Double数字型 不是数字时返回0
	 */
	public Double NullToDouble(Object obj);
	   /**
     * 将对象转为 保留一位 
     * @param obj
     * @return
     */
    public   String  DecimalFormat_OBJ(Object obj);
	/**
	 * 将Date对象强转成 日期yyyy-MM-dd字符串型 出错返回当前时间
	 */
	public String DateToShortStr(Date unitdate);

	/**
	 * 将Date对象强转成 日期yyyy-mm-dd hh24:mi:ss字符串型 出错返回当前时间
	 */
	public String DateToLongStr(Date unitdate);

	/**
	 * 获取当前日期yyyy-MM-dd字符串型 出错返回当前日期
	 */
	public String getCurrentDateTostr();

	/**
	 * 获取当前日期年份
	 */
	public int getCurrentDateYear(int addMonth);

	/**
	 * 获取当前日期月份
	 */
	public int getCurrentDateMonth(int addMonth);

	/**
	 * 获取当前日期yyyy-mm-dd hh24:mi:ss字符串型 出错返回当前时间
	 */
	/**
	 * 比较字符串日期DATE1 和字符串日期DATE2的大小 DATE1大 返回1 DATE2大返回-1 相等返回0
	 */
	public int compare_date(String DATE1, String DATE2);

	public String getCurrentTimeTostr();

	/***
	 * 时间范围内查询
	 */
	public String getSearchDate(String strFiledName, String strStarDate,
			String strEndDate);

	/***
	 * 数字范围内查询
	 */
	public String getSearchInt(String strFiledName, int intStarNum,
			int intEndNum);

}
