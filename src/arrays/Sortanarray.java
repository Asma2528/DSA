// Problem: https://leetcode.com/problems/sort-an-array
class Solution {
    // Merge sort
    // TC - O(n logn)
    // SC -O(n)

    public void merge(int[] nums,int low,int mid,int high){
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
    }

    public void divide(int[] nums,int low,int high){
        if(low>=high) return;

        int mid=(low+high)/2;
        divide(nums,low,mid);
        divide(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    public int[] sortArray(int[] nums) {
        divide(nums,0,nums.length-1);

        return nums;
    }
}