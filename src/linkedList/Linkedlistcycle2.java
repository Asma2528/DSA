// Problem: https://leetcode.com/problems/linked-list-cycle-ii
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // Brute force approach
        // TC - O(n)
        // SC - O(n)
        // ListNode temp = head;
        // Map<ListNode,Integer> map=new HashMap<>();
        // int count = 0;
        // while(temp!=null){
        //     if(map.containsKey(temp)){
        //         return temp;
        //     }
        //     map.put(temp,count);
        //     count++;
        //     temp = temp.next;
        // }

        // return null;

        // Optimal approach
        // TC - O(n)
        // SC - O(1)
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
        /*
        Summary:
        Phase 1: Detect cycle using slow/fast pointers
        Phase 2: Reset slow to head; move both one step at a time
        Where they meet = start of the cycle
        */
    }
}