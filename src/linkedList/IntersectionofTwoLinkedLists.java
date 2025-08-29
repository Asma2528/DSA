// Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode collision(ListNode headA, ListNode headB, int count){
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(count!=0){ //  O(max(m, n))
            tempA = tempA.next;
            count--;
        }

        while(tempA!=tempB){
            tempA=tempA.next;
            tempB=tempB.next;
        }

        return tempA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Brute force approach
        // TC - O(m + n)
        // SC - O(m)
        // Map<ListNode, Integer> map = new HashMap<>();
        // ListNode temp = headA;
        // int count = 0;
        // while(temp!=null){
        //     map.put(temp,count);
        //     count++;
        //     temp = temp.next;
        // }

        // temp = headB;
        // while(temp!=null){
        //     if(map.containsKey(temp)){
        //         return temp;
        //     }
        //     temp = temp.next;
        // }

        // return null;

        // Better approach
        // TC - O(m + n) + O(max(m, n))
        // SC - O(1)
        // ListNode temp = headA;
        // int count1 = 0;
        // while(temp!=null){ // O(m)
        //     count1++;
        //     temp = temp.next;
        // }

        // temp = headB;
        // int count2 = 0;
        // while(temp!=null){ // O(n)
        //     count2++;
        //     temp = temp.next;
        // }

        // if(count1 > count2){
        //     return collision(headA, headB, count1 - count2);
        // }
            
        // return collision(headB, headA, count2 - count1);

        // Optimal approach (Two-Pointer Switching)
        // TC - O(m + n)
        // SC - O(1)
       
       /*
        Key Idea:
        Traverse both lists with two pointers (tempA and tempB)
        When a pointer reaches the end of its list, switch it to the head of the other list
        This way, both pointers will traverse exactly m + n steps
        If the lists intersect, they'll meet at the intersection node
        If not, both will reach null at the same time

        Intution:
        When each pointer reaches the end of its list, we switch it to the start of the other list:
        tempA goes: A → B
        tempB goes: B → A

        This way:
        Both pointers travel the same total distance: lengthA + lengthB
        If there's an intersection, they’ll meet there after at most m + n steps
        If not, they’ll both reach null at the same time
        */

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA!=tempB){
            if(tempA==null){
                tempA = headB;
            }
            else if(tempB==null){
                tempB = headA;
            }
            else{
                tempA=tempA.next;
                tempB=tempB.next;
            }
        }

        return tempA;
    }
}