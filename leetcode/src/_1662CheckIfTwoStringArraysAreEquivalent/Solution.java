package _1662CheckIfTwoStringArraysAreEquivalent;

class Solution {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        boolean flag = false;
        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();

        for (int i = 0; i < word1.length; i++) {
            w1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            w2.append(word2[i]);
        }
        if(w1.toString().equals(w2.toString())){
            flag = true;
        }
        return flag;
    }

    public static boolean arrayStringsAreEqualChatGPT(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();
        for (String s : word1) {
            w1.append(s);
        }
        for (String s : word2) {
            w2.append(s);
        }
        return w1.toString().equals(w2.toString());
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }
}

/*
1662. Check If Two String Arrays are Equivalent
        Solved
Easy
        Topics
Companies
        Hint
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.
        Example 1:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true

Constraints:

        1 <= word1.length, word2.length <= 103
        1 <= word1[i].length, word2[i].length <= 103
        1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.

*/