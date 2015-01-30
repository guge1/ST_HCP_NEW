package nMarket.FinishChar;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JPanel;


import nMarket.FinishChar.Spider.CreateSpiderChart_Mark;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.TextAnchor;

import system.dao.Impl.PublicDateDAO;
import system.dao.Impl.PublicPageDAO;

import com.opensymphony.xwork2.ActionSupport;

public class ChartAction  extends ActionSupport implements ServletRequestAware {
	

	private HttpServletRequest request = null;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
private static final long serialVersionUID = 5752180822913527064L;
private JFreeChart chart;
private PublicDateDAO publicDateDAO=null;
private PublicPageDAO publicPageDAO = null;
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

public String execute(){
  
	//chart=getPieChar(); ±ýÍ¼
	
	 CreateSpiderChart_Mark SpiderChart=new CreateSpiderChart_Mark();
	 PaoPaoChart PaoPaoChart=new PaoPaoChart();
		chart= SpiderChart.createSpiderChart();
		//	chart=PaoPaoChart.createChart();
      return SUCCESS;

}



public JFreeChart getChart() {
 return chart;
}


}