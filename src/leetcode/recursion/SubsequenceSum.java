package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSum {

    public static void main(String[] args) {
        int[] input = new int[]{10,1,2,7,6,1,5};
        List<Integer> ans = new ArrayList<>();
        printSub(input,ans,0,8);
    }

    private static void printSub(int[] input, List<Integer> ans,int n,int sum) {
        if(n==input.length) {
            if(sum==0) {
                    System.out.println(ans);
            }
            return;
        }

        ans.add(input[n]);
        printSub(input, ans, n+1 , sum-input[n]);
        ans.remove(ans.size()-1);
        printSub(input, ans, n+1 , sum);
    }
}
