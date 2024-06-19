package _2085CountCommonWordsWithOneOccurrence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int countWords(String[] words1, String[] words2) {
        int ans = 0;

        Map<String , Integer> map = new HashMap<>();

        for (String word : words1){
            if (!map.containsKey(word)){
                map.put(word , 1);
            }else {
                map.put(word , map.get(word)+1 );
            }
        }
        for (String word : words2){
            if (!map.containsKey(word)){
                map.put(word , 1);
            }else {
                map.put(word , map.get(word)+1 );
            }
        }

        for (Map.Entry<String, Integer> m : map.entrySet()) {

            if (m.getValue() == 2){
                ans++;
            }
        }

        return ans;
    }

    public static int countWordsGemini(String[] words1, String[] words2) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();

        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (map.get(word) > 1) {
                return 0;
            }
        }

        for (String word : words2) {
            if (map.get(word) == 1) {
                ans++;
                map.remove(word);
            }
        }

        return ans;
    }

    public static int countWordsChatGPT(String[] words1, String[] words2) {
        Map<String, Integer> countWords1 = new HashMap<>();
        Map<String, Integer> countWords2 = new HashMap<>();

        // Count the occurrences of each word in words1
        for (String word : words1) {
            countWords1.put(word, countWords1.getOrDefault(word, 0) + 1);
        }

        // Count the occurrences of each word in words2
        for (String word : words2) {
            countWords2.put(word, countWords2.getOrDefault(word, 0) + 1);
        }

        int ans = 0;

        // Check each word in countWords1 and see if it appears exactly once in both maps
        for (Map.Entry<String, Integer> entry : countWords1.entrySet()) {
            String word = entry.getKey();
            if (entry.getValue() == 1 && countWords2.getOrDefault(word, 0) == 1) {
                ans++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(countWords(new String[]{"leetcode", "is", "amazing", "as", "is"} , new String[]{"amazing", "leetcode", "is"}));
    }

}

/*2085. Count Common Words With One Occurrence
Easy
Topics
Companies
Hint
Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.



Example 1:

Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
Explanation:
- "leetcode" appears exactly once in each of the two arrays. We count this string.
- "amazing" appears exactly once in each of the two arrays. We count this string.
- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
- "as" appears once in words1, but does not appear in words2. We do not count this string.
Thus, there are 2 strings that appear exactly once in each of the two arrays.
Example 2:

Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
Output: 0
Explanation: There are no strings that appear in each of the two arrays.
Example 3:

Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
Explanation: The only string that appears exactly once in each of the two arrays is "ab".


Constraints:

1 <= words1.length, words2.length <= 1000
1 <= words1[i].length, words2[j].length <= 30
words1[i] and words2[j] consists only of lowercase English letters.*/