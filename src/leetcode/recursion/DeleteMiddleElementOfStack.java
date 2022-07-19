package leetcode.recursion;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int mid = (stack.size()+1)/2;
        removeElement(stack, mid);

        System.out.println(stack);
    }


    public static void removeElement(Stack<Integer>s,int mid) {
        if(s.size()==mid) {
            s.pop();
            return;
        }
        int temp = s.pop();
        removeElement(s,mid);
        s.push(temp);
    }
}
