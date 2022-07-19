package tree;

public class LCA {


    Node lca(Node root, int n1,int n2)
    {
        // Your code here
        if(root==null) {
            return null;
        }

        // If any of the value is found on the root. Then we surely know other value will be below this.
        // SO this current node will be parent of the second value and LCA for both.
        if(root.data==n1 || root.data==n2) {
            return root;
        }


        Node left = lca(root.left,n1,n2);
        Node right = lca(root.right,n1,n2);

        // Then we iterate in the left part. Let us suppose we iterated whole left part of tree and nothing found and we hit.
        // the leaf node then surely we know that right will be the LCA for both nodes.
        if(left==null) return right;
        if(right==null) return left;

        // If one value is found in left and one in right side then current is the LCA for both nodes.
        return root;
    }
}
