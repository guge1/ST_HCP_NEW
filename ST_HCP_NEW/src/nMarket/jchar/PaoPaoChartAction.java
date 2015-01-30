package nMarket.jchar;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.ActionSupport;

public class PaoPaoChartAction extends ActionSupport {
private static final long serialVersionUID = 5752180822913527064L;
private JFreeChart chart;
 
public String execute(){
  
      //����JFreeChart����      // ͼ�����  //���� // �Ƿ���ʾͼ��  //�Ƿ���ʾ������ʾ  //�Ƿ�����URL 
      chart = ChartFactory.createPieChart3D( 
            "��״ͼ",  getDataSet(), true,   false,  false   ); 
      //��������ͼ����⣬�ı����� 
      chart.setTitle(new TextTitle("��״ͼ", new Font("����", Font.ITALIC , 22))); 
      
      //ȡ��ͳ��ͼ��ĵ�һ��ͼ�� 
      LegendTitle legend = chart.getLegend(0); 
      //�޸�ͼ�������� 
      legend.setItemFont(new Font("����", Font.BOLD, 14)); 
      //��ñ�ͼ��Plot���� 
      PiePlot plot = (PiePlot)chart.getPlot(); 
      //���ñ�ͼ�����ֵı�ǩ���� 
      plot.setLabelFont(new Font("����", Font.BOLD, 10)); 
      //�趨����͸���ȣ�0-1.0֮�䣩 
      plot.setBackgroundAlpha(0.9f); 
      //�趨ǰ��͸���ȣ�0-1.0֮�䣩 
      plot.setForegroundAlpha(0.50f); 
      
      // ͼƬ����ʾ�ٷֱ�:�Զ��巽ʽ��{0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ���� ,С�������λ
//      plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}��{1}({2})", NumberFormat.getNumberInstance(),
//              new DecimalFormat("0.00%")));
//      // ͼ����ʾ�ٷֱ�:�Զ��巽ʽ�� {0} ��ʾѡ� {1} ��ʾ��ֵ�� {2} ��ʾ��ռ����
      
//      plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator ("{0}"));
      
      return SUCCESS;

}

public DefaultPieDataset getDataSet(){
  DefaultPieDataset data = new DefaultPieDataset();
     data.setValue("Java", new Double(43.2));
     data.setValue("Visual Basic", new Double(1.0));
     data.setValue("C/C++", new Double(17.5));
     data.setValue("tangjun��", new Double(60.0));
     return data;
}

public JFreeChart getChart() {
 return chart;
}


}