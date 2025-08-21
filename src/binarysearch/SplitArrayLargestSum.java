// Problem: https://leetcode.com/problems/split-array-largest-sum/
class Solution {
    // This problem is same as book allocation
    // when at starting low stands at a possible value and high stands at not possible value then once BS completed low will ends up in a not possible value and high will ends up in a possible value in this case high will store the ans. Similarly, if low (at starting) -> not possible value and high (at starting) -> possible value then once BS completed low will be storing the answer.


    public int noOfSubarrays(int[] nums, int k) {
        int subarrays = 1; // at least one subarray will exist
        int prev = 0;   // current subarray sum
        for (int i = 0; i < nums.length; i++) {
            if (prev + nums[i] <= k) {  // If adding nums[i] doesn't exceed k, add it to current subarray
                prev += nums[i];
            } else {
                subarrays++;  // Otherwise, start a new subarray
                prev = nums[i];
            }
        }

        return subarrays;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n < k){
            return -1; // impossible to split into more parts than no of elements
        }
        
        int sum = nums[0], max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }   
            sum+=nums[i];
        }
        
        // Brute force approach
        // TC - O(n) +  O(sum - max + 1) * O(n)
        // SC - O(1)
        // Idea: Try every possible "largest subarray sum" from max → sum
        // If it's possible to split into <= k subarrays, return that value

        // for(int i=max;i<=sum;i++){
        //     if(noOfSubarrays(nums, i)<=k){
        //         return i;
        //     }
        // }
        
        // return sum;

        // Optimal approach
        // TC - O(n) +  O(log (sum - max + 1)) * O(n)
        // SC - O(1)
        // The answer lies between:
        //   low = max element (at least one subarray must hold the largest element)
        //   high = sum of array (worst case: all elements in one subarray)
        //
        // Example: nums = [7,2,5,10,8], k = 2
        // low = 10, high = 32
        // mid = 21 → can split into 2 subarrays (valid)
        // mid = 15 → requires 3 subarrays (too many)
        // Binary search keeps narrowing range to find minimum largest sum

        int high = sum;
        int low = max;

        while(low<=high){
            int mid = low + ((high - low)/2);
            int subarrays = noOfSubarrays(nums, mid);
            if(subarrays<=k){
                // If we can split into k or fewer subarrays,
                // try smaller "largest sum" (move left)
                high = mid - 1;
            }
            else{
                // If more than k subarrays are needed,
                // increase allowed sum (move right)
                low = mid + 1;
            }
        }

        // After binary search ends, low will be the
        // minimum possible largest subarray sum
        return low;
    }
}