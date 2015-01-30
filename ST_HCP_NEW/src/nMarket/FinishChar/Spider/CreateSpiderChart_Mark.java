package nMarket.FinishChar.Spider;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.JPanel;

import nMarket.FinishChar.PaoPaoChart;
import nMarket.FinishChar.spiderXYZDataset;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;
/**
 * JFreeChart��֩����ͼ���ֳ��״�ͼ����״ͼ�� �����ݿ̶�
 * @author Administrator
 *
 */
import java.awt.Color;  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.HashMap;
import java.util.List;
import java.util.Map;
  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;  
import org.jfree.chart.ChartRenderingInfo;  
import org.jfree.chart.ChartUtilities;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.entity.StandardEntityCollection;  
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;  
import org.jfree.chart.plot.SpiderWebPlot;  
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.servlet.ServletUtilities;  
import org.jfree.chart.title.TextTitle;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
import org.jfree.data.xy.XYZDataset;
import org.jfree.util.Rotation;  

import com.opensymphony.xwork2.ActionSupport;

import system.dao.IPublicDAO;
import system.dao.ISqlDAO;
import system.dao.Impl.PublicDAO;
import system.dao.Impl.PublicDateDAO;
import system.dao.Impl.PublicPageDAO;
import system.dao.Impl.PublicSourceDAO;
import system.publicClass.PublicMethod;
  
public class CreateSpiderChart_Mark    extends ActionSupport implements ServletRequestAware  {  
	private PublicDateDAO publicDateDAO=null;
	private PublicPageDAO publicPageDAO = null;
	private PublicSourceDAO publicSourceDAO = null;
	private ISqlDAO sqlDao = null;
	private JFreeChart chart;
	private	Double dMacValue=40D;//���ֵ
	

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
 
 
	public PublicSourceDAO getPublicSourceDAO() {
		return publicSourceDAO;
	}

	public void setPublicSourceDAO(PublicSourceDAO publicSourceDAO) {
		this.publicSourceDAO = publicSourceDAO;
	}

	public ISqlDAO getSqlDao() {
		return sqlDao;
	}

	public void setSqlDao(ISqlDAO sqlDao) {
		this.sqlDao = sqlDao;
	}
	
    private static final long serialVersionUID = 1L;  
    private static String  strPKID="";
    public String execute(){
      
    	//chart=getPieChar(); ��ͼ
    	
//    	 CreateSpiderChart_Mark SpiderChart=new CreateSpiderChart_Mark();
//    	 PaoPaoChart PaoPaoChart=new PaoPaoChart();
    		chart= createSpiderChart();
    		//	chart=PaoPaoChart.createChart();
          return SUCCESS;

    }


    public   JFreeChart createSpiderChart  () {  
    	CategoryDataset categorydataset=createDataset();
        SpiderWebPlot spiderwebplot = new SkillScorePlot(categorydataset);  
        spiderwebplot.setStartAngle(10D);  
        categorydataset.getValue(0, 1);  
        
         
        

        Font font = new Font("����",Font.PLAIN,12) ;// X��  
        spiderwebplot.setLabelFont(font);
        
        spiderwebplot.setBackgroundPaint(Color.white);  
        spiderwebplot.setMaxValue(dMacValue);  
        spiderwebplot.setDirection(Rotation.CLOCKWISE);  
        spiderwebplot.setAxisLinePaint(Color.blue);  
        spiderwebplot.setInteriorGap(0.3D);  
        spiderwebplot.setToolTipGenerator(new StandardCategoryToolTipGenerator());  
        JFreeChart jfreechart = new JFreeChart("������Ч�Է���",TextTitle.DEFAULT_FONT, spiderwebplot, true);  

        jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 16));//x����������

        jfreechart.getTitle().setFont(new Font("����", Font.BOLD,22)); //����

        // �����״���ɫ
           GradientPaint paint = new GradientPaint(0.0F, 0.0F,
             Color.black, 0.0F, 0.0F, Color.black);
           spiderwebplot.setAxisLinePaint(paint);//���ùǼ���ɫ
          
           GradientPaint outpaint = new GradientPaint(1.0F, 1.0F,
             Color.black, 1.0F, 1.0F, Color.black);
           if(!"".equals(strPKID))
	       	{
	           spiderwebplot.setSeriesPaint(2, outpaint);//�����������ɫ
	       	}else
	       	{
	            spiderwebplot.setSeriesPaint(7, outpaint);//�����������ɫ
	       	}
           spiderwebplot.setOutlineVisible(false);
           spiderwebplot.setWebFilled(false);//����ҽԺ���Ƿ� �����ɫ
 
           
//        CategoryPlot plot = jfreechart.getCategoryPlot();// ���ͼ��ҽԺ����
//        CategoryAxis axis = plot.getDomainAxis();   
//        axis.setMaximumCategoryLabelLines(4); // ��ߵ�4���������ʾ4����  

//        PolarPlot polarplot = (PolarPlot) jfreechart.getPlot();


        // �����ı�����ɫ
//        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.red,
//          0.0F, 0.0F, Color.red); //
//        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F,
//          Color.blue, 0.0F, 0.0F, Color.blue); //
//        // ���������ı�����ɫ
//        DefaultPolarItemRenderer renderer = new DefaultPolarItemRenderer();
//        renderer.setSeriesPaint(0, gradientpaint1);
//        renderer.setSeriesPaint(1, gradientpaint2);

         //  PolarPlot polarplot = (PolarPlot) jfreechart.getPlot();
        jfreechart.setBackgroundPaint(Color.LIGHT_GRAY);  
        return jfreechart;  
    }  
  
 
  

    /*
     * �����״�ͼ
     */
    private   CategoryDataset createDataset() {  
    	  strPKID =publicPageDAO.NullToStr( request.getParameter("PKID"));
    	//strPKID="10001";
    	//List  listSys=  publicDateDAO.querySysList(request);

		int	intYear=PublicMethod.getCurrentDateYear(-1);
		int	intMonth = PublicMethod.getCurrentDateMonth(-1);//2011-12
		List  listSys=publicDateDAO.queryHisList(intYear,intMonth,strPKID,request);
    	  DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		  String[]  strResource=  {"PFCS,�հݷô���","KNH,ʵ�ع��������ı�ֵ","TGHDCS,�г��ƹ�����", "ABFGL,Ŀ��ͻ������� ", "BFJH,ST/T1��Ч�ݷø�����" ,"BFJH_T,T2��Ч�ݷø�����", "CPZS,��Ʒ֪ʶ ", "XSJQ,���ۼ���"};
		  String[]  strV=       {"10" ,"80","1", "80" ,"80", "80","85", "85"};
		  String[]  strHeight=  {"15" ,"100","2", "100","100 ", "100", "100","100"  };
		  //String[]  strBeiShu=  {"8.5" ,"21","1", "1", "1","1","85", "1" };
		  
		  if(listSys!=null&&listSys.size()>0)
     	 {
     		 Map MaxMap =new HashMap();//��¼���ֵ
     		 Map unitMap =new HashMap();//��¼��λ
     		 String[]   strNameList =new String[listSys.size()] ; 
     		 for(int j=0; j<listSys.size();j++)
     		 {//��¼ÿ�����ֵ
     			 
     		    String strName=	 publicPageDAO.GetFieldValue(listSys, "NAME", j);
     		    strNameList[j] =  strName; 
     			for (int i = 0; i < strResource.length; i++)
    			{//���ֶ�
    				String strFieldNames =publicPageDAO.NullToStr(strResource[i]);
    				String strFieldName=strFieldNames;
    				String strFieldCName=strFieldNames;
    				if(strFieldName.split(",").length>1)
    				{
    					 strFieldName=strFieldNames.split(",")[0];//Ӣ������
    					  strFieldCName=strFieldNames.split(",")[1];//��������
    				}
    				if (!"".equals(strFieldName))
    				{
					  Double dValue=  publicPageDAO.NullToDouble(publicPageDAO.GetFieldValue(listSys, strFieldName, j));
					 
					  if("BFJH".equals(strFieldName)||"TGHDCS".equals(strFieldName))
					  {
						 // dValue=dValue*20;
					  }
					
					  Double maxValue=   publicPageDAO.NullToDouble( MaxMap.get(strFieldName));
					  if(dValue>maxValue)
					  {
						  maxValue=dValue;
					  }

					  Double zuiDaValue=publicPageDAO.NullToDouble( strHeight[i]) ;//���ֵ
					  if(maxValue<=zuiDaValue)
			    	  {//���ֵС�ڱ�׼ֵ
			    		  maxValue=zuiDaValue;
			    	  }
					  if(maxValue>dMacValue)
					  {
						  dMacValue=maxValue+10;
					  }
			    	  Double unit=maxValue/100;//100�ݵĵ�λ
			    	  unitMap.put(strFieldName,unit);
					  MaxMap.put(strFieldName,maxValue);
					  //System.out.println(dValue);
    				}
    			}
     		 }
     		 
     		 
     		 if(listSys!=null&&listSys.size()>0)
         	 {
         		 for(int j=0; j<listSys.size();j++)
         		 {

             		 Map Map =(Map)listSys.get(j);//��¼���ֵ 
	      		    //String strName=	 publicPageDAO.GetFieldValue(listSys, "NAME", j);
		  			for (int i = 0; i < strResource.length; i++)
		 			{//���ֶ�
		 				String strFieldNames =publicPageDAO.NullToStr(strResource[i]);
		  				String strFieldName=strFieldNames;
		 				String strFieldCName=strFieldNames;
		 				if(strFieldName.split(",").length>1)
		 				{
		 					 strFieldName=strFieldNames.split(",")[0];//Ӣ������
		 					  strFieldCName=strFieldNames.split(",")[1];//��������
		 				}
		 				if (!"".equals(strFieldName))
	    				{
							  Double dValue=  publicPageDAO.NullToDouble(publicPageDAO.GetFieldValue(listSys, strFieldName, j));
							  Double maxValue=   publicPageDAO.NullToDouble( MaxMap.get(strFieldName)) ;
							 // System.out.println("unit"+dValue);
							  Double biaoZhunValue=publicPageDAO.NullToDouble( strV[i]);//��׼ֵ
							  Double zuiDaValue=publicPageDAO.NullToDouble( strHeight[i]) ;//���ֵ
					    	  
					    	  Double  unit= publicPageDAO.NullToDouble( unitMap.get(strFieldName));//100�ݵĵ�λ
					    	  if(unit==0){unit=1D;}
							  Double  vs =dValue/unit; 
//							  System.out.println(strFieldName+"   "+ vs +"  maxValue "+maxValue+"  dValue "+dValue );
					    	  defaultcategorydataset.addValue(vs ,publicPageDAO.NullToStr(  strNameList[j]), strFieldCName);
					    	 // defaultcategorydataset.addValue(biaoZhunValue , "��׼ֵ", strFieldCName);//��׼ֵ
			  				  //defaultcategorydataset.addValue(100, "", strFieldCName);//������ı�
		 			     }
		 			}
					 // System.out.println(  "   " );

					
	     	      }
         	 }
     		for (int i = 0; i < strResource.length; i++)
 			{//���ֶ�
 				String strFieldNames =publicPageDAO.NullToStr(strResource[i]);
  				String strFieldName=strFieldNames;
 				String strFieldCName=strFieldNames;
 				if(strFieldName.split(",").length>1)
 				{
 					 strFieldName=strFieldNames.split(",")[0];//Ӣ������
 					  strFieldCName=strFieldNames.split(",")[1];//��������
 				}
 				if (!"".equals(strFieldName))
				{ 
					  Double maxValue=   publicPageDAO.NullToDouble( MaxMap.get(strFieldName)) ;
					 
					  Double biaoZhunValue=publicPageDAO.NullToDouble( strV[i]);//��׼ֵ
					  Double zuiDaValue=publicPageDAO.NullToDouble( strHeight[i]) ;//���ֵ
			    	 
			    	  Double  unit= publicPageDAO.NullToDouble( unitMap.get(strFieldName));//100�ݵĵ�λ
			    	  if(unit==0){unit=1D;}
			    	  //Double unit=maxValue/100;//100�ݵĵ�λ 
					  biaoZhunValue=biaoZhunValue/unit;
					  zuiDaValue=zuiDaValue/unit;
			    	  defaultcategorydataset.addValue(biaoZhunValue , "��׼ֵ", strFieldCName);//��׼ֵ
			    	 // defaultcategorydataset.addValue(zuiDaValue , "���ֵ", strFieldCName);//��׼ֵ
	  				  defaultcategorydataset.addValue(dMacValue, "�߿�", strFieldCName);//������ı�
 			     }
 			}
     		 
     	 } 
    	  return defaultcategorydataset;
    }  
      
    public String getChart(HttpSession session, PrintWriter printWriter){  
          
        JFreeChart jfreeChart = createSpiderChart();  
        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());  
        String fileName = null;  
        try {  
            fileName = ServletUtilities.saveChartAsPNG(jfreeChart, 500, 300, info,  
                    session);// ����ͼƬ  
            // Write the image map to the PrintWriter  
            ChartUtilities.writeImageMap(printWriter, fileName, info, false);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        printWriter.flush();  
        return fileName;// ��������ͼƬ���ļ���  
    }  
//    private static JFreeChart createChart(CategoryDataset categorydataset) {  
//        SpiderWebPlot spiderwebplot = new SkillScorePlot(categorydataset);  
//        spiderwebplot.setStartAngle(45D);  
//        categorydataset.getValue(0, 1);  
//         
//        spiderwebplot.setBackgroundPaint(Color.LIGHT_GRAY);  
//        spiderwebplot.setMaxValue(100D);  
//        spiderwebplot.setDirection(Rotation.ANTICLOCKWISE);  
//        spiderwebplot.setAxisLinePaint(Color.blue);  
//        spiderwebplot.setInteriorGap(0.3D);  
//        spiderwebplot.setToolTipGenerator(new StandardCategoryToolTipGenerator());  
//        JFreeChart jfreechart = new JFreeChart("������Ч�Է���",TextTitle.DEFAULT_FONT, spiderwebplot, false);  
//
//        jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 16));//x����������
//
//        jfreechart.getTitle().setFont(new Font("����", Font.BOLD,22)); 
//        
//        jfreechart.setBackgroundPaint(Color.GREEN);  
//        return jfreechart;  
//    }  
    public String getSpiderChart(HttpSession session, PrintWriter printWriter){  
        
        JFreeChart jfreeChart = createSpiderChart();  
        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());  
        String fileName = null;  
        try {  
            fileName = ServletUtilities.saveChartAsPNG(jfreeChart, 500, 300, info,  
                    session);// ����ͼƬ  
            // Write the image map to the PrintWriter  
            ChartUtilities.writeImageMap(printWriter, fileName, info, false);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        printWriter.flush();  
        return fileName;// ��������ͼƬ���ļ���  
    }  
    
  
    public JFreeChart getChart() {
     return chart;
    }
}  
 