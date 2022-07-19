package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinTimeToBurnTree {

    public static int minTime(Node root, int target)
    {
        // Your code goes here
        Map<Node, Node> parentMap = new HashMap<>();
        // We first create the parent mapping in a map and then we start checking in all direction like left right and parent
        // if any node is not burned then we burn it and icrease the time.
        Node start = createParentMapAndFindTargetNode(root,target,parentMap);
        int ans = findMinTime(parentMap,start);
        return ans;
    }

    public static Node createParentMapAndFindTargetNode(Node root, int target,Map<Node, Node> parentMap) {

        // We should create the parentMap using Level order traversal

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        Node start = null ;

        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int i=0;i<size;i++) {
                Node current = qu.poll();

                if(current.data==target) {
                    start = current;
                }

                if(current.left!=null) {
                    qu.add(current.left);
                    parentMap.put(current.left,current);
                }

                if(current.right!=null) {
                    qu.add(current.right);
                    parentMap.put(current.right,current);
                }
            }
        }

        return start;
    }

    public static int findMinTime(Map<Node, Node> parentMap, Node target) {

        // We need to do level order traversal and find for parent,left,right if they are
        // not burned then we will burn them and increasse the time.

        int ans = 0;
        int flagToBurn = 0;
        Queue<Node> qu = new LinkedList<>();
        // To store which nodes are already burned
        Map<Node, Integer> visitedMap = new HashMap<>();


        qu.add(target);
        visitedMap.put(target,1);

        while(!qu.isEmpty()) {
            int size = qu.size();
            flagToBurn = 0;
            for(int i=0;i<size;i++) {
                Node current = qu.poll();

                //checking left node
                if(current.left!=null && !visitedMap.containsKey(current.left)) {
                    visitedMap.put(current.left,1);
                    flagToBurn = 1;
                    qu.add(current.left);
                }

                //checking right node
                if(current.right!=null && !visitedMap.containsKey(current.right)) {
                    visitedMap.put(current.right,1);
                    flagToBurn = 1;
                    qu.add(current.right);
                }

                // checking parent node
                if(parentMap.get(current)!=null && !visitedMap.containsKey(parentMap.get(current))) {
                    visitedMap.put(parentMap.get(current),1);
                    flagToBurn = 1;
                    qu.add(parentMap.get(current));
                }
            }
            // Only if after all iterations we find the flag is 1 then we increase as there can be a scenario where
            // nodes are already burned in above loop so we will not increase time
            if(flagToBurn==1) ans++;
        }

        return ans;

    }
}
