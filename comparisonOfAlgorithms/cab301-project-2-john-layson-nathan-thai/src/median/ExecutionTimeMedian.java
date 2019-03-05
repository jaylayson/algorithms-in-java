package median;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class ExecutionTimeMedian {

	static int[] arrayData;
    static Random rand = new Random();
    
    static double startTime;
    static double endTime;
    static double runTime;

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
    
	/*
	 * Median Algorithm.
	 * Used to find median if the array is SORTED.
	 */
	static int Median(int[] array) 
	{
		int n = array.length; //the -1 is because it is returning 1 index too high(ensure to explain in report)
		if (n == 1) 
		{
			return array[0];
		} 
		else 
		{
			return Select(array, 0, Math.floor((n/2.0)), n - 1);
		}
	}
	
	
	/*
	 * Select helper method for Median.
	 */
	static int Select(int[] array, int l, double m, int h) 
	{
		int pos = Partition(array, l, h);
		
		if (pos == m) 
		{
			return array[pos];
		}
		if (pos > m) 
		{
			return Select(array, l, m, pos - 1);
		}
		if (pos < m) 
		{
			return Select(array, pos + 1, m, h);
		}
		return 0;
	}
	
	
	/*
	 * Partition helper method for Select.
	 */
	static int Partition(int[] array, int l, int h) 
	{
		int pivotval = array[l];
		int pivotloc = l;
		
		for(int j = l + 1; j <= h; j++) 
		{
			if (array[j] < pivotval) 
			{
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
	static void swap(int value1, int value2, int index1, int index2, int[] array)
    {
        int temp = value1;
        array[index1] = value2;
        array[index2] = temp;
    }
	
	@Test
	public void testExecutionTimeMedian()
	{	
		double runTimeAverage = 0.0;
		double runTimeTotal = 0.0;
		
		for (int i = 0; i < 100; i++)
		{
			createArray("5000");
			runTimeTotal = 0;
			runTimeAverage = 0;
			for (int j = 0; j < 10; j++)
			{
				startTime = System.nanoTime();
				Median(arrayData);
				endTime = System.nanoTime();
				runTime = ((endTime - startTime)/1000000000);
				runTimeTotal += runTime;
				runTimeAverage = runTimeTotal/10.0;
				if (j == 9)
				{
					try
					{
						String str = String.valueOf(runTimeAverage);
						String str2 = String.valueOf(arrayData.length);
						BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Nathan/Documents/runTimeMedian.csv", true));
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
		}
	}
}
