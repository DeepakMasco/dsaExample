package tree;

import java.util.*;
// In this we utilise the HD for every node. It start as 0 for root and in left it goes current-1 and in right current+1
// So for top view as we are using HD so we need to do Level order traversal. and then for every HD the last/bottom most node
// will be printed. And the list will be sorted using HD.
public class BottomView {
    class Pair {
        Node node;
        int hd;


        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        // To store the HD for every node as we are storing the nodes in Queue so it is imp to store that.
        Queue<Pair> qu = new LinkedList<>();
        // As we want our values to be sorted on HD we use treemap and make the key as HD
        Map<Integer, Integer> map = new TreeMap<>();


        if(root==null) {
            return ans;
        }

        qu.add(new Pair(root,0));

        while(!qu.isEmpty()) {
            for(int i=0;i<qu.size();i++) {
                Pair current = qu.poll();

                // checking is not required as we just need the last so it will automatically override the values again and again.
                map.put(current.hd,current.node.data);

                if(current.node.left!=null) {
                    qu.add(new Pair(current.node.left,current.hd-1));
                }

                if(current.node.right!=null) {
                    qu.add(new Pair(current.node.right,current.hd+1));
                }
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }
}
