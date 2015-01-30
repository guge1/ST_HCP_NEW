package nMarket.FinishChar;

import java.util.List;

import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.XYZDataset;

import system.dao.Impl.PublicDateDAO;
import system.dao.Impl.PublicPageDAO;

/**
 * A quick-and-dirty implementation of the {@link XYZDataset interface}.  
 * Hard-coded and not useful beyond the demo.
 */
public class spiderXYZDataset extends AbstractXYZDataset 
        implements XYZDataset {

    /** The x values. */
    private double[][] xVal = {{1.0}, {4.0}, {5.0}};

    /** The y values. */
    private double[][] yVal = {{1.0}, {4.0}, {5.0}};

    /** The z values. */
    private double[][] zVal = {{1.1}, {4.4}, {5.0}};
    private  String[]  strNames={"值1","值2","值3"};

 
    /*
     * 人员姓名
     */
	public  void setNames(String[]  strNameList    )
    {
    	
    	 this.strNames= strNameList;
    }
	  /*
     * y
     */
	public  void setXVal(double[][]  xVal    )
    {
    	
    	  this.xVal= xVal;
    }

	  /*
   * y
   */
	public  void setYVal(double[][]  yVal    )
  {
  	
  	  this.yVal= yVal;
  }
	  /*
     * y
     */
	public  void setZVal(double[][] zVal    )
    {
    	
    	  this.zVal= zVal;
    }
    /**
     * Returns the number of series in the dataset.
     *
     * @return The series count.
     */
    public int getSeriesCount() {
        return xVal.length;
    }

    /**
     * Returns the key for a series.
     *
     * @param series  the series (zero-based index).
     *
     * @return The key for the series.
     */
    public Comparable getSeriesKey(int series) {
        //return "Series " + series;
        return  strNames[series];
    }

    /**
     * Returns the number of items in a series.
     *
     * @param series  the series (zero-based index).
     *
     * @return The number of items within the series.
     */
    public int getItemCount(final int series) {
        return this.xVal[0].length;
    }

    /**
     * Returns the x-value for an item within a series.
     * <P>
     * The implementation is responsible for ensuring that the x-values are
     * presented in ascending order.
     *
     * @param series  the series (zero-based index).
     * @param item  the item (zero-based index).
     *
     * @return The x-value.
     */
    public Number getX(int series, int item) {
        return new Double(this.xVal[series][item]);
    }

    /**
     * Returns the y-value for an item within a series.
     *
     * @param series  the series (zero-based index).
     * @param item  the item (zero-based index).
     *
     * @return The y-value.
     */
    public Number getY(int series, int item) {
        return new Double(this.yVal[series][item]);
    }

    /**
     * Returns the z-value for the specified series and item.
     *
     * @param series  the series index (zero-based).
     * @param item  the item index (zero-based).
     *
     * @return The value.
     */
    public Number getZ(final int series, final int item) {
        return new Double(this.zVal[series][item]);
    }
    
}