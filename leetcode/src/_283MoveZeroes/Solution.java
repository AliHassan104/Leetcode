package _283MoveZeroes;

import java.util.Arrays;

public class Solution {

    public static void moveZeroes(int[] nums) {

        if (nums.length<2){
            return;
        }

        int L = 0;
        int R = 1;

        while (R < nums.length){
            if (nums[L] != 0){
                L++;
                R++;
            } else if (nums[R] == 0 ) {
                R++;
            } else {
                int temp = nums[R];
                nums[R] = nums[L];
                nums[L] = temp;
            }
        }



    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        Arrays.stream(arr).forEach(e-> System.out.println(e));

        //{0,1,0,3,12}
        // L R
        // 1 0 0 3 12
        //   L R
        // 1 0 0 3 12
        //   L   R
        // 1 3 0 0 12
        //



    }

}
