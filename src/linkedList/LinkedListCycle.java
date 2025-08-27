// Problem: https://leetcode.com/problems/linked-list-cycle
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

/*
If two people run on a circular track—one slow, one fast—they’ll eventually meet at some point, no matter their speeds. But if they run on a straight road, the fast one will keep going ahead and they'll never meet.
This is exactly how the slow and fast pointer (Floyd’s Cycle Detection) works in a linked list to detect a loop.
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // Brute force approach
        // TC - O(n)
        // SC - O(n)
        // ListNode temp = head;
        // Map<ListNode,Integer> map=new HashMap<>();
        // int count = 0;
        // while(temp!=null){
        //     if(map.containsKey(temp)){
        //         return true;
        //     }
        //     map.put(temp,count);
        //     count++;
        //     temp = temp.next;
        // }

        // return false;

        // Brute force approach
        // TC - O(n)
        // SC - O(1)
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }
}