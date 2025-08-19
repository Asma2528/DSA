// Problem: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
class Solution {
    public int calculateSum(int[] nums, int d) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += Math.ceil((double) nums[i] / d);
        }

        return result;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        // Brute force approach
        // TC - O(n) + O(max) * O(n)
        // SC - O(1)
        // int max = nums[0];

        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] > max) {
        //         max = nums[i];
        //     }
        // }

        // int res = -1;

        // for(int i=1;i<=max;i++){
        //     int div = calculateSum(nums,i);
        //     if(div<=threshold){
        //         res = i; 
        //         break;
        //     }
        // }

        // return res;

        // Optimal approach
        // TC - O(n) + O(log max) * O(n)
        // SC - O(1)
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int low = 1, high = max;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int div = calculateSum(nums, mid);
            if (div <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
