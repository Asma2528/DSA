// Problem: https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1
// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // TC - O(n)
        // SC - O(1)
        if(head==null){
            return null;
        }
        
        if(head.next==null){
            if(head.data==x){
                return null;
            }
            else{
                return head;
            }
        }
        
        Node prev = null;
        Node temp = head;
        while(temp!=null){
            if(temp.data==x){
                if(temp==head){
                    head = head.next; // If the starting nodes match then keep on shifting the head
                }
                
                Node front = temp.next; 
                prev = temp.prev;
                
                if(front!=null){ // to avoid null pointer exception when temp reaches last node and front is null
                    front.prev = prev; 
                }
                
                if(prev!=null){  // to avoid null pointer exception when temp is first node and prev is null
                    prev.next = front;
                }
                
                temp = front; // Move temp to next node
            }
            else{
                temp = temp.next;
            }
        }
        
        return head;
        
        
    }
}