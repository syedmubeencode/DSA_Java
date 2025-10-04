# Problem #5: Top K Frequent Elements

## Problem Description

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements in the array.

- You may return the answer in any order.  
- The test cases are generated such that the answer is always unique.

## Example 1

```text
Input: nums = [1, 2, 2, 3, 3, 3], k = 2
Output: [2, 3]

Explanation:
The elements 2 and 3 appear most frequently.
```

```text
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int n : nums) {
        freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>(Map.Entry.comparingByValue());
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
        pq.offer(entry);
        if (pq.size() > k) {
            pq.poll(); // remove lowest frequency
        }
    }
    return pq.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
}
```

# My Findings

- Learned how to use a **HashMap** to store frequency counts of elements.  
- Understood the use of a **PriorityQueue (Max Heap)** to efficiently get the top `k` elements.  
- Practiced using **getOrDefault** for cleaner frequency counting.  
- Observed that extracting from the heap ensures we always get the most frequent elements first.  



## Understanding `somthing` in Java
```


```


```


