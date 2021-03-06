package leetcode.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FrequencySortWithHeap {


    public static void main(String[] args) {

        // Sort the array in increasing freq and if the freq is same then sort in descending order of no.
        int[] ans = frequencySort(new int[]{1,1,1,2,2,2,3});
        for(int i: ans) {
            System.out.println(i);
        }
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }


        Queue<Integer> heap = new PriorityQueue<>((a, b) -> {
            if(map.get(a)!=map.get(b))
            {return map.get(a) - map.get(b);}
            else return b - a;

        });




        for(int key: map.keySet()) {
            heap.add(key);
        }


        int[] ans = new int[nums.length];
        int i = 0;

        while(heap.size()>0) {
            int value = heap.poll();
            int freq = map.get(value);
            while(freq>0) {
                ans[i++] = value;
                freq--;
            }
        }

        return ans;

    }
}
