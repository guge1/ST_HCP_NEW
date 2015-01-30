//package nMarket.jchar; 
//
//import java.util.Arrays;
//import java.util.Date;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.DateAxis;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
//import org.jfree.chart.labels.ItemLabelAnchor;
//import org.jfree.chart.labels.ItemLabelPosition;
//import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
//import org.jfree.chart.labels.StandardXYToolTipGenerator;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYBubbleRenderer;
//import org.jfree.chart.renderer.xy.XYItemRenderer;
//import org.jfree.chart.urls.StandardXYURLGenerator;
//import org.jfree.data.DefaultKeyedValues2D;
//import org.jfree.data.time.Day;
//import org.jfree.data.time.TimePeriod;
//import org.jfree.data.time.TimeTableXYDataset;
//import org.jfree.data.xy.XYDataset;
//import org.jfree.data.xy.XYZDataset;
//
//public class FreeChart {
//
//	
//	//另外，负责画图的方法如下：
//	public static JFreeChart createBubbleChart(String title, KpiParam param, Properties map){
//	final KpiParam _param = param;
//	TimeTableXYZDataset xyz = getXYZDataset(param, map);
//	JFreeChart jfreechart = ChartFactory.createBubbleChart(title, null, null, 
//	xyz, PlotOrientation.VERTICAL, true, true, false);
//	        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
//	        xyplot.setDomainAxis(getDateAxis(param.getFor_what()));
//	        XYItemRenderer renderer = new XYBubbleRenderer(1);
//	       
//	        xyplot.setRenderer(renderer);
//	        xyplot.setForegroundAlpha(0.65F);
//	        renderer = xyplot.getRenderer();
//	        renderer.setSeriesPaint(0, PAINTS);
//	        renderer.setSeriesPaint(1, PAINTS);
//	        renderer.setLegendItemLabelGenerator(new StandardXYSeriesLabelGenerator(){
//	        public String generateLabel(XYDataset dataset, int series){
//	        return CRMDict.getDictItemName("KPI_DEFINE", "", 
//	           dataset.getSeriesKey(series).toString());
//	        }
//	        });
//	        renderer.setItemLabelGenerator(new BubbleXYItemLabelGenerator(){
//	        public String generateLabel(XYDataset dataset, int series, int item){
//	        XYZDataset xyz = (XYZDataset)dataset;
//	        double z = xyz.getZValue(series, item);
//	        return FORMAT_PERCENT.format(z/BUBBLE_ZOOM);
//	        }
//	        });
//	        renderer.setToolTipGenerator(new StandardXYToolTipGenerator(){
//	        public String generateToolTip(XYDataset dataset, int series, int item){
//	        TimeTableXYZDataset xyz = (TimeTableXYZDataset)dataset;
//	        double y, z;
//	        Day day = (Day)xyz.getTimePeriod(item);
//	        y = xyz.getYValue(series, item);
//	        z = xyz.getZValue(series, item);
//	        String kpi_id = dataset.getSeriesKey(series).toString();
//	        return "("+KpiParam.yyyy_mm_dd(day).substring(5)+", "+
//	        CRMDict.getDictItemName("KPI_DEFINE", "", kpi_id)+")" +
//	        " = "+FORMAT_DOUBLE.format(y)+"("+
//	        FORMAT_PERCENT.format(z/BUBBLE_ZOOM)+")";
//	        }
//	        });
//	        renderer.setURLGenerator(new StandardXYURLGenerator(){
//	        public String generateURL(XYDataset dataset, int series, int item){
//	        TimeTableXYZDataset xyz = (TimeTableXYZDataset)dataset;
//	        Day day = (Day)xyz.getTimePeriod(item);
//	        _param.setKpi_id(dataset.getSeriesKey(series).toString());
//	        _param.setMax_date(KpiParam.yyyy_mm_dd(day));
//	        return getURL(_param);
//	        }
//	        });
//	        renderer.setItemLabelsVisible(true);
//	        renderer.setPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
//	        DateAxis xAxis = (DateAxis)xyplot.getDomainAxis();
//	        Date lower = new Date(((Day)xyz.getTimePeriod(0)).previous().getFirstMillisecond());
//	        Date upper = new Date(((Day)xyz.getTimePeriod(xyz.getItemCount()-1)).next().getFirstMillisecond());
//	        xAxis.setRange(lower, upper);
//	        NumberAxis yAxis = (NumberAxis)xyplot.getRangeAxis();
//	        double y = 0;
//	        for(int i=0; i<xyz.getSeriesCount(); i++){
//	        for(int j=0; j<xyz.getItemCount(0); j++){
//	        y = xyz.getYValue(i, j);
//	        }
//	        }
//	        Arrays.sort(y);
//	        double offset = (y - y)/5;
//	        yAxis.setRange(y - offset, y + offset);
//	        return jfreechart;
//	} 
//}
