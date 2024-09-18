package _66PlusOne;

import java.util.Arrays;

public class Solution {

    // my code wrong
    public static int[] plusOne(int[] digits) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }

        Integer i = Integer.parseInt(sb.toString())+1;

        sb = new StringBuilder(i.toString());

        int[] ans = new int[sb.length()];

        for (int j = 0; j < sb.length(); j++) {
            ans[j] = Integer.parseInt(String.valueOf(sb.charAt(j)));
        }

        return ans;
    }

    public static int[] plusOneUdemy(int[] digits) {
        int currentDigit = digits.length-1;

        while (digits[currentDigit] == 9){
            if (currentDigit == 0){
                int[] newArray = new int[digits.length+1];
                newArray[0] = 1;

                return newArray;
            }
            digits[currentDigit]=0;
            currentDigit--;
        }
        digits[currentDigit]++;
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {8,9,9};
        Arrays.stream(plusOneUdemy(arr)).forEach(e-> System.out.println(e));
    }
}
