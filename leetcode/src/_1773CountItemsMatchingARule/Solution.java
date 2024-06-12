package _1773CountItemsMatchingARule;

import java.util.Arrays;
import java.util.List;

class Solution {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int rule = 2;
        int countMatches = 0;

        if (ruleKey == "type"){
            rule = 0;
        }else if (ruleKey == "color"){
            rule = 1;
        }

        for (int i = 0; i < items.size(); i++) {
           if(items.get(i).get(rule) == ruleValue){
                countMatches++;
           }
        }
        return countMatches;
    }

    public static int countMatchesChatGPT(List<List<String>> items, String ruleKey, String ruleValue) {
        int rule = -1;
        int countMatches = 0;

        switch (ruleKey) {
            case "type":
                rule = 0;
                break;
            case "color":
                rule = 1;
                break;
            case "name":
                rule = 2;
                break;
        }

        for (List<String> item : items) {
            if (item.get(rule).equals(ruleValue)) {
                countMatches++;
            }
        }

        return countMatches;
    }


    public static void main(String[] args) {
        System.out.println(countMatches(Arrays.asList(Arrays.asList("phone", "blue", "pixel"), Arrays.asList("computer", "silver", "lenovo"),Arrays.asList("phone", "gold", "iphone")) , "type" , "phone"));
    }
}
/*
1773. Count Items Matching a Rule
        Easy
Topics
        Companies
Hint
You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
        ruleKey == "color" and ruleValue == colori.
        ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.

Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
Example 2:

Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
Output: 2
Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.

        Constraints:
        1 <= items.length <= 104
        1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
ruleKey is equal to either "type", "color", or "name".
All strings consist only of lowercase letters.*/
