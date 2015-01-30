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
	 * ����У�鷽��*******************************************************************
	 * **
	 * 
	 * 
	 * /** ������ת�����ַ��� null �Ƿ��ؿ�
	 * 
	 * @param obj
	 * @return
	 */
	public String NullToStr(Object obj);

	/**
	 * \ ������ת���� yyyy-MM-dd hh:mm:ss ��ʽ����
	 * 
	 * @param objDate
	 * @return
	 */
	public Date strToLongDate(Object objDate);

	/**
	 * ������ת�������� ������0
	 * 
	 * @param obj
	 * @return
	 */
	public int NullToNumber(Object obj);

	/**
	 * ������ǿת�� float ������ ��������ʱ����0
	 */
	public float NullToFloatr(Object obj);

	/**
	 * ������ǿת�� Double������ ��������ʱ����0
	 */
	public Double NullToDouble(Object obj);
	   /**
     * ������תΪ ����һλ 
     * @param obj
     * @return
     */
    public   String  DecimalFormat_OBJ(Object obj);
	/**
	 * ��Date����ǿת�� ����yyyy-MM-dd�ַ����� �����ص�ǰʱ��
	 */
	public String DateToShortStr(Date unitdate);

	/**
	 * ��Date����ǿת�� ����yyyy-mm-dd hh24:mi:ss�ַ����� �����ص�ǰʱ��
	 */
	public String DateToLongStr(Date unitdate);

	/**
	 * ��ȡ��ǰ����yyyy-MM-dd�ַ����� �����ص�ǰ����
	 */
	public String getCurrentDateTostr();

	/**
	 * ��ȡ��ǰ�������
	 */
	public int getCurrentDateYear(int addMonth);

	/**
	 * ��ȡ��ǰ�����·�
	 */
	public int getCurrentDateMonth(int addMonth);

	/**
	 * ��ȡ��ǰ����yyyy-mm-dd hh24:mi:ss�ַ����� �����ص�ǰʱ��
	 */
	/**
	 * �Ƚ��ַ�������DATE1 ���ַ�������DATE2�Ĵ�С DATE1�� ����1 DATE2�󷵻�-1 ��ȷ���0
	 */
	public int compare_date(String DATE1, String DATE2);

	public String getCurrentTimeTostr();

	/***
	 * ʱ�䷶Χ�ڲ�ѯ
	 */
	public String getSearchDate(String strFiledName, String strStarDate,
			String strEndDate);

	/***
	 * ���ַ�Χ�ڲ�ѯ
	 */
	public String getSearchInt(String strFiledName, int intStarNum,
			int intEndNum);

}
