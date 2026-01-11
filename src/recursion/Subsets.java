// Problem: https://leetcode.com/problems/subsets/
class Solution {
    private void printSubsets(int[] nums, int idx, List<Integer> subset,List<List<Integer>> result)
    {
        if(idx==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        printSubsets(nums, idx+1, subset, result);
        subset.remove(subset.size()-1);
        printSubsets(nums, idx+1, subset, result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        // // TC - O(2^n * n)
        // // SC - O(2^n * n) // approimately
        // List<List<Integer>> result = new ArrayList<>();
        // int n = nums.length;

        // // Calculate the total number of subsets: 2^n
        // // We have 2^n subsets for a set of size n
        // int noOfSubsets = 1 << n; // equal to 2^n

        // // Loop through all possible subsets (from 0 to 2^n - 1)
        // for (int num = 0; num < noOfSubsets; num++) {
        //     // A list to store the current subset
        //     List<Integer> subset = new ArrayList<>();

        //     // Loop through each element in the input array
        //     for (int j = 0; j < n; j++) {
        //         // Check if the j-th bit of num is set (1), meaning nums[j] is part of the subset
        //         if ((num & (1 << j)) != 0) {
        //             subset.add(nums[j]); // Include nums[j] in the current subset
        //         }
        //     }
        //     result.add(subset);
        // }

        // return result;

        // Using recursion
        // TC - O((2^n) * n)
        // SC 
        // Auxiliary Space:- O(n) [recursion stack space as the depth can be maximum 3 if nums.length = 3]
        //  Total Space (including output): O(2ⁿ × n)

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        printSubsets(nums, 0, subset, result);
        return result;
    }
}
	end