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
     * 定义JFreeChart对象 大家请注意在这里JFreeChart对象名只能为chart   
     * 不能是别的   
     * 关于这点  
     * 大家可以上struts2网站上面查看一下  
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
        // 调用方法  
        try {
			this.chart = JfreeChartTest.createChart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return SUCCESS;  
    }  
}  