package bruteForceMedian;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class ExecutionTimeBruteForceMedian {
	
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
	 * BruteForceMedian Algorithm.
	 * Used to find median if the array is UNSORTED.
	 */
    static int bruteForceMedian(int[] array) {
		int n = array.length;
		double k = Math.ceil((double) n / 2.0);
		for (int i = 0; i <= n - 1; i++) {
			int numSmaller = 0;
			int numEqual = 0;
			for (int j = 0; j <= n - 1; j++) {
				if (array[j] < array[i]) {
					numSmaller++;
				} 
				else if (array[j] == array[i]) {
					numEqual++;
				}
			}
			if (numSmaller < k && k <= (numSmaller + numEqual)) { //This is what really checks if the candidate is median
				return array[i];

			}
		}
		return 0;
	}
    
  @Test
  	public void testExecutionTimeBruteForceMedian()
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
  				bruteForceMedian(arrayData);
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
  						BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Nathan/Documents/runTimeBruteForceMedian.csv", true));
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
