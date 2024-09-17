package _136SingleNumber;

public class Solution {
    public static int singleNumber(int[] nums) {
        int finder = 0;
        for (int i = 0; i < nums.length; i++) {
            finder ^= nums[i];
        }
        return finder;
    }

    public static void main(String[] args) {
       int[] arr = {1,2,3,2,1,4,3};
        System.out.println(singleNumber(arr));
    }
}
