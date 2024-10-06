package com.dsa.hashTable;

import java.util.HashMap;

public class TwoSum3Oct {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int target = 3;
		int[] result = twoSum(nums, target);
		for(int i : result) {
			System.out.println(i);
		}
	}
}


/*
 
 #Problem
 
Problem: Given an array of integers, find two numbers such that they add up to a specific target. Return the indices of the two numbers.
Approach: Use a hash table to store the elements and their indices while traversing the array. For each element, check if the complement (target - current element) exists in the hash table.
 
 
 */

