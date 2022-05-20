package slidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class MaxSubStringWithKUniqueChar {

    public static void main(String[] args) {

        String input = "aabcbcdbca";
        int k = 2;
        int uniqueCharCount = 0;
        int i=0,j=0;
        int ans = 0;
        Map<Character, Integer> unique = new HashMap();
        while(j<input.length()) {
            char c = input.charAt(j);

            if(unique.containsKey(c)) {
               int value = unique.get(c);
               unique.put(c, value+1);
            } else {
                unique.put(c, 1);
            }

            uniqueCharCount = unique.size();
            if(uniqueCharCount==k) {
                ans = Math.max(ans, j-i+1);
            }

            if (uniqueCharCount>k) {
                char c2 = input.charAt(i);
                int value2 = unique.get(c2);
                if (value2==1) {
                    unique.remove(c2);
                } else {
                    unique.put(c2, value2-1);
                }
                i++;
            }

            j++;
        }
        System.out.println(ans==0?-1:ans);
    }
}
