// Problem: https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;

        while(t1!=null || t2!=null){
            int sum = carry;

            if(t1!=null) sum+=t1.val;
            if(t2!=null) sum+=t2.val;
            
            ListNode newNode = new ListNode(sum % 10); // we there is a carry over then only units place digit will be added to node
            current.next = newNode;
            carry = sum / 10; // we there is a carry over it will be stored in carry to add it in the next sum

            if(t1!=null) t1=t1.next;
            if(t2!=null) t2=t2.next;

            current = current.next;
        }

        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        
        return dummy.next;
    }
}