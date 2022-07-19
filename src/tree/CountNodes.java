package tree;
// If we do any inorder traversal or other one it will be costly in time operation.
// What we can do is as the tree is complete binary tree.
// So we can make use of this and see if left==right height then use 2^height -1 formula to return
// If not we can do nodes in left + right + 1;
public class CountNodes {
    public int countNodes(Node root) {
        if(root==null) return 0;

        int leftH = heightLeft(root);
        int rightH = heightRight(root);

        if(leftH!=rightH) {
            return countNodes(root.left)+countNodes(root.right) +1;
        } else {
            return ((2<<(leftH)) -1);
        }

    }


    public int heightLeft(Node root) {
        if(root==null) return 0;
        int count = 0;
        while(root.left!=null) {
            root = root.left;
            count++;
        }

        return count;
    }

    public int heightRight(Node root) {
        if(root==null) return 0;
        int count = 0;
        while(root.right!=null) {
            root = root.right;
            count++;
        }

        return count;
    }
}
