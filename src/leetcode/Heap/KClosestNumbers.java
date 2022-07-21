package leetcode.Heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
* In this we are given
*
* */
public class KClosestNumbers {

    public static class Pair{
        int diff;
        int value;

        Pair(int diff, int value){
            this.diff = diff;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        printKClosestNo(new int[] {5,6,7,8,9,10},7, 3);
        List<Integer> numbers = findClosestElements(new int[] {5,6,7,8,9,10},3, 7);
        numbers.forEach(System.out::println);
    }

    private static void printKClosestNo(int[] arr, int key, int values) {

        PriorityQueue<Pair> maxPq = new PriorityQueue<>((o1, o2) -> {
            if(o1.diff == o2.diff) {
                return o2.value - o1.value;
            } else {
                return  o2.diff - o1.diff;
            }
        });


        for(int i: arr) {
            maxPq.add(new Pair(Math.abs(key-i), i));
            if(maxPq.size()>values) {
                maxPq.poll();
            }
        }

        while(maxPq.size()>0) {
            System.out.println(maxPq.poll().value);
        }
    }

    //This appraoch uses binary search in a window form and which is way much faster compared to heap.
    // But we can use this only if array is sorted
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = arr.length-1;

        while(end-start>=k) {
            int lowDiff = Math.abs(arr[start]-x);
            int highDiff = Math.abs(arr[end]-x);

            if(lowDiff<=highDiff) end--;
            else start++;
        }

        while(start<=end) {
            result.add(arr[start++]);
        }

        return result;
    }
}
