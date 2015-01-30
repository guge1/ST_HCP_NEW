package nMarket.jchar;

import java.awt.Color;
import java.awt.Dimension;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JPanel;

import nMarket.FinishChar.spiderXYZDataset;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.*;

/**
 * ��������ͼ
 * @jdk 1.6
 * @author skzr.org(E-mail:skzr.org@gmail.com)
 * @version 1.0.0
 */ 
public   class BubbleChartDemo2 extends ApplicationFrame implements ServletRequestAware  {
        private static final long serialVersionUID = 1L;

    	private HttpServletRequest request = null;
        public BubbleChartDemo2(String s) {
                super(s);
                JPanel jpanel = createDemoPanel();
                jpanel.setPreferredSize(new Dimension(800, 600));
                setContentPane(jpanel);
            System.out.println(    jpanel.toString());
        }

        private static JFreeChart createChart(XYZDataset xyzdataset) {
                JFreeChart jfreechart = ChartFactory.createBubbleChart(
                                "ERP Grid", "��Ч��", "���۽��", xyzdataset,
                                PlotOrientation.VERTICAL, true, false, false);
                XYPlot xyplot = (XYPlot) jfreechart.getPlot();
                xyplot.setRenderer(new XYBubbleRenderer(0));
                xyplot.setForegroundAlpha(0.65F);
                xyplot.setDomainPannable(true);
                xyplot.setRangePannable(true);
                XYItemRenderer xyitemrenderer = xyplot.getRenderer();
                xyitemrenderer.setSeriesPaint(0, Color.blue);
                xyitemrenderer.setSeriesPaint(1, Color.BLACK);
                  

                XYItemRenderer renderer = new XYBubbleRenderer(1); 
                renderer = xyplot.getRenderer(); 
                
                xyitemrenderer.setBaseItemLabelGenerator(new BubbleXYItemLabelGenerator());
                xyitemrenderer.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
                xyitemrenderer.setBaseItemLabelsVisible(true);
                xyitemrenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
                NumberAxis numberaxis = (NumberAxis) xyplot.getDomainAxis();
                numberaxis.setRange(0.0D, 10D);
                NumberAxis numberaxis1 = (NumberAxis) xyplot.getRangeAxis();
                numberaxis1.setRange(0.0D, 10D);
                return jfreechart;
        }

        public static JPanel createDemoPanel() {
                JFreeChart jfreechart = createChart(new spiderXYZDataset());
                ChartPanel chartpanel = new ChartPanel(jfreechart);
                chartpanel.setMouseWheelEnabled(true);
                 
                return chartpanel;
        }

        public static void main(String args[]) {
                BubbleChartDemo2 bubblechartdemo2 = new BubbleChartDemo2(
                                "�������ͼ");
                bubblechartdemo2.pack();
                RefineryUtilities.centerFrameOnScreen(bubblechartdemo2);
                bubblechartdemo2.setSize(800, 600);
//                TextTitle textTitle = bubblechartdemo2.get;  
//                textTitle.setFont(new Font("����", Font.PLAIN, 20)); //������������
 
                bubblechartdemo2.setVisible(true);
        }
        
        
        public  String getZongTiFenXiPaoPao()
    	{
        	BubbleChartDemo2 bubblechartdemo2 = new BubbleChartDemo2( "�������ͼ");
			bubblechartdemo2.pack();
			RefineryUtilities.centerFrameOnScreen(bubblechartdemo2);
			bubblechartdemo2.setVisible(true);
    		
    		return null;
    	}


    	public void setServletRequest(HttpServletRequest request) {
    		this.request = request;
    	}
        
}
