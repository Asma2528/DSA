// Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        // for (int i = 0; i < numbers.length; i++) {
        //     for (int j = i + 1; j < numbers.length; j++) {
        //         if (numbers[i] + numbers[j] == target) {
        //             return new int[] { i + 1, j + 1 };
        //         }
        //     }
        // }
        // return new int[] {};

        // Better approach
        // TC - O(n)
        // SC - O(n)
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < numbers.length; i++) {
        //     int diff = target - numbers[i];
        //     if (map.containsKey(diff)) {
        //         return new int[] { map.get(diff) + 1, i + 1 };
        //     }

        //     map.put(numbers[i], i);
        // }

        // return new int[] {};

        // Optimal approach (It will only work is array is sorted)
        // TC - O(n)
        // SC - O(1)
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;

        while (left != right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }
}