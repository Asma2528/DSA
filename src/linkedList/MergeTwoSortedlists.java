// Problem: https://leetcode.com/problems/merge-two-sorted-lists
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
    public ListNode convertToLinkedList(ArrayList<Integer> list){
        ListNode head = new ListNode(list.get(0));
        ListNode temp = head;

        for(int i=1;i<list.size();i++){
            ListNode nextNode = new ListNode(list.get(i));
            temp.next = nextNode;
            temp = temp.next;
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        // TC - O(n1 + n2) + O(N log N) + O(N)
        // SC - O(N) + O(N) {to return the answer}
        // ArrayList<Integer> list = new ArrayList<>();

        // ListNode temp = list1;
        // while(temp!=null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }

        // temp = list2;
        // while(temp!=null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }

        // Collections.sort(list); // O(N log N) where N is n1 + n2

        // return convertToLinkedList(list); // O(N)

        // TC - O(n1 + n2)
        // SC - O(1)
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t1 = list1;
        ListNode t2 = list2;

        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }

        if(t1==null){
            temp.next = t2;
        }
        else{
            temp.next = t1;
        }

        return dummy.next;
    }
}