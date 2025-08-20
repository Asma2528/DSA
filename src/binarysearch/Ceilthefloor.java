// Problem: https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
    // Aprroach - 1 (more better if array is already sorted with TC - 2*O(log n))
    // TC - O(n log n) * O(log n) * O(log n)
    // SC - O(1)
    // Arrays.sort(arr);
    
    // //  Floor
    // int floor = -1;
    // int low = 0;
    // int high = arr.length - 1;
    // while(low<=high){
    //         int mid = low + ((high - low) / 2);
    //         if(arr[mid]<=x){
    //             floor = arr[mid];
    //             low = mid + 1;
    //         }
    //         else{
    //             high = mid - 1;

    //         }
    // }
    
    
    // //   Ceil
    // int ceil = -1;
    // low = 0;
    // high = arr.length - 1;
    // while(low<=high){
    //         int mid = low + ((high - low) / 2);
    //         if(arr[mid]>=x){
    //             ceil = arr[mid];
    //             high = mid - 1;
    //         }
    //         else{
    //             low = mid + 1;
    //         }
    //     }
    
    // return new int[] {floor,ceil};
    
    // Aprroach - 2
    // TC - O(n)
    // SC - O(1)
    int floor = -1, ceil = -1;
    
    for(int a:arr){
        if(a<=x && (floor == -1 || a > floor)){
            floor = a;
        }
        if(a>=x && (ceil == -1 || a < ceil)){
            ceil = a;
        }
    }
    
    return new int[] {floor,ceil};
        
    }
}
