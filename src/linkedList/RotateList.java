// Problem: https://leetcode.com/problems/rotate-list
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
    public ListNode rotateRight(ListNode head, int k) {
        // TC - O(2n)
        // SC - O(1)
        /*
        Idea:
        Find the length of the list and last node of the list
        Make the list circular by connecting tail to head.
        Find k using k % len (in case k is bigger)
        Find the new last node of rotated list (len - k)
        Point next node of the last node as the new head
        Point last node's next as null (to break the circular list)
        */
        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        if (k % len == 0)
            return head;
        k = k % len;
        tail.next = head;
        ListNode curr = head;
        int count = len - k;

        while (count != 1) {
            curr = curr.next;
            count--;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}