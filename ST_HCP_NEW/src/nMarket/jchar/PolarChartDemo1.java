package nMarket.jchar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PolarChartDemo1 extends ApplicationFrame {

public PolarChartDemo1(String s) {
   super(s);
   JPanel jpanel = createDemoPanel();
   jpanel.setPreferredSize(new Dimension(600, 500));
   setContentPane(jpanel);
}

private static XYDataset createDataset() {
   XYSeriesCollection xyseriescollection = new XYSeriesCollection();
   XYSeries xyseries = new XYSeries("Series       1 ");
   xyseries.add(0.0D, 2D);
   xyseries.add(90D, 13D);
   xyseries.add(180D, 9D);
   xyseries.add(270D, 8D);
   xyseriescollection.addSeries(xyseries);
   XYSeries xyseries1 = new XYSeries("Series       2 ");
   xyseries1.add(90D, -11.199999999999999D);
   xyseries1.add(180D, 21.399999999999999D);
   xyseries1.add(250D, 17.300000000000001D);
   xyseries1.add(355D, 10.9D);
   xyseriescollection.addSeries(xyseries1);
   return xyseriescollection;
}

private static JFreeChart createChart(XYDataset xydataset) {
   JFreeChart jfreechart = ChartFactory.createPolarChart(
     "Polar       Chart       Demo       1 ", xydataset, true,
     false, false);
   jfreechart.setBackgroundPaint(Color.white);
   PolarPlot polarplot = (PolarPlot) jfreechart.getPlot();
   polarplot.setBackgroundPaint(Color.lightGray);
   polarplot.addCornerTextItem("Corner       Item       1 ");
   polarplot.addCornerTextItem("Corner       Item       2 ");
   polarplot.setBackgroundImageAlignment(PolarPlot.MINIMUM_HEIGHT_TO_DRAW);
   polarplot.setAngleTickUnit(new NumberTickUnit(45));
   // polarplot.setAngleGridlinesVisible(false);

   // �����״���ɫ
   GradientPaint gradientpaint3 = new GradientPaint(0.0F, 0.0F,
     Color.black, 0.0F, 0.0F, Color.black);
   polarplot.setRadiusGridlinePaint(gradientpaint3);//

   // �����ı�����ɫ
   GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.red,
     0.0F, 0.0F, Color.red); //
   GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F,
     Color.blue, 0.0F, 0.0F, Color.blue); //
   // ���������ı�����ɫ
   DefaultPolarItemRenderer renderer = new DefaultPolarItemRenderer();
   renderer.setSeriesPaint(0, gradientpaint1);
   renderer.setSeriesPaint(1, gradientpaint2);
   polarplot.setRenderer(renderer);

   NumberAxis numberaxis = (NumberAxis) polarplot.getAxis();
   numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
   numberaxis.setAutoRange(true);
   numberaxis.setVisible(false);
   numberaxis.setTickUnit(new NumberTickUnit(2));// �����״���������

   return jfreechart;
}

public static JPanel createDemoPanel() {
   final JFreeChart jfreechart = createChart(createDataset());
   ChartPanel chartpanel = new ChartPanel(jfreechart);
   // chartpanel.setMouseZoomable(true);// �Ƿ�������Ŵ�
   //ͨ�������ַŴ���С�Ŵ����嶼�Ŵ���С��Ѱ�Ҹ��÷���ing
   chartpanel.addMouseWheelListener(new MouseWheelListener() {

    public void mouseWheelMoved(MouseWheelEvent e) {
     if (-3 == e.getUnitsToScroll()) {
      jfreechart.setPadding(new RectangleInsets(jfreechart
        .getPadding().getTop() - 10, jfreechart
        .getPadding().getBottom() - 10, jfreechart
        .getPadding().getLeft() - 10, jfreechart
        .getPadding().getRight() - 10));
      System.out.println("����");
     } else if (3 == e.getUnitsToScroll()){
      jfreechart.setPadding(new RectangleInsets(jfreechart
        .getPadding().getTop() + 10, jfreechart
        .getPadding().getBottom() + 10, jfreechart
        .getPadding().getLeft() + 10, jfreechart
        .getPadding().getRight() + 10));
      System.out.println("����");
     }
    }

   });
   return chartpanel;
}

public static void main(String args[]) {
   PolarChartDemo1 polarchartdemo1 = new PolarChartDemo1(
     "Polar       Chart       Demo ");
   polarchartdemo1.pack();
   RefineryUtilities.centerFrameOnScreen(polarchartdemo1);
   polarchartdemo1.setVisible(true);
}

}