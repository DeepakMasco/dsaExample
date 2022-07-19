package tree;

public class Diameter {

    // https://leetcode.com/problems/diameter-of-binary-tree/submissions/


    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(Node root) {
        solve(root);
        // As we calculated the no of nodes. But we need the edges. So it will be always -1 the no of nodes.
        return res-1;

    }

    private int solve(Node root) {
        if(root==null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);
        // this is to check if the diameter passes from the parent of current node.
        int temp = Math.max(left,right) + 1;
        // this is to check if the diameter passes from current node itself.
        int ans = Math.max(temp, 1 + left + right);

        //we store the result in global variable so that we don't change it in every call.
        res = Math.max(res, ans);

        // We return the value which we get if the diameter passes from parent node.
        return temp;

    }
}
