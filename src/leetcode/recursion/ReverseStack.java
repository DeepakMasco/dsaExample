package leetcode.recursion;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        reverse(stack);

        System.out.println(stack);
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.size()==0) {
            return;
        }

        int temp = stack.pop();
        reverse(stack);
       insert(stack, temp);

    }

    private static void insert(Stack<Integer> stack, int temp) {
        if(stack.isEmpty()) {
            stack.push(temp);
            return;
        }

        int temp1 = stack.pop();
        insert(stack,temp);
        stack.push(temp1);
    }
}
