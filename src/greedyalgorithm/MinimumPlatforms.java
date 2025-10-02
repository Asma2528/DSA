// Problem: https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        if(arr.length == 0){
            return 0;
        }
        // Brute force appproach
        // TC - O(n^2)
        // SC - O(1)
        // int maxPlat = 0;
        
        // // Loop through each train
        // for(int i = 0; i < arr.length; i++){
        //     int plat = 0; // Start with 1 platform for the current train
            
        //      // Compare with all subsequent trains
        //     for(int j = 0; j < arr.length; j++){
        //         // Check if train i and train j overlap
        
        //         if (arr[j] <= arr[i] && dep[j] >= arr[i]) {
        //             plat++; // If overlapping, we need another platform
        //         }
                
        //     }
        //         // Update the maximum platforms required
        //         maxPlat = Math.max(maxPlat, plat);
        // }
        
        // return maxPlat;
        
        
        // Optimal appproach
        // TC - O(2*(n log n)) + O(2n) \\ 2n because we are traversing to both arr and dep array
        // SC - O(1) 
        // We are distrauting the input array here. If its a problem then we can copy the elements
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n = arr.length;
        
        int platNeeded = 1, result = 1;
        int i = 1, j = 0;
        
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {  // another train needs a platform
                platNeeded++;
                i++;
            } else {                 // one train left, free platform
                platNeeded--;
                j++;
            }
            result = Math.max(result, platNeeded);
        }
        
        return result;

    }
}
