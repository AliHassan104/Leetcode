package _189RotateArray;

import java.util.Arrays;

public class Solution {

    public static void rotate(int[] nums, int k) {

        // Normalize k to avoid unnecessary rotations
        k = k % nums.length;

        // reverser entire array
        // {7,6,5,4,3,2,1}
        reverse(nums,0, nums.length-1);

        // {5,6,7 , 4,3,2,1}
        reverse(nums,0,k-1);

        // {5,6,7 , 1,2,3,4}
        reverse(nums,k, nums.length-1);

        Arrays.stream(nums).forEach(e-> System.out.print(e + " "));
    }

    public static void reverse(int[] nums , int start , int end){

        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7}; // { 5,6,7,1,2,3,4 }
                                    // 1) {7,6,5,4,3,2,1}  (2) {5,6,7 , 1,2,3,4}
        int k = 3;

        rotate(arr , k);
    }

}
