// Problem: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // Brute force approach
        // TC - O(n) + O(n/2)
        // SC - O(1)
        // ListNode temp = head;
        // int n = 0;

        // while(temp!=null){
        //     n++;
        //     temp = temp.next;
        // }

        // temp = head;
        // int m = (n / 2) ; //Finding a node before middle node in case of odd length, Finding first middle in case of even length
        // while(m!=1){
        //     m--;
        //     temp = temp.next;
        // }

        // temp.next = temp.next.next;

        // return head;

        // Optimal approach
        // TC - O(n/2)
        // SC - O(1)
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}