package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// It is similar to level order. As we just print or add only the first elemenet of a particular level for LEFT view
public class LeftView {

    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();

        if(root==null) {
            return ans;
        }

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()) {
            int level = qu.size();
            for(int i=0;i<level;i++) {
                Node current = qu.poll();
                if(i==0) {
                    ans.add(current.data);
                }
                if(current.left!=null) qu.add(current.left);
                if(current.right!=null) qu.add(current.right);
            }
        }


        return ans;
    }
}
