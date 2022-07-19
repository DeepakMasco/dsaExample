package tree;

import java.util.LinkedList;
import java.util.Queue;


// This is smilar to doing level order traversal.
// AS max width means max no of nodes between 2 nodes in a given level.
// We are making the first elemnt HD of every level as 0 so that the value of 2*currentHD +1 does not overflow of int range
// and the ans would be last-first+1
public class MaxWidth {


    class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public int widthOfBinaryTree(Node root) {

        int ans = 0;

        if(root==null) return 0;

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root,0));

        while(!qu.isEmpty()) {
            int size = qu.size();

            int min = qu.peek().hd;
            int first=0, last=0;

            for(int i=0;i<size;i++) {
                Pair current = qu.poll();
                int currHd = current.hd-min;
                if(i==0) first = currHd;
                if(i==size-1) last = currHd;
                if(current.node.left!=null) {
                    qu.add(new Pair(current.node.left,currHd*2+1));
                }
                if(current.node.right!=null) {
                    qu.add(new Pair(current.node.right,currHd*2+2));
                }
            }

            ans = Math.max(ans,last-first+1);

        }
        return ans;
    }
}
