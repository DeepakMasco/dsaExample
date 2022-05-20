package slidingWindow.variable;

import java.util.HashMap;
import java.util.Map;

public class MinWindowsSubstring {

    public static void main(String[] args) {

        String pattern = "ABC";
        String input = "ADOBECODEBANC";
        int uniqueChatCount = 0;


        int i=0;
        int j=0;
        int ans = input.length()+1;

        Map<Character, Integer> unique = new HashMap<>();
        for(char c: pattern.toCharArray()){
            unique.put(c, unique.getOrDefault(c,0)+1);
        }

        String output = "";

        uniqueChatCount = unique.size();
        while(j<input.length()) {
            char c= input.charAt(j);

            if(unique.containsKey(c)) {
                int value = unique.get(c);
                if (value==1) {
                    uniqueChatCount--;
                }
                unique.put(c, value-1);
            }

            if(uniqueChatCount==0) {
                while (uniqueChatCount==0){

                if ((j-i+1)<ans) {
                    ans = j-i+1;
                    output = input.substring(i,j+1);
                }

                char c2 = input.charAt(i);
                if (unique.containsKey(c2)) {
                    int value = unique.get(c2);
                    unique.put(c2, ++value);
                    if(value>0) {
                        uniqueChatCount++;
                    }

                }
                i++;
                }
            }
                j++;
        }

        System.out.println(ans);
        System.out.println(output);

    }
}
