// Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Brute force approach
        // TC - O(m + n)
        // SC - O(m + n)
        // int m = nums1.length;
        // int n = nums2.length;
        // int p = m + n;
        // int[] nums3 = new int[p];
        // int idx1 = 0, idx2 = 0, idx3 = 0;

        // while (idx1 < m && idx2 < n) {
        //     if (nums1[idx1] <= nums2[idx2]) {
        //         nums3[idx3++] = nums1[idx1++];
        //     } else {
        //         nums3[idx3++] = nums2[idx2++];
        //     }
        // }

        // while (idx1 < m) {
        //     nums3[idx3++] = nums1[idx1++];
        // }

        // while (idx2 < n) {
        //     nums3[idx3++] = nums2[idx2++];
        // }

        // if (p % 2 == 0) {
        //     return (double) (nums3[p / 2] + nums3[(p / 2) - 1]) / 2;
        // }

        // return (double) nums3[p / 2];

        // Better approach
        // TC - O(m + n)
        // SC - O(1)
        // int m = nums1.length;
        // int n = nums2.length;
        // int idx1 = 0, idx2 = 0, idx3 = -1;
        // int i1 = (m + n - 1) / 2; // left median index
        // int i2 = (m + n) / 2; // right median index
        // int el1 = -1, el2 = -1;

        // while (idx1 < m && idx2 < n) {
        //     int current;
        //     if (nums1[idx1] <= nums2[idx2]) {
        //         current = nums1[idx1++];
        //     } else {
        //         current = nums2[idx2++];
        //     }
        //     idx3++;
        //     if (idx3 == i1)
        //         el1 = current;
        //     if (idx3 == i2) {
        //         el2 = current;
        //         break;
        //     }
        // }

        // while (idx1 < m && el2 == -1) {
        //     int current;
        //     current = nums1[idx1++];
        //     idx3++;
        //     if (idx3 == i1)
        //         el1 = current;
        //     if (idx3 == i2) {
        //         el2 = current;
        //         break;
        //     }
        // }

        // while (idx2 < n && el2 == -1) {
        //     int current;
        //     current = nums2[idx2++];
        //     idx3++;
        //     if (idx3 == i1)
        //         el1 = current;
        //     if (idx3 == i2) {
        //         el2 = current;
        //         break;
        //     }
        // }

        // if ((m + n) % 2 == 0) {
        //     return (double) (el1 + el2) / 2;
        // }

        // return (double) el2;

        // Optimal Approach - Using Binary Search
        // TC - O(min(logm, log n))
        // SC - O(1)
        // Idea:
        // 1. Binary search will be on the basis of symmetry where we determine how many from array 1 will be on the left how many from array 2 will be on the right.
        // 2. To determine if it's a valid or an invalid symmetry we just compare if the entire left is smaller than the entire right.
        // Eg: a1 = {1, 3, 4, 7, 10, 12}
        // a2 = {2, 3, 6, 15}
        // Valid Symmetry - 4 is smaller than 6, 3 is smaller than 7
        // left - 3 elements from a1 and 2 elements from a2, right - remaining elements
        // left - {1, 2, 4}   right - {7, 10, 12}
        //        {2, 3}              {6, 15}

        // Invalid Symmetry - 2 is smaller than 15,but 6 is greater than 4
        // left - 2 elements from a1 and 3 elements from a2, right - remaining elements
        // left - {1, 2}   right - {4, 7, 10, 12}
        //        {2, 3, 6}              {15}

        // 2. Median will the greatest of all on the left and smallest of all on the right and we added them and divided by 2
        // From our example, 4 + 6 = 10 / 2 = 5
        // Median: 5

        // Formula for median - [max(l1, l2) + min(r1, r2)] / 2
        // where l1 is the leftmost element from a1, l2 is the leftmost element from a2, r1 is the rightmost element from a1, r2 is the rightmost element from a2.
        // From our example, l1 - 4, l2 - 3, r1 - 7, r2 - 6

        // How to use binary search
        // Range - minarray[0] to minarray[n-1] (In ourcase a2 is minarray)
        // How to eliminate left or right: 
        // if l1 > r2 -> high = mid - 1
        // if l2 > r1 -> low = mid + 1

        // l1 - a1[mid1 -1], l2 - a2[mid2 - 1]
        // r1 - a1[mid1], r2 - a2[mid2]
        // If on left there is no element take INT MIN, on right if there is no element take INT MAX

        // For m+n even length - will divide elements into left and right in equal parts
        // For m+n odd length - will divide elements into left and right as left will have 1 more element than right.
        // left = (m + n + 1) / 2 {this will work for even length as well}
        // Here median will be max(l1, l2)

        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // Ensure nums1 is always the smaller array
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;
        // Total elements on the left side of the partition
        int left = (m + n + 1) / 2;  


        while (low <= high) {
            // mid1 = partition in nums1, mid2 = partition in nums2
            int mid1 = low + ((high - low) / 2);
            int mid2 = left - mid1; 

            // l1, l2 = left boundary values
            // r1, r2 = right boundary values
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE; // When the range starts from 0
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE; // When the range gets beyond array size

            if (mid1 < m) 
                r1 = nums1[mid1];
            if (mid2 < n)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

             // Check if partition is valid
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 1) { 
                    // Odd total length → median is max of left
                    return (double) Math.max(l1, l2);
                } else {  
            // Even total length → median is average of max(left) & min(right)
                    return (double) ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
                }
            } else if (l1 > r2) {
                high = mid1 - 1; // too many elements taken from nums1
            } else {
                low = mid1 + 1; // too few elements taken from nums1
            }

        }

        return 0; // Should never reach here
    }
}