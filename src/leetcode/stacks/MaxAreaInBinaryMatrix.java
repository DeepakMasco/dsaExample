package leetcode.stacks;

import java.util.Stack;
/*Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.



Example 1:

Input: matrix =
[["1","0","1","0","0"],
["1","0","1","1","1"],
["1","1","1","1","1"],
["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:

Input: matrix = [["0"]]
Output: 0

Example 3:

Input: matrix = [["1"]]
Output: 1



https://leetcode.com/problems/maximal-rectangle/
*/

public class MaxAreaInBinaryMatrix {

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}}));
    }

    public static int maximalRectangle(char[][] matrix) {
        int col = matrix[0].length;
        int ans = 0;
        int[] mah = new int[col];
        for(char[] row1: matrix) {
            for(int i=0;i<col;i++) {
                if(row1[i]=='0') {
                    mah[i]=0;
                } else {
                    mah[i]+=1;
                }
            }
            ans = Math.max(ans, lar(mah));
        }
        return ans;
    }

    public static int lar(int[] heights) {
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
