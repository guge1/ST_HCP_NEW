package nMarket.jchar;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class AxisLine {
    private static XYDataset createDataset(int members)  
    {  
            XYSeriesCollection   xyseriescollection   =   new   XYSeriesCollection();
            XYSeries   xyseries;
            List xysp =null;
            if(members==6)
            {
            xysp =XYSeries6Point();
            }
            else
            {
            if(members==20)
            {
               xysp =XYSeries20Point();
            }
            }
            if(xysp!=null)
            {
            for(int i=0;i<xysp.size();i++)
            {
               xyseries = new   XYSeries(((XYSeriesPoint)xysp.get(i)).getName());
               xyseries.add(((XYSeriesPoint)xysp.get(i)).getDegree(),0.0D);//ԭ��
               xyseries.add(((XYSeriesPoint)xysp.get(i)).getDegree(),100.0D);//���ֵ
               xyseriescollection.addSeries(xyseries);
            }
            }
           
            XYSeries   xyseries0   =   new   XYSeries("����ҵˮƽ");  
            xyseries0.add(0.0D,   91D);  
            xyseries0.add(90D,   100D);  
            xyseries0.add(180D,   78D);  
            xyseries0.add(270D,   84D);
            xyseriescollection.addSeries(xyseries0);
          
            XYSeries   xyseries1   =   new   XYSeries("��ҵ����ˮƽ");  
            xyseries1.add(90D,   11.199999999999999D);  
            xyseries1.add(180D,   21.399999999999999D);  
            xyseries1.add(250D,   17.300000000000001D);
            xyseries1.add(355D,   10.9D);
           
            xyseriescollection.addSeries(xyseries1);
            XYSeries   xyseries2   =   new   XYSeries("��������ˮƽ");  
            xyseries2.add(90D,   90.199999999999999D);  
            xyseries2.add(180D,   90.399999999999999D);  
            xyseries2.add(250D,   90.300000000000001D);  
            xyseries2.add(355D,   100D);  
            xyseriescollection.addSeries(xyseries2);
           
            return xyseriescollection;
    }
   
    private   static String   createChart(XYDataset   xydataset,File file)  
    {  
            JFreeChart   jfreechart   =   ChartFactory.createPolarChart("��ҵ��Ϣ��ˮƽ�״�ͼ",   xydataset,   true,   false,   false);  
            jfreechart.setBackgroundPaint(Color.white);

    try {
     Image image = ImageIO.read(new   File("D:\\png\\Sunset.jpg"));
             //jfreechart.setBackgroundImage(image);
    } catch (IOException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }  
            PolarPlot   polarplot   =   (PolarPlot)jfreechart.getPlot();
            polarplot.setBackgroundAlpha(0.0f);
            polarplot.setBackgroundPaint(Color.white);
         
            polarplot.setAngleGridlinesVisible(false);

            NumberAxis   numberaxis   =   (NumberAxis)polarplot.getAxis();  
            numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
           
            outputPNG(jfreechart,file);//������ļ�          

            System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
            System.out.println(AxisLine.class.getClassLoader().getResource(""));
            System.out.println(ClassLoader.getSystemResource(""));
            System.out.println(AxisLine.class.getResource(""));
            System.out.println(AxisLine.class.getResource("/"));//Class�ļ�����·����
            System.out.println(new File("/").getAbsolutePath());
            System.out.println(System.getProperty("user.dir"));

           
            return   file.getPath();  
    }

    public   static   void   main(String   args[])  
    {  
    createChart(createDataset(6),new File("d:\\6.png"));
    createChart(createDataset(20),new File("d:\\20.png"));
    }
    public static void outputPNG(JFreeChart chart,File file) {
        try {
            ChartUtilities.saveChartAsPNG(file,chart,640,640);
        } catch (Exception e) {
           
        }       
    }
    private static List XYSeries6Point()
    {
    List list = new ArrayList();
    XYSeriesPoint xysp;
    String labels6[] = new String[]{
        "�쵼��",
        "��������",
        "Ӧ�á������봴��",
        "IT���������IT����",
        "��Ϣ��������Դ",
        "��Ϣ��Ч��"
        };
    for(int i=0;i<labels6.length;i++)
    {
       xysp = new XYSeriesPoint();
       xysp.setName(labels6[i]);
       xysp.setDegree(i*60D);

       list.add(xysp);
    }
   
    return list;
    }
    private static List XYSeries20Point()
    {
    List list = new ArrayList();
    XYSeriesPoint xysp;
    String labels20[] = new String[]{
        "��֪�����ƶ���",
        "��Ϣ��ս����滮",
        "��Ϣ������ִ����",
        "��Ϣ��Ͷ�ʲ�����Ͷ�ʽṹ",
        "ϵͳ�ܹ�����·��",
        "��Ϣ����׼�淶��ܿ���ϵ",
        "��Ӫҵ����Ϣ��",
        "������Ϣ��",
        "��������",
        "��Ϣ������ˮƽ",
        "����봴��",
        "��Ϣ��������Ŀ����",
        "��Ϣ��ȫ����",
        "IT�������",
        "IT��Ч����",
        "IT����",
        "��Ϣ����ѵ",
        "��Ϣ���˲�",
        "�ʽ�����Ч��",
        "�ʽ�ܿ�����"
        };
    for(int i=0;i<labels20.length;i++)
    {
       xysp = new XYSeriesPoint();
       xysp.setName(labels20[i]);
       xysp.setDegree(i*18D);
       list.add(xysp);
    }
    return list;
    }
}