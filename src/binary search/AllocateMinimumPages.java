// Problem: https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
class Solution {
    public int calculateStudents(int[] arr,int p){
        int student = 1; 
        int pages = 0;
        for(int i=0;i<arr.length;i++){
            if(pages + arr[i]<=p){
                pages+= arr[i];
            }
            else{
                student++;
                pages= arr[i];
            }
        }
        
        return student;
    }
    
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if(n < k){
            return -1;
        }
        
        int sum = arr[0], max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }   
            sum+=arr[i];
        }
        
        // Brute force approach
        // TC - O(n) +  O(sum - max + 1) * O(n)
        // SC - O(1)
        
        // for(int i=max;i<=sum;i++){
        //     int noOfStudents = calculateStudents(arr,i);
        //     if(noOfStudents <= k){
        //         return i;
        //     }
        // }
        
        // return sum;
        
        // Optimal approach
        // TC - O(n) +  O(log (sum - max + 1)) * O(n)
        // SC - O(1)
        int high = sum;
        int low = max;

        while(low<=high){
            int mid = low + ((high - low)/2);
            int noOfStudents = calculateStudents(arr,mid);
            if(noOfStudents>k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;

    }
}