// Problem: https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node convertToList(ArrayList<Integer> list){
        Node head = new Node(list.get(0));
        Node temp = head;
        
        for(int i=1;i<list.size();i++){
            Node newNode = new Node(list.get(i));
            temp.bottom = newNode;
            temp = temp.bottom;
        }
        
        return head;
    }
    
    public Node merge(Node first,Node second){ // O(m + m) where m is the length of vertical list
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while(first!=null && second!=null){
            if(first.data<=second.data){
                temp.bottom = first;
                temp = temp.bottom;
                first = first.bottom;
            }
            else{
                temp.bottom = second;
                temp = temp.bottom;
                second = second.bottom;
            }
        }
        
        if(first!=null){
            temp.bottom = first;
        }
        else{
            temp.bottom = second;
        }
        
        if(dummy.bottom==null){
            return null;
        }
        
        return dummy.bottom;
    }
     
    public Node flatten(Node root) {
        // Brute force approach
        // TC - 2*O(n*m) + O(n*m log n*m)
        // SC - 2*O(n*m)
        // Idea: Iterate through the linked list and add the values in an arraylist
        // Sort the arraylist
        // Convert arraylist into single vertical list 
        
        // if(root==null){
        //     return null;
        // }
        
        // ArrayList<Integer> list = new ArrayList<>();
        // Node temp = root;
        
        // while(temp!=null){ // O(n*m)
        //     Node t2 = temp;
        //     while(t2!=null){
        //         list.add(t2.data);
        //         t2 = t2.bottom;
        //     }
        //     temp = temp.next;
        // }
        
        // Collections.sort(list); O(n*m log n*m)
        
        // return convertToList(list); // O(n*m)
        
        
        // Optimal Approach
        // TC - O(n) * O(m2) thus it is O(2nm)
        // SC - O(n) // for recursive stack space
        /*
        Use recursion to flatten the list from the end:
        First, recursively flatten the next sublist.
        Then merge the current list (root) with the already flattened next list.
        The merge() function merges two sorted bottom-linked lists into one.
        Return the head of the merged vertical list.
        */
        
        if(root==null || root.next==null){
            return root;
        }
        
        Node mergedRoot = flatten(root.next); // O(n) (as we traverse thorugh the hortizonal list) 
        
        Node head = merge(root, mergedRoot); // O(m + m) = O(2m) (as we are sending 2 vertical lists)
        
        return head;
        
    }
}