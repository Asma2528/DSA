// Problem: https://leetcode.com/problems/kth-missing-positive-number/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Brute force approach
        // TC - O(n)
        // SC - O(1)
        // Eg: [2,3,4,7,11] k = 5
        // Will increment k by 1 whenever we encounter an element in array smaller than k as each element will take the place in the missing numbers range
        // 2 will have its own place. Thus k++ (6). Similarly 3, 4, 7 have its own place k = k + 3 = (9)
        // There 9 is kth positive integer that is missing from this array.

        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] <= k) {
        //         k++;
        //     } else {
        //         break;
        //     }
        // }
        // return k;

        // Optimal Approach
        // [2,3,4,7,11] k = 5
        // We can find missing number in a particular position as arr[mid] - (mid + 1)
        // TC - O(log n)
        // SC - O(1)
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int missingNumbers = arr[mid] - (mid + 1); //mid + 1 is the actual number that should be there. Eg: arr[3] = 7 then 7 - (3+1) = 3. 3 numbers are missing as on 3rd index
            if(missingNumbers<k){ // we are looking for 5 so any number smaller than 5 and numbers before that will be eliminated
                low = mid + 1; // we need more missing numbers
            }
            else{ // Numbes greater than 5 will be eliminated.
                high = mid - 1; // too many missing, go left
            }
        }

        // Answer will be arr[high] + how many more we need to reach k
        // missing = arr[high] - (high + 1)
        // more = k - missing
        // kth positive missing integer = arr[high] + more
        // arr[high] + (k - missing)
        // arr[high] + (k - (arr[high] - (high + 1)))
        // arr[high] + k - arr[high] + high + 1
        // high + 1 + k;

        return high + 1 + k;
        // return low; //this is also right

        // Explanation of optimal approach
        // Key Idea:
        // - For index mid, missing numbers till that point = arr[mid] - (mid + 1)
        // - If missing < k, move right (low = mid + 1)
        // - If missing >= k, move left (high = mid - 1)
        //
        // Example: arr = [2,3,4,7,11], k = 5
        // mid=2 → arr[2]=4 → missing=1 → <k → move right
        // mid=3 → arr[3]=7 → missing=3 → <k → move right
        // mid=4 → arr[4]=11 → missing=6 → >=k → move left
        // low=4, high=3 → exit loop
        // Answer = high + 1 + k = 3+1+5=9
    }
}