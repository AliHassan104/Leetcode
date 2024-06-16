package _1108DefangingAnIPAddress;

import java.util.Arrays;

public class Solution {

    public static String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder();

        String[] s = address.split("\\.");

        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
            if (i != s.length-1){
                sb.append("[.]");
            }
        }

        return sb.toString();

    }

    public static String defangIPaddrChatGPT(String address) {
        StringBuilder sb = new StringBuilder();

        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("255.100.50.0"));
    }

}

/*
1108. Defanging an IP Address
Solved
Easy
Topics
Companies
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".



Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"


Constraints:

The given address is a valid IPv4 address.
* */