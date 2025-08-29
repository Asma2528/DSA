// Problem: https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1
/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        // Brute force approach
        // TC - Nearly O(n^2)
        // SC - O(n + m)
        // Node temp1 = head;
        
        // while(temp1!=null){
        //     Node temp2 = temp1.next;
        //     while(temp2!=null && temp1.data+temp2.data<=target){
        //         if(temp1.data + temp2.data == target){
        //             ArrayList<Integer> innerList = new ArrayList<>();
        //             innerList.add(temp1.data);
        //             innerList.add(temp2.data);
        //             list.add(innerList);
        //         }
        //         temp2=temp2.next;
        //     }
        //     temp1=temp1.next;
        // }
        
        // return list;
        
        // Optimal approach
        // TC - Nearly O(2n)
        // SC - O(n + m)
        Node left = head;
        Node right = head;
        while(right.next!=null){
            right = right.next;
        }
        
        while(left.data<right.data){
            if(left.data+right.data == target){
                ArrayList<Integer> innerList = new ArrayList<>();
                innerList.add(left.data);
                innerList.add(right.data);
                list.add(innerList);
                
                left = left.next;
                right = right.prev;
            }
            else if(left.data+right.data > target){
                right = right.prev;
            }
            else{
                left = left.next;
            }
        }
        
        
        return list;
    }
}

