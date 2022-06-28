package leetcode.dp.knapsack;
/*
*
* In this we need to maximize the value of kanpsack in given weight capacity.
* So we make choice diagram like if weight <= capacity then we can either choose it or leave it.
* If wieght>capacity then we need to leave that element and move ahead.
*
*
* This solution can give Time Limit in some cases as we are re-calculating things here.
* */
public class KnapsackWithRecursion {

    public static void main(String[] args) {

        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
       System.out.println(knapSack(W, wt, val, n));
    }


    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        if (n==0 || W==0) {
            return 0;
        }
        if (wt[n-1]<=W) {
            return Math.max(
                    //Picking weight
                    val[n-1]+knapSack(W-wt[n-1],wt,val,n-1),
                             //Leaving
                             knapSack(W,wt,val,n-1)
            );
        }
//Leaving as weight size is > capacity
        return knapSack(W,wt,val,n-1);

    }
}
