package com.dsa.neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class NeetCode_6 {
	// Problem
	/*
	 * Given an integer array nums and an integer k, return the k most frequent
	 * elements in the array. • You may return the answer in any order. The test
	 * cases are generated such that the answer is always unique.
	 */

	public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append('#').append(str);
        }
        return encoded.toString();
    } // Decodes a single string back to a list of strings

    public static List<String> decode(String encodedStr) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < encodedStr.length()) {
            int j = i; // find the '#' delimiter to extract length
            while (encodedStr.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(encodedStr.substring(i, j));
            j++; // move past '#'
            String word = encodedStr.substring(j, j + length);
            result.add(word);
            i = j + length; // move to next encoded segment
        }
        return result;
    } // Driver code

    public static void main(String[] args) {
        List<String> input = Arrays.asList("neet", "code", "love", "you");
        String encoded = encode(input);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
