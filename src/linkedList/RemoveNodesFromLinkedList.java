// Problem: https://leetcode.com/problems/remove-nodes-from-linked-list
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseHead = reverseList(head);

        ListNode prev = null;
        ListNode curr = reverseHead;
        int maxVal = Integer.MIN_VALUE;

        while (curr != null) {
            if (curr.val < maxVal) {
                prev.next = curr.next;
            } else {
                maxVal = curr.val;
                prev = curr;
            }
            curr = curr.next;
        }

        return reverseList(reverseHead);
    }
}