package leetcode;

public class IntersectionOf2LinkedList {

/*
    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
    Output: Intersected at '8'
    Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
    From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/2116221/Visual-Explanation-or-One-Pass-JAVA

*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;
        while(headA != headB) {
            headA = headA ==null ? ptrB : headA.next;
            headB = headB ==null ? ptrA : headB.next;
        }
        return headA;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
