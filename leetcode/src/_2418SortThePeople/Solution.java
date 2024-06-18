package _2418SortThePeople;

import java.util.*;

public class Solution {
    public static String[] sortPeople(String[] names, int[] heights) {
        String[] ans = new String[names.length];

        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];
            int tempIndex = i;

            for (int j = i+1; j < heights.length; j++) {

                if(heights[i] < heights[j] && heights[j] > curHeight ){
                    curHeight = heights[j];
                    tempIndex = j;
                }

            }

            ans[i] = names[tempIndex];

            String tempName = names[i];
            names[i] = names[tempIndex];
            names[tempIndex] = tempName;

            int tempHeight = heights[i];
            heights[i] = heights[tempIndex];
            heights[tempIndex] = tempHeight;
        }
        return ans;
    }

    public static String[] sortPeopleGemini(String[] names, int[] heights) {
        Person[] people = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(people, (p1, p2) -> Integer.compare(p2.height, p1.height));
        String[] sortedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            sortedNames[i] = people[i].name;
        }
        return sortedNames;
    }

    public static String[] sortPeopleChatGPT(String[] names, int[] heights) {
        int n = names.length;
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            people.add(new Person(names[i], heights[i]));
        }
        people.sort(Comparator.comparingInt(Person::getHeight).reversed());
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people.get(i).getName();
        }
        return sortedNames;
    }

    static class Person {
        private final String name;
        private final int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public int getHeight() {
            return height;
        }
    }

    public static void main(String[] args) {
        Arrays.stream(sortPeople(new String[]{"Mary", "John", "Emma"} , new int[]{180, 165, 170})).forEach(e-> System.out.println(e));
    }
}


/*2418. Sort the People
Easy
Topics
Companies
Hint
You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.



Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.


Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct.*/