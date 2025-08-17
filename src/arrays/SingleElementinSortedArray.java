// Problem: https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Brute force - Approach - 1
        // TC - O(n)
        // SC - O(1)
        // int n = nums.length;

        // if (n == 1) {
        //     return nums[0];
        // }

        // for (int i = 0; i < n; i++) {
        //     if (i == 0) {
        //         if (nums[i] != nums[i + 1]) {
        //             return nums[i];
        //         }
        //     } 
        //     else if (i == n - 1) {
        //         if (nums[i] != nums[i - 1]) {
        //             return nums[i];
        //         }
        //     } else if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
        //         return nums[i];
        //     }
        // }

        // return -1;

        // Brute force - Approach - 2
        // TC - O(n)
        // SC - O(1)
        // int n = nums.length;
        // int xor = 0;

        // for(int num:nums){
        //     xor = xor ^ num;
        // }

        // return xor;

        // Optimal Approach
        // TC - O(log n)
        // SC - O(1)
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (nums[low] != nums[low + 1]) {
            return nums[low];
        }

        if (nums[high] != nums[high - 1]) {
            return nums[high] ;
        }

        low++;
        high--;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Before the single element occurs, the pairs are in (even, odd) form
            // After the element occurs, the pairs are in (odd,even) form
            // Eliminating left half
            if(mid%2==1 && (nums[mid]==nums[mid-1]) ||
            mid%2==0 && (nums[mid]==nums[mid+1]))
            //if mid is odd then will check the previous element with it which confirms that it is (even,odd) pair and will eliminate left half
             //if mid is even then will check the next element with it which confirms that it is (even,odd) pair and will eliminate left half
            {
                low = mid + 1;
            }
            // Eliminating right half 
            else{ 
                high = mid - 1;
            }
        }

        return -1;
    }
}