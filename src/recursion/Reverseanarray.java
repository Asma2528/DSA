// Problem: https://www.geeksforgeeks.org/problems/reverse-an-array/1
class Solution {
    public void reverse(int arr[], int i, int j){
        if(i>=j){
            return;
        }
        
        // swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        reverse(arr, i+1, j-1);
    }
    
    public void reverseArray(int arr[]) {
        // Using recursion
        // TC - O(n)
        // SC - O(n) recursive stack space
        reverse(arr,0,arr.length-1);
        
    }
}