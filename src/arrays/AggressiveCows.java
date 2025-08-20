// Problem: https://www.geeksforgeeks.org/problems/aggressive-cows/1
class Solution {
    public Boolean canWePlaceCows(int[] stalls, int dist ,int k){
        int countCows = 1; // First cow placed in the first stall
        int lastCow = stalls[0]; // Position of the last placed cow
        
        // Trying to place the rest of the cows
        for(int i = 1;i<stalls.length; i++){
            // If the distance between the current stall and the last placed cow is >= dist
            if((stalls[i] - lastCow) >= dist){
                countCows++;
                lastCow=stalls[i];
            }
             
            // If we have placed all cows, return true
            if(countCows>=k){
                return true;
            }
        }

        return false;  // If we couldn't place all k cows
    }
    
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Sort the stalls to make sure cows are placed in increasing order
        
        // Brute force approach
        // TC - O(n log n) + O(max) * O(n)
        // SC - O(1)
        // int max = stalls[stalls.length - 1] - stalls[0]; // Maximum distance between the first and last stall
        
        // for(int i=1;i<=max;i++){
        //     if(!canWePlaceCows(stalls,i,k)){
        //         return i-1;
        //     }
        // }
        
        // return max;
        
        // Optimal approach
        // TC - O(n log n) + O(log max) * O(n)
        // SC - O(1)
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum distance between the first and last stall
        int low = 1;
        
        while(low<=high){
            int mid = low + ((high - low)/2);
            if(canWePlaceCows(stalls,mid,k)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return high;

    }
}