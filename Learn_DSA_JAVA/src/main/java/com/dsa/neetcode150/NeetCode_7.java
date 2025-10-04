package com.dsa.neetcode150;

import java.util.Arrays;

public class NeetCode_7 {
	// Problem:
	/*
	 * Given an integer array nums, return an array output where output[i] is the
	 * product of all the elements of nums except nums[i].
	 * 
	 * Constraint: Solve in O(n) without division.
	 */

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 4, 6 };
		int[] nums2 = { -1, 0, 1, 2, 3 };

		System.out.println(Arrays.toString(productExceptSelf(true, "method", nums1)));
		System.out.println(Arrays.toString(productExceptSelf(true, "method", nums2)));
	}

	private static int[] productExceptSelf(boolean start, String method, int[] nums) {
		if (!start)
			return new int[] {};

		if (method.equalsIgnoreCase("method")) {
			// ✅ Optimal O(n) without division using prefix + suffix
			int n = nums.length;
			int[] output = new int[n];

			// Step 1: prefix product
			output[0] = 1;
			for (int i = 1; i < n; i++) {
				output[i] = output[i - 1] * nums[i - 1];
			}

			// Step 2: suffix product (right product)
			int suffix = 1;
			for (int i = n - 1; i >= 0; i--) {
				output[i] *= suffix;
				suffix *= nums[i];
			}
			return output;

		} else if (method.equalsIgnoreCase("core")) {
			// ✅ Brute force O(n^2)
			int n = nums.length;
			int[] output = new int[n];

			for (int i = 0; i < n; i++) {
				int product = 1;
				for (int j = 0; j < n; j++) {
					if (i != j)
						product *= nums[j];
				}
				output[i] = product;
			}
			return output;

		} else if (method.equalsIgnoreCase("stream")) {
			// ✅ Streams approach (less efficient, but concise)
			int n = nums.length;
			int[] output = new int[n];

			for (int i = 0; i < n; i++) {
				int index = i;
				output[i] = Arrays.stream(nums).filter(val -> val != nums[index]
						|| index != Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)).indexOf(val))
						.reduce(1, (a, b) -> a * b);
			}
			return output;

		} else if (method.equalsIgnoreCase("recursion")) {
			// ✅ Recursive approach
			int n = nums.length;
			int[] output = new int[n];
			productRec(nums, 0, 1, output);
			return output;
		}

		return new int[] {};
	}

	// Helper recursion (post-order style)
	private static int productRec(int[] nums, int index, int prefix, int[] output) {
		if (index == nums.length)
			return 1;

		int suffix = productRec(nums, index + 1, prefix * nums[index], output);
		output[index] = prefix * suffix;
		return nums[index] * suffix;
	}

}
