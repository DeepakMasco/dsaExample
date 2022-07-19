package tree;

public class SubTreeOrNot {
    Node startPoint = null;
    public boolean isSubtree(Node root, Node subRoot) {
        if(root == null){
            return false;
        }

        // We check at every node and if anyone gives yes we return true. Because there can be deuplicate values also present
        if(checkTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Same as of checking 2 trees are identical or not
    public boolean checkTree(Node root, Node subRoot) {

        if(root == null || subRoot == null) {
            return root==subRoot;
        }

        return (root.data==subRoot.data) && checkTree(root.left,subRoot.left) &&checkTree(root.right,subRoot.right) ;
    }
}
