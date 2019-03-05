package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class FunctionalityTest {
	
	static long startTime;
	static long stopTime;
	static double gap;
	
	//FUNCTIONALITY TEST CASES. LOW NUMBERS ARE USED FOR EASY DETERMINATION OF MIN AND MAX.
	static int[] random = new int[5]; //Randomized
	static int[] normal = new int[] {1,2,3,4,5}; //Sorted
	static int[] atStart = new int[] {5,1,2,3,4};//Min Max at the start
	static int[] atMid = new int[] {2,3,1,5,4}; // Min Max at the middle
	static int[] atEnd = new int[] {2,3,4,5,1}; // Min Max at the end
	static int[] reverse = new int[] {5,4,3,2,1};//Reverse
	
	
	 public static int randomFill(){
		 	int min = 1;
		 	int max = 20;
		    Random rand = new Random();
		    int randomNum = rand.nextInt((max - min) + 1) + min;
		    return randomNum;
		    }
	 
	 public static int[] CreateRandomArray(int[] Array) {
		    for(int i=0;i<Array.length;i++)
		    {
		        Array[i] = randomFill();
		    }
		    return Array;
		}
	
	// static int basicOperation;
	public static int[] MaxMin2(int[] intArray){
	//	basicOperation = 0;
		int minValue = intArray[0];
		int maxValue = intArray[0];
		for(int i = 1; i<=intArray.length - 1; i++) {
		//	basicOperation++;
            if (intArray[i] > maxValue) {
            	maxValue = intArray[i];
            } else {
            	if(intArray[i] < minValue){
            	minValue = intArray[i];
            }
          }
		}
		return new int[] {minValue, maxValue};
	}

	public static String Test(int[] Array) {
	//	startTime = System.nanoTime();
		int[] result = MaxMin2(Array);
	//	stopTime = System.nanoTime();
	//	gap = ((stopTime - startTime) / 1000000d);
		String string = "Minimum Element is " + result[0] + ". Maximum Element is "+ 
				result[1] + "\nArray: " + Arrays.toString(Array);
		return string;
		
	}

	public static void main(String[] args) {
		
		CreateRandomArray(random);
		System.out.println(Test(random));
		
		System.out.println(Test(normal));
		
		System.out.println(Test(atStart));
		
		System.out.println(Test(atMid));
		
		System.out.println(Test(atEnd));
		
		System.out.println(Test(reverse));
		
		
	}

}
