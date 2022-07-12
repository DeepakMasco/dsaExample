package leetcode.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/*
*
* https://leetcode.com/problems/top-k-frequent-words/
* Similar question
*
*
* */
public class TopKFrequentNumbers {

    public static void main(String[] args) {
        int[] ans = topKFrequent(new int[] {1,1,1,2,2,3},2);
        for(int i : ans) {
            System.out.println(i);
        }
     }


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){ map.put(num, map.getOrDefault(num, 0) + 1); }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int key : map.keySet()){
            heap.add(key);
            if(heap.size()>k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];
        int i=0;
        while(heap.size()>0){
            ans[i++] = heap.poll();
        }

        return ans;
    }
}
