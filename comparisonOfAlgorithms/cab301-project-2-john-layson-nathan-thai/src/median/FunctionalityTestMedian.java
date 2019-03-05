package median;

import java.util.Arrays;

public class FunctionalityTestMedian {
	
    /*
	 * Sets of Unsorted Even arrays
	 */
	static int[] R10 = new int[] {9,2,1,5,6,3,10,8,7,4};
	static int[] R20 = new int[] {6,5,16,4,10,3,2,20,15,18,7,11,17,14,13,9,1,12,8,19};
	static int[] R30 = new int[] {16,9,5,2,17,1,22,27,8,20,10,21,7,30,29,14,15,23,28,25,24,13,18,3,12,19,6,4,11,26};
	
	/*
	 * Sets of Sorted Even arrays
	 */
	static int[] S10 = new int[] {1,2,3,4,5,6,7,8,9,10};
	static int[] S20 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	static int[] S30 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
	/*
	 * Sets of Unsorted Odd arrays.
	 */
	static int[] R11 = new int[] {9,1,10,11,8,5,2,7,6,4,3};
	static int[] R21 = new int[] {9,13,17,20,4,1,2,8,11,18,12,15,14,21,5,7,10,6,16,3,19};
	static int[] R31 = new int[] {7,31,26,19,10,25,21,8,4,24,28,2,23,1,5,14,18,29,13,17,11,22,9,30,16,6,3,15,20,27,12};
	
	/*
	 * Sets of Sorted Odd arrays.
	 */
	static int[] S11 = new int[] {1,2,3,4,5,6,7,8,9,10,11};
	static int[] S21 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
	static int[] S31 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	
	
	/*
	 * Sets of Unsorted arrays with median duplicates.
	 */
	static int[]D5 = new int[] {5,1,4,3,3};
	static int[]D6 = new int[] {1,3,4,5,6,3};
    
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
	public static String Test(int[]Array) {
		int result = Median(Array);
		
		String string = "Median is: " + result +"\nArray: " +
		Arrays.toString(Array);
		return string;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(Test(S11) + " (Odd|Sorted)");
		//System.out.println(Test(S21) + " (Odd|Sorted)");
		//System.out.println(Test(S31) + " (Odd|Sorted)\n");
		
		System.out.println(Test(R11) + " (Odd|Unsorted)");
		//System.out.println(Test(R21) + " (Odd|Unsorted)");
		//System.out.println(Test(R31) + " (Odd|Unsorted)\n");
		
		System.out.println(Test(R10) + " (Even|Unsorted)");
		//System.out.println(Test(R20) + " (Even|Unsorted)");
		//System.out.println(Test(R30) + " (Even|Unsorted)\n");
		
		System.out.println(Test(S10) + " (Even|Sorted)");
		//System.out.println(Test(S20) + " (Even|Sorted)");
		//System.out.println(Test(S30) + " (Even|Sorted)\n");
		
		System.out.println(Test(D5) + " (Odd|Unsorted)");
		System.out.println(Test(D6) + " (Even|Sorted)\n");		
	}
	
}
