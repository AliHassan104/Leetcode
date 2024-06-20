package _648ReplaceWords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static String replaceWords(List<String> dictionary, String sentence) { // almost correct
        StringBuilder stringBuilder = new StringBuilder();

        String[] sentenceArr = sentence.split(" ");


        for (int i = 0; i < sentenceArr.length; i++) {
            boolean flag = false;
            String curWord = "";
            for (int j = 0; j < dictionary.size(); j++) {
                if (sentenceArr[i].startsWith(dictionary.get(j))){
                    curWord = dictionary.get(j);
                    flag = true;
                }
            }
            if (!flag){
                stringBuilder.append(sentenceArr[i]);
            }else {
                stringBuilder.append(curWord);
            }
            if (i != sentenceArr.length-1){
                stringBuilder.append(" ");
            }

        }

        return stringBuilder.toString();
    }

    public static String replaceWordsChatGPT(List<String> dictionary, String sentence) {
        // Use a HashSet for faster lookup
        Set<String> dictSet = new HashSet<>(dictionary);
        StringBuilder stringBuilder = new StringBuilder();
        String[] sentenceArr = sentence.split(" ");

        for (String word : sentenceArr) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (dictSet.contains(prefix)) {
                    break;
                }
            }
            stringBuilder.append(prefix.isEmpty() ? word : prefix).append(" ");
        }

        // Remove the trailing space
        stringBuilder.setLength(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceWords(Arrays.asList("cat","bat","rat") , "the cattle was rattled by the battery"));
    }
}

/*648. Replace Words
Medium
Topics
Companies
In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.



Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"


Constraints:

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.*/