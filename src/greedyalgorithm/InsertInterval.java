// Problem: https://leetcode.com/problems/insert-interval/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // TC - O(2n)
        // SC - O(n) where n is the     length of intervals array + new interval

        /*
        Approach:
        1. We will divide the problem into three sections:
            - Left: Intervals that end before the new interval starts.
            - Middle: The intervals that overlap with the new interval.
            - Right: Intervals that start after the new interval ends.
        
        2. We first add all intervals from the "Left" part to the result.
        3. We merge the overlapping intervals in the "Middle" with the new interval.
        4. Finally, we add all intervals from the "Right" part to the result.
        
        5. The result array will contain all intervals, including the merged `newInterval`.
        */

        int i = 0;
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;

         // Step 1: Add all intervals that end before the new interval starts
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i++]);
        }

        // Step 2: Merge all intervals that overlap with the new interval
        while(i < n && intervals[i][0] <= newInterval[1]){
            // Update the start and end of the newInterval to merge overlapping intervals
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged newInterval to the result
        result.add(newInterval);

        // Step 3: Add all intervals that start after the new interval ends
        while(i < n){
            result.add(intervals[i++]);
        }

        // Convert the List to an array and return it
        return result.toArray(new int[result.size()][]); // O(n)
    }
}