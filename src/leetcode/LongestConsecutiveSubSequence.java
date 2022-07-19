package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LongestConsecutiveSubSequence {
/*
*Only one traversal is needed and the time complexity is O(n) under the assumption that hash insert and search take O(1) time.
* */
    public static void main(String[] args) {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2,2 };
        int n = arr.length;
        System.out.println(
                "Length of the Longest consecutive subsequence is "
                        + findLongestConseqSubseq(arr, n));

        System.out.println(
                "Length of the Longest consecutive subsequence is "
                        + findLongestConseqSubseqWithPQ(arr, n));
    }

    static int findLongestConseqSubseq(int nums[], int n)
    {

        HashSet<Integer> set = new HashSet<>();

        for(int i:nums) {
            set.add(i);
        }

        int res = 0;
        for(int i: nums) {
            // AS this will be the first element for the sequence. As number-1 is not present.
            if(!set.contains(i-1)) {
                int j = i;
                int ans = 0;

                while(set.contains(j)) {
                    set.remove(j);
                    j++;
                    ans++;
                }

                res = Math.max(res,ans);
            }
        }
        return res;
    }


    static int findLongestConseqSubseqWithPQ(int arr[], int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: arr) {
            pq.add(a);
        }

        int c = 1;
        int max = 1;
        int prev = pq.poll();
        for(int i=1;i<n;i++) {
            if(pq.peek()-prev > 1) {
                c =1;
            } else if (pq.peek()-prev == 1) {
                c++;
            }
            prev = pq.poll();
            if(c>max) max=c;
        }
        return max;
    }
}
