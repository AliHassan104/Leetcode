package _2053KthDistinctStringInAnArray;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public static String kthDistinct(String[] arr, int k) {
        String ans = "";

        Map<String , Integer> map = new LinkedHashMap<>();

        for (String a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<String> distinctStrings = map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Returning the k-th distinct string if it exists
        return k <= distinctStrings.size() ? distinctStrings.get(k - 1) : "";
    }

    public static String kthDistinctChatGPT(String[] arr, int k) {
        Map<String, Integer> countMap = new LinkedHashMap<>();

        // Counting occurrences of each string
        for (String str : arr) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        // Finding the k-th distinct string
        for (String str : arr) {
            if (countMap.get(str) == 1) {
                k--;
                if (k == 0) {
                    return str;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"} , 2));
    }
}

/*2053. Kth Distinct String in an Array
Easy
Topics
Companies
Hint
A distinct string is a string that is present only once in an array.

Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.



Example 1:

Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1st, so it is the 1st distinct string.
"a" appears 2nd, so it is the 2nd distinct string.
Since k == 2, "a" is returned.
Example 2:

Input: arr = ["aaa","aa","a"], k = 1
Output: "aaa"
Explanation:
All strings in arr are distinct, so the 1st string "aaa" is returned.
Example 3:

Input: arr = ["a","b","a"], k = 3
Output: ""
Explanation:
The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".*/