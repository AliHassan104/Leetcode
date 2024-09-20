package _1TwoSum;

import java.util.Arrays;
import java.util.Hashtable;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {

        Hashtable<Integer , Integer> numbersFound = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            if (numbersFound.containsKey(target - nums[i])){
                return new int[] { numbersFound.get(target - nums[i]) , i  };
            }
            numbersFound.put(nums[i] , i);
        }

        return null;

    }

    public static void main(String[] args) {
        int[] arr = {2,7,5,4,11};
        int target = 11;
        Arrays.stream(twoSum(arr, target)).forEach(e-> System.out.println(e));
    }

}
