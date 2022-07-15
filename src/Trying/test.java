package Trying;

public class test {

    static boolean isSumTree = true;

    public static void main(String[] args) {
       // call findSUm method
        System.out.println(isSumTree);

        LinkedListNode listNode = new LinkedListNode();
        LinkedListNode custom = listNode;
        LinkedListNode listNode1 = new LinkedListNode();
        LinkedListNode listNode2 = new LinkedListNode();
        LinkedListNode listNode3 = new LinkedListNode();
        LinkedListNode listNode4 = new LinkedListNode();

        listNode.val = 1;
        listNode.next = listNode1;

        listNode1.val = 3;
        listNode1.next = listNode2;

        listNode2.val = 4;
        listNode2.next = listNode3;

        listNode3.val = 6;
        listNode3.next = listNode4;

        listNode4.val = 10;
        listNode4.next = null;

        while(custom!=null) {
            System.out.println(custom.val);
            custom= custom.next;
        }

        deleteNode(listNode1, 4);

        while(listNode!=null) {
            System.out.println(listNode.val);
            listNode= listNode.next;
        }
        // LRU
        // fixed of storage
        // if full delete the least recent and then inset the value
        // o(1)
        // leastReacentlyUsed -
        // Treamap - full->
        // key, value, recentTime.
        // Custom comparator - recentTime
        //
        // has of elemtn - index to sotred - array,
        // find a way to update timespat or stroing at every fetch
        //
    }

    // sum excluding root value
    // 4, 5  = 10
    private static int findSum(Node root) {
        if(root==null) {
            return 0;
        }

        int left = findSum(root.left);
        int right = findSum(root.right);

        if(left+right!= root.val) {
            isSumTree = false;
            return -1;
        }
        return root.val;
    }


    private static void deleteNode(LinkedListNode node, int valToDelete) {

        LinkedListNode prev = node;
        // to find the element to delete
        while(node!=null) {
            if(node.val==valToDelete) {
                // to copy past
                while(node.next!=null) {
                    node.val = node.next.val;
                    prev = node;
                    node = node.next;
                }
                prev.next = null;
                break;
            }
            node = node.next;
        }
    }




}
