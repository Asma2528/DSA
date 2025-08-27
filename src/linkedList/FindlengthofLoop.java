// Problem: https://www.geeksforgeeks.org/problems/find-length-of-loop/1
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }

        // Brute force approach
        // TC - O(n)
        // SC - O(n)
        // Node temp = head;
        // Map<Node,Integer> map=new HashMap<>();
        // int count = 0;
        // while(temp!=null){
        //     if(map.containsKey(temp)){
        //         return count - map.get(temp);
        //     }
        //     map.put(temp,count);
        //     count++;
        //     temp = temp.next;
        // }

        // return 0;

        // Optimal approach
        // TC - O(n)
        // SC - O(1)
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = slow.next;
                int len = 1;
                while(slow!=fast){
                    len++;
                    slow = slow.next;
                }
                return len;
            }
        }

        return 0;
        
    }
}