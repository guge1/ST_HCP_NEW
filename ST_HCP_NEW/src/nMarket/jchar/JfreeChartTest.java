package nMarket.jchar;

import java.awt.Font;  
import java.io.IOException;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;  
  
public class JfreeChartTest {  
  
    public static JFreeChart createChart() throws IOException {  
        // ���ݼ�  
        DefaultPieDataset dpd = new DefaultPieDataset();  
        dpd.setValue("������Ա", 25);  
        dpd.setValue("�г���Ա", 25);  
        dpd.setValue("������Ա", 45);  
        dpd.setValue("������Ա", 10);  
        // ����PieChart����  
        JFreeChart chart = ChartFactory.createPieChart3D("ĳ��˾��Ա��֯�ṹͼ", dpd,  
                true, true, false);  
        utils.setFont(chart);  
        return chart;  
    }  
}  
  
/**  
 * ��������  
 *   
 * @author zyong  
 *   
 */  
class utils {  
    public static void setFont(JFreeChart chart) {  
        Font font = new Font("����", Font.ITALIC, 12);  
        PiePlot plot = (PiePlot) chart.getPlot();  
        chart.getTitle().setFont(font);  
        plot.setLabelFont(font);  
        chart.getLegend().setItemFont(font);  
    }  
}  