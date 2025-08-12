// Problem: https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Brute force approach
        // TC - O(n^3) 
        // SC - SC - O(n) (due to HashSet)
        // Set<List<Integer>> resultSet = new HashSet<>();

        // for (int i = 0; i < nums.length - 2; i++) {

        //     for (int j = i + 1; j < nums.length - 1; j++) {

        //         for (int k = j + 1; k < nums.length; k++) {

        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //             List<Integer> list = new ArrayList<>();
        //                 list.add(nums[i]);
        //                 list.add(nums[j]);
        //                 list.add(nums[k]);
        //                 Collections.sort(list);
        //                 resultSet.add(list);
        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(resultSet);

        // Better approach
        // TC - O(n^2) * (logm) size of hashset
        // SC - SC - O(n) + O(no of unique elements)*2 (due to HashSet)
        // Set<List<Integer>> resultSet = new HashSet<>();

        // for (int i = 0; i < nums.length; i++) {
        //     Set<Integer> set = new HashSet<>();
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int k = -(nums[i] + nums[j]);
        //         if (set.contains(k)) {
        //             List<Integer> list = new ArrayList<>();
        //             list.add(nums[i]);
        //             list.add(nums[j]);
        //             list.add(k);
        //             Collections.sort(list);
        //             resultSet.add(list);
        //         }
        //         set.add(nums[j]);
        //     }
        // }

        // return new ArrayList<>(resultSet);

        // Optimal approach
        // TC - O(nlogn) + O(n)
        // SC - O(no of unique elements) // for returning the answer
        List<List<Integer>> result = new ArrayList<>();
        // O(nlogn)
        Arrays.sort(nums);
        // O(n)
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                }
            }
        }

        return result;
    }
}