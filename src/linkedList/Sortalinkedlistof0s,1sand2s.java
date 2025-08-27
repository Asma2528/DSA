// Problem: https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        
        // Brute force approach
        // TC - O(2N)
        // SC - O(1)
        // int zero = 0, one = 0, two = 0;
        // Node temp = head;
        
        // while(temp!=null){
        //     if(temp.data==0){
        //         zero++;
        //     }
        //     else if(temp.data==1){
        //         one++;
        //     }
        //     else{
        //         two++;
        //     }
        //     temp = temp.next;
        // }
        
        // temp = head;

        // while(zero!=0){
        //     temp.data = 0;
        //     temp = temp.next;
        //     zero--;
        // }
        
        // while(one!=0){
        //     temp.data = 1;
        //     temp = temp.next;
        //     one--;
        // }
        
        // while(two!=0){
        //     temp.data = 2;
        //     temp = temp.next;
        //     two--;
        // }
        
        // return head;
        
        // Optimal force approach
        // TC - O(N)
        // SC - O(1)
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);
        Node zero = zeroDummy;
        Node one = oneDummy;
        Node two = twoDummy;
        Node temp = head;
        
        while(temp!=null){
            if(temp.data==0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data==1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        
        
        // Terminate the last list to avoid cycle
        two.next = null;

        // Connect lists
        one.next = twoDummy.next;
        zero.next = oneDummy.next;

        
        return zeroDummy.next;
    }
}