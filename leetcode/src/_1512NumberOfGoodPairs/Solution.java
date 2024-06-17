package _1512NumberOfGoodPairs;

import java.util.HashMap;

public class Solution {
    public static int numIdenticalPairs(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int numIdenticalPairsGemini(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                ans += map.get(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }
}

/*
1512. Number of Good Pairs
Solved
Easy
Topics
Companies
Hint
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
* */