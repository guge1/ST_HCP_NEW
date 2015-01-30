package nMarket.FinishChar.Spider;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import nMarket.FinishChar.spiderXYZDataset;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;
/**
 * JFreeChart的蜘蛛网图（又称雷达图，网状图） 有数据刻度
 * @author Administrator
 *
 */
import java.awt.Color;  
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.http.HttpSession;  

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;  
import org.jfree.chart.ChartUtilities;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;  
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;  
import org.jfree.chart.plot.SpiderWebPlot;  
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.servlet.ServletUtilities;  
import org.jfree.chart.title.TextTitle;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.util.Rotation;  
  
public class CreatePieChart {  
	private JFreeChart chart;
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  

   


    public JFreeChart  getPieChar()
    {
    	 //生成JFreeChart对象      // 图表标题  //数据 // 是否显示图例  //是否显示工具提示  //是否生成URL 
        chart = ChartFactory.createPieChart3D( 
              "饼状图",  getDataSet(), true,   false,  false   ); 
        //重新设置图标标题，改变字体 
        chart.setTitle(new TextTitle("饼状图", new Font("黑体", Font.ITALIC , 22))); 
        
        //取得统计图标的第一个图例 
        LegendTitle legend = chart.getLegend(0); 
        //修改图例的字体 
        legend.setItemFont(new Font("宋体", Font.BOLD, 14)); 
        //获得饼图的Plot对象 
        PiePlot plot = (PiePlot)chart.getPlot(); 
        //设置饼图各部分的标签字体 
        plot.setLabelFont(new Font("隶书", Font.BOLD, 10)); 
        //设定背景透明度（0-1.0之间） 
        plot.setBackgroundAlpha(0.9f); 
        //设定前景透明度（0-1.0之间） 
        plot.setForegroundAlpha(0.50f); 
        
        // 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
//        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}：{1}({2})", NumberFormat.getNumberInstance(),
//                new DecimalFormat("0.00%")));
//        // 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
        
//        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator ("{0}"));
        
    	return  chart;
    	
    }
    public DefaultPieDataset getDataSet(){
      DefaultPieDataset data = new DefaultPieDataset();
         data.setValue("Java", new Double(43.2));
         data.setValue("Visual Basic", new Double(1.0));
         data.setValue("C/C++", new Double(17.5));
         data.setValue("tangjun书", new Double(60.0));
         return data;
    }

    public JFreeChart getChart() {
     return chart;
    }
}