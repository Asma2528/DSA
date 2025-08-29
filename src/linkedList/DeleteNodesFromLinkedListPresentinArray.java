// Problem: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head==null){
            return null;
        }

        // Brute force approach
        // TC - O(m*n) where m is length of nums and n is length of head
        // SC - O(1)
   
        // ListNode temp = head;
        // ListNode back = null;

        // for(int i=0;i<nums.length;i++){
        //     while(temp!=null){
        //         if(temp.val==nums[i]){
        //             if(temp==head){
        //                 head = head.next;
        //                 temp = temp.next;
        //             }
        //             else{
        //                 if(back!=null){
        //                     back.next = temp.next;
        //                 }
        //                 temp = temp.next;
        //             }
        //         }
        //         else{
        //             back = temp;
        //             temp = temp.next;
        //         }
        //     }
        //     temp = head;
        // }

        // return head;

        // Optimal approach
        // TC - O(m + n) 
        // SC - O(m + n)
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){ // O(m)
            set.add(nums[i]);
        }

        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = temp;
        ListNode back = dummy;

        while(temp!=null){ // O(n)
            if(set.contains(temp.val)){
                back.next = tamp.next;
            }
            else{
                back = temp;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}