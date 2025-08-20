// Problem: https://leetcode.com/problems/magnetic-force-between-two-balls/
class Solution {
     public Boolean canWePlaceBalls(int[] position, int dist ,int m){
        int countBalls = 1; // First ball placed in the first position
        int lastBall = position[0]; // Position of the last placed ball
        
        // Trying to place the rest of the balls
        for(int i = 1;i<position.length; i++){
            // If the distance between the current position and the last placed ball is >= dist
            if((position[i] - lastBall) >= dist){
                countBalls++;
                lastBall=position[i];
            }
             
            // If we have placed all balls, return true
            if(countBalls>=m){
                return true;
            }
        }

        return false;  // If we couldn't place all m balls
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position); // Sort the position to make sure balls are placed in increasing order
        
        // Brute force approach
        // TC - O(n log n) + O(max) * O(n)
        // SC - O(1)
        // int max = position[position.length - 1] - position[0]; // Maximum distance between the first and last position
        
        // for(int i=1;i<=max;i++){
        //     if(!canWePlaceBalls(position,i,m)){
        //         return i-1;
        //     }
        // }
        
        // return max;
        
        // Optimal approach
        // TC - O(n log n) + O(log max) * O(n)
        // SC - O(1)
        int high = position[position.length - 1] - position[0]; // Maximum distance between the first and last stall
        int low = 1;
        
        while(low<=high){
            int mid = low + ((high - low)/2);
            if(canWePlaceBalls(position,mid,m)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high;      
    }
}