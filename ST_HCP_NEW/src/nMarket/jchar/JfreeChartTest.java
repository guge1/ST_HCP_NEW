package nMarket.jchar;

import java.awt.Font;  
import java.io.IOException;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;  
  
public class JfreeChartTest {  
  
    public static JFreeChart createChart() throws IOException {  
        // 数据集  
        DefaultPieDataset dpd = new DefaultPieDataset();  
        dpd.setValue("管理人员", 25);  
        dpd.setValue("市场人员", 25);  
        dpd.setValue("开发人员", 45);  
        dpd.setValue("其它人员", 10);  
        // 创建PieChart对象  
        JFreeChart chart = ChartFactory.createPieChart3D("某公司人员组织结构图", dpd,  
                true, true, false);  
        utils.setFont(chart);  
        return chart;  
    }  
}  
  
/**  
 * 设置字体  
 *   
 * @author zyong  
 *   
 */  
class utils {  
    public static void setFont(JFreeChart chart) {  
        Font font = new Font("宋体", Font.ITALIC, 12);  
        PiePlot plot = (PiePlot) chart.getPlot();  
        chart.getTitle().setFont(font);  
        plot.setLabelFont(font);  
        chart.getLegend().setItemFont(font);  
    }  
}  