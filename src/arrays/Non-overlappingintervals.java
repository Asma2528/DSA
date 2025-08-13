// Problem: https://leetcode.com/problems/non-overlapping-intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Optimal approach
        // TC - O(nlogn) * O(n)
        // SC - O(1)
        int count = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                count++;
                if(end>intervals[i][1]){
                    end = intervals[i][1];
                }
            }
            else{
                end = intervals[i][1];
            }
        }
        return count;

    }
}
