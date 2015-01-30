package nMarket.FinishChar.Spider;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;
/**
 * JFreeChart的蜘蛛网图（又称雷达图，网状图） 无数据刻度
 * @author Administrator
 *
 */
public class SpiderWebChartDemo 
{

 public  SpiderWebChartDemo()
 {
//	 String s
//  super(s);
//  JPanel jpanel = createDemoPanel();
//  jpanel.setPreferredSize(new Dimension(600, 470));
//  setContentPane(jpanel);
 }

 public   CategoryDataset createDataset()
 {
  String strName1 = "张海鑫";
  String strName2 = "王胜理 ";
  String strName3 = "刘文娟";
  String strName4 = "邓建 ";
  String strName5 = "刘瑞华 ";
  String strName6 = "何文琪";
  String strTypeNDS = "销售技巧(Selling skills)";
  String s4 = "产品知识(Product Knowledge)";
  String s5 = "月拜访次数(Monthly Call Rate 10/Day)";
  String s6 = "推广活动次数(Activity 4/month)";
  String s7 = "拜访计划 (Call Plan)";
  DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
  defaultcategorydataset.addValue(1.0D, strName1, strTypeNDS);
  defaultcategorydataset.addValue(4D, strName1, s4);
  defaultcategorydataset.addValue(3D, strName1, s5);
  defaultcategorydataset.addValue(5D, strName1, s6);
  defaultcategorydataset.addValue(5D, strName1, s7);
  defaultcategorydataset.addValue(5D, strName2, strTypeNDS);
  defaultcategorydataset.addValue(7D, strName2, s4);
  defaultcategorydataset.addValue(6D, strName2, s5);
  defaultcategorydataset.addValue(8D, strName2, s6);
  defaultcategorydataset.addValue(4D, strName2, s7);
  defaultcategorydataset.addValue(4D, strName3, strTypeNDS);
  defaultcategorydataset.addValue(3D, strName3, s4);
  defaultcategorydataset.addValue(2D, strName3, s5);
  defaultcategorydataset.addValue(3D, strName3, s6);
  defaultcategorydataset.addValue(6D, strName3, s7);
  

  defaultcategorydataset.addValue(4D, strName4, strTypeNDS);
  defaultcategorydataset.addValue(3D, strName4, s4);
  defaultcategorydataset.addValue(2D, strName4, s5);
  defaultcategorydataset.addValue(3D, strName4, s6);
  defaultcategorydataset.addValue(6D, strName4, s7);
  

  defaultcategorydataset.addValue(4D, strName5, strTypeNDS);
  defaultcategorydataset.addValue(3D, strName5, s4);
  defaultcategorydataset.addValue(2D, strName5, s5);
  defaultcategorydataset.addValue(3D, strName5, s6);
  defaultcategorydataset.addValue(6D, strName5, s7);

  defaultcategorydataset.addValue(4D, strName6, strTypeNDS);
  defaultcategorydataset.addValue(3D, strName6, s4);
  defaultcategorydataset.addValue(2D, strName6, s5);
  defaultcategorydataset.addValue(3D, strName6, s6);
  defaultcategorydataset.addValue(6D, strName6, s7);
  return defaultcategorydataset;
 }

 public   JFreeChart createChart(CategoryDataset categorydataset)
 {
  SpiderWebPlot spiderwebplot = new SpiderWebPlot(categorydataset);
  spiderwebplot.setStartAngle(54D);
  spiderwebplot.setInteriorGap(0.40000000000000002D);
  spiderwebplot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
  JFreeChart jfreechart = new JFreeChart("销售有效性分析图", TextTitle.DEFAULT_FONT, spiderwebplot, false);
  LegendTitle legendtitle = new LegendTitle(spiderwebplot);
  legendtitle.setPosition(RectangleEdge.BOTTOM);
  jfreechart.addSubtitle(legendtitle);
  
  
  
  
  return jfreechart;
 }

 public   JPanel createDemoPanel()
 {
  JFreeChart jfreechart = createChart(createDataset());
  return new ChartPanel(jfreechart);
 }

 public static void main(String args[])
 {
//  SpiderWebChartDemo spiderwebchartdemo = new SpiderWebChartDemo("销售有效性分析图");
//  spiderwebchartdemo.pack();
//  RefineryUtilities.centerFrameOnScreen(spiderwebchartdemo);
//  spiderwebchartdemo.setVisible(true);
 }
}