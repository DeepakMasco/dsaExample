package leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfProvience {

    public int findCircleNum(int[][] arr) {
        int len = arr.length;

        boolean[] visited = new boolean[len];

        Arrays.fill(visited, false);

        int count = 0;

        for(int i=0;i<len;i++) {
            if(!visited[i]) {
                count++;
                bfs(arr,visited,i);
            }
        }
        return count;
    }



    private void bfs(int[][] arr, boolean[] isVisited, int from) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(from);
        isVisited[from] = true;


        while(!qu.isEmpty()) {
            int curr = qu.poll();
            for(int i=0;i<arr[curr].length;i++) {
                int ne = arr[curr][i];
                if(isVisited[i]==false && ne==1) {
                    isVisited[i]=true;
                    qu.add(i);
                }
            }
        }
    }
}
