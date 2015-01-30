package nMarket.FinishChar.Spider;

import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics2D;  
import java.awt.font.FontRenderContext;  
import java.awt.font.LineMetrics;  
import java.awt.font.TextAttribute;  
import java.awt.geom.Arc2D;  
import java.awt.geom.Point2D;  
import java.awt.geom.Rectangle2D;  
import java.util.HashMap;  
import org.jfree.chart.plot.SpiderWebPlot;  
import org.jfree.data.category.CategoryDataset;  
  
/** 
 *  
 * 因为要用到显示数据的标签,必须重写SpiderWebPlot类的drawLabel方法: 
 *  
 */  
public class SkillScorePlot extends SpiderWebPlot {  
  
    private static final long serialVersionUID = 1L;  
  
    /** 
     * @param LABELANDAXISGAP : the gap between the label and the axis. 
     * @param LABELANDCENTERGAP : the gap between the label and the center point. 
     */  
    private static final double LABELANDAXISGAP = 10;  
    private static final double LABELANDCENTERGAP = 1;  
  
    public SkillScorePlot(CategoryDataset categorydataset) {  
        super(categorydataset);  
    }  
  
    /** 
     * @param extent : the angle gap between two near axis. 
     */  
    @Override  
    protected void drawLabel(Graphics2D graphics2D, Rectangle2D rectangle2D,  
            double value, int cat, double startAngle, double extent) {  
  
        super  
                .drawLabel(graphics2D, rectangle2D, value, cat, startAngle,  
                        extent);  
  
        /** 
         * @param sumAxisNum : the sum number of the axis. 
         * @param centerX : the center X coordinate of the panel. 
         * @param centerY : the center Y coordinate of the panel. 
         */  
        int sumAxisNum = this.getDataset().getColumnCount();  
        double centerX = rectangle2D.getCenterX();  
        double centerY = rectangle2D.getCenterY();  
        Arc2D arc2D;  
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();  
  
        for (int currentAxisNum = 0; currentAxisNum < sumAxisNum; currentAxisNum++) {  
  
            /** 
             * @param currentValue : the value of the current axis. 
             * @param label : the value on the label. 
             * @param scale : the scale of the point value to the max value on 
             *            current axis. 
             */  
            double currentValue = this.getDataset().getValue(0, currentAxisNum).doubleValue();  
            String label = String.valueOf((int) currentValue);  
            double scale = (currentValue / this.getMaxValue());  
            /** 
             * the coordinate of the label 
             */  
  
            if (startAngle == this.getStartAngle()) {  
                double labelX;  
                double labelY;  
                /** 
                 * @param currentAngle : the angle of the current axis where the label place. 
                 */  
                double currentAngle = extent * currentAxisNum + startAngle;  
                arc2D = new Arc2D.Double(rectangle2D, currentAngle, 0, Arc2D.OPEN);  
                Point2D point2D = arc2D.getEndPoint();  
                double axisX = Math.abs(point2D.getX() - centerX)* scale;  
                double axisY = Math.abs(point2D.getY() - centerY)* scale;  
  
                if (currentAngle >= 0 && currentAngle < 90) {  
                    labelX = centerX + axisX;  
                    labelY = centerY - axisY;  
                } else if (currentAngle < 180) {  
                    labelX = centerX - axisX;  
                    labelY = centerY - axisY;  
                } else if (currentAngle < 270) {  
                    labelX = centerX - axisX;  
                    labelY = centerY + axisY;  
                } else {  
                    labelX = centerX + axisX;  
                    labelY = centerY + axisY;  
                }  
                  
                LineMetrics lm = getLabelFont().getLineMetrics(label,  
                        fontRenderContext);  
                double ascent = lm.getAscent();  
  
                /** 
                 * set the gap between the label and axis, or between the label 
                 * and the center point. 
                 */  
                if (Math.abs(labelX - rectangle2D.getCenterX()) < LABELANDCENTERGAP) {  
                    labelX += LABELANDAXISGAP;  
                    labelY += ascent / (float) 2;  
                } else if (Math.abs(labelY - rectangle2D.getCenterY()) < LABELANDCENTERGAP) {  
                    labelY += LABELANDAXISGAP;  
                } else if (labelX >= rectangle2D.getCenterX()) {  
                    if (labelY < rectangle2D.getCenterY()) {  
                        labelX += LABELANDAXISGAP;  
                        labelY += LABELANDAXISGAP;  
                    } else {  
                        labelX -= LABELANDAXISGAP;  
                        labelY += LABELANDAXISGAP;  
                    }  
                } else {  
                    if (labelY > rectangle2D.getCenterY()) {  
                        labelX -= LABELANDAXISGAP;  
                        labelY -= LABELANDAXISGAP;  
                    } else {  
                        labelX += LABELANDAXISGAP;  
                        labelY -= LABELANDAXISGAP;  
                    }  
                }  
                //set label font  
                HashMap<TextAttribute, Comparable<?>> hm = new HashMap<TextAttribute, Comparable<?>>();  
                hm.put(TextAttribute.SIZE, 14);   
                hm.put(TextAttribute.FAMILY,"Impact");//  
                Font font = new Font(hm);  
  
                graphics2D.setPaint(Color.blue);  
                graphics2D.setFont(font);  
                graphics2D.drawString(label, (float) labelX, (float) labelY);  
            }  
        }  
    }  
}  