// Problem: https://leetcode.com/problems/find-the-peaks/
class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        // TC - O(n)
        // SC - O(n) // for returning the result
        List<Integer> result = new ArrayList<>();
        int n = mountain.length;

        for (int i = 1; i < n - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }

        return result;
    }
}