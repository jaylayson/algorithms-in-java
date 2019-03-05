package bruteForceMedian;

public class BasicOpTestBruteForce {
	/*
	 * Sets of Odd arrays for AVG EFFICIENCY.
	 */
	static int[] M1 = new int[] {3,2,1,4,5};
	static int[] M2 = new int[] {1,3,2,4,5};
	static int[] M3 = new int[] {1,2,3,4,5};
	static int[] M4 = new int[] {1,2,4,3,5};
	static int[] M5 = new int[] {1,2,4,5,3};
	
	/*
	 * Sets of Even arrays for ORDER OF GROWTH.
	 */
	static int[] O5 = new int[] {1,2,4,5,3};
	static int[] O10 = new int[] {1,2,3,4,6,7,8,9,10,5};
	static int[] O20 = new int[] {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20,10};
	static int[] O40 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,40,
									21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,20};
	
	/*
	 * Sets of Arrays for both AVG EFF. and ORDER OF GROWTH
	 */
	static int[] AOG1 = new int[] {1,2,3,4,5,6,7,8,9,10};
	static int[] AOG2 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	static int[] AOG3 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
	static int[] AOG4 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
	static int[] AOG5 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
	static int[] AOG6 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60};
	static int[] AOG7 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70};
	static int[] AOG8 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80};
	static int[] AOG9 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90};
	static int[] AOG10 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
	 /*
	 * BruteForceMedian Algorithm.
	 * Used to find median if the array is UNSORTED.
	 */
	static int basicOp;
	static int bruteForceMedian(int[] array) {
		basicOp = 0;
		int n = array.length;
		double k = Math.ceil((double) n / 2.0);
		for (int i = 0; i <= n - 1; i++) {
			int numSmaller = 0;
			int numEqual = 0;
			for (int j = 0; j <= n - 1; j++) {
				basicOp++;
				if (array[j] < array[i]) {
					numSmaller++;
				} else if (array[j] == array[i]) {
					numEqual++;
				}
			}
			if (numSmaller < k && k <= (numSmaller + numEqual)) {
				return array[i];

			}
		}
		return 0;
	}
	
	public static String Test(int[]Array) {
		int result = bruteForceMedian(Array);
		String string = "Basic Operation Count: " + basicOp +"\nArray: " + Array.length;
		return string;
	}

	public static void main(String[] args) {
		
		/*
		 * 5 elements in 5 arrays, each median is placed in index 0,1st,2nd,3rd,4th,5th per output
		 */
//		System.out.println(Test(M1));
//		System.out.println(Test(M2));
//		System.out.println(Test(M3));
//		System.out.println(Test(M4));
//		System.out.println(Test(M5));
		
//		System.out.println(Test(O5));
//		System.out.println(Test(O10));
//		System.out.println(Test(O20));
//		System.out.println(Test(O40));
		
		System.out.println(Test(AOG1));
		System.out.println(Test(AOG2));
		System.out.println(Test(AOG3));
		System.out.println(Test(AOG4));
		System.out.println(Test(AOG5));
		System.out.println(Test(AOG6));
		System.out.println(Test(AOG7));
		System.out.println(Test(AOG8));
		System.out.println(Test(AOG9));
		System.out.println(Test(AOG10));
		
		
	}
}
