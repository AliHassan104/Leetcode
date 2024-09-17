package _136SingleNumber;

public class Solution {
    public static int singleNumber(int[] nums) {
        int finder = 0;
        for (int i = 0; i < nums.length; i++) {
            finder ^= nums[i]; // xor ^ -> meaning if different 1 else(same) 0
        }

        /*
        * starting with finder zero
        * 0000 -> 0 , 0100 -> 4 xor 0100 (4)
        * 0100 -> 4 , 0001 -> 1 xor 0101 (5)
        * 0101 -> 5 , 0010 -> 2 xor 0111 (7)
        * 0111 -> 7 , 0001 -> 1 xor 0110 (6)
        * 0110 -> 6 , 0010 -> 2 xor 0100 (4) which is the answer
        * what's happening here is if we xor a number twice wh=ith same number we get same answer
        * i.e. (4 ^ 1) ^ 1 = 4
        * so if only one 1 is which is not repeated and all number are writen twice we get unique number
        * in the end
        *  */
        return finder;
    }

    public static void main(String[] args) {
       int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
}
