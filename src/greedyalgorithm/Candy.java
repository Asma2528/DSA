// Problem: https://leetcode.com/problems/candy/
class Solution {
    public int candy(int[] ratings) {
        // Brute force approach
        // TC - O(3n)
        // SC - O(2n)
        /*
        Idea: Each child must get more candy than a neighbor with a lower rating.
        1. Go left → right: give +1 candy if rating is higher than previous.
        2. Go right → left: give +1 candy if rating is higher than next.
        3. Take max from both sides for each child and add them up.
        */
        // int n = ratings.length;
        // int left[] = new int[n];
        // left[0] = 1;
        // for(int i=1;i<n;i++){
        //     if(ratings[i-1]<ratings[i]){
        //         left[i] = left[i-1]+1;
        //     }
        //     else{
        //         left[i] = 1;
        //     }
        // }

        // int right[] = new int[n];
        // right[n - 1] = 1;
        // for(int i=n-2;i>=0;i--){
        //     if(ratings[i+1]<ratings[i]){
        //         right[i] = right[i+1]+1;
        //     }
        //     else{
        //         right[i] = 1;
        //     }
        // }

        // int sum = 0;
        // for(int i=0;i<n;i++){
        //     sum+=Math.max(left[i],right[i]);
        // }

        // return sum;

        // Better approach
        // TC - O(2n)
        // SC - O(n)
        // int n = ratings.length;
        // int left[] = new int[n];
        // left[0] = 1;
        // for (int i = 1; i < n; i++) {
        //     if (ratings[i - 1] < ratings[i]) {
        //         left[i] = left[i - 1] + 1;
        //     } else {
        //         left[i] = 1;
        //     }
        // }

        // int sum = Math.max(left[n-1], 1);
        // int right = 1;
        // for (int i = n - 2; i >= 0; i--) {
        //     if (ratings[i + 1] < ratings[i]) {
        //         right = right + 1;
        //     }
        //     else{
        //         right = 1;
        //     }
        //     sum += Math.max(left[i], right);
        // }

        // return sum;

        // Optimal approach
        // TC - O(n)
        // SC - O(1)
        /*
        Optimal idea (slope-based):
        We move through ratings and look at them like "slopes":
        1. If equal → just give 1 candy.
        2. If strictly increasing → keep giving more candies (1,2,3…).
        - Track the highest candy count (peak).
        3. If strictly decreasing → keep giving more candies backward (1,2,3…).
        - But if the downhill is longer than the uphill peak,
            we must add extra candies to fix the peak child.
        4. Keep summing candies as we go.
        This way we handle all cases in one pass without extra arrays.


        (Simple words):
        Walk through ratings and think of them as slopes:
        - Flat (equal): give 1 candy.
        - Going up: give more and more candies (like climbing stairs).
        - Going down: give more candies again (1,2,3…),
        but check if the down slope is longer than the up slope.
        If yes → add extra candy to the peak so rules are not broken.
        Add everything to sum as you go → done in one pass!
        */

        int n = ratings.length;
        int sum = 1;
        int i = 1;

        while (i < n) {
            // equal ratings → reset
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }
        
            // handle increasing slope
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1 ]) {
                peak++;  
                sum += peak;
                i++;
            }

            // handle decreasing slope
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }

            // adjust if descending slope longer than peak
            if (down > peak) {
                sum += down - peak;
            }
        }

        return sum;
    }
}