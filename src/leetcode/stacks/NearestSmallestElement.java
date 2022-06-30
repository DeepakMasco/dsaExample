package leetcode.stacks;

import java.util.Stack;
/*
*
* N = 4, arr[] = [4 5 2 10 8]
Output:
 2 2 -1 8 -1
Explanation:
In the array, the next smaller element
since it doesn't exist, it is -1.

Time Complexity: O(N)
Auxiliary Space: O(N)
*
* */
public class NearestSmallestElement {

    public static void main(String[] args) {
        long[] ans = nextSmallerElementToRight(new long[] {4,5,2,10,8}, 5);
        long[] ansLeft = nextSmallerElementToLeft(new long[] {4,5,2,10,8}, 5);
        for(long a: ans) {
            System.out.print(a + " ");
        }
        System.out.println();
        for(long a: ansLeft) {
            System.out.print(a + " ");
        }
    }

    private static long[] nextSmallerElementToLeft(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();
        long[] ans = new long[n];
        int j = 0;

        for(int i=0;i<n;i++) {
            if(stack.isEmpty()) {
                ans[j++] = -1;
            } else {
                if(stack.peek()<arr[i]) {
                    ans[j++] = stack.peek();
                } else {
                    while(stack.size()>0) {
                        if(stack.peek()>arr[i]) {
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
            stack.push(arr[i]);
        }
        return ans;
    }

    private static long[] nextSmallerElementToRight(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();
        long[] ans = new long[n];
        int j = n-1;

        for(int i=n-1;i>=0;i--) {
            if(stack.isEmpty()) {
                ans[j--] = -1;
            } else {
                if(stack.peek()<arr[i]) {
                    ans[j--] = stack.peek();
                } else {
                    while(stack.size()>0) {
                        if(stack.peek()>arr[i]) {
                            stack.pop();
                            if(stack.isEmpty()) {
                                ans[j--] = -1;
                            }
                        }
                        else {
                            ans[j--] = stack.peek();
                            break;
                        }
                    }
                }
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}
