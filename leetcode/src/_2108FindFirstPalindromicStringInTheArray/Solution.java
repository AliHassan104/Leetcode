package _2108FindFirstPalindromicStringInTheArray;

public class Solution {

    public static String firstPalindrome(String[] words) {

        String palindrome = "";

        for (String word : words){
            boolean flag = true;
            for (int i = 0; i < word.length()/2; i++) {
                if (word.charAt(i) == word.charAt(word.length()-i-1)){

                }else {
                    flag = false;
                    break;
                }
            }
            if (flag){
                palindrome = word;
                break;
            }
        }

        return palindrome;
    }

    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));
    }
}


/*
* 2108. Find First Palindromic String in the Array
Solved
Easy
Topics
Companies
Hint
Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.



Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.
Example 2:

Input: words = ["notapalindrome","racecar"]
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".
Example 3:

Input: words = ["def","ghi"]
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists only of lowercase English letters
* */