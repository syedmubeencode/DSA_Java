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

public class NeetCode_5 {
	// Problem
	/*
	 * Given an integer array nums and an integer k, return the k most frequent
	 * elements within the array.
	 * 
	 * The test cases are generated such that the answer is always unique.
	 * 
	 * You may return the output in any order.
	 */

	// ** NOTE ** //
	// Streams method = stream
	// Old method = core
	// HashMap method = method
	// Recursion method = recursion

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 3, 3 };
		int k = 2;

		System.out.println(groupSolutionDSA(true, "method", nums, k)); // ✅ HashMap + Heap
//		System.out.println(groupSolutionDSA(true, "core", nums, k)); // ✅ Sorting by frequency
//		System.out.println(groupSolutionDSA(true, "stream", nums, k)); // ✅ Streams
//		System.out.println(groupSolutionDSA(true, "recursion", nums, k)); // ✅ Recursion
	}

	private static List<Integer> groupSolutionDSA(boolean start, String method, int[] nums, int k) {
		if (!start)
			return Collections.emptyList();

		if (method.equalsIgnoreCase("method")) {
			// ✅ HashMap + PriorityQueue (Heap) → O(n log k)
			Map<Integer, Integer> freqMap = new HashMap<>();
			for (int num : nums) {
				freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
			}

			PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
					Comparator.comparingInt(Map.Entry::getValue));

			for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
				heap.offer(entry);
				if (heap.size() > k)
					heap.poll();
			}

			List<Integer> result = new ArrayList<>();
			while (!heap.isEmpty()) {
				result.add(heap.poll().getKey());
			}
			return result;
		} else if (method.equalsIgnoreCase("core")) {
			// ✅ Sorting by frequency → O(n log n)
			Map<Integer, Integer> freqMap = new HashMap<>();
			for (int num : nums) {
				freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
			}

			return freqMap.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).limit(k)
					.map(Map.Entry::getKey).collect(Collectors.toList());
		} else if (method.equalsIgnoreCase("stream")) {
			// ✅ Pure Streams → concise
			return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet()
					.stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue())).limit(k).map(Map.Entry::getKey)
					.collect(Collectors.toList());
		} else if (method.equalsIgnoreCase("recursion")) {
			// ✅ Recursion approach (simulate sorting by recursion)
			Map<Integer, Integer> freqMap = new HashMap<>();
			for (int num : nums) {
				freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
			}

			List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
			List<Integer> result = new ArrayList<>();
			topKRec(entries, result, k, 0);
			return result;
		}

		return Collections.emptyList();
	}

	// ✅ Helper for recursion
	private static void topKRec(List<Map.Entry<Integer, Integer>> entries, List<Integer> result, int k, int index) {
		if (index == k || entries.isEmpty())
			return;

		// Find max frequency element
		Map.Entry<Integer, Integer> maxEntry = Collections.max(entries, Comparator.comparingInt(Map.Entry::getValue));
		result.add(maxEntry.getKey());
		entries.remove(maxEntry);

		topKRec(entries, result, k, index + 1);
	}
}
