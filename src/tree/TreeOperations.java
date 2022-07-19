package tree;

import java.util.Scanner;
import java.util.Stack;

public class TreeOperations {

    public static void main(String[] args) {
        System.out.println("Program to Create Tree");
        Node root = createTree();

        System.out.println("InOrder Traversal");
        inOrder(root);

         System.out.println("PreOrder Traversal");
        preOrder(root);

        System.out.println("PreOrder Traversal With Iteration");
        preOrderIterative(root);

        System.out.println("PostOrder Traversal");
        postOrder(root);

        int height = height(root);
        System.out.println("Height Of Tree");
        System.out.println(height);


        int size = getSize(root);
        System.out.println("Size Of Tree");
        System.out.println(height);

        int min = getMin(root);
        System.out.println("Min Of Tree");
        System.out.println(min);

        int max = getMax(root);
        System.out.println("Maxx Of Tree");
        System.out.println(max);

    }

    public static Node createTree() {
        Node root;
        System.out.println("Enter the Value");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        if(data == -1) {
            return null;
        }

        root = new Node(data);

        System.out.println("Enter the Left for " +  data);
        root.left = createTree();

        System.out.println("Enter the Right for " + data);
        root.right = createTree();
        return root;
    }


    public static int getMax(Node root) {
        if(root==null) {
            return Integer.MIN_VALUE;
        }

        int temp = Math.max(getMax(root.left),getMax(root.right));
        return Math.max(temp,root.data);
    }

    public static int getMin(Node root) {
        if(root==null) {
            return Integer.MAX_VALUE;
        }

        int temp = Math.min(getMin(root.left),getMin(root.right));
        return Math.min(temp,root.data);
    }


    public static int getSize(Node root)
    {
//add Code here.
        if(root==null) {
            return 0;
        }

        return getSize(root.left)+getSize(root.right)+1;

    }
    public static void inOrder(Node root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root==null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void preOrder(Node root) {
        if(root==null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int height(Node root) {
        if(root==null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int size(Node root) {
        if(root==null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    public static void preOrderIterative(Node root) {
//Node,Left,Right
        Stack<Node> preOrderStack = new Stack<>();

        if (root==null) {
            return;
        }
        preOrderStack.push(root);

        while(!preOrderStack.isEmpty()) {
            Node node = preOrderStack.pop();
            System.out.println(node.data);

            if(node.right!=null) {
                preOrderStack.push(node.right);
            }
            if(node.left!=null) {
                preOrderStack.push(node.left);
            }
        }
    }
}
