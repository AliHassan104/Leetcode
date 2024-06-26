package _2023NumberOfPairsOfStringsWithConcatenationEqualToTarget;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int numOfPairs(String[] nums, String target) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if ((nums[i] + nums[j]).equalsIgnoreCase(target)) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static int numOfPairsChatGPT(String[] nums, String target) {
        int ans = 0;
        Map<String, Integer> countMap = new HashMap<>();

        for (String num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (String num : nums) {
            if (target.startsWith(num)) {
                String suffix = target.substring(num.length());
                ans += countMap.getOrDefault(suffix, 0);

                if (suffix.equals(num)) {
                    ans--;
                }
            }
        }

        return ans;
    }

    public static int numOfPairsGemini(String[] nums, String target) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i < target.length(); i++) {
            String prefix = target.substring(0, i);
            String suffix = target.substring(i);

            if (map.containsKey(prefix) && map.containsKey(suffix)) {
                int count = map.get(prefix) * map.get(suffix);

                if (prefix.equals(suffix)) {
                    count--;
                }

                ans += count;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numOfPairs(new String[]{"777", "7", "77", "77"} , "7777"));
    }
}

/*2023. Number of Pairs of Strings With Concatenation Equal to Target
Medium
Topics
Companies
Hint
Given an array of digit strings nums and a digit string target, return the number of pairs of indices (i, j) (where i != j) such that the concatenation of nums[i] + nums[j] equals target.



Example 1:

Input: nums = ["777","7","77","77"], target = "7777"
Output: 4
Explanation: Valid pairs are:
- (0, 1): "777" + "7"
- (1, 0): "7" + "777"
- (2, 3): "77" + "77"
- (3, 2): "77" + "77"
Example 2:

Input: nums = ["123","4","12","34"], target = "1234"
Output: 2
Explanation: Valid pairs are:
- (0, 1): "123" + "4"
- (2, 3): "12" + "34"
Example 3:

Input: nums = ["1","1","1"], target = "11"
Output: 6
Explanation: Valid pairs are:
- (0, 1): "1" + "1"
- (1, 0): "1" + "1"
- (0, 2): "1" + "1"
- (2, 0): "1" + "1"
- (1, 2): "1" + "1"
- (2, 1): "1" + "1"


Constraints:

2 <= nums.length <= 100
1 <= nums[i].length <= 100
2 <= target.length <= 100
nums[i] and target consist of digits.
nums[i] and target do not have leading zeros.*/