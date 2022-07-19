package tree;
// In this we need to convert the Tree into a Double Linked List.
// So we have to make a LinkedList in the InorderTraversal.

public class ConvertToDDL {

    Node head = null;
    Node prev = null;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        //  Your code here

        convert(root);
        return head;
    }

// Doing inorder traversal to convert into DLL
    public void convert(Node root) {
        if(root==null) {
            return;
        }

        convert(root.left);

        // for first node in the leftmost side. The prev = null. So we make this as starting point.
        if(prev==null) head = root;
        else {
            // As it is inorder traversal we make the following changes.
            prev.right = root;
            root.left = prev;
        }

        // to preserve the last node always.
        prev = root;
        convert(root.right);
    }
}
