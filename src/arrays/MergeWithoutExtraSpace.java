// Problem: https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
class Solution {
    public void swap(int a[],int b[],int idx1,int idx2){
        if(a[idx1]>b[idx2]){
        int temp=a[idx1];
        a[idx1]=b[idx2];
        b[idx2]=temp;
        }
    }
    
    public void mergeArrays(int a[], int b[]) {
        // 1st Approach 
        // TC - O(min(n,m)) + O(nlogn) + O(mlogm)
        // SC - O(1)
        // int m = a.length;
        // int n = b.length;
        // int left = m - 1;
        // int right = 0;

        // while (left >= 0 && right < n) {
        //     if (a[left] > b[right]) {
        //         int temp = a[left];
        //         a[left] = b[right];
        //         b[right] = temp;
        //         left--;
        //         right++;
        //     } else {
        //         break;
        //     }
        // }

        // Arrays.sort(a);
        // Arrays.sort(b);

        // 2nd Approach 
        // TC - O(log(n+m)) + O(n+m)
        // SC - O(1)
        int n=a.length;
        int m=b.length;
        int gap=(n+m)/2 + (n+m)%2;
        
        while(gap>0){
            
            int left = 0;
            int right = left + gap;
            
            while(right<(n+m)){
                // when both left in in a and right is in b
                if(left < n && right >=n){
                    swap(a,b,left,right-n);
                }
                // when both left and right are in b
                else if(left >= n){
                    swap(b,b,left-n,right-n);
                }
                // when both left and right are in a
                else{
                    swap(a,a,left,right);
                }
                left++;
                right++;
            }
            
            if(gap==1){
                break;
            }
            
            gap=(gap/2) + (gap%2);
        }
  
    }
}
