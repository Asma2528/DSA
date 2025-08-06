// Problem: https://leetcode.com/problems/subarray-sum-equals-k
class Solution {
    public int subarraySum(int[] nums, int k) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        // int total = 0;
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i; j < nums.length; j++) {
        //         sum += nums[j];
        //         if (sum == k) {
        //             total++;
        //         }
        //     }
        //     sum = 0;
        // }
        // return total;

        // Optimal Approach
        // TC - O(n)
        // SC - O(n)
        int sum = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                total++;
            }

            int rem = sum - k;
            if (map.containsKey(rem)) {
                total += map.get(rem);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}