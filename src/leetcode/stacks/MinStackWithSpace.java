package leetcode.stacks;

import java.util.Stack;

public class MinStackWithSpace {


    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(18);
        stack.push(15);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.push(20);
        stack.push(40);
        stack.push(5);
    }

    static class CustomStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> secondaryStack = new Stack<>();

        public void push(int a) {
            stack.push(a);
            if(secondaryStack.isEmpty() || a<=secondaryStack.peek()) {
                secondaryStack.push(a);
            }
        }

        public void pop() {
            if(stack.size()>0) {
                int val = stack.pop();
                if(val==secondaryStack.peek()) {
                    secondaryStack.pop();
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            if(secondaryStack.size()>0) {
                return secondaryStack.peek();
            }
            return -1;
        }
    }
}
