# Problem #2: Valid Anagram

## Problem Description

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.  

An **anagram** is a word or phrase formed by rearranging the letters of another word or phrase, using all the original letters exactly once.

## Examples

**Example 1:**


Input: s = "racecar", t = "carrace"
Output: true
Explanation: Both strings contain the same characters with the same frequency.



```
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] charCounts = new int[26];
        for(int i=0; i<s.length();i++){
            charCounts[s.charAt(i)-'a']++;
            charCounts[t.charAt(i)-'a']--;
        }
        for(int count : charCounts){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
```

# My Findings

- Learned to declare a normal array with a fixed size, as we used to declare before using collections.
- Remember: for **Strings**, we use `s.length()`; for **arrays**, we use `arr.length` (no brackets).

