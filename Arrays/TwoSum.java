// Problem: Two Sum
// Platform: LeetCode
// Difficulty: Easy
// Time: O(n)
// Space: O(n)

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            map.put(nums[i], i);
        }
        
        // This line only executes if no pair is found (won’t happen per problem)
        return new int[0];
    }
}
