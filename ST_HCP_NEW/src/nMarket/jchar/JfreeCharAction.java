package nMarket.jchar;
 

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.jfree.chart.JFreeChart;  
  
import com.opensymphony.xwork2.ActionSupport;  
  
public class JfreeCharAction extends ActionSupport implements ServletRequestAware {  


	private HttpServletRequest request = null;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
    /**  
     * ����JFreeChart���� �����ע��������JFreeChart������ֻ��Ϊchart   
     * �����Ǳ��   
     * �������  
     * ��ҿ�����struts2��վ����鿴һ��  
     *   
     * http://struts.apache.org/2.x/docs/jfreechart-plugin.html  
     */  
    private JFreeChart chart;  
    public JFreeChart getChart() {  
        return chart;  
    }  
  
    public void setChart(JFreeChart chart) {  
        this.chart = chart;  
    }  
  
    public String getPaoPao(){  
        // ���÷���  
        try {
			this.chart = JfreeChartTest.createChart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return SUCCESS;  
    }  
}  