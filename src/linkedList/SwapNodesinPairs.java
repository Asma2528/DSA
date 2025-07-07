// Problem: https://leetcode.com/problems/swap-nodes-in-pairs
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
    public ListNode swapPairs(ListNode head) {
        if(head==null ||head.next==null){
            return head;
        }

        ListNode ptr=head;
        ListNode prev=null;
        ListNode curr=ptr.next;
        ListNode h=curr;

        while(curr!=null){
            ptr.next=curr.next;
            curr.next=ptr;

            if(prev!=null){
                prev.next=curr;
            }
            prev=ptr;
            ptr=ptr.next;

            if(ptr!=null){
                curr=ptr.next;
            }
            else{
                curr=null;
            }
        }
        
        return h;
    }
}