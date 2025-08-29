// Problem: https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1
class Solution {
    Node removeDuplicates(Node head) {
        // TC - O(n)
        // SC - O(1)
        if(head==null || head.next==null){
            return head;
        }
        
        Node temp = head;
        while(temp!=null && temp.next!=null){
            Node nextNode = temp.next;
            
            while(nextNode!=null && nextNode.data==temp.data){
                nextNode = nextNode.next;
            }
            
            temp.next = nextNode;
            if(nextNode!=null) nextNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }
}