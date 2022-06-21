package slidingWindow.fixed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnaragamCount {
//TODO - Add question
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

        for(int l=0;l<length1;l++){
            Character c = str1.charAt(l);
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1 );
            }
            else {
                countMap.put(c,1);
                uniquueChar++;
            }
        }
        List<Integer> countList = new ArrayList<>();

        while(j<lenght2)
        {

            Character c = str2.charAt(j);
            if (countMap.containsKey(c)) {
                int values = countMap.get(c);
                countMap.put(c, values - 1 );
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
