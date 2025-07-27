// Problem: https://leetcode.com/problems/missing-number/
class Solution {
    public int missingNumber(int[] nums) {
        // Brute force approach
        // TC- O(2n)
        // SC - O(n)
        // HashSet<Integer> set = new HashSet<>(nums.length);

        // for (int n : nums) {
        //     set.add(n);
        // }

        // int missingNumber = -1;
        // for (int i = 0; i <= nums.length; i++) {
        //     if (!set.contains(i)) {
        //         missingNumber = i;
        //         break;
        //     }
        // }

        // return missingNumber;

        // Better approach
        // TC- O(n)
        // SC - O(1)
        // int n=nums.length;
        // int sum=n*(n+1)/2;
        // int actualSum=0;
        // for(int nm:nums){
        //     actualSum+=nm;
        // }

        // return sum-actualSum;   
        //  above approach can take slight more space due to sum calculataion

        // Optimal approach
        // TC- O(n)
        // SC - O(1)
        int xor1=0, xor2 = 0;
        for (int i = 1; i <= nums.length; i++) {
            xor1 = xor1 ^ i;
            xor2 = xor2 ^ nums[i-1];
        }
        return xor1 ^ xor2;
    }
}