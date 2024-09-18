package _350IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer , Integer> map = new HashMap<>();

        ArrayList<Integer> intersectionalArr = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])){
                map.put(nums1[i] , map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])){
                intersectionalArr.add(nums2[i]);
                map.put(nums2[i] , map.get(nums2[i])-1);
                if (map.get(nums2[i]) == 0){
                    map.remove(nums2[i]);
                }
            }
        }

        int[] result = new int[intersectionalArr.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = intersectionalArr.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};

        int[] arr3 = intersect(arr1, arr2);

        Arrays.stream(arr3).forEach(e-> System.out.println(e));

    }
}
