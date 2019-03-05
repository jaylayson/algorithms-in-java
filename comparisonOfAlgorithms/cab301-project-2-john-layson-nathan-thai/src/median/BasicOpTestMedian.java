package median;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;

public class BasicOpTestMedian {
	static int[] M1 = new int[] {5,4,3,2,1}; //Reversed
	static int[] M2 = new int[] {3,2,1,4,5}; //First index
	static int[] M3 = new int[] {1,3,2,4,5};// Second index
	static int[] M4 = new int[] {1,2,3,4,5}; //Sorted Ascending
	static int[] M5 = new int[] {1,2,4,3,5}; //4th index
	static int[] M6 = new int[] {1,2,4,5,3}; //Last Index
	
	
	static int[] arrayData;
    static Random rand = new Random();
	
	static int basicOp;
	static int Median(int[] array) {
		basicOp = 0;
		int n = array.length;
		if(n == 1) {
			return array[0];
		} else {
			return Select(array, 0, Math.floor((n/2.0)), n - 1);
		}
	}
	
	/*
	 * Select helper method for Median.
	 */
	static int Select(int[] array, int l, double m, int h) {
		int pos = Partition(array, l, h);
		if(pos == m) {
			return array[pos];
		}
		if(pos > m) {
			return Select(array, l, m, pos - 1);
		}
		if(pos < m) {
			return Select(array, pos + 1, m, h);
		}
		
		return 0;
	}
	
	/*
	 * Partition helper method for Select.
	 */
	static int Partition(int[] array, int l, int h) {
		int pivotval = array[l];
		int pivotloc = l;
		for(int j = l + 1; j <= h; j++) {
			basicOp++;
			if(array[j] < pivotval) {
				pivotloc++;
				swap(array[pivotloc],array[j], pivotloc, j, array);
			}
		}
		swap(array[l], array[pivotloc], l, pivotloc, array);
		return pivotloc;
	}
	
	/*
	 * Swap helper method for Partition.
	 */
	static void swap(int value1, int value2, int index1, int index2, int[]array)
    {
        int temp = value1;
        array[index1] = value2;
        array[index2] = temp;
    }
	
	
	
	public static String Test(int[]Array) {
		int result = Median(Array);
		String string = "Basic Operation Count: " + basicOp +  "\nMedian: " + result;
		return string;
	}
	
	/*
     * Used to create an array with an array index of between 1 and 5000
     */
    public static void createArray(String populate)
    {
    	String whichData = populate;
    	if (whichData == "5000");
    	{
    		int min1 = 1;
    		int max1 = 5000;
    		int min2 = 0;
    		int max2 = 5000;
    		
    		int arrayLengthVar = rand.nextInt(max1 - min1) + min1;
    		arrayData = new int[arrayLengthVar];
    		
    		for (int i = 0; i < arrayData.length; i++)
    		{
    			int arrayValue = rand.nextInt(max2 + 1 - min2) + min2;
    			arrayData[i] = arrayValue;
    		}
    	}
    }
    
    @Test
	public void testExecutionTimeMedian()
	{	
		for (int i = 0; i < 100; i++)
		{
			createArray("5000");
			Median(arrayData);
			try
			{
				String str = String.valueOf(basicOp);
				String str2 = String.valueOf(arrayData.length);
				BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Nathan/Documents/basicOpMedian.csv", true));
				writer.write(str2 + "," + str);
				writer.newLine();
				writer.close();
			}
			catch(IOException e)
			{
				System.out.println("Oops");
			}
		}
	}

	public static void main(String[] args) {
		
		System.out.println(Test(M1));
		System.out.println(Test(M2));
		System.out.println(Test(M3));
		System.out.println(Test(M4));
		System.out.println(Test(M5));
		System.out.println(Test(M6));

	}

}
