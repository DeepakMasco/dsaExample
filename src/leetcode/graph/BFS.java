package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
*
* */
public class BFS {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // We are starting from 0 as source point.
        // V means no of vertex in graph.
        return minEdgeBFS(adj, 0, V);
    }

    private ArrayList<Integer> minEdgeBFS(ArrayList<ArrayList<Integer>> edges, int from, int n) {

        Queue<Integer> queue = new LinkedList<>();
        // As our graph starts with 0 so we can have array till n only
        boolean[] visited = new boolean[n];
        ArrayList<Integer> result = new ArrayList<>();

        // Make this false for every element first
        Arrays.fill(visited, false);

        // Adding the source to queue
        queue.add(from);
        // Adding the source to result array
        result.add(from);

        visited[from] = true;

        // We need to run the loop till the time queue is not empty similar to level order traversal
        while(!queue.isEmpty()) {
            int current = queue.remove();
            // Here we get the no of neighbours from the adj list.
            for(int i=0;i<edges.get(current).size();i++) {

                int neighbour = edges.get(current).get(i);
                // If the neighbour is visited we skip the iteration
                if(visited[neighbour]) {
                    continue;
                } else {
                    visited[neighbour] = true;
                    result.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return result;
    }


}
