// Problem: https://leetcode.com/problems/majority-element-ii
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(n) - for returning result
        // int count = 0;
        // List<Integer> result = new ArrayList<>();

        // for (int i = 0; i < nums.length; i++) {
        //     count = 0;

        //     if (result.contains(nums[i])) {
        //         continue;
        //     }

        //     for (int j = 0; j < nums.length; j++) {
        //         if (nums[j] == nums[i]) {
        //             count++;
        //         }
        //     }
        //     if (count > nums.length / 3) {
        //         result.add(nums[i]);
        //     }
        // }

        // return result;

        // Better approach
        // TC - O(n)
        // SC - O(n)
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            if (result.contains(num)) {
                continue;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > n / 3) {
                result.add(num);
            }
        }

        return result;
    }
}
