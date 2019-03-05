package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class CountBasicOp {
	static long startTime;
	static long stopTime;
	static double gap = 0.0;
	
	//Best case
	static int[] bestCase =  new int[] {1,2,3,4,5,6,7,8,9,10};
	//Average case
	static int[] avgCase = new int[] {1,2,3,4,5,10,6,7,8,9};
	//Worst case
	static int[] worstCase = new int[] {10,1,2,3,4,5,6,7,8,9};
	
	
	//CONSTANT GROWTH/DIFFERENCES REFLECTS ON NUMBER OF BASIC OPS
	//Length:20
	static int[] smallestSorted = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	//Length:40
	static int[] smallSorted = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
	//Length:60
	static int[] mediumSorted = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60};
	//Length:80
	static int[] largeSorted = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80};
	//Length:100
	static int[] largerSorted = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
	//Length:120
	static int[] largestSorted = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120};
	 
	public static int randomFill(){
		 	int min = 1;
		 	int max = 10; //Changed to 20 in FunctionalityTest.java for better identification.
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
	 
	 static int elseCounter;
	 static int basicOperation;
	public static int[] MaxMin2(int[] intArray){
		basicOperation = 0;
		elseCounter = 0;
		int minValue = intArray[0];
		int maxValue = intArray[0];
		for(int i = 1; i<=intArray.length - 1; i++) {
         if (intArray[i] > maxValue) {
        	basicOperation++; 
         	maxValue = intArray[i];
         } else {
        	 elseCounter++;
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
		String string = 
	  "Number of times basic operation is executed: " + basicOperation + "\n" + "Else Executed: "+ elseCounter +
	  "\nArray length: " + Array.length + "\nArray values: " + Arrays.toString(Array)+ "\n"; //+
	//  "\nMinimum Element is " + result[0] + ". Maximum Element is "+ 
	 //result[1] + "\n";
		return string;
		
	}
	
	/*
	 * The first set of tests are for testing constant difference with constant array growth 
	 * The second set of tests are for testing the number of basic ops with random growths
	 */
	public static void main(String[] args) {
		System.out.println("!!Best case, average case, worst case and a random array scenarios!!\n");
		System.out.println(Test(bestCase));
		System.out.println(Test(avgCase));
		System.out.println(Test(worstCase));
		System.out.println("\n------------------------------------------------------------------\n\n");
		System.out.println("The bigger the array, the more basic operations(Sorted)\n");
		System.out.println(Test(smallestSorted));
		System.out.println(Test(smallSorted));
		System.out.println(Test(mediumSorted));
		System.out.println(Test(largeSorted));
		System.out.println(Test(largerSorted));
		System.out.println(Test(largestSorted));
	}

}
