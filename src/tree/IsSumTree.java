package tree;

public class IsSumTree {

    boolean isSumTree(Node root)
    {
        // if root is null or it is a leaf node then we calculate it is valid sum tree
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }

        int left = sum(root.left);
        int right = sum(root.right);



        // We check if current node is following the rule and then left and right part also follows the rule or not
        return (left+right)==root.data && isSumTree(root.left) && isSumTree(root.right);
    }


// This function returns the sum till the node from bottom.
    public int sum(Node root) {
        if(root==null) return 0;

        return sum(root.left)+sum(root.right)+root.data;
    }
}
