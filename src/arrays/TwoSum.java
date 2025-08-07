class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[] { i, j };
        //         }
        //     }
        // }
        // return new int[] {};

        // Better approach
        // TC - O(n)
        // SC - O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};

        // Optimal approach (It will only work is array is sorted)
        // TC - O(n)
        // SC - O(1)
        // int left = 0;
        // int right = nums.length - 1;
        // int sum = 0;

        // while (left != right) {
        //     sum = nums[left] + nums[right];
        //     if (sum == target) {
        //         return new int[] { left, right };
        //     } else if (sum < target) {
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }

        // return new int[] {};
    }
}