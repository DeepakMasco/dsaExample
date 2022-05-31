package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

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

    static int findLongestConseqSubseq(int arr[], int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        for (int i = 0; i < n; ++i)
        {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1))
            {
                // Then check for next elements
                // in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
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
