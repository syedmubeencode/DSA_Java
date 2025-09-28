package com.dsa.neetcode150;

import java.util.HashSet;

public class NeetCode_1 {
	//Problem
	/*
	 * Given an integer array nums, return true if any value appears more than once
	 * in the array, otherwise return false.
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3,3};
		System.out.println(hasDuplicate(nums));
	}

	public static boolean hasDuplicate(int[] nums) {
		HashSet<Integer> seenNumber = new HashSet<>();
		for (int num : nums) {
			if (seenNumber.contains(num)) {
				return true;
			}
			seenNumber.add(num);
		}
		return false;
	}

}
