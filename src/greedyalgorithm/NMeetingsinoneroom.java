// Problem: https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
import java.util.*;

class Meet {
    int start; // Start time of the meeting
    int end;   // End time of the meeting
    
    // Constructor to initialize a meeting with its start and end times
    public Meet(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    
    // Function to find the maximum number of non-overlapping meetings
    public int maxMeetings(int start[], int end[]) {
        // TC: O(2n + nlogn)
        // SC: O(n) for storing the meeting objects in an array

        int n = start.length; // Number of meetings
        if (n == 0) {         // If there are no meetings, return 0
            return 0;
        }

        Meet[] mt = new Meet[n]; // Array to store the meeting objects
        
        // Create meeting objects for each meeting and store them in the array
        int j = 0;
        for (int i = 0; i < n; i++) {
            Meet m = new Meet(start[i], end[i]); // Create a new meeting object
            mt[j++] = m; // Store it in the array
        }

        // Sort the meetings based on their end time (ascending order)
        Arrays.sort(mt, new Comparator<Meet>() {
            @Override
            public int compare(Meet m1, Meet m2) {
                return Integer.compare(m1.end, m2.end); // Compare by end time
            }
        });

        int lastEnd = mt[0].end; // Track the end time of the last meeting that was included
        int countMax = 1;         // Count the first meeting as it will always be included
        
        // Iterate through the sorted meetings and count the non-overlapping ones
        for (int i = 1; i < n; i++) {
            // If the start time of the current meeting is greater than the last selected meeting's end time
            if (mt[i].start > lastEnd) {
                countMax++;           // We can include this meeting
                lastEnd = mt[i].end; // Update the end time to the current meeting's end time
            }
        }

        return countMax; // Return the maximum number of meetings that can be attended
    }
}
