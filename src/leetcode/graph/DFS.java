package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        Arrays.fill(vis,false);

        ArrayList<Integer> ans = new ArrayList<>();

        dfs(adj, vis, ans , 0);
        return ans;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis,  ArrayList<Integer> ans, int from) {

        vis[from]=true;
        ans.add(from);

        for(int i: adj.get(from)) {
            if(!vis[i]) {
                dfs(adj,vis,ans,i);
            }
        }


    }
}
