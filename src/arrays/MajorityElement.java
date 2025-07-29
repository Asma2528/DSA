// Problem: https://leetcode.com/problems/majority-element
class Solution {
    public int majorityElement(int[] nums) {
        // Brute force approach
        // TC - O(n)
        // SC - O(1)
        // HashMap<Integer,Integer> map=new HashMap<>();
        // int n=nums.length;

        // for(int num:nums){
        //     map.put(num,map.getOrDefault(num,0)+1);

        //     if(map.get(num)>n/2){
        //         return num;
        //     }
        // }

        // Optimal approach
        // Boyer-Moore Voting Algorithm
        // TC - O(n)
        // SC - O(1)
        int candidate = -1;
        int count = 0;

        for (int n : nums) {
            if (count == 0) {
                count = 1;
                candidate = n;
            } else if (n == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int n : nums) {
            if (n == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        return -1;
    }
}
