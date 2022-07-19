package tree;

public class MaxPath {
    // This if for any node to any node.
    // There is no restriction to use leaf node itself.

    //https://leetcode.com/problems/binary-tree-maximum-path-sum/



    int res = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        solve(root);
        return res;
    }


    private int solve(Node root) {
        if(root==null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        // We have 2 options let us say either we can select a path from left or right but there can be
        // a possibility both left and right are negative and only root itself is greater.
        // So we will do max from all 3 values,
        int temp = Math.max(root.data, Math.max(left,right)+root.data);

        // We will calculate this for current node assuming the result will be from node itself.
        int ans = Math.max(temp, left+right+root.data);

        res = Math.max(res,ans);

        return temp;
    }
}
