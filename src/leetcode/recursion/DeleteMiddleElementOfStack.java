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

        deleteMid(stack, stack.size());

        System.out.println(stack);
    }

    public static void deleteMid(Stack<Integer> s, int sizeOfStack){
        // code here
        int mid = (sizeOfStack+1)/2;

        removeElement(s, mid);
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
