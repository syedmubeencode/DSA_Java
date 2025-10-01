package com.dsa.neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NeetCode_4 {
	// Problem
	/*
	 * Given an array of strings strs, group all anagrams together into sublists.
	 * You may return the output in any order.
	 * 
	 * An anagram is a string that contains the exact same characters as another
	 * string, but the order of the characters can be different.
	 */

	// ** NOTE ** //
	// Streams method = stream
	// Old method = core
	// HashMap method = method
	// Recursion method = recursion

	public static void main(String[] args) {
		String[] strs = { "act", "pots", "tops", "cat", "stop", "hat" };

		System.out.println(groupAnagaram(true, "method", strs)); // ✅ HashMap sorting key
		System.out.println(groupAnagaram(true, "core", strs)); // ✅ Brute force
		System.out.println(groupAnagaram(true, "stream", strs)); // ✅ Java Streams
		System.out.println(groupAnagaram(true, "recursion", strs));// ✅ Recursion
	}

	private static List<List<String>> groupAnagaram(boolean start, String method, String[] strs) {
		if (!start)
			return Collections.emptyList();

		if (method.equalsIgnoreCase("method")) {
			// ✅ HashMap method (best: O(n * k log k))
			Map<String, List<String>> map = new HashMap<>();
			for (String str : strs) {
				char[] chars = str.toCharArray();
				Arrays.sort(chars); // sort letters
				String key = new String(chars);
				map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
			}
			return new ArrayList<>(map.values());
		} else if (method.equalsIgnoreCase("core")) {
			// ✅ Brute force method (O(n^2 * k))
			List<List<String>> result = new ArrayList<>();
			boolean[] visited = new boolean[strs.length];

			for (int i = 0; i < strs.length; i++) {
				if (!visited[i]) {
					List<String> group = new ArrayList<>();
					group.add(strs[i]);
					visited[i] = true;
					for (int j = i + 1; j < strs.length; j++) {
						if (!visited[j] && isAnagram(strs[i], strs[j])) {
							group.add(strs[j]);
							visited[j] = true;
						}
					}
					result.add(group);
				}
			}
			return result;
		} else if (method.equalsIgnoreCase("stream")) {
			// ✅ Streams method (groupingBy with sorted key)
			return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
				char[] chars = s.toCharArray();
				Arrays.sort(chars);
				return new String(chars);
			})).values());
		} else if (method.equalsIgnoreCase("recursion")) {
			// ✅ Recursion method
			List<List<String>> result = new ArrayList<>();
			boolean[] visited = new boolean[strs.length];
			groupAnagaramRec(strs, 0, visited, result);
			return result;
		}

		return Collections.emptyList();
	}

	// Helper for brute force anagram check
	private static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] a = s1.toCharArray(), b = s2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		return Arrays.equals(a, b);
	}

	// ✅ Helper for recursion
	private static void groupAnagaramRec(String[] strs, int index, boolean[] visited, List<List<String>> result) {
		if (index == strs.length)
			return;

		if (!visited[index]) {
			List<String> group = new ArrayList<>();
			group.add(strs[index]);
			visited[index] = true;

			for (int j = index + 1; j < strs.length; j++) {
				if (!visited[j] && isAnagram(strs[index], strs[j])) {
					group.add(strs[j]);
					visited[j] = true;
				}
			}
			result.add(group);
		}

		groupAnagaramRec(strs, index + 1, visited, result); // move to next index
	}
}
