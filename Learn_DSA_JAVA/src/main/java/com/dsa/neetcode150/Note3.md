# Problem #3: Two Sum

## Problem Description

Given an array of integers `nums` and an integer `target`, return the indices `[i, j]` such that:

- `nums[i] + nums[j] == target`  
- `i != j`  

The answer should be returned with the smaller index first.  
You may assume that there is exactly **one unique solution** for every input.

## Examples

**Example 1**  
```text
Input: nums = [3, 4, 5, 6], target = 7
Output: [0, 1]
Explanation: nums[0] + nums[1] == 7



```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                return new int[] {map.get(compliment), i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }
}
```

# My Findings

- Learned to declare a normal array with a fixed size, as we used to declare before using collections.
- Remember: for **Strings**, we use `s.length()`; for **arrays**, we use `arr.length` (no brackets).

