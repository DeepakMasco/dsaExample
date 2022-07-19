package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;


/*There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed.
The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise).
 In each step, a certain number of people are skipped and the next person is executed.
 The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed),
  until only the last person remains, who is given freedom.
Given the total number of persons n and a number k which indicates that k-1 persons
are skipped and kth person is killed in circle. The task is to choose the place in the initial circle
 so that you are the last one remaining and so survive.



Example 1:

Input:
n = 2, k = 1
Output:
2
Explanation:
Here, n = 2 and k = 1, then safe position is
2 as the person at 1st position will be killed.

Example 2:

Input:
n = 4, k = 2
Output:
1
Explanation:
The safe position is 1.
*/
public class JosephusProblem {

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        k = k-1;
        List<Integer> army = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            army.add(i);
        }
      int ans = solve(n,k,army, 0);
        System.out.println(ans);
    }

    private static int solve(int n, int k, List<Integer> army, int start) {
        if(n==1) {
            return army.get(0);
        }
        start = (start+k)%n;
        army.remove(start);
        return solve(n-1,k,army, start);
    }
}
