package slidingWindow.fixed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* We will be given 2 strings i.e pattern and input string.
* We need to find out how many anagrams of pattern are present in the input string.
* And output the starting index of those anagrams.
*
* We are doing traversal of each string once so it's time complexity should be O(A+B) considering A and B are length of 2 strings.
* We are using HashMap to store the freq so it will O(A)
* A - Pattern Length , B - Input String Length
* Time Complexity: O(A+B)
* Auxiliary Space: O(A)
* as we are just storing freq of pattern only.
* */
public class AnaragamCount {

    public static void main(String[] args) {


        String str1 = "abc";
        String str2 = "cbaebabacd";
        int i =0;
        int j=0;
        int lenght2 = str2.length();
        int length1 = str1.length();
        int count = 0;
        int uniquueChar = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        // We make the freq map
        for(int l=0;l<length1;l++){
            Character c = str1.charAt(l);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1 );
        }

        uniquueChar = countMap.size();
        List<Integer> countList = new ArrayList<>();

        while(j<lenght2)
        {
            Character c = str2.charAt(j);
            if (countMap.containsKey(c)) {
                int values = countMap.get(c);
                countMap.put(c, values - 1 );
                // Doing this to check if we inserted 0 for the freq in map
                if(values-1==0) {
                    uniquueChar--;
                }
            }

            if (j-i+1 == length1) {
             if(uniquueChar==0) {
                 count++;
                 countList.add(i);
             }
                Character c2 = str2.charAt(i);
                if (countMap.containsKey(c2)) {
                    int values = countMap.get(c2);
                    if(values==0) {
                        uniquueChar++;
                    }
                    countMap.put(c2, countMap.get(c2) + 1);
                }
                i++;
            }
            j++;
        }
        countList.forEach(System.out::println);
        System.out.println(count);

    }
}
