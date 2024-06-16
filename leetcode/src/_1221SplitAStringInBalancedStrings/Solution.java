package _1221SplitAStringInBalancedStrings;

public class Solution {

    public static int balancedStringSplit(String s) {

        int count = 0;
        int chr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') chr++; else chr--;
            if (chr == 0) count++;
        }
        return count;
    }

    public static int balancedStringSplitChatGPT(String s) {
        int balancedCount = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == 'R' ? 1 : -1;
            if (balance == 0) {
                balancedCount++;
            }
        }

        return balancedCount;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

}


/*
1221. Split a String in Balanced Strings
Easy
Topics
Companies
Hint
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.



Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".


Constraints:

2 <= s.length <= 1000
s[i] is either 'L' or 'R'.
s is a balanced string.
*/