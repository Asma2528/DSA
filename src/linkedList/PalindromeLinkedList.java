// Problem: https://leetcode.com/problems/palindrome-linked-list
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
    public ListNode findMiddle(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode back = null;

        while(temp!=null){
            ListNode front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }

        return back;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Brute force approach
        // TC - O(2N)
        // SC - O(N)
        // Stack<Integer> st = new Stack<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     st.push(temp.val);
        //     temp = temp.next;
        // }

        // temp = head;
        // while(temp!=null){
        //     if(st.peek()!=temp.val){
        //         return false;
        //     }
        //     temp = temp.next;
        //     st.pop();
        // }

        // return true;

        // Optimal approach
        // TC - O(2N)
        // SC - O(1)
        ListNode middle = findMiddle(head);  // O(N/2)
        ListNode newHead = reverse(middle);  // O(N/2)
        ListNode first = head;
        ListNode second = newHead;

        while(second!=null){ // O(N/2)
            if(first.val!=second.val){
                newHead = reverse(newHead);  // O(N/2)
                return false;
            }
            first = first.next;
            second = second.next;
        }

        newHead = reverse(newHead);
        return true;
    }
}