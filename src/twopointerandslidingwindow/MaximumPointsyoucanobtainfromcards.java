// Problem: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // TC - O(2k)
        // SC - O(1)
        /* Approach: We will first calculate the sum of first k elements and set it to maxSum
        Then in the second loop we will remove 1 left element in each iteration and add 1 right element from the end
        We will set it in maxSum if it greater than current maxSum
        We will do this till all the left elements are removed (and thus all right elements are added)
        Left:- Elements from the start
        Right:- Elements from the end
        */

        int lsum = 0, rsum = 0, maxSum = 0;
        for (int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }

        maxSum = lsum;
        int ridx = cardPoints.length - 1;

        for(int i=k-1;i>=0;i--){  // If k is 4 then i will be 3 which is 3rd index in an array
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[ridx--];
            maxSum = Math.max(lsum+rsum,maxSum);
        }

        return maxSum;

    }
}