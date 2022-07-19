package tree;

public class EqualTree {

    public boolean checkTree(Node root, Node subRoot) {
        //If any of the tree finishes first then we retrun false. Else if both finishes together then true
        if(root == null || subRoot == null) {
            return root==subRoot;
        }

        return (root.data==subRoot.data) && checkTree(root.left,subRoot.left) &&checkTree(root.right,subRoot.right) ;
    }
}
