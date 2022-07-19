package tree;

import java.util.*;

public class ZigZagTraversal {
// It is similar to level order traversal.
    // Only difference is at every alternate level we need to add elements in reverse order. Hence we use stack in that
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> qu = new LinkedList<>();

        if(root==null) {
            return ans;
        }

        qu.add(root);
        int flag = 0;
        Stack<Integer> stack = new Stack<>();

        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int i=0;i<size;i++){
                Node current = qu.poll();
                if(flag==0)
                    ans.add(current.data);
                if(flag==1) {
                    stack.push(current.data);
                }


                if(current.left!=null) qu.add(current.left);
                if(current.right!=null) qu.add(current.right);
            }

            if(flag==1) {
                flag =0;
                while(!stack.isEmpty()) {
                    ans.add(stack.pop());
                }
            } else {
                flag=1;
            }
        }



        return ans;
    }


// We can also use the below way.
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> qu = new LinkedList<>();

        if(root==null) {
            return ans;
        }

        qu.add(root);
        int flag = 0;

        while(!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node current = qu.poll();
                if(flag==0)
                    currentLevel.add(current.data);
                // the below way will walys make sure the elements are added in reverse order. and this makes it fast also
                else
                    currentLevel.add(0,current.data);

                if(current.left!=null) qu.add(current.left);
                if(current.right!=null) qu.add(current.right);
            }

            if(flag==1) {
                flag =0;
            } else {
                flag=1;
            }
            ans.add(currentLevel);
        }



        return ans;
    }
}
