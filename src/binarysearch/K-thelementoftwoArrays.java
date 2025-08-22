// Problem: https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
class Solution {
    /*
    consider the example: n1=4, n2=6, k=8
if we assume low=0 and high=n1
it means there is a possibility of taking 0 elements from n1 arr and 
remaining elements from n2 arr (which has only 6 elements but we need 
8 elements at left so its mandatory to consider atleast 2 elements 
from left arr)  so low = max(0, k-n2)
for high consider the scenario n1=4, n2=6, k=2 where need to have 
only 2 elements at left so should consider maximum 2 elements from n1 array
so high = min(k, n1)
*/

    public int kthElement(int a[], int b[], int k) {
        // Better Approach
        // TC - O(m +n)
        // SC - O(1)
        // int m = a.length;
        // int n = b.length;

        // int count = 0;
        // int idx1 = 0;
        // int idx2 = 0;
        // int kthEl = -1;
        
        // while(idx1<m && idx2 <n){
        //     int curr = -1;
        //     if(a[idx1]<=b[idx2]){
        //         curr = a[idx1++];
        //     }
        //     else{
        //         curr = b[idx2++];
        //     }
        //     count++;
            
        //     if(count == k){
        //         kthEl = curr;
        //         return kthEl;
        //     }
        // }
        
        // while(idx1<m){
        //     int curr = -1;
        //     curr = a[idx1++];
        //     count++;
            
        //     if(count == k){
        //         kthEl = curr;
        //         return kthEl;
        //     }
        // }
        
        // while(idx2<n){
        //     int curr = -1;
        //     curr = b[idx2++];
        //     count++;
            
        //     if(count == k){
        //         kthEl = curr;
        //         return kthEl;
        //     }
        // }
        
        // return 0;
        
        
        // Optimal Approach
        // TC - O(min(log m,log n))
        // SC - O(1)
        int m = a.length;
        int n = b.length;
        if(m>n){
            return kthElement(b,a,k);
        }
        
        int low = Math.max(0,k-n);
        int high = Math.min(m, k);
        int left = k;
        
        while(low<=high){
            int mid1 = low + ((high - low)/2);
            int mid2 = k - mid1;
            
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE; 
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE; 
            
            if(mid1<m){
                r1 = a[mid1];
            }
            
            if(mid2<n){
                r2 = b[mid2];
            }
            
            if(mid1 >0){
                l1 = a[mid1 - 1];
            }
            
            if(mid2 >0){
                l2 = b[mid2 - 1];
            }
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }
        
        return 0;
    }
}