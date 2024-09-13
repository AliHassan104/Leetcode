package array._26RemoveDuplicatesFromSortedArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // my way
    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        return set.size();
    }

    public static int removeDuplicatesUdemy(int[] nums) {
        int lastUniqueIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[lastUniqueIndex] != nums[i]){
                nums[lastUniqueIndex + 1] = nums[i];
                lastUniqueIndex++;

            }
        }

        return lastUniqueIndex+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,2,3,3,3,3};
        System.out.println(removeDuplicatesUdemy(arr));
    }
}
