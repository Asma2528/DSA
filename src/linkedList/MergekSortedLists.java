// Problem: https://leetcode.com/problems/merge-k-sorted-lists/
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

class Pair {
    ListNode node;
    int data;
    public Pair(ListNode node,int data){
        this.node = node;
        this.data = data;
    }
}

class Solution {
    public ListNode convertToList(ArrayList<Integer> list){
        ListNode head =  new ListNode(list.get(0));
        ListNode temp = head;

        for(int i=1;i<list.size();i++){
            ListNode newNode = new ListNode(list.get(i));
            temp.next = newNode;
            temp = temp.next;
        }

        return head;
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        if(list1!=null){
            temp.next = list1;
        }else{
            temp.next = list2;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        // Brute force approach
        // TC - O(2(n*m)) + O(n*m log n*m)
        // SC - O(2(n*m)) // n*m for arraylist and n*m for result linkedlist

        // ArrayList<Integer> list = new ArrayList<>();

        // // O(n*m)
        // for(int i=0;i<lists.length;i++){
        //     ListNode temp = lists[i];
        //     while(temp!=null){
        //         list.add(temp.val);
        //         temp = temp.next;
        //     }
        // }

        //  if(list.size()==0){
        //     return null;
        // }

        // Collections.sort(list); // O(n*m log n*m)

        // return convertToList(list);  // O(n*m)

        // Better approach
        // TC - O(n * (k *(k+1) / 2)) = O((k^2)*n) // k is no of lists 
        /*
        Explanation of TC
        Merge 1st and 2nd list: The time complexity is O(n+n)=O(2n). The resulting list has 2n nodes.

        Merge with 3rd list: You now merge a list of size 2n with a list of size n. This takes O(2n+n)=O(3n) time. The resulting list has 3n nodes.

        Merge with 4th list: You merge a list of size 3n with a list of size n, taking O(3n+n)=O(4n) time.

        This pattern continues. The total time complexity is the sum of all these merge operations:
        O(2n+3n+4n+⋯+kn)
        O(n(2+3+4+⋯+k))

        The sum of an arithmetic series from 1 to k is  k*(k+1) / 2
        */
        // SC - O(1)
        // ListNode temp = lists[0];

        // for(int i=1;i<lists.length;i++){
        //     temp = merge(lists[i],temp);
        // }

        // return temp;

        // Optimal Approach (using minheap)
        // TC - O(n log n) + O(m log m)
        // SC - O(n) n is the total number of nodes in all the lists
        /*
        Approach - 
        1. Insert the head of each list into the heap.
        2. Extract the smallest node from the heap, append it to the result list, and if the node has a next element, add it to the heap.
        3. Repeat until all nodes are processed.
        */
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for(int i=0;i<lists.length;i++){ // O(n)
            if(lists[i]!=null) pq.add(new Pair(lists[i],lists[i].val)); // O(log m) where M is the current size of the heap. It takes log m to add the heads of all the lists
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll(); // O(n log n)
            temp.next = pair.node;
            temp = temp.next;
            if(pair.node.next!=null) pq.add(new Pair(pair.node.next,pair.node.next.val));
        }

        return dummy.next;
    }
}