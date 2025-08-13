// Problem: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
class Solution {
    public long subarrayXor(int nums[], int k) {
    //  Brute force approach
    // TC - O(n^2)
    // SC - O(1)
    // int xor=0;
    // int sum=0;
    
    // for(int i=0;i<nums.length;i++){
    //     xor=0;
    //     for(int j=i;j<nums.length;j++){
    //         xor=xor^nums[j];
    //         if(xor==k){
    //             sum++;
    //         }
    //     }
    // }
    // return sum;
    
    // Optimal Approach
    //  TC - O(n)
    //  SC - O(n)
    int xor=0;
    int count=0;
    Map<Integer,Integer> map=new HashMap<>();
    map.put(0, 1);
    
    for(int i=0;i<nums.length;i++){
        xor=xor^nums[i];
        int x=xor^k;
        if(map.containsKey(x)){
            count+=map.get(x);
        }
        map.put(xor, map.getOrDefault(xor, 0) + 1);

    }
    
    return count;
    
    }
}