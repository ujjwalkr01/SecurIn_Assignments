package SecurIn_Assign;

import java.util.Arrays;

public class QuestionB {

	public static void main(String[] args) {

		int dieA[] = { 1, 2, 3, 4, 5, 6 };
		int dieB[] = { 1, 2, 3, 4, 5, 6 };

//		int n = dieA.length;
//
//		int resArr[] = undoom_dice(dieA, dieB, n);

		int[] newDieA = undoom_dice(dieA, dieB);
		int[] newDieB = Arrays.copyOf(dieB, dieB.length);

		System.out.println("printing the new Die A");
		for (int i = 0; i < newDieA.length; i++) {
			System.out.print(newDieA[i] + " ");
		}
		System.out.println();
		System.out.println("printing the new Die B");
		for (int i = 0; i < newDieB.length; i++) {
			System.out.print(newDieB[i] + " ");
		}
	}

	private static int[] undoom_dice(int[] dieA, int[] dieB) {

		int[] newDieA = Arrays.copyOf(dieA, dieA.length);

		// Transforming Die A to meet the conditions
		for (int i = 0; i < newDieA.length; i++) {
			if (newDieA[i] > 4) {
				newDieA[i] = 4; // Set the maximum spots on a face to 4
			}
		}

		// Calculating the sum probabilities for original dice
		double[] originalSumProbCnt = calculateSumProbabilities(dieA, dieB);

		// Calculating the sum probabilities for the transformed dice
		double[] transformedSumProbabilities = calculateSumProbabilities(newDieA, dieB);

		// Checking if the probabilities are the same
		for (int i = 0; i < originalSumProbCnt.length; i++) {
			if (originalSumProbCnt[i] != transformedSumProbabilities[i]) {
				System.out.println("Transformation not successfull");
				break;
			}
		}

		return newDieA;
	}

	private static double[] calculateSumProbabilities(int[] dieA, int[] dieB) {
		double[] sumProbabilities = new double[12];

		for (int i = 0; i < dieA.length; i++) {
			for (int j = 0; j < dieB.length; j++) {
				int sum = dieA[i] + dieB[j];
				sumProbabilities[sum - 2] += 1.0 / (dieA.length * dieB.length);
			}
		}

		return sumProbabilities;
	}

//	private static int[] undoom_dice(int[] Die_A, int[] Die_B, int n) {
//
//		// so here I am creating the array for counting of all the possible sum of
//		// Original Dice_A & Dice_B
//		int originalProbCnt[] = new int[n * 2 + 1];
//
//		// finding the possible sum of both the both the dice
//		for (int i : Die_A) {
//			for (int j : Die_B) {
//				originalProbCnt[i + j]++;
//			}
//		}
//
////		for (int i = 0; i < originalProbCnt.length; i++) {
////			System.out.print(originalProbCnt[i] + " ");
////		}
//
//		// As per given problem statement Dice_A should not have more than 4
//		// spots.Therefore I have created the new_DieA array of same length as
//		// Die_A and running the loop for ensuring that it must not containing more than 4 spots.
//		int new_DieA[] = new int[n];
//
//		for (int i = 0; i < new_DieA.length; i++) {
//			new_DieA[i] = Math.min(4, Die_A[i]);
//		}
//
////		for (int i = 0; i < new_DieA.length; i++) {
////			System.out.print(new_DieA[i] + " ");
////		}
//
//		// Now finding the difference between the sum of the spots of new_DieA and Die_A.
//		int sum_DieA = 0, sum_new_DieA = 0;
//
//		for (int ele : Die_A) {
//			sum_DieA += ele;
//		}
//		for (int ele : new_DieA) {
//			sum_new_DieA += ele;
//		}
//
//		int maxSpot = sum_new_DieA - sum_DieA;
//
////		System.out.println(maxSpot);
//
//		// Using the loop for redistributing the excess spots by reducing the spots on
//		// faces that currently have the maximum spots.
//		for (int i = 0; i < maxSpot; i++) {
//			int indexOfMax = indexOfMaxValue(new_DieA);
//			new_DieA[indexOfMax]--;
//		}
//
//		// Then I have created the transArr array to store the count of the possible sum
//		// of the newDieA and Die_B
//		int transArr[] = new int[2 * n + 1];
//
//		for (int i : new_DieA) {
//			for (int j : Die_B) {
//				transArr[i + j]++;
//			}
//		}
//
//		// Now will be matching the possible sum of both the probability if they will be
//		// same then returning the original DieA
//		// else will be returning the newDieA
//
//		for (int i = 0; i < originalProbCnt.length; i++) {
//			if (originalProbCnt[i] != transArr[i]) {
//				System.out.println("Probabilites of obtaining the Sums are not same");
//				return Die_A;
//			}
//		}
//		return new_DieA; // Probabilites of the sum are same
//
//	}
//
//	public static int indexOfMaxValue(int[] array) {
//		int maxIndex = 0;
//		int maxValue = array[0];
//		for (int i = 1; i < array.length; i++) {
//			if (array[i] > maxValue) {
//				maxValue = array[i];
//				maxIndex = i;
//			}
//		}
//		return maxIndex;
//	}

}
