// Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public int findLLSize(ListNode head) {
        int size = 0;

        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return size;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        // Brute force approach
        // TC - O(2N)
        // SC - O(1)

        // int size = findLLSize(head);
        // if (size == n) {
        //     return head.next;
        // }
        // int idx = size - n;
        // int i = 1;
        // ListNode prev = head;
        // while (i < idx) {
        //     prev = prev.next;
        //     i++;
        // }
        // prev.next = prev.next.next;

        // return head;

        // Optimal approach
        // TC - O(N)
        // SC - O(1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n steps ahead
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if(fast.next==null){
            return head.next; // If we have to remove head when only 2 nodes are given
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}