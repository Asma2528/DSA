// Problem: https://www.geeksforgeeks.org/problems/rotation4723/1
class Solution {
    public int findKRotation(int nums[]) {
        // Brute force approach
        // TC - O(n)
        // SC - O(1)
        // int n = nums.length;
        // int count = 0;
        
        // for(int i=0;i<n;i++){
        //     if(i!=n-1){
        //         if(nums[i]>nums[i+1]){
        //             return i + 1;
        //         }
        //     }
        // }
        
        // return 0;
        
        // Optimal approach
        // TC - O(log n), Worst case where all elements are same O(n)
        // SC - O(1)
        int low = 0;
        int high = nums.length - 1;
        int result = Integer.MAX_VALUE;
        int idx = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // If duplicates are blocking, shrink boundaries
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                if(result>nums[mid]){
                    idx = mid;
                    result = nums[mid];
                }
                if(low < high){
                    low = low + 1;
                    high = high - 1;
                    continue;
                }
            }

            if (nums[low] <= nums[mid]) {
                if(result>nums[low]){
                    idx = low;
                    result = nums[low];
                }
                low = mid + 1;
            } else {
                if(result>nums[mid]){
                    idx = mid;
                    result = nums[mid];
                }
                high = mid - 1;
            }
        }

        return idx;
}

}