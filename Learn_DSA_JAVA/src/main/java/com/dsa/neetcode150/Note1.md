## Problem #1: Contains Duplicate

#### Problem Description

Given an array of integers `nums`, determine whether any value appears at least twice in the array.

- **Return** `true` if there exists any duplicate value.  
- **Otherwise**, return `false`.

#### Example

**Input:** nums = [1,2,3,1]
**Output:** true

**Input:** nums = [1,2,3,4]
**Output:** false


```
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seenNumber = new HashSet<>();
        for(int num : nums){
            if(seenNumber.contains(num)){
                return true;
            }
            seenNumber.add(num);
        }
        return false;
    }
}
```

# My Findings

- Learned about **HashSet**: its declaration, its scope, and its generic methods.  
- Understood how **HashSet** efficiently checks for duplicates.  
- Observed that adding elements and checking for existence works in **constant time on average**.
