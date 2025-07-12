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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode temp = new ListNode(0);
        ListNode l3 = temp;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                l3.next = curr1;
                l3 = l3.next;
                curr1 = curr1.next;
            } else {
                l3.next = curr2;
                l3 = l3.next;
                curr2 = curr2.next;
            }
        }

        while (curr1 != null) {
            l3.next = curr1;
            l3 = l3.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            l3.next = curr2;
            l3 = l3.next;
            curr2 = curr2.next;
        }

        return temp.next;

    }
}