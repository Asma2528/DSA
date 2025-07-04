// Problem: https://leetcode.com/problems/permutations/
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> getPermutations(int[] nums, List<Integer> inner, List<List<Integer>> ans) {
        if (inner.size() == nums.length) {
            ans.add(new ArrayList<>(inner)); 
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (inner.contains(nums[i])) continue;

            inner.add(nums[i]);

            getPermutations(nums, inner, ans);

            inner.remove(inner.size() - 1);
        }

        return ans;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        return getPermutations(nums, inner, ans);
    }
}