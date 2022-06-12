package leetcode.stacks;

import java.util.Stack;

public class MinStackWithoutSpace {

    public static void main(String[] args) {
        MinStackWithSpace.CustomStack stack = new MinStackWithSpace.CustomStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(-2147483648);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    static class CustomStack {
        Stack<Integer> stack = new Stack<>();
        int min;

        public void push(int a) {
            if(stack.isEmpty()) {
                min = a;
                stack.push(a);
            }
            else {
           if(a<min) {
             stack.push(2*a - min);
                min = a;
            } else {
               stack.push(a);
           }
            }
        }

        public void pop() {
           if(stack.peek()<min) {
                min = 2*min - stack.peek();
           }
               stack.pop();
        }

        public int top() {
            if(stack.peek()<min) {
                return min;
            }
            return stack.peek();
        }

        public int getMin() {
            if(stack.size()>0) {
                return min;
            }
            return -1;
        }
    }
}
