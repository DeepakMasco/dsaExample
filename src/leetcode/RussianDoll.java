package leetcode;

import java.util.Arrays;
import java.util.Comparator;



/*You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

        One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

        Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

        Note: You cannot rotate an envelope.



        Example 1:

        Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
        Output: 3
        Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

        Example 2:

        Input: envelopes = [[1,1],[1,1],[1,1]]
        Output: 1*/


/*This problem is asking for LIS in two dimensions, width and height. Sorting the width reduces the problem by one dimension. If width is strictly increasing,
        the problem is equivalent to finding LIS in only the height dimension. However, when there is a tie in width, a strictly increasing sequence in height
        may not be a correct solution. For example, [[3,3] cannot fit in [3,4]]. Sorting height in descending order when there is a tie prevents
        such a sequence to be included in the solution.

        The same idea can be applied to problems of higher dimensions. For example, box fitting is three dimensions, width, height, and length. Sorting width
        ascending and height descending reduces the problem by one dimension. Finding the LIS by height further reduces the problem by another dimension.
        When find LIS based on onl`y length, it becomes a standard LIS problem.*/

// binary search solution: O(nlogn)
// width is increasing, but if two widths are the same, the height is decreasing
// after sorting, all envolopes are valid 'based on width', so we just binary search based on 'heights'
// to choose 'some of them' to meet the requirement
// Ex. after sorting: (1,3), (3,5), (6,8), (6,7), (8,4), (9,5)
// transform to question find LIS: [3,5,8,7,4,5] => like '300. Longest Increasing Subsequence'
public class RussianDoll  {

    public static void main(String[] args) {
        int[][] envelopes = new int[][] {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }


    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 2) return envelopes.length;

        Arrays.sort(envelopes, new EnvelopeComparator());
        int[] dp = new int[envelopes.length];
        int size = 0;

        for(int[] envelope: envelopes) {
            // binary search
            int left = 0, right = size, middle = 0;     // right = size
            while(left < right) {
                middle = left + (right - left) / 2;
                if(dp[middle] < envelope[1]) left = middle + 1;
                else right = middle;
            }

            // left is the right position to 'replace' in dp array
            dp[left] = envelope[1];
            if(left == size) size++;
        }
        return size;
    }

    static class EnvelopeComparator implements Comparator<int[]> {
        public int compare(int[] e1, int[] e2) {
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
        }
    }
}