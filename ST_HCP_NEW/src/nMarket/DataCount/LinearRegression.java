package nMarket.DataCount;

import java.text.DecimalFormat;

//
//* <p><b>Linear Regression</b>
//* <br>
//* Demonstrate linear regression by constructing the regression line for a set
//* of data points.
//*
//* <p>require DataPoint.java,RegressionLine.java
//*
//* <p>为了计算对于给定数据点的最小方差回线，需要计算SumX,SumY,SumXX,SumXY; (注：SumXX = Sum (X^2))
//* <p><b>回归直线方程如下： f(x)=a1x a0 </b>
//* <p><b>斜率和截距的计算公式如下：</b>
//* <br>n: 数据点个数
//
//* <p>a1=(n(SumXY)-SumX*SumY)/(n*SumXX-(SumX)^2)
//* <br>a0=(SumY - SumY * a1)/n
//* <br>(也可表达为a0=averageY-a1*averageX)
//*
//* <p><b>画线的原理：两点成一直线，只要能确定两个点即可</b><br>
//* 第一点：(0,a0) 再随意取一个x1值代入方程，取得y1，连结(0,a0)和(x1,y1)两点即可。
//* 为了让线穿过整个图,x1可以取横坐标的最大值Xmax，即两点为(0,a0),(Xmax,Y)。如果y=a1*Xmax a0,y大于
//* 纵坐标最大值Ymax，则不用这个点。改用y取最大值Ymax，算得此时x的值，使用(X,Ymax)， 即两点为(0,a0),(X,Ymax)
//*
//* <p><b>拟合度计算：(即Excel中的R^2)</b>
//* <p> *R2 = 1 - E
//* <p>误差E的计算：E = SSE/SST
//* <p>SSE=sum((Yi-Y)^2) SST=sumYY - (sumY*sumY)/n;
//* <p>
//*/
public class LinearRegression
{
	private static final int MAX_POINTS = 10;
	private double E;
	
	/**
	* Main program.
	*
	* @param args
	* the array of runtime arguments
	*/
	public static void main(String args[])
	{
		RegressionLine line = new RegressionLine();
		
	//	line.addDataPoint(new DataPoint(20, 136));
	//	line.addDataPoint(new DataPoint(40, 143));
	//	line.addDataPoint(new DataPoint(60, 152));
	//	line.addDataPoint(new DataPoint(80, 162));
	//	line.addDataPoint(new DataPoint(100, 167));
		
		
		
	
		line.addDataPoint(new DataPoint(1 , 359408 )); 
		
	
		line.addDataPoint(new DataPoint(2 ,  287526)); 
	
		line.addDataPoint(new DataPoint( 3, 369676 )); 
		
	
		line.addDataPoint(new DataPoint( 4, 349216 )); 
	
		line.addDataPoint(new DataPoint( 5, 288947 )); 
		
	
		line.addDataPoint(new DataPoint(6 ,  319283)); 
	
		line.addDataPoint(new DataPoint(7 , 358992 )); 
	
		line.addDataPoint(new DataPoint( 8, 448768 )); 
		line.addDataPoint(new DataPoint( 9, 325810 )); 
		line.addDataPoint(new DataPoint( 10, 331109 )); 
		line.addDataPoint(new DataPoint(11 ,199552  )); 
		line.addDataPoint(new DataPoint(12 ,312067  )); 
		printSums(line);
		printLine(line);
	}
	/**
	 * Print the computed sums.
	 *
	 * @param line
	 *            the regression line
	 */
	   private static void printSums(RegressionLine line)
	   {
	       System.out.println("/n数据点个数 n = " + line.getDataPointCount());
	       System.out.println("/nSum x  = " + line.getSumX());
	       System.out.println("Sum y  = " + line.getSumY());
	       System.out.println("Sum xx = " + line.getSumXX());
	       System.out.println("Sum xy = " + line.getSumXY());
	       System.out.println("Sum yy = " + line.getSumYY());      
	      
	   }
	
	   /**
	 * Print the regression line function.
	 *
	 * @param line
	 *            the regression line
	 */
	   private static void printLine(RegressionLine line)
	   {
	       System.out.println("/n回归线公式:  y = " + (line.getA0() + line.getA1()*13 ));
	      // System.out.println("拟合度：     R^2 = " + line.getR());
	
		   DecimalFormat df = new DecimalFormat("0.0"); 
		   
	//       System.out.println("结果：     lastResult = " + df.format( line.getResult()));
	       
	   }
  

} 
