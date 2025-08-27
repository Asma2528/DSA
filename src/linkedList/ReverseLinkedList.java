// Problem: https://leetcode.com/problems/reverse-linked-list
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
        // Brute force approach - (Changing values)
        // TC - O(2n)
        // SC - O(n)
        // Stack<Integer> st = new Stack<>();
        // ListNode temp = head;

        // while(temp != null){
        //     st.push(temp.val);
        //     temp = temp.next;
        // }

        // temp = head;
        // while(temp != null){
        //     temp.val = st.peek();
        //     st.pop();
        //     temp = temp.next;
        // }

        // return head;

        // Recursive approach
        // TC - O(n)
        // SC - O(n) // for recursive stack
        // if(head==null || head.next==null){
        //     return head;
        // }

        // ListNode newHead = reverseList(head.next);

        // ListNode front = head.next;
        // front.next = head;
        // head.next = null;

        // return newHead;

        // Iterative approach
        // TC - O(n)
        // SC - O(1) // for recursive stack
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode back = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }

        return back;

    }
}