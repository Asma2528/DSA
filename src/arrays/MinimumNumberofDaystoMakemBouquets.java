// Problem: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
class Solution {
    public Boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int dayCount = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                dayCount += count / k;
                count = 0;
            }
        }

        dayCount += count / k;
        System.out.println(dayCount);

        if (dayCount >= m) {
            return true;
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long) m * k) { // If flowers in bloomDay are less than no of flowers required to make bouquets then its impossible to make m bouquets.
            return -1;
        }

        // Brute force approach
        // TC - O(n) + O((max - min + 1) * n)
        // SC - O(1)
        // int min = bloomDay[0], max = bloomDay[0];

        // for (int i = 1; i < n; i++) {
        //     if (bloomDay[i] > max) {
        //         max = bloomDay[i];
        //     }
        //     if (bloomDay[i] < min) {
        //         min = bloomDay[i];
        //     }
        // }

        // for (int i = min; i <= max; i++) {
        //     if (isPossible(bloomDay, i, m, k)) {
        //         return i;
        //     }
        // }

        // return -1;

        // Optimal Approach - Using binary search
        // TC - O(n) + O((log(max - min + 1)) * n)
        // SC - O(1)
        int min = bloomDay[0], max = bloomDay[0];

        for (int i = 1; i < n; i++) {
            if (bloomDay[i] > max) {
                max = bloomDay[i];
            }
            if (bloomDay[i] < min) {
                min = bloomDay[i];
            }
        }

        int low = min, high = max;
        // int result = max;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (isPossible(bloomDay, mid, m, k)) {
                // result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // return result;
        return low;
    }
}