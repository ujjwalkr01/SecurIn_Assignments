package SecurIn_Assign;

public class Question1 {

	public static void main(String[] args) {

		int dieA[] = { 1, 2, 3, 4, 5, 6 };
		int dieB[] = { 1, 2, 3, 4, 5, 6 };

		int n = dieA.length;
		int m = dieB.length;

		// part-A-->1 Total no. of combination possible

		partA1_PrintingAllCombinationPairOfDie(dieA, n, dieB, m);

		System.out.println("-------------partA-1 ends------------------");

		// part-A-->2 calculating all the combination of pairs and storing in 6*6 matrix

		partA2_CalculatingCombinationOfPairs(dieA, n, dieB, m);

		System.out.println("-------------partA-1 ends------------------");

		// part-A-->3 Finding the probability of all the Possible Sums occurring among
		// the number of combinations from (2).

		partA3_findProbabilityofAllSum(dieA, n, dieB, m);

	}

	private static void partA1_PrintingAllCombinationPairOfDie(int[] dieA, int n, int[] dieB, int m) {
		
		/*LOGIC----->
		 * As per given problem statement both dice have six faces each. 
		 * Therefore the possible outcomes can be calculated by rolling both dices and by counting the unique pairs of them.
		 * Hence the logic is that I have initialized the variable combination that will be counting all the unique pairs of the die.
		 * And I am running two loops--> outer loop for the length of dieA and inner loop for the length of dieB.
		 * And hence for each face of the dieA with dieB we will be getting the unique pairs and combination will get incremented hence giving
		 * the result of 6*6=36 total possible outcomes.
		 */

		int combination = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// printing the pairs
				// hence for 1 face it will be printing all the 6 possible face of the dice b
				// therefore for 6*6 will be 36
				System.out.print("(" + dieA[i] + "," + dieB[j] + ") ");
				combination++;
			}
			System.out.println();
		}
		System.out.println("Total combination outcomes of two dice:- " + combination);
	}

	private static void partA2_CalculatingCombinationOfPairs(int[] dieA, int n, int[] dieB, int m) {

		// creating new 2d matrix of 6*6(because we got to know there will be total 36
		// possible combination) for storing the combination pairs sum
		
		/*LOGIC----->
		 * So I have created a 2d array for storing the sum of the possible outcome pairs.
		 * For that I have created two for loops both starting from index 1 to 6 that denotes the faces of die
		 * And for storing them in matrix I have decremented i and j value by 1 as we know array index always starts with 0.
		 * Hence will go inserting the value in matrix by just adding the i and j value(where i and j represent the number of faces in die)
		 */

		int arr[][] = new int[n][m];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// stroing the value in matrix
				arr[i - 1][j - 1] = i + j;
			}
		}

		// displaying the 2d matrix
		System.out.println("printing all the sum of possible combination pairs");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void partA3_findProbabilityofAllSum(int[] dieA, int n, int[] dieB, int m) {

		// creating new 2d matrix of 6*6(because we got to know there will be total 36
		// possible combination) for storing the combination pairs sum
		
		/*LOGIC--->
		 * First I am finding all the possible combination sum and storing it in matrix of 6*6
		 * Then I have calculated the max possible combination sum and stored in variable sum(i.e 12).
		 * Then I have initialized the variable totalObs for storing the value of total Observation
		 * (as formula to find the probability=No. of Observation/Total Observations)
		 * 
		 * Then I ran a loop from i=2 till 12 as per problem statement for finding the number of observation present.
		 * Then I have printed it according to the problem statement example.
		 * */

		int arr[][] = new int[n][m];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// stroing the value in matrix
				arr[i - 1][j - 1] = i + j;
			}
		}

		// now finding the probability of the possible sum

		// max sum will be 12 in matrix as large face value is 6 in both die adding both
		// will be giving the sum 12;
		int sum = n + m;

		// TO find the probability of any given value the formula is no of
		// Observation/total no of observation.

		int totalObs = n * m;

		System.out.println("Probability of the possible combination sum from 2");

		for (int i = 2; i <= sum; i++) {
			//for finding the number of observations or count
			int count = findCountOfPossibleSumInMatrix(arr, i);

			System.out.printf("Sum=%d. DieA=DieB=%d\t", i, count);
			System.out.printf("P(Sum=%d)=%d/%d", i, count, totalObs);
			System.out.println();
		}
	}

	//function for finding the number of observations
	private static int findCountOfPossibleSumInMatrix(int[][] arr, int ele) {
		
		/*
		 * Iterating in a matrix to find the element number of observation.
		 * Each time the element will be found then count will get incremented and
		 * at end it will return the number of observation(count) of element.
		 * */

		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == ele) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
