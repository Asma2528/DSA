// Problem: https://leetcode.com/problems/binary-subarrays-with-sum/
class Solution {
    public int countSubarrays(int[] nums,int goal){
        if(goal<0){ // Incase goal is -1 (if the goal is 0 in main function and we sent goal-1, so there is a chance that goal is -1)
            return 0;
        }
        int count = 0;
        int l = 0;
        int sum = 0;
        for (int r = 0; r < nums.length; r++){
            sum+=nums[r];

            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        /*
        Approach: Generate all subarrays
        */
        // int total = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int sum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         sum += nums[j];
        //         if (sum == goal) {
        //             total++;
        //         }

        //         if (sum > goal) {
        //             break;
        //         }
        //     }
        // }

        // return total;

        // Better approach (Using prefix sum concept)
        // TC - O(n)
        // SC - O(n)
        // int sum = 0;
        // int count = 0;
        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];

        //     if (sum == goal) {
        //         count++;
        //     }

        //     int rem = sum - goal;
        //     if (map.containsKey(rem)) {
        //         count += map.get(rem);
        //     }

        //     map.put(sum, map.getOrDefault(sum, 0) + 1);
        // }

        // return count;

        // Optimal approach
        // TC - O(2*2n) i.e nearly O(4n)
        // SC - O(1)
        /*
        We will create helper function which calculates total number of subarrays where sum<=goal and sum<=goal-1
        Then subtract its answer
        It will give us the total number of subarrays where sum=goal
        */
        int sum = 0;
        int count = countSubarrays(nums,goal);
        count -= countSubarrays(nums,goal-1);

        return count;
    }
}