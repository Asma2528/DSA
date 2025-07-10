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
        if (head == null || head.next == null) {
            return head;
        }
        int size = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            size++;
        }

        curr.next = head;

        int tailPos = size - (k % size);
        ListNode tail = head;
        for (int i = 1; i < tailPos; i++) {
            tail = tail.next;
        }

        head = tail.next;
        tail.next = null;

        return head;
    }
}