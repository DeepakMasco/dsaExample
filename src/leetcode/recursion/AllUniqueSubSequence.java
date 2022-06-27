package leetcode.recursion;

import java.util.Collections;
import java.util.HashSet;

public class AllUniqueSubSequence {

    public static void main(String[] args) {
        HashSet<String> result = new HashSet<>();
        uniqueSubSequence("aab", "", result);
        System.out.println(result);
    }

    private static void uniqueSubSequence(String input, String output, HashSet<String> result) {
        if(input.length()==0) {
            result.add(output);
            return;
        }

        uniqueSubSequence(input.substring(1), output+input.charAt(0), result);
        uniqueSubSequence(input.substring(1), output, result);

    }
}
