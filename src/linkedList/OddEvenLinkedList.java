// Problem: https://leetcode.com/problems/odd-even-linked-list/
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        // Brute force approach
        // TC - O(2N)
        // SC - O(N)
        // ListNode temp = head;
        // ArrayList<Integer> list = new ArrayList<>();

        // while(temp!=null && temp.next!=null){
        //     list.add(temp.val);
        //     temp = temp.next.next;
        // }
        // if(temp!= null) list.add(temp.val);
        
        // temp = head.next;
        // int idx = 0;
        // while(temp!=null && temp.next!=null){
        //     list.add(temp.val);
        //     temp = temp.next.next;
        // }
        // if(temp!= null)  list.add(temp.val);

        // temp = head;
        // while(temp!=null){
        //     temp.val = list.get(idx);
        //     temp = temp.next;
        //     idx++;
        // }

        // return head;

        // Optimal approach
        // TC - O(N)
        // SC - O(1)
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = new ListNode(-1);
        evenHead.next = even;

        
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead.next;

        return head;
    }
}