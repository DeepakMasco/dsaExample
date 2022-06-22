package leetcode.Heap;


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
}
