package leetcode1094;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[][] trips = {{3,2,7},{3,7,9}, {8,3,9}};
		
		int capacity = 11;
		
		System.out.println("input: " + Arrays.deepToString(trips) + " capacity: " + capacity);
		
		CheckIfAbleToCarPool solution = new CheckIfAbleToCarPool();
		
		System.out.println("Solution: " + solution.carPooling(trips, capacity));
	}
}
