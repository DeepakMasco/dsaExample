package leetcode.graph;

import java.util.*;

public class MinDistanceFromAToB {

    public static void main(String[] args) {
        // To store adjacency list of graph
        int n = 8;
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
           edges.add(new ArrayList<>());
        }

        addEdge(edges, 1, 2);
        addEdge(edges, 2, 3);
        addEdge(edges, 2, 5);
        addEdge(edges, 2, 8);
        addEdge(edges, 3, 4);
        addEdge(edges, 3, 5);
        addEdge(edges, 4, 5);
        addEdge(edges, 5, 6);
        addEdge(edges, 6, 7);
        addEdge(edges, 7, 8);
        int u = 1;
        int v = 5;
        System.out.println(minEdgeBFS(edges, u, v, n));
    }

    private static int minEdgeBFS(List<List<Integer>> edges, int from, int to, int n) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        int[] path = new int[n+1];

        Arrays.fill(visited, false);

        queue.add(from);
        visited[from] = true;
        dist[from] = 0;

        while(!queue.isEmpty()) {
            int current = queue.remove();
            for(int i=0;i<edges.get(current).size();i++) {
                int neighbour = edges.get(current).get(i);
                if(visited[neighbour]) {
                    continue;
                } else {
                    visited[neighbour] = true;
                    dist[neighbour] = dist[current] + 1;
                    path[neighbour] = current;
                    queue.add(neighbour);
                    if(neighbour==to) {
                        break;
                    }
                }
            }
        }

        // To print the path we can backtrack
        System.out.println(to);
        while(to!=from) {
            int temp = path[to];
            System.out.println(temp);
            to = temp;
        }

    return dist[to];
    }


    static void addEdge(List<List<Integer>> edges, int u, int v)
    {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
}
