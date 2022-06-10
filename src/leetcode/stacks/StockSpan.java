package leetcode.stacks;

import java.util.Stack;


/*The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stocks price for all n days.
The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Example 1:

Input:
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6
Explanation:
Traversing the given input span for 100
will be 1, 80 is smaller than 100 so the
span is 1, 60 is smaller than 80 so the
span is 1, 70 is greater than 60 so the
span is 2 and so on. Hence the output will
be 1 1 1 2 1 4 6.



The above question is similar to i - nearest greater element from left index .
*/

public class StockSpan {


    public static void main(String[] args) {
        int[] ansLeft = calculateSpan(new int[] {100,80,60,70,60,75,85}, 7);
        for(int a: ansLeft) {
            System.out.print(a + " ");
        }
    }

    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[n];
        int j=0;
        for(int i=0;i<n;i++) {
            if(stack.isEmpty()){
                output[j++] = i - (-1);
            } else {
                if(price[i]<price[stack.peek()]) {
                    output[j++] = i - stack.peek();
                } else {
                    while(stack.size()>0) {
                        if(price[i]>=price[stack.peek()]) {
                            stack.pop();
                            if(stack.isEmpty()) {
                                output[j++] = i - (-1);
                            }
                        }else {
                            output[j++] = i - stack.peek();
                            break;
                        }
                    }
                }
            }
            stack.push(i);
        }
        return output;
    }
}
