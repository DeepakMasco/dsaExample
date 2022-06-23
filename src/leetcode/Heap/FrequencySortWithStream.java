package leetcode.Heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencySortWithStream {

    public static void main(String[] args) {
        int[] ans = frequencySort(new int[]{1,1,2,2,2,3});
        for(int i: ans) {
            System.out.println(i);
        }
    }

    private static int[] frequencySort(int[] ints) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(ints).forEach(value -> map.put(value, map.getOrDefault(value, 0) + 1));


        return Arrays.stream(ints).boxed()
                .sorted((o1, o2) -> map.get(o1)!= map.get(o2) ? map.get(o1) - map.get(o2) :  o2-o1)
                .mapToInt(value -> value)
                .toArray();
    }
}
