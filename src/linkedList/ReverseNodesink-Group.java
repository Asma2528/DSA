// Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
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
    // Helper method to reverse a linked list.
    // This function takes a ListNode and reverses the entire linked list.
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode back = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }

        return back; // Return the new head (which is the last node of the original list).
    }

    // Helper method to find the kth node in the linked list.
    // This function returns the kth node starting from 'head'.
    public ListNode findKthNode(ListNode head, int k){
        ListNode temp = head;
        while(k!=1 && temp!=null){
            temp = temp.next;
            k--;
        }
        return temp; // Return the kth node (or null if the list is shorter than k).
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // TC - O(2n)
        // SC - O(1)
        if(head==null || head.next==null){ // Base case: If the list is empty or has only one node, no need to reverse.
            return head;
        }

        ListNode temp = head;  // 'temp' will move through the list.
        ListNode prev = null;  // 'prev' will keep track of the previous group after reversal.

       // Loop through the list to reverse nodes in groups of size k.
        while(temp!=null){
             // Find the kth node in the current group of k nodes.
            ListNode kthNode = findKthNode(temp,k); 

            // If there are fewer than k nodes remaining, do not reverse.
            if(kthNode==null){
                 // If there are fewer than k nodes left, simply link the last part of the list.
                if(prev!=null) prev.next = temp;
                break; // Stop further processing, as no more full groups are available.
            }
            else{
                // Otherwise, we reverse the group of k nodes starting from 'temp'.
                ListNode nextNode = kthNode.next; // Save the node after the kth node.
                kthNode.next = null;  // Disconnect the kth node from the rest of the list.
                reverse(temp);    // Reverse the group of k nodes.
                
                if(temp==head){ // If we're processing the first group, update the head.
                    head = kthNode; // The new head of the list will be the kth node after reversal.
                }
                else{
                    prev.next = kthNode; // Link the previous group to the new head of the reversed group.
                }
                prev = temp; // Move 'prev' to the end of the current group (after reversal).       
                temp = nextNode;  // Move 'temp' to the start of the next group.
            }
        }

        // Return the new head of the entire list after processing all the groups.
        return head;
    }
}