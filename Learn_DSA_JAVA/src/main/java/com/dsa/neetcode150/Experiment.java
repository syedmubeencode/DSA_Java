package com.dsa.neetcode150;

import java.util.*;

public class Experiment {
	public static void main(String[] args) {
		// Example 1: Using fixed array for frequency counting
		String word = "apple";
		int[] count = new int[26];
		for (char c : word.toCharArray()) {
			count[c - 'a']++;
		}
		System.out.println("Frequency of characters in 'apple': " + Arrays.toString(count));
		// Output
		/*
		 * Frequency of characters in 'apple': [1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0,
		 * 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		 */

		// Example 2: Using computeIfAbsent
		Map<String, List<String>> map = new HashMap<>();
		String key = "fruit";
		String str = "apple";

		map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);

		System.out.println("Map after insertion: " + map);
		// Output
		/* Map after insertion: {fruit=[apple]} */

	}
}
