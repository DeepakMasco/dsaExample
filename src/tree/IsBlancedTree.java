package tree;

public class IsBlancedTree {

    public boolean isBalanced(Node root) {
        if(root==null) return true;
        // we check at every node the height and find the difference.
        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }


    public int height(Node root) {
        if(root==null) return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }
}
