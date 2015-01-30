package nMarket.jchar;
//package nMarket.actions;
//
//import org.jfree.data.DefaultKeyedValues2D;
//import org.jfree.data.time.TimePeriod;
//import org.jfree.data.time.TimeTableXYDataset;
//import org.jfree.data.xy.XYZDataset;
//
//public class TimeTableXYZDataset extends TimeTableXYDataset implements XYZDataset{
//	private DefaultKeyedValues2D zValues;
//
//	public TimeTableXYZDataset(){
//	super();
//	zValues = new DefaultKeyedValues2D(true);
//	}
//
//	public void add(String seriesName, TimePeriod period, double y, double z){
//	add(seriesName, period, ((Number) (new Double(y))), ((Number) (new Double(z))), true);
//	}
//
//	public void add(String seriesName, TimePeriod period, Number y, Number z, boolean notify)
//	    {
//	add(period, y, seriesName, notify);
//	zValues.addValue(z, period, seriesName);
//	        if(notify)
//	            fireDatasetChanged();
//	    }
//
//	public Number getZ(int series, int item){
//	return zValues.getValue(item, series);
//	}
//
//	public double getZValue(int series, int item){
//	return getZ(series, item).doubleValue();
//	}
//	}
