// Problem: https://leetcode.com/problems/intersection-of-two-arrays
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Brute force approach
        // Time Complexity: O(n + m) where n is the length of nums1, m is the     length of nums2
        // Space Complexity: O(n + m) for the sets
        // HashSet<Integer> temp = new HashSet<>();
        // HashSet<Integer> result = new HashSet<>();

        // for (int n : nums1) {
        //     temp.add(n);
        // }

        // for (int i = 0; i < nums2.length; i++) {
        //     if (temp.contains(nums2[i])) {
        //         result.add(nums2[i]);
        //     }
        // }

        // int k = 0;
        // int[] res = new int[result.size()];
        // for (int n : result) {
        //     res[k++] = n;
        // }

        // return res;

        // Optimal force approach
        // Time Complexity: O(n + m)
        // Space Complexity: O(k) where k = number of unique intersecting elements
        int[] temp=new int[1001];
        for(int n:nums1){
            temp[n]=1;
        }

        int count=0;
        for(int n:nums2){
            if(temp[n]==1){
                temp[n]=2;
                count++;
            }
        }

        int[] result=new int[count];
        int i=0;
        for(int n:nums1){
            if(temp[n]==2){
                result[i++]=n;
                temp[n]=0;
            }
        }

        return result;
        
        // Since temp is a constant-sized array (bounded by the problem: 0 <= nums[i] <= 1000), this is considered constant auxiliary space.
        // Constant Auxiliary Space (also referred to as O(1) auxiliary space) refers to a space complexity in which the amount of extra memory used by an algorithm does not depend on the size of the input. In simpler terms, it means that the algorithm uses a fixed amount of extra space regardless of how large the input is.

    }

}