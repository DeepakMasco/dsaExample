package leetcode.stacks;

import java.util.Stack;

/*Given an array of integers heights representing the histogram's bar
height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.


We can reduce this into finding the next smallest
from left and right and then doing rightIndex-leftIndex-1 * arr[i] = area
and then we can find the max area for the same.



Time Complexity: O(2N)
Auxiliary Space: O(2N+2N)
*/
public class MaxAreaOfHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] fromLeft = nextSmallerElementToLeft(heights,n);
        int[] fromRight = nextSmallerElementToRight(heights,n);

        int max = 0;

        for(int i=0;i<n;i++) {
            max = Math.max(max, (fromRight[i]-fromLeft[i]-1)*heights[i]);
        }
        return max;
    }

    private static int[] nextSmallerElementToLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int j = 0;

        for(int i=0;i<n;i++) {
            if(stack.isEmpty()) {
                ans[j++] = -1;
            } else {
                if(arr[stack.peek()]<arr[i]) {
                    ans[j++] = stack.peek();
                } else {
                    while(stack.size()>0) {
                        if(arr[stack.peek()]>=arr[i]) {
                            stack.pop();
                            if(stack.isEmpty()) {
                                ans[j++] = -1;
                            }
                        }
                        else {
                            ans[j++] = stack.peek();
                            break;
                        }
                    }
                }
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerElementToRight(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int j = n-1;

        for(int i=n-1;i>=0;i--) {
            if(stack.isEmpty()) {
                ans[j--] = n;
            } else {
                if(arr[stack.peek()]<arr[i]) {
                    ans[j--] = stack.peek();
                } else {
                    while(stack.size()>0) {
                        if(arr[stack.peek()]>=arr[i]) {
                            stack.pop();
                            if(stack.isEmpty()) {
                                ans[j--] = n;
                            }
                        }
                        else {
                            ans[j--] = stack.peek();
                            break;
                        }
                    }
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
