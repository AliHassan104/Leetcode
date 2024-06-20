package _2185CountingWordsWithAGivenPrefix;

public class Solution {

    public static int prefixCount(String[] words, String pref) { // wrong
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < pref.length(); j++) {
                if (words[i].length() >= pref.length() && words[i].charAt(j) != pref.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                ans++;
            }
        }

        return ans;
    }

    public static int prefixCountChatGPT(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.length() >= pref.length() && word.startsWith(pref)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
    }

}

/*2185. Counting Words With a Given Prefix
Easy
Topics
Companies
Hint
You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.



Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
Example 2:

Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.


Constraints:

1 <= words.length <= 100
1 <= words[i].length, pref.length <= 100
words[i] and pref consist of lowercase English letters.*/