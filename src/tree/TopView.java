package tree;

import java.util.*;
// In this we utilise the HD for every node. It start as 0 for root and in left it goes current-1 and in right current+1
// So for top view as we are using HD so we need to do Level order traversal. and then for every HD the first/topmost node
// will be printed. And the list will be sorted using HD.
public class TopView {

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();

        if(root==null) {
            return ans;
        }

        // To store the HD for every node as we are storing the nodes in Queue so it is imp to store that.
        Queue<Pair> qu = new LinkedList<>();

        // As we want our values to be sorted on HD we use treemap and make the key as HD
        Map<Integer, Integer> map = new TreeMap<>();

        qu.add(new Pair(root,0));

        while(!qu.isEmpty()) {

            int size = qu.size();
            for(int i=0;i<size;i++) {
                Pair current = qu.poll();
                // checking if we already have that key if not then only add as only topmost/first nodes is used
                if(!map.containsKey(current.hd)) {
                    map.put(current.hd,current.node.data);
                }

                if(current.node.left!=null)
                    qu.add(new Pair(current.node.left,current.hd-1));

                if(current.node.right!=null)
                    qu.add(new Pair(current.node.right,current.hd+1));
            }
        }


        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;

    }
}
