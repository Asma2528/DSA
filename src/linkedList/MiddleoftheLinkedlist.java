// Problem: https://leetcode.com/problems/middle-of-the-linked-list
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
    public ListNode middleNode(ListNode head) {
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
        // int m = (n / 2) + 1; //Finding middle node in case of odd length, Finding second middle in case of even length
        // while(m!=1){
        //     m--;
        //     temp = temp.next;
        // }

        // return temp;

        // Optimal approach
        // TC - O(n/2)
        // SC - O(1)

        ListNode fast = head;
        ListNode slow = head;

        // For odd length - fast pointer goes the the last node
        // For even length - slow pointer goes to the null (beyond list)

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}