// Problem: https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
class Solution {
    public int rowWithMax1s(int arr[][]) {
        // Brute force approach 
        // TC - O(m*n)
        // SC - O(1)
        // int max = -1;
        // int maxRow = -1;
        // for(int i=0;i<arr.length;i++){
        //     int count = 0;
        //     for(int j=0;j<arr[0].length;j++){
        //         count+=arr[i][j];
        //     }

        //     if(count>max){
        //         max = count;
        //         maxRow = i;
        //     }
        // }

        // return maxRow;
        
        // Better approach 
        // TC - O(m * log n)
        // SC - O(1)
        // int max = -1;
        // int maxRow = -1;
        // int m = arr.length;
        // int n = arr[0].length;
        
        // for(int i=0;i<m;i++){
        //     int count = 0;
        //     int low = 0;
        //     int high = n - 1;
        //     int first = Integer.MAX_VALUE;
            
        //     while(low<=high){
        //         int mid = low + ((high - low) / 2);
        //         if(arr[i][mid]==1){
        //             high = mid - 1;
        //             first = Math.min(first, mid); 
        //         }
        //         else{
        //             low = mid + 1;
        //         }
        //     }
            
        //     count = n - first;
            
        //     if(count>max){
        //         max = count;
        //         maxRow = i;
        //     }
        // }

        // return maxRow;
        
        // Optimal approach 
        // TC - O(m + n)
        // SC - O(1)
        int maxRow = -1;
        int maxOnes = 0;
        int m = arr.length;
        int n = arr[0].length;
        int i = 0; // row pointer
        int j = n - 1; // column pointer
    
        while (i < m && j >= 0) { // we are checking for ones from the last element of the row
            if (arr[i][j] == 1) {
                // We found a '1'. All elements to the left in this row are also '1's.
                // This row has at least (j+1) ones. The number of ones is (n - j).
                // We can update the answer and move left to find more ones in the same row.
                maxOnes = n - j;
                maxRow = i;
                j--;
            } else {
                // This is a '0'. The current row has no more '1's from this point on.
                // Move to the next row to find a '1'.
                i++;
            }
        }
        
        return maxRow;
        
    }
}