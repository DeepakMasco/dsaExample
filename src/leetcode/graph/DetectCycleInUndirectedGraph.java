package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleInUndirectedGraph {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                // We maintain the parent node. As if we dont do that even in 2 nodes it will show as cycle.
                // 1<->2 but it is not called a cycle. Cycle means the node should point to some other node which is visited.
                // But that is not the parent node from where the flow came in.
                if (dfs(adj, i, -1, vis)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int from, int parent, boolean[] vis) {
        vis[from] = true;

        for (int i : adj.get(from)) {
            if (!vis[i]) {
                if (dfs(adj, i, from, vis)) {
                    return true;
                }
                // This condition helps in findiing the real cycle.
            } else if (parent != i) {
                return true;
            }

        }

        return false;

    }
}
