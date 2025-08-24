// Problem: https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
class Solution {
   public int findCountOfElementInRow(int[] row, int n, int element){
        int low = 0;
        int high = n - 1;

        while(low<=high){
            int mid = low + ((high - low) / 2);
            if(row[mid] <= element){
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        } 
        
        return low; // low will be the count of elements <= 'element'
    }
    
    public int findCountOfElements(int[][] mat,int m,int n,int element){
        int count = 0;
        for(int i=0;i<m;i++){
            count+= findCountOfElementInRow(mat[i], n, element);
        }
        return count;
    }
    
    public int median(int[][] mat) {
        // Though process:
        // If we have 5X3 matrix with 15 number of elements - median will be at 8th position
        // We will be storing the numbers lesser than equal to 
        // find out the first occurrence where it is greater than 7 
        // and this is this place where the median is

        
        // Brute force approach
        // TC - O(mXn) + O(mXn log(mXn))
        // SC - O(mXn)
        // int m = mat.length;
        // int n = mat[0].length;
        // int k = 0;
        // int[] arr = new int[m*n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         arr[k++] = mat[i][j];
        //     }
        // }
        
        // Arrays.sort(arr);
        // return arr[ (m*n) / 2];
        
        // Optimal approach
        // TC - O(m) + O(log (2000) * n * log m)
        // SC - O()
        int m = mat.length;
        int n = mat[0].length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<m; i++){
            min = Math.min(min, mat[i][0]);
            max = Math.max(max, mat[i][n-1]);
        }
        
        int low = min;
        int high = max;
        int required = m*n/2;
        
        while(low<=high){
            int mid = low + ((high - low) / 2);
            int noOfElements = findCountOfElements(mat, m, n, mid);
            
            if(noOfElements<=required){
                low = mid + 1;
            }

            else{
                high = mid - 1;
            }
        }
        
        return low;
    }
}