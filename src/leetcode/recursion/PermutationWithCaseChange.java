package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/*
*
* Print all permutations of a string keeping the sequence but changing cases.
Examples:


Input : ab
Output : AB Ab ab aB

Input : ABC
Output : abc Abc aBc ABc abC AbC aBC ABC
*
*
* */
public class PermutationWithCaseChange {

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String input = "ab";
        generatePermutation(input, "", ans);
        System.out.println(ans);
    }

    private static void generatePermutation(String input, String output, List<String> ans) {
        if(input.length()==0) {
            ans.add(output);
            return;
        }
        generatePermutation(input.substring(1), output+(Character.toUpperCase(input.charAt(0))), ans);
        generatePermutation(input.substring(1), output+(Character.toLowerCase(input.charAt(0))), ans);
    }
}
