# Problem #4: Group Anagrams

## Problem Description

Given an array of strings `strs`, group the strings that are anagrams of each other into sublists.  
You may return the output in any order.

An **anagram** is a word formed by rearranging the letters of another word, using all the original letters exactly once.

---

## Example 1

**Input:**
```text
strs = ["act", "pots", "tops", "cat", "stop", "hat"]



```
import java.util.*;
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            // create a unique key like "a2b1c0..."
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append("#");
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(input));
    }
}
```

# My Findings

- Please generelize using this `int[] count = new int[26]`; kind of fixed array.
- You should know how it working `count[c - 'a']++`;
- Know what this map function do `map.computeIfAbsent` and know the complete what this line will do `map.computeIfAbsent(key, k -> new ArrayList<>()).add(str)`;


## Understanding `computeIfAbsent` in Java

## Explanation

- `computeIfAbsent` checks if the key exists in the map.  
- If it does not exist, it creates a new value (here, a new `ArrayList`).  
- Finally, it adds `str` to the list corresponding to the key.  

```
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
```


