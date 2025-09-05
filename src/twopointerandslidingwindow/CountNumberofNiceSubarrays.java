// Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
class Solution {
    public int countSubarrays(int[] nums, int k) {
        int total = 0;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                count++;
            }
          
            while(count > k) {
                if (nums[left] % 2 == 1) {
                    count--;
                }
                left++;
            }
            total += (right - left + 1); // counts all valid subarrays in the current windowx
        }
        return total;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        // int total = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int count = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         if (nums[j] % 2 == 1) {
        //             count++;
        //         }
        //         if (count == k) {
        //             total++;
        //         }
        //         else if(count > k){
        //             break;
        //         }
        //     }
        // }

        // return total;

        // Optimal approach
        // TC - O(2n)
        // SC - O(1)
        return countSubarrays(nums, k) - countSubarrays(nums, k - 1);

    }
}