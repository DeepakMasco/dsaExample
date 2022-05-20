package slidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class MaxSubStringWithNoRepeatingChar {

    public static void main(String[] args) {
        String input = "arwvivbgvtybtnudd";
        int k = 0; //as no repeating characters
        int i=0,j=0;
        Map<Character, Integer> unique = new HashMap<>();
        int repeatingChar = 0;
        int ans = 0;


        while(j<input.length()) {

            char c = input.charAt(j);
            if(unique.containsKey(c)) {
                int value = unique.get(c);
                unique.put(c, value+1);
                if (value==1) {
                    repeatingChar++;
                }
            } else {
                unique.put(c, 1);
            }

            if(repeatingChar==k) {
                ans = Math.max(ans, j-i+1);
            }


            if(repeatingChar>k) {
                char c2 = input.charAt(i);
                int value2 = unique.get(c2);
                if(value2==2) {
                    repeatingChar--;
                }
                    unique.put(c2, value2-1);
                i++;
            }
            j++;
        }

        System.out.println(ans==0?-1:ans);
    }
}
