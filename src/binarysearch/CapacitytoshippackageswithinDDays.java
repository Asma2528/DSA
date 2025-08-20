// Problem: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days
class Solution {
    // For such type of questions first you need to identify the range (min -> max)
    // Here the largest value in weights will be min. Reason: largest package needs to be loaded so that much capacity is atleast required.
    // The sum of all weights will be max. Reason: Sum of all weights will go in 1 day
    public Boolean isPossible(int[] weights, int weight, int days) {
        int currentWeight = 0;
        int requiredDays = 1; // Start with one day because you always need at least one day to ship all the packages.

        for (int i = 0; i < weights.length; i++) {
            if(currentWeight + weights[i] > weight){
                // If the current weight exceeds the capacity, we need a new day
                requiredDays++;
                currentWeight = weights[i];
            }
            else{
                // Otherwise, just add the package to the current day
                currentWeight +=weights[i];
            }
        }

        // Return true if we can ship all within the allowed number of days
        return requiredDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        // Brute force approach
        // TC - O(n) + O(sum - max + 1) * O(n)
        // SC - O(1)
        // int sum = 0;
        // int max = weights[0];

        // for (int i = 0; i < weights.length; i++) {
        //     sum += weights[i];
        //     if (max < weights[i]) {
        //         max = weights[i];
        //     }
        // }

        // int minWeight = sum;

        // for (int i = max; i <= sum; i++) {
        //     if (isPossible(weights, i, days)) {
        //         minWeight = i;
        //         break;
        //     }
        // }
        // return minWeight;

        // Optimal approach
        // TC - O(n) + O(log (sum - max + 1)) * O(n)
        // SC - O(1)
        int high = 0;
        int low= weights[0];

        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            if (low < weights[i]) {
                low = weights[i];
            }
        }

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (isPossible(weights,mid,days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}