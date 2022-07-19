package leetcode;

import java.util.Arrays;

/*You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

    horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
    verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided
in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.



Example 1:

Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4
Explanation: The figure above represents the given rectangular cake.
Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.


https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/


In this the solution is to find the max width of cut in both direction and then multiply and give the result back.

*/
public class MaxAreaOfCake {

    public static void main(String[] args) {
        System.out.println(maxArea(5,4,new int[] {1,2,4},new int[]{1,3}));
    }


    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        //sort both arrays.
        // find the max by doing - of prev element.
        // multiply both max and return ans
        int mod = 1000000007;

        Arrays.sort(horizontalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        Arrays.sort(verticalCuts);
        // finding max betwwen last and first gap
        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[n-1]);
        int maxV = Math.max(verticalCuts[0], w -verticalCuts[m-1]);


//finding the rest gaps excluding last and first
        for(int i=1;i<n;i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        for(int i=1;i<verticalCuts.length;i++) {
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i-1]);
        }
        long ans = 1L * maxH * maxV;

        return  (int) (ans % 1000000007);
    }
}
