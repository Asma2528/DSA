// Problem: https://leetcode.com/problems/merge-intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0]; // If intervals is empty, return an empty array.
        }

        // Brute force approach
        // TC - O(nlogn) * O(2n)
        // SC - O(n)
        // int[][] result = new int[intervals.length][2];
        // int prev = -1;

        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // for (int i = 0; i < intervals.length; i++) {
        //     int start = intervals[i][0];
        //     int end = intervals[i][1];

        //     if (prev != -1 && end <= result[prev][1])
        //         continue;

        //     for (int j = i + 1; j < intervals.length; j++) {
        //         if (end >= intervals[j][0]) {
        //             end = Math.max(end, intervals[j][1]);
        //         } else {
        //             break;
        //         }
        //     }
        //     prev++;
        //     result[prev] = new int[] { start, end };
        // }

        // return Arrays.copyOf(result, prev + 1);

        // Optimal approach
        // TC - O(nlogn) * O(n)
        // SC - O(n)
        int[][] result = new int[intervals.length][2];
        int prev = -1;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (prev == -1 || intervals[i][0] > result[prev][1]) {
                prev++;
                result[prev] = new int[] { intervals[i][0], intervals[i][1] };
            } else{
                if(result[prev][1]<intervals[i][1]){
                    result[prev][1] = intervals[i][1];
                }
            }

        }
        return Arrays.copyOf(result, prev+1);

    }
}