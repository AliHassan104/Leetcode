package _804UniqueMorseCodeWords;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int uniqueMorseRepresentations(String[] words) {
        Map<String , String> map = new HashMap<>();
        map.put("a",".-");
        map.put("b","-...");
        map.put("c","-.-.");
        map.put("d","-..");
        map.put("e",".");
        map.put("f","..-.");
        map.put("g","--.");
        map.put("h","....");
        map.put("i","..");
        map.put("j",".---");
        map.put("k","-.-");
        map.put("l",".-..");
        map.put("m","--");
        map.put("n","-.");
        map.put("o","---");
        map.put("p",".--.");
        map.put("q","--.-");
        map.put("r",".-.");
        map.put("s","...");
        map.put("t","-");
        map.put("u","..-");
        map.put("v","...-");
        map.put("w",".--");
        map.put("x","-..-");
        map.put("y","-.--");
        map.put("z","--..");

        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(map.get(String.valueOf(words[i].charAt(j))));
            }
            set.add(String.valueOf(sb));
        }

        return set.size();
    }

    public static int uniqueMorseRepresentationsChatGPT(String[] words) {
        String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",
                ".--.", "--.-",".-.","...","-","..-","...-",".--",
                "-..-","-.--","--.."};

        Set<String> uniqueMorse = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morseCodes[c - 'a']);
            }
            uniqueMorse.add(sb.toString());
        }

        return uniqueMorse.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}

/*804. Unique Morse Code Words
Solved
Easy
Topics
Companies
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

'a' maps to ".-",
'b' maps to "-...",
'c' maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
Return the number of different transformations among all words we have.



Example 1:

Input: words = ["gin","zen","gig","msg"]
Output: 2
Explanation: The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations: "--...-." and "--...--.".
Example 2:

Input: words = ["a"]
Output: 1


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 12
words[i] consists of lowercase English letters.*/