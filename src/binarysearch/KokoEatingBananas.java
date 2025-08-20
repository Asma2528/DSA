// Problem: https://leetcode.com/problems/koko-eating-bananas
class Solution {
    public int calculate(int[] piles, int speed) {
        int totalHrs = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHrs += Math.ceil((double) piles[i] / speed);
        }
        return totalHrs;
    }

    public int maxElement(int[] piles) {
        int max = piles[0];

        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {
        // The largest number in the piles is the maximum number of bananas koko can eat per hour. In this way koko can finish bananas in less hours
        // We will start from the minimum integer 1 to the largest number in the array.
        // Eg: 3, 6, 7, 11
        // If k = 2 then [3 - 2 ,6 - 3, 7 - 4, 11 -6] thus total hrs is 2+3+4+6 = 15hrs
        // Brute force approach
        // TC - O(n) + O(maxElement) * O(n) 
        // SC - O(1)
        // int reqTime = 0;

        // for (int i = 1; i <= maxElement(piles); i++) {
        //     reqTime = calculate(piles, i);
        //     if (reqTime <= h) {
        //         return i;
        //     }
        // }

        // Optimal approach - Using binary search
        // TC - O(n) +  O(log maxElement) * O(n)
        // SC - O(1)
        int reqTime = 0;
        int low = 1;
        int high = maxElement(piles); // O(n)
        // int result = high;

        // O(log maxElement) 
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            reqTime = calculate(piles, mid); // O(n)
            if (reqTime <= h) {
                // result = Math.min(result,mid);
                high = mid - 1;
            } 
            else if (reqTime > h) {
                low = mid + 1;
            }
        }

        // return result;
        return low;
    }
}