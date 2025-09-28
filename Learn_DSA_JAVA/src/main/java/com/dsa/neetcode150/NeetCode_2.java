package com.dsa.neetcode150;

import java.util.*;

public class NeetCode_2 {
	// Problem
	/*
	 * Valid Anagram: Given two strings s and t, return true if the two strings are
	 * anagrams of each other, otherwise return false.
	 */

	// ** NOTE ** //
	// Streams method = Streams
	// Old method = core
	// Recursion method = recursion
	public static void main(String[] args) {
		String s = "racecar", t = "carrace";

		System.out.println(isAnagram(true, "method", s, t));
	}

	private static boolean isAnagram(boolean start, String method, String s, String t) {
		if (!start)
			return false;

		if (s.length() != t.length())
			return false;

		if (method.equalsIgnoreCase("method")) {
			int[] charCounts = new int[26];
			for (int i = 0; i < s.length(); i++) {
				charCounts[s.charAt(i) - 'a']++;
				charCounts[t.charAt(i) - 'a']--;
			}
			for (int count : charCounts) {
				if (count != 0)
					return false;
			}
			return true;
		} else if (method.equalsIgnoreCase("core")) {
			char[] sArr = s.toCharArray();
			char[] tArr = t.toCharArray();
			Arrays.sort(sArr);
			Arrays.sort(tArr);
			return Arrays.equals(sArr, tArr);
		} else if (method.equalsIgnoreCase("stream")) {
			return s.chars().sorted().boxed().toList().equals(t.chars().sorted().boxed().toList());
		} else if (method.equalsIgnoreCase("recursion")) {
			return isAnagramRecursive(s, t, new int[26], 0);
		}

		return false;
	}

	// Helper for recursion
	private static boolean isAnagramRecursive(String s, String t, int[] counts, int index) {
		if (index == s.length()) {
			for (int count : counts) {
				if (count != 0)
					return false;
			}
			return true;
		}
		counts[s.charAt(index) - 'a']++;
		counts[t.charAt(index) - 'a']--;
		return isAnagramRecursive(s, t, counts, index + 1);
	}
}
