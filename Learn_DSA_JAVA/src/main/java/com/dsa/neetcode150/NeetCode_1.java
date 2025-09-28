package com.dsa.neetcode150;

import java.util.*;

public class NeetCode_1 {
	// Problem
	/*
	 * Given an integer array nums, return true if any value appears more than once
	 * in the array, otherwise return false.
	 */

	// ** NOTE ** //
	// Streams method = Streams
	// Old method = core
	// Recursion method = recursion
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3 };

		System.out.println(hasDuplicate(true, "method", nums));
	}

	private static boolean hasDuplicate(boolean start, String method, int[] nums) {
		if (!start)
			return false;

		if (method.equalsIgnoreCase("method")) {
			HashSet<Integer> seenNumber = new HashSet<>();
			for (int num : nums) {
				if (seenNumber.contains(num)) {
					return true;
				}
				seenNumber.add(num);
			}
		} else if (method.equalsIgnoreCase("core")) {
			// ✅ Core Java (Sorting)
			Arrays.sort(nums);
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] == nums[i - 1]) {
					return true;
				}
			}
		} else if (method.equalsIgnoreCase("stream")) {
			return Arrays.stream(nums).distinct().count() != nums.length;
		} else if (method.equalsIgnoreCase("recursion")) {
			return hasDuplicateRecursive(nums, 0, new HashSet<>());
		}

		return false;
	}

	// Helper method for recursion
	private static boolean hasDuplicateRecursive(int[] nums, int index, Set<Integer> seen) {
		if (index == nums.length)
			return false; // base case
		if (seen.contains(nums[index]))
			return true; // duplicate found
		seen.add(nums[index]);
		return hasDuplicateRecursive(nums, index + 1, seen); // move to next
	}
}
