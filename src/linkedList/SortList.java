// Problem: https://leetcode.com/problems/sort-list/
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
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(left!=null && right!=null){
            if(left.val<=right.val){
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
            else{
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }   
        
        if(left!=null){
            temp.next = left;
        }
        else{
            temp.next = right;
        }
        
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        // Brute force approach
        // TC - O(log n) + O(2n)
        // SC - O(n) due to the recursion stack
        // ArrayList<Integer> list = new ArrayList<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }

        // Collections.sort(list);

        // int i = 0;
        // temp = head;
        // while(temp!=null){
        //     temp.val = list.get(i);
        //     i++;
        //     temp = temp.next;
        // }

        // return head;

        // Optimal approach
        // TC - O(log n * (n + n/2))
        // SC - O(log n) due to the recursion stack
        /*
        Approach:
        Base case: If the list is empty or has a single node, it is already sorted.
        Find the middle of the list using findMiddle.
        Recursively split the list into two halves and sort them.
        Merge the two sorted halves using the merge method.
        */

        ListNode middle = findMiddle(head); // O(n/2)
        ListNode rightHead = middle.next;
        middle.next = null;

        // O(log n)
        ListNode leftHead = sortList(head);
        rightHead = sortList(rightHead);

        return merge(leftHead,rightHead); // O(n)
    }
}