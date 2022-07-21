package leetcode.Random;

import java.util.HashSet;
import java.util.Set;


/*
* Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.



Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
*/
public class BinaryCodesInSubstring {
    public static void main(String[] args) {

        System.out.println(hasAllCodes("00110", 2));
    }

    public static boolean hasAllCodes(String s, int k) {
        int totalCode = 1<<k;
        Set<String> unique = new HashSet<>();
        for(int i=0;i<s.length()-k+1;i++) {
            String sub = s.substring(i,i+k);
            if(!unique.contains(sub)) {
                totalCode--;
                unique.add(sub);
                if(totalCode==0) {
                    return true;
                }
            }
        }
        return false;
    }
}
