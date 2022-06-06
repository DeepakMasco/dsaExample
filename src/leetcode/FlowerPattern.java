package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FlowerPattern {


    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        int n = 3;
        String [][] ans = new String[n*2][n*2];

        for(int i=0;i<n*2;i++) {
            for(int j=0;j<n*2;j++) {
                ans[i][j] = map.get(n-i);
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }


    }
}
