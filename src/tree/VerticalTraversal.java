package tree;

import java.util.*;

public class VerticalTraversal {
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    // This is similar to the Top View as we are using HD for a node.
    // So we need to make a level order traversal.

    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();

        if(root==null) {
            return ans;
        }


        Queue<Pair> qu = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        qu.add(new Pair(root,0));
        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int i=0;i<size;i++) {
                Pair current = qu.poll();

                if(map.containsKey(current.hd)) {
                    map.get(current.hd).add(current.node.data);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(current.node.data);
                    map.put(current.hd,list);
                }

                if(current.node.left!=null) {
                    qu.add(new Pair(current.node.left,current.hd-1));
                }
                if(current.node.right!=null) {
                    qu.add(new Pair(current.node.right,current.hd+1));
                }
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            for(int i=0;i<size;i++) {
                ans.add(entry.getValue().get(i));
            }
        }

        return ans;
    }
}
