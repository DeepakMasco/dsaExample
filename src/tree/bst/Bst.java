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

        boolean ans2ndWay = checkBst2ndWay(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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

    private static boolean checkBst2ndWay(Node root, int min, int max) {
       if(root == null) {
           return true;
       }
       if(root.data < min || root.data > max) {
           return false;
       }
        return checkBst2ndWay(root.left, min, root.data-1) && checkBst2ndWay(root.right, root.data +1, max);
    }

    private static Node insertNewNode(Node root, int key) {
        if (root==null) {
            return new Node(key);
        }
        if(root.data>key) {
            root.left = insertNewNode(root.left, key);
        } else if(root.data<key) {
            root.right = insertNewNode(root.right, key);
        }
        return root;
    }
}
