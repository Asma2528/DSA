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
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
    if(head==null || head.next==null){
        return head;
    }
    ListNode prev=null;
    ListNode curr=head;
    while(curr!=null){
        ListNode temp=curr.next;
        curr.next=prev;
        prev=curr;
        curr=temp;
    }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
            return true;
        }

        ListNode middle=findMiddle(head);
        ListNode secondHalfHead=reverse(middle.next);
        middle.next=null;
        ListNode first=head;
        ListNode second=secondHalfHead;
        while(second!=null){
            if(first.val!=second.val){
                middle.next=reverse(secondHalfHead);
                return false;

            }
            first=first.next;
            second=second.next;
        }
        middle.next=reverse(secondHalfHead);
        return true;
    }
}