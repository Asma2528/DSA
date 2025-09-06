// Problem: https://leetcode.com/problems/subarrays-with-k-different-integers/
class Solution {
    public int countSubarraysLessThanEqualToK(int[] nums, int k){
        int count = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count+=right+left+1;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // Brute force approach
        // TC - O(n^3)
        // SC - O(1)
        // int count = 0;
        // for(int i=0;i<nums.length;i++){
        //     Map<Integer,Integer> map = new HashMap<>();
        //     for(int j=i;j<nums.length;j++){
        //         map.put(nums[j],map.getOrDefault(nums[j],0)+1);

        //         if(map.size()==k){
        //             count++;
        //         }
        //     }
        // }

        // return count;

        // Optimal approach
        // TC - O(2n)
        // SC - O(1)
       
        return countSubarraysLessThanEqualToK(nums,k-1) - countSubarraysLessThanEqualToK(nums,k) ;
    }
}