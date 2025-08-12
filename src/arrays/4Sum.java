// Problem: https://leetcode.com/problems/4sum
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Brute force approach
        // TC - O(n^4)
        // SC - O(no of unique quadruplets) //for returning answer
        // Set<List<Integer>> resultSet = new HashSet<>();

        // for (int i = 0; i < nums.length - 3; i++) {
        //     for (int j = i + 1; j < nums.length - 2; j++) {
        //         for (int k = j + 1; k < nums.length - 1; k++) {
        //             for (int l = k + 1; l < nums.length; l++) {
        //                 if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
        //                     List<Integer> list = new ArrayList<>();
        //                     list.add(nums[i]);
        //                     list.add(nums[j]);
        //                     list.add(nums[k]);
        //                     list.add(nums[l]);
        //                     Collections.sort(list);
        //                     resultSet.add(list);
        //                 }
        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(resultSet);

        // Better approach
        // TC - O(n^3) * O(log no f elements in set)
        // SC - O(n) + O(no of unique quadruplets) //for returning answer
        // Set<List<Integer>> resultSet = new HashSet<>();

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         Set<Long> set = new HashSet<>();
        //         for (int k = j + 1; k < nums.length; k++) {

        //             long sum = (long) nums[i] + nums[j] + nums[k];
        //             long fourth = (long) target - sum;

        //             if (set.contains(fourth)) {

        //                 // Skip if fourth doesn't fit in int range
        //                 if (fourth < Integer.MIN_VALUE || fourth > Integer.MAX_VALUE) {
        //                     continue;
        //                 }

        //                 List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
        //                 Collections.sort(list);
        //                 resultSet.add(list);
        //             }

        //             set.add((long) nums[k]);
        //         }
        //     }
        // }

        // return new ArrayList<>(resultSet);

        // Optimal approach - Two Pointers technique combined with Sorting
        // TC - O(n^3)
        // SC - O(no of quadruplets) //for returning the answer
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }

            }
        }

        return result;
    }
}