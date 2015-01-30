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
//* <p>Ϊ�˼�����ڸ������ݵ����С������ߣ���Ҫ����SumX,SumY,SumXX,SumXY; (ע��SumXX = Sum (X^2))
//* <p><b>�ع�ֱ�߷������£� f(x)=a1x a0 </b>
//* <p><b>б�ʺͽؾ�ļ��㹫ʽ���£�</b>
//* <br>n: ���ݵ����
//
//* <p>a1=(n(SumXY)-SumX*SumY)/(n*SumXX-(SumX)^2)
//* <br>a0=(SumY - SumY * a1)/n
//* <br>(Ҳ�ɱ��Ϊa0=averageY-a1*averageX)
//*
//* <p><b>���ߵ�ԭ�������һֱ�ߣ�ֻҪ��ȷ�������㼴��</b><br>
//* ��һ�㣺(0,a0) ������ȡһ��x1ֵ���뷽�̣�ȡ��y1������(0,a0)��(x1,y1)���㼴�ɡ�
//* Ϊ�����ߴ�������ͼ,x1����ȡ����������ֵXmax��������Ϊ(0,a0),(Xmax,Y)�����y=a1*Xmax a0,y����
//* ���������ֵYmax����������㡣����yȡ���ֵYmax����ô�ʱx��ֵ��ʹ��(X,Ymax)�� ������Ϊ(0,a0),(X,Ymax)
//*
//* <p><b>��϶ȼ��㣺(��Excel�е�R^2)</b>
//* <p> *R2 = 1 - E
//* <p>���E�ļ��㣺E = SSE/SST
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
	       System.out.println("/n���ݵ���� n = " + line.getDataPointCount());
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
	       System.out.println("/n�ع��߹�ʽ:  y = " + (line.getA0() + line.getA1()*13 ));
	      // System.out.println("��϶ȣ�     R^2 = " + line.getR());
	
		   DecimalFormat df = new DecimalFormat("0.0"); 
		   
	//       System.out.println("�����     lastResult = " + df.format( line.getResult()));
	       
	   }
  

} 
