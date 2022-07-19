package tree;

import java.util.*;
// This is similar to burining of a tree.
// We just break once we get time==k and last elements present in qu are the nodes to print.
// So we iterate and add in the list of ans.
public class NodesAtKDistance {

    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parentMap = new HashMap<>();
        createParentMapAndFindTargetNode(root,parentMap);
        return findMinTime(parentMap,target,k);
    }


    public void createParentMapAndFindTargetNode(Node root,Map<Node, Node> parentMap) {

        // We should create the parentMap using Level order traversal

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);


        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int i=0;i<size;i++) {
                Node current = qu.poll();

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
    }



    public static List<Integer> findMinTime(Map<Node, Node> parentMap, Node target, int k) {

        // We need to do level order traversal and find for parent,left,right if they are
        // not burned then we will burn them and increasse the time.

        int ans = 0;
        int flag = 0;
        Queue<Node> qu = new LinkedList<>();
        // To store which nodes are already burned
        Map<Node, Integer> visitedMap = new HashMap<>();
        List<Integer> ansList = new ArrayList<>();


        qu.add(target);
        visitedMap.put(target,1);

        while(!qu.isEmpty()) {
            int size = qu.size();
            if(flag==k) break;
            flag++;
            for(int i=0;i<size;i++) {
                Node current = qu.poll();

                //checking left node
                if(current.left!=null && !visitedMap.containsKey(current.left)) {
                    visitedMap.put(current.left,1);
                    qu.add(current.left);
                }

                //checking right node
                if(current.right!=null && !visitedMap.containsKey(current.right)) {
                    visitedMap.put(current.right,1);
                    qu.add(current.right);
                }

                // checking parent node
                if(parentMap.get(current)!=null && !visitedMap.containsKey(parentMap.get(current))) {
                    visitedMap.put(parentMap.get(current),1);
                    qu.add(parentMap.get(current));
                }
            }
        }

        while(!qu.isEmpty()) {
            Node node = qu.poll();
            ansList.add(node.data);
        }

        return ansList;

    }
}
