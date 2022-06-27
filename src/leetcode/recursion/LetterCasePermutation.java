package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/*
* Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.



Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]

* */
public class LetterCasePermutation {

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String input = "a1b2";
        generatePermutation(input, "", ans);
        System.out.println(ans);
    }

    private static void generatePermutation(String input, String output, List<String> ans) {
        if(input.length()==0) {
            ans.add(output);
            return;
        }
        if(Character.isDigit(input.charAt(0))) {
            generatePermutation(input.substring(1), output+(input.charAt(0)), ans);
        } else {
            generatePermutation(input.substring(1), output+(Character.toUpperCase(input.charAt(0))), ans);
            generatePermutation(input.substring(1), output+(Character.toLowerCase(input.charAt(0))), ans);
        }
    }
}
