// Problem: https://leetcode.com/problems/3sum-closest
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Brute force approach
        // TC - O(n^3) 
        // SC - SC - O(1)
        // int closestSum = Integer.MAX_VALUE;

        // for (int i = 0; i < nums.length - 2; i++) {

        //     for (int j = i + 1; j < nums.length - 1; j++) {

        //         for (int k = j + 1; k < nums.length; k++) {
        //                 int sum = nums[i] + nums[j] + nums[k];

        //             if (Math.abs(sum-target)<Math.abs(closestSum-target)) {
        //                 closestSum=sum;
        //             }
        //         }
        //     }
        // }

        // return closestSum;

        // Optimal approach
        // TC - O(nlogn) + O(n)
        // SC - O(no of unique elements) // for returning the answer
        int closestSum = Integer.MAX_VALUE;
        // O(nlogn)
        Arrays.sort(nums);
        // O(n)
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return sum;
                }
            }
        }

        return closestSum;
    }
}