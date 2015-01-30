package nMarket.FinishChar;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JPanel;


import org.apache.struts2.interceptor.ServletRequestAware;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.TextAnchor;

import system.dao.IPublicDAO;
import system.dao.Impl.PublicDAO;
import system.dao.Impl.PublicDateDAO;
import system.dao.Impl.PublicPageDAO;
import system.publicClass.PublicMethod;

import com.opensymphony.xwork2.ActionSupport;

public class PaoPaoChart   extends ActionSupport implements ServletRequestAware {
private static final long serialVersionUID = 5752180822913527064L;
private JFreeChart chart;
private PublicDateDAO publicDateDAO=null;
private PublicPageDAO publicPageDAO = null;
 
private HttpServletRequest request = null;
public void setServletRequest(HttpServletRequest request) {
	this.request = request;
}

public PublicDateDAO getPublicDateDAO() {
	return publicDateDAO;
}

public void setPublicDateDAO(PublicDateDAO publicDateDAO) {
	this.publicDateDAO = publicDateDAO;
}


public PublicPageDAO getPublicPageDAO() {
	return publicPageDAO;
}

public void setPublicPageDAO(PublicPageDAO publicPageDAO) {
	this.publicPageDAO = publicPageDAO;
}
 
public   String execute()
{
  
	//chart=getPieChar();
//	spiderXYZDataset  XYZDataset=new spiderXYZDataset();
//	XYZDataset=setDataset();
//	 

		chart=createChart();
		 return SUCCESS;
     // return SUCCESS;

}


private  spiderXYZDataset    setDataset()
{ 
	Double xMaxValue=0D;//x���ֵ
	Double yMaxValue=0D;//y���ֵ
	Double zMaxValue=0D;//z���ֵ
	 

	Double xMinValue=0D;//x���ֵ
	Double yMinValue=0D;//y���ֵ
	Double zMinValue=0D;//z���ֵ
	
	spiderXYZDataset  XYZDataset=new spiderXYZDataset();
	// List  listSys=  publicDateDAO.querySysList(request);

		int	intYear=PublicMethod.getCurrentDateYear(0);
		int	intMonth = PublicMethod.getCurrentDateMonth(0);//2011-12
		List listSys =publicDateDAO.querySysList(intYear,intMonth,request);
	 List  paraList=	publicDateDAO.queryParaList(request);//��Դ����
	 String[]  strYouXiaoXingResource=  {"XSGN,��������"};
	 String[]  strXiaoShouResource=  { "QXX,������"};
	 String[]  maxVs=  {"HZGM,Ǳ��", "QXX,������", "XSGN,��������"};
	 Map MaxMap =new HashMap();//��¼���ֵ
	 if(listSys!=null&&listSys.size()>0)
 	 {
 		 String[]   strNameList =new String[listSys.size()] ;
 		double[][]   XList =new double[listSys.size()][1] ;//��������
 		double[][]   YList =new double[listSys.size()][1] ;//���۽��
 		double[][]   ZList =new double[listSys.size()][1] ;//Ǳ��
 		Double coutYXXValue=0D;//���������ֵ��
 		Double coutXiaoShouValue=0D;//���۵�ֵ��
 		//��¼û���ֶε����ֵ
 		for(int j=0; j<listSys.size();j++)
		 {
			for (int i = 0; i < maxVs.length; i++)
			{//��������
				String strFieldNames =publicPageDAO.NullToStr(maxVs[i]);
				String strFieldName=strFieldNames;
				String strFieldCName=strFieldNames;
				if(strFieldName.split(",").length>1)
				{
					 strFieldName=strFieldNames.split(",")[0];//Ӣ������
					  strFieldCName=strFieldNames.split(",")[1];//��������
				}

				  Double dValue=  publicPageDAO.NullToDouble(publicPageDAO.GetFieldValue(listSys, strFieldName, j));
				  Double maxValue=   publicPageDAO.NullToDouble( MaxMap.get(strFieldName));
				  if(dValue>maxValue)
				  {
					  maxValue=dValue;
				  }
				  MaxMap.put(strFieldName,maxValue);
			}
		 }
 		//x��
 		 for(int j=0; j<listSys.size();j++)
 		 {
 			coutXiaoShouValue=0D;coutYXXValue=0D;
 			for (int i = 0; i < strYouXiaoXingResource.length; i++)
			{//��������
				String strFieldNames =publicPageDAO.NullToStr(strYouXiaoXingResource[i]);
				String strFieldName=strFieldNames;
				String strFieldCName=strFieldNames;
				if(strFieldName.split(",").length>1)
				{
					 strFieldName=strFieldNames.split(",")[0];//Ӣ������
					  strFieldCName=strFieldNames.split(",")[1];//��������
				}
				if (!"".equals(strFieldName))
				{
				    Double intPara=1D;//��Դ����
					if(paraList!=null&&paraList.size()>0)
					{
						intPara=publicPageDAO.NullToDouble(  publicPageDAO.GetFieldValue(paraList,strFieldName, 0));//����
					}
				   Double xValue=  publicPageDAO.NullToDouble(publicPageDAO.GetFieldValue(listSys, strFieldName, j));
				  
				   Double maxValue=   publicPageDAO.NullToDouble( MaxMap.get(strFieldName));
				   if(maxValue==0)
				   {
					   maxValue=1D;
				   }

					if(intPara==0.0)
					{
						intPara=1D;
					}
				   coutYXXValue+=xValue;///  /maxValue*intPara;//���ֵ

				} 
			}
 			for (int i = 0; i < strXiaoShouResource.length; i++)
			{//���۽��
				String strFieldNames =publicPageDAO.NullToStr(strXiaoShouResource[i]);
				String strFieldName=strFieldNames;
				String strFieldCName=strFieldNames;
				if(strFieldName.split(",").length>1)
				{
					 strFieldName=strFieldNames.split(",")[0];//Ӣ������
					  strFieldCName=strFieldNames.split(",")[1];//��������
				}
				if (!"".equals(strFieldName))
				{
				    Double intPara=1D;//��Դ����
					if(paraList!=null&&paraList.size()>0)
					{
						intPara=publicPageDAO.NullToDouble(  publicPageDAO.GetFieldValue(paraList,strFieldName, 0));//����
					}
					if(intPara==0.0)
					{
						intPara=1D;
					}
				    Double xValue=  publicPageDAO.NullToDouble(publicPageDAO.GetFieldValue(listSys, strFieldName, j));
					 Double maxValue=   publicPageDAO.NullToDouble( MaxMap.get(strFieldName));
					
					 if(maxValue==0.0)
					   {
						   maxValue=1D;
					   }
				   coutXiaoShouValue+=xValue;// /maxValue*intPara ;
//				   System.out.println(coutXiaoShouValue);
				} 
			}
 			//����xyzֵ
 
 			 String strName=	 publicPageDAO.GetFieldValue(listSys, "NAME", j);
   		    Double intHZGM_param=1D;//��Դ����
 			if(paraList!=null&&paraList.size()>0)
 			{
 				 intHZGM_param=publicPageDAO.NullToDouble(  publicPageDAO.GetFieldValue(paraList,"HZGM", 0));//����
 			}	 
  		    Double HZGM=  publicPageDAO.NullToDouble(publicPageDAO.GetFieldValue(listSys, "HZGM", j));//Ǳ�� Ǳ��
  	
 			//�ַ������Դռ�İٷֱ�
 			Double xValue=coutYXXValue;
 			Double yValue=coutXiaoShouValue ;//���۽��
 			Double zValue=HZGM;//HZGM*0.6+XSZZ*0.4;//�ַ������Դռ�İٷֱ�
 			
 			//��¼���ֵ
 			  if(xValue>xMaxValue)
			  {
			    xMaxValue=xValue;
			  }  if(xValue<0&&xMinValue>yValue)
				  {
				    xMinValue=xValue;
				  }
			  

 			  if(yValue>yMaxValue)
			  {
 				 yMaxValue=yValue;
			  } 
				  if(yValue<0&&yMinValue>yValue)
				  {
		 			 yMinValue=yValue;
				  }
			   
 			  if(zValue>zMaxValue)
			  {
			    zMaxValue=zValue;
			  } 
				  if(zValue<0&&zMinValue>yValue)
				  {
					  zMinValue=zValue;
				  }
			  

 	 		strNameList[j] =  strName; 
 			XList[j][0]=xValue;
 			YList[j][0]=yValue;//��λ��Ԫ
 			ZList[j][0]=zValue;
 		 }
 		
 		 
// 		���۽�� = ���۾����������ֵ x ���۾�������Ȩ�� +  ��������ֵ x �����Ȩ�� + �����������ֵ x ��������Ȩ�أ�
//
//
// 		�������� = ���ۼ������ֵ x ���ۼ���Ȩ�� + ��Ʒ֪ʶ���ֵ x ��Ʒ֪ʶȨ�� + .....+ �ݷüƻ����ֵ x �ݷüƻ�Ȩ�ء�
//
//
// 		��������ֵ�ǰ��������۴�������ݶ���������֮�е����ֵ��õ���0��1֮�������
//
//
// 		Ǳ������Ǳ�������ֵ���ѣ���safari


 		 
	   XYZDataset.setNames(strNameList);
	   Double  xUnit=(xMaxValue-xMinValue)/90;
	   Double  yUnit=(yMaxValue-yMinValue)/180;
	   Double  zUnit=(zMaxValue-zMinValue)/90;
	   
//	   System.out.println("xMaxValue "+xMaxValue);
	   DecimalFormat df = new DecimalFormat("0.0"); 
	   DecimalFormat df1 = new DecimalFormat("0.00"); 

	   for(int j=0; j<listSys.size();j++)
	  {

//		   System.out.println(XList[j][0]); 
		   
		   XList[j][0]=publicPageDAO.NullToDouble(df.format((XList[j][0]-xMinValue)/xUnit+20));
		 
		   YList[j][0]=publicPageDAO.NullToDouble(df.format((YList[j][0]-yMinValue)/yUnit+20)); 
		   
		   ZList[j][0]=publicPageDAO.NullToDouble(df1.format((ZList[j][0]-zMinValue)/zUnit/5+5));

//		   System.out.println( "  "+ XList[j][0] );
	  }
	 
	   
	   
	   XYZDataset.setXVal(XList);
	   XYZDataset.setYVal(YList);
	   XYZDataset.setZVal(ZList);
	 }

	return XYZDataset;
}

public   JFreeChart createChart() {
	XYZDataset xyzdataset= setDataset();
    JFreeChart jfreechart = ChartFactory.createBubbleChart(
                    "ҽ��͸��ͼ", "��������", "������", xyzdataset,
                    PlotOrientation.VERTICAL, true, true, false);
     
    
    XYPlot xyplot = (XYPlot) jfreechart.getPlot();
    xyplot.setRenderer(new XYBubbleRenderer(0));
    xyplot.setForegroundAlpha(0.65F);
    xyplot.setDomainPannable(true);
    xyplot.setRangePannable(true);
     
   
 // ��������ͼ����⣬�ı�����


   // jfreechart.setTitle(new TextTitle("ERP Grid" , new Font("����", Font.ITALIC , 22))); //�������� 

     jfreechart.getTitle().setFont(new Font("����", Font.BOLD,22)); 
    
    ValueAxis rangeAxis = xyplot.getRangeAxis();
    rangeAxis.setLabelFont(new Font("����", Font.BOLD, 14));//y��������
    
     
    ValueAxis domainAxis = xyplot.getDomainAxis();
    domainAxis.setLabelFont(new Font("����", Font.BOLD, 14));//x��������
    

    jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 16));//x����������
    
    XYItemRenderer xyitemrenderer = xyplot.getRenderer();
    
    
//    xyitemrenderer.setSeriesPaint(0, Color.blue);//�Զ�����ɫ
//    xyitemrenderer.setSeriesPaint(1, Color.BLACK);
      

    XYItemRenderer renderer = new XYBubbleRenderer(1); 
    renderer = xyplot.getRenderer(); 
     
    
    
    xyitemrenderer.setBaseItemLabelGenerator(new BubbleXYItemLabelGenerator());
    xyitemrenderer.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
    xyitemrenderer.setBaseItemLabelsVisible(true);
    xyitemrenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
    NumberAxis numberaxisX = (NumberAxis) xyplot.getDomainAxis();
    numberaxisX.setRange(0.0D, 140D);//x��ķ�Χ
    
    NumberAxis numberaxisY = (NumberAxis) xyplot.getRangeAxis();
    numberaxisY.setRange(0.0D, 140D);//y��ķ�Χ
    
    
    return jfreechart;
}

//public static JPanel createDemoPanel() {
//    JFreeChart jfreechart = createChart(new spiderXYZDataset());
//    ChartPanel chartpanel = new ChartPanel(jfreechart);
//    chartpanel.setMouseWheelEnabled(true);
//     
//    return chartpanel;
//}

 
public JFreeChart getChart() {
 return chart;
}


}