package leetcode.Random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*You are given a vector of strings you are supposed to concatenate their occurrences if they occur more than once.

        Example :

        Input: [tv, musicPlayer, microwave, tv, mediaPlayer, tv]
        Output: [tv, musicPlayer, microwave, tv1, musicPlayer1, tv2]*/
public class ConcatOccurances {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("tv", "musicPlayer", "microwave", "tv", "mediaPlayer", "tv");
        HashMap<String, Integer> map = new HashMap<>();
        for(String a:input) {
            int value = map.getOrDefault(a, 0)+1;
            map.put(a, value);
            if(value==1) {
                System.out.println(a);
            } else {
                System.out.println(a.concat("" + (value-1)));
            }
        }
    }
}
