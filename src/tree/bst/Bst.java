package tree.bst;

import tree.Node;
import tree.TreeOperations;

public class Bst {
    private static TreeOperations treeOperations = new TreeOperations();

    public static void main(String[] args) {

        System.out.println("Program to Create Tree");
        Node root = treeOperations.createTree();

        root = insertNewNode(root, 10);
        root = insertNewNode(root, 30);
        root = insertNewNode(root, 1000);
        root = insertNewNode(root, 70);
        treeOperations.inOrder(root);


        boolean ans = checkBst(root);
        System.out.println("The given tree is BST : " + ans);

        boolean ans2ndWay = checkBst2ndWay(root, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("The given tree is BST : " + ans2ndWay);
    }

    static Node prev = null;
    private static boolean checkBst(Node root) {
        if(root!=null) {
            if(!checkBst(root.left)) {
                return false;
            }
            if(prev!=null && prev.data>= root.data ) {
                return false;
            }
            prev = root;
            return checkBst(root.right);
        }
        return true;
    }

    private static boolean checkBst2ndWay(Node root, long min, long max) {
       if(root == null) {
           return true;
       }
       if(root.data <= min || root.data >= max) {
           return false;
       }
        return checkBst2ndWay(root.left, min, root.data) && checkBst2ndWay(root.right, root.data, max);
    }

    private static Node insertNewNode(Node root, int key) {
        if (root==null) {
            return new Node(key);
        }

        // Using simple binary search to find if it exists in left or right.
        if(root.data>key) {
            root.left = insertNewNode(root.left, key);
        } else if(root.data<key) {
            root.right = insertNewNode(root.right, key);
        }
        return root;
    }

// In a BST inorder traversal will always give sorted no.
    // So if we want to delete any node we need to find the inorder successor(next no) of the key
    public Node deleteNode(Node root, int key) {
        if(root==null) {
            return root;
        }

        if(root.data>key) {
            root.left = deleteNode(root.left,key);
        } else if(root.data<key) {
            root.right = deleteNode(root.right,key);
        }
        else {
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            // We find the next no which will come in inorderTraversal/
            // As it is BST so the leftMost element will be the smallest always.

            int min = findMin(root.right);
            // we update the current node with the data of min Value
            root.data = min;
            // then we delete the node which contains the min value by going to right side of that.
            root.right = deleteNode(root.right,min);
        }
        return root;
    }

    public int findMin(Node root) {
        int min = root.data;
        while(root.left!=null) {
            min = root.left.data;
            root = root.left;
        }

        return min;
    }
}
