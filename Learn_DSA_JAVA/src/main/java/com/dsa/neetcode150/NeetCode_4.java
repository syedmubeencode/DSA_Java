package com.dsa.neetcode150;

import java.util.*;
import java.util.stream.IntStream;

public class NeetCode_4 {
	// Problem
	/*
	 * Given an array of strings strs, group the strings that are anagrams of each
	 * other into sublists. You may return the output in any order. An anagram is a
	 * word formed by rearranging the letters of another word, using all the
	 * original letters exactly once.
	 */
	
	// ** NOTE ** //
	// Streams method = stream
	// Old method = core
	// HashMap method = method
	// Recursion method = recursion
	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 6 };
		int target = 7;

		System.out.println(Arrays.toString(twoSum(true, "method", nums, target)));
	}

	private static int[] twoSum(boolean start, String method, int[] nums, int target) {
		if (!start)
			return new int[] {};

		if (method.equalsIgnoreCase("method")) {
			// ✅ HashMap method (best: O(n))
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int compliment = target - nums[i];
				if (map.containsKey(compliment)) {
					return new int[] { map.get(compliment), i };
				}
				map.put(nums[i], i);
			}
		} else if (method.equalsIgnoreCase("core")) {
			// ✅ Brute force method (O(n^2))
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						return new int[] { i, j };
					}
				}
			}
		} else if (method.equalsIgnoreCase("stream")) {
			// ✅ Streams method (less efficient, but functional style)
			return IntStream
					.range(0, nums.length).boxed().flatMap(i -> IntStream.range(i + 1, nums.length)
							.filter(j -> nums[i] + nums[j] == target).mapToObj(j -> new int[] { i, j }))
					.findFirst().orElse(new int[] {});
		} else if (method.equalsIgnoreCase("recursion")) {
			// ✅ Recursion method
			return twoSumRecursive(nums, target, 0, 1);
		}

		return new int[] {};
	}

	// Helper for recursion
	private static int[] twoSumRecursive(int[] nums, int target, int i, int j) {
		if (i >= nums.length - 1)
			return new int[] {};
		if (j >= nums.length)
			return twoSumRecursive(nums, target, i + 1, i + 2);
		if (nums[i] + nums[j] == target)
			return new int[] { i, j };
		return twoSumRecursive(nums, target, i, j + 1);
	}
}
