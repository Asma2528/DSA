// Problem: https://leetcode.com/problems/single-number-iii/
class Solution {
    public int[] singleNumber(int[] nums) {
        // Brute force approach
        // TC - O(n) + O(m)
        // SC - O(m) - size of map which is (n/2) + 2
        // Map<Integer,Integer> map = new HashMap<>();
        // int[] result = new int[2];
        // int idx = 0;

        // for(int i = 0;i< nums.length; i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // } 

        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     if(entry.getValue()==1){
        //         result[idx++] = entry.getKey();
        //     }
        // }

        // return result;

        // Optimal approach
        // TC - O(n)
        // SC - O(1)
        int[] result = new int[2];
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            // All duplicate numbers cancel out, leaving: xor = unique1 ^ unique2
            xor = xor ^ nums[i];
        }

        // Extract the rightmost set bit - This isolates one bit where the two unique numbers differ.
        // xor & (xor - 1) removes the rightmost set bit
        // XORing it back gives only that bit
        xor = (xor & (xor - 1)) ^ xor;

        // Split numbers into two groups
        int b1 = 0;
        int b2 = 0;

        for (int i = 0; i < nums.length; i++) {
        // The two unique numbers differ at this bit
        // They go into different groups
        // Duplicate numbers still cancel out inside each group
            if ((nums[i] & xor) != 0) {
                b1 = b1 ^ nums[i];
            } else {
                b2 = b2 ^ nums[i];
            }
        }

        result[0] = b1;
        result[1] = b2;

        return result;
    }
}