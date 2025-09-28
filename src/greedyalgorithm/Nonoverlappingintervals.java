// Problem: https://leetcode.com/problems/non-overlapping-intervals/
class Solution {
    // Similar to N meetings in one room
    public int eraseOverlapIntervals(int[][] intervals) {
        // Optimal approach
        // TC - O(nlogn) * O(n)
        // SC - O(1)

        // Sort interval based on the end
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[1], b[1])); // O(n log(n))
        int end = intervals[0][1];
        int count = 1;

        for(int i=1;i<intervals.length;i++){ // O(n)
            if(intervals[i][0]>=end){
                count++;
                end = intervals[i][1];
            }
        }

        return intervals.length-count;
    }
}