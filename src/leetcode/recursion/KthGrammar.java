package leetcode.recursion;


/*We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

    For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.

Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.



Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0

Example 2:

Input: n = 2, k = 1
Output: 0
Explanation:
row 1: 0
row 2: 01



N
1    0
2    0 1
3    0 1 1 0
4    0 1 1 0 1 0 0 1


If we observe the above pattern the Nth term is divided in half and first half is exactly same as prev N and the rest half
is like negate of the first half.
so with this observation we first try to find the mid of Nth row and then check where does K lies.
If k is before mid we can do n-1,k and if not we need to first find n-1,k-mid and then negate the result to get the ans
*/
public class KthGrammar {

    public static void main(String[] args) {
        System.out.println(kthGrammar(4,3));
    }


    public static int kthGrammar(int n, int k) {

        if(n==1 && k==1) {
            return 0;
        }

        int mid = (int)Math.pow(2,n-1)/2;

        if(k<=mid) {
            return kthGrammar(n-1,k);
        } else {
            return kthGrammar(n-1,k-mid)==0?1:0;
        }

    }
}
