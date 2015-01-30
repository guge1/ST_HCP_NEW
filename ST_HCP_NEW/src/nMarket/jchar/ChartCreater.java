package nMarket.jchar;
//package nMarket.actions;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Paint;
//import java.awt.RadialGradientPaint;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Point2D;
//import java.awt.geom.Rectangle2D;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.AxisLocation;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PiePlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.RingPlot;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.category.BarRenderer;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
//import org.jfree.chart.renderer.xy.XYItemRenderer;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.gantt.GanttCategoryDataset;
//import org.jfree.data.general.PieDataset;
//import org.jfree.data.time.TimeSeriesCollection;
//import org.jfree.data.xy.DefaultOHLCDataset;
//import org.jfree.data.xy.DefaultTableXYDataset;
//import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.data.xy.XYZDataset;
//import org.jfree.util.TableOrder;
//
///**
// * @author WangMin
// */
//public class ChartCreater {
//
//	/**
//	 * ÆøÅÝÍ¼
//	 */
//	public static JFreeChart createBubbleChart(String name, String category,
//			String value, XYZDataset xYZDataset, PlotOrientation po,
//			boolean legend, boolean tooltip, boolean url) {
//		JFreeChart chart = ChartFactory.createBubbleChart(name, category,
//				value, xYZDataset, po, legend, tooltip, url);
//
//		return chart;
//	}
//
//	private static XYZDataset vXYZDataset=null;
//	private static    PlotOrientation po=null;
//	 public static void main(final String[] args ) {
// 		 vXYZDataset.getX(10, 10);
//		 vXYZDataset.getZValue(10,10);
//		 po.hashCode();
//		//		 vFreeChart=ChartFactory.createBubbleChart(strFreeChartInfo,strFreeChartXInfo,strFreeChartYInfo,this.getXYZDataset(),PlotOrientation.VERTICAL,true,false,false);
// 		 createBubbleChart("name","category"," value", vXYZDataset, po, false, false, false);
//	 }
//	 
//}