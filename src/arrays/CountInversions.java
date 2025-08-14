// Problem: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
class Solution {
    // Merge sort
    // TC - O(n logn)
    // SC -O(n)

    public int merge(int[] nums,int low,int mid,int high){
        int count = 0;
        int[] temp=new int[high-low+1];
        int ptr1=low;
        int ptr2=mid+1;
        int idx=0;

        while(ptr1<=mid && ptr2<=high){
            if(nums[ptr1]<=nums[ptr2]){
                temp[idx++]=nums[ptr1++];
            }
            else{
                temp[idx++]=nums[ptr2++];
                count += (mid - ptr1 + 1);
            }
        }

        while(ptr1<=mid){
            temp[idx++]=nums[ptr1++];
        }

        while(ptr2<=high){
            temp[idx++]=nums[ptr2++];
        }

        for(int i=0,j=low;i<temp.length;i++,j++){
            nums[j]=temp[i];
        }
        
        return count;
    }

     public int divide(int[] nums, int low, int high) {
        if (low >= high) return 0;

        int mid = (low + high) / 2;
        int count = 0;
        count += divide(nums, low, mid);
        count += divide(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        return count;
    }


    static int inversionCount(int arr[]) {
        // Brute force approach 
        // TC - O(n^2)
        // SC - O(1)
        // int count = 0;
        
        // for(int i=0;i<arr.length-1;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]>arr[j]){
        //             count++;
        //         }
        //     }
        // }
        
        // return count;
        
        // Optimal approach 
        // TC - O(nlogn)
        // SC - (n)
        // But the input array will be sorted. Incase we dont want that we can create a copy of the input array to solve it.
        
        // If you want to preserve the original array
        // int[] copy = Arrays.copyOf(arr, arr.length);
        // return new Solution().divide(copy, 0, copy.length - 1);

        // If you're okay with modifying the input
        return new Solution().divide(arr, 0, arr.length - 1);

    }
}