// Problem: https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        Node back = null;

        while (temp != null) {
            Node front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }

        return back;
    }
    
    public int helper(Node temp){
        if(temp==null){
            return 1;
        }
        
        int carry = helper(temp.next);
        
        temp.data = temp.data + carry;
        
        if(temp.data <= 9){
            return 0;
        }
        
        temp.data = 0;
        return 1;
    }

    public Node addOne(Node head) {
        if(head==null){
            return head;
        }
        
        // Brute force approach
        // TC - O(3N)
        // SC - O(1)
        
        // head = reverse(head);
        
        // Node temp = head;
        // int carry = 1;
        
        // while(temp!=null){
        //     if(temp.data+carry>=10){
        //         temp.data = 0;
        //     }
        //     else{
        //         temp.data = temp.data + carry;
        //         carry = 0;
        //         break;
        //     }

        //     temp = temp.next;
        // }
        
        // head = reverse(head);
        
        // if(carry==1){
        //     Node node = new Node(carry);
        //     node.next = head;
        //     return node;
        // }
        
        // return head;
        
        // Optimal approach
        // TC - O(n)
        // SC - O(n) // for recursive stack space
        
        int carry = helper(head);
        
        if(carry==1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        
        return head;
    }
}