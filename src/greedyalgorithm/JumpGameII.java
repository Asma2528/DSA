// Problem: https://leetcode.com/problems/jump-game-ii/
class Solution {
    // Recursive function to count minimum jumps to reach index n-1
    public int countMinJumps(int[] nums, int idx, int jumps) {
        // If we reached or crossed the last index
        if (idx >= nums.length - 1) {
            return jumps;
        }

        int minJumps = Integer.MAX_VALUE;

        // Try all possible jumps from current index
        for (int step = 1; step <= nums[idx]; step++) {
            minJumps = Math.min(minJumps, countMinJumps(nums, idx + step, jumps + 1));
        }

        return minJumps;
    }

    public int jump(int[] nums) {
        // TC - O(n^n) (exponential)
// Because at each index you branch into up to nums[idx] recursive calls.
        // SC - O(n) // recursive stack space
        /*
        ** How the approach works **
        1. Recursive exploration from current index
        Start at idx = 0 with jumps = 0.
        At each index, look at nums[idx] — this tells you how far you can jump from here (1 to nums[idx] steps).
        2. Try all possible next jumps
        For every step from 1 to nums[idx], recursively call the function on idx + step and jumps + 1.
        This explores all possible paths you can take through the array.
        3. Base condition
        If idx >= last index, it means we reached (or crossed) the end — return the number of jumps taken so far.
        4. Find the minimum
        From all recursive paths, take the minimum jump count and return it
        */
        if (nums.length == 1) {
            return 0;
        }
        return countMinJumps(nums, 0, 0);
    }
}
