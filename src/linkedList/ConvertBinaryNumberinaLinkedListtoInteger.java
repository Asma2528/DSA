// Problem: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
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
    public int findSize(ListNode head) {
        ListNode curr = head;
        int size = 0;

        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return size - 1;
    }

    public int getDecimalValue(ListNode head) {
        // String bin = "";
        // ListNode curr = head;

        // while (curr != null) {
        //     bin += Integer.toString(curr.val);
        //     curr = curr.next;
        // }

        // int num = Integer.parseInt(bin, 2);

        // return num;

        int num = 0;
        ListNode curr = head;
        int c = findSize(head);

        while (curr != null) {
            num += curr.val * Math.pow(2, c);
            curr = curr.next;
            c--;
        }

        return num;

    }
}