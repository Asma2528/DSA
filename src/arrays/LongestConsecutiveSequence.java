// Problem: https://leetcode.com/problems/longest-consecutive-sequence
class Solution {
    public Boolean search(int[] arr, int target) {
        for (int n : arr) {
            if (n == target)
                return true;
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        // int longest = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     int temp = nums[i];
        //     int count = 1;

        //     while (search(nums, temp + 1)) {
        //         temp = temp + 1;
        //         count++;
        //     }
        //     longest = Math.max(longest, count);
        // }

        // return longest;

        // Better approach
        // TC - O(n log n) * O(n)
        // SC - O(1)
        // int longest = 1;
        // Arrays.sort(nums);
        // int count = 1;

        // for (int i = 0; i < nums.length - 1; i++) {
        //     int last = nums[i];
        //     if (last + 1 == nums[i + 1]) {
        //         last = nums[i + 1];
        //         count++;
        //     } else if (nums[i] != nums[i + 1]) {
        //         count = 1;
        //     }
        //     longest = Math.max(longest, count);
        // }

        // return longest;

        // Optimal approach
        // TC - O(3n)
        // SC - O(n)
        int longest = 1;

        Set<Integer> set = new HashSet<>();
        // O(n)
        for (int n : nums) {
            set.add(n);
        }

        // O(n)
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int num = n;
                int count = 1;
                // O(n)
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                if (count > longest) longest = count;
            }
        }

        return longest;
    }
}