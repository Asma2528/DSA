// Problem: https://leetcode.com/problems/single-number-ii/
class Solution {
    public int singleNumber(int[] nums) {
        // Brute force appproach (using map)
        // TC - O(n) + O(m) where m is size of map whcih is (n/3 + 1)
        // SC - O(m) 
        // Map<Integer, Integer> map = new HashMap<>();
        // int result = -1;

        // for (int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() == 1) {
        //         result = entry.getKey();
        //         break;
        //     }
        // }

        // return result;

        // Better approach (using bit manipulation)
        // TC - O(32 * n)
        // SC - O(1)
        // int result = 0;

        // for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
        //     int cnt = 0; // Count no of 1's at bitIndex position
        //     for (int i = 0; i < nums.length; i++) {
        //         if ((nums[i] & (1 << bitIndex)) != 0) { // Check if bitIndex's position is set
        //             cnt++;
        //         }
        //     }
        //         if (cnt % 3 == 1) {
        //             result = result | (1 << bitIndex); // set bit for bitIndex position
        //         }
        // }

        // return result;

        // More Better approach (using sort)
        // TC - O(n log n) + O(n/3)
        // SC - O(1)
        // Arrays.sort(nums);

        // for(int i = 1; i< nums.length ; i+=3){
        //     if(nums[i-1]!=nums[i]){
        //         return nums[i-1];
        //     }
        // }

        // return nums[nums.length - 1];

        // Optimal approach (using buckets)
        // TC - O(n)
        // SC - O(1)
        int ones = 0;
        int twoes = 0;

        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & (~twoes);
            twoes = (twoes ^ nums[i]) & (~ones);
        }

        return ones;
    }
}