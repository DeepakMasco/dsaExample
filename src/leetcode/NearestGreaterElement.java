package leetcode;

import java.util.Stack;


/*Input:
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1
Explanation:
In the array, the next larger element
to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ?
since it doesn't exist, it is -1.*/


public class NearestGreaterElement {

    public static void main(String[] args) {
        long[] ans = nextLargerElement(new long[] {7,8,1,4}, 4);
        for(long a: ans) {
            System.out.println(a);
        }
    }

    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long[] output = new long[n];
        int j = n-1;
        Stack<Long> stack = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            if(stack.isEmpty()) {
                output[j--] = -1;
            } else {
                if(stack.peek()>arr[i]) {
                    output[j--] = stack.peek();
                } else {
                    while(stack.size()>0) {
                        if(stack.peek()<=arr[i]) {
                            stack.pop();
                            if(stack.isEmpty()) {
                                output[j--] = -1;
                            }
                        } else {
                            output[j--] = stack.peek();
                            break;
                        }
                    }
                }
            }
            stack.push(arr[i]);

        }
        return output;
    }
}
