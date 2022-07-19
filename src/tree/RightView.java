package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// It is similar to level order. As we just print or add only the last elemenet of a particular level for RIGHT view
public class RightView {

    public List<Integer> rightSideView(Node root) {

        List<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);


        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int i=0;i<size;i++) {
                Node current = qu.poll();
                if(i==size-1) ans.add(current.data);

                if(current.left!=null) qu.add(current.left);
                if(current.right!=null) qu.add(current.right);
            }

        }

        return ans;

    }

}
