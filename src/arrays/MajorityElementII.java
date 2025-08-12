// Problem: https://leetcode.com/problems/majority-element-ii
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1) - as there will always be 0 to 2 elements
        // int count = 0;
        // List<Integer> result = new ArrayList<>();

        // for (int i = 0; i < nums.length; i++) {
        //     count = 0;

        //     if (result.contains(nums[i])) {
        //         continue;
        //     }

        //     for (int j = 0; j < nums.length; j++) {
        //         if (nums[j] == nums[i]) {
        //             count++;
        //         }
        //     }

        //     if (count > nums.length / 3) {
        //         result.add(nums[i]);
        //     }

        //     if(count==2){
        //         break;
        //     }
        // }

        // return result;

        // Better approach
        // TC - O(n)
        // SC - O(n)
        // List<Integer> result = new ArrayList<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int n = nums.length;

        // for (int num : nums) {
        //     if (result.contains(num)) {
        //         continue;
        //     }

        //     map.put(num, map.getOrDefault(num, 0) + 1);

        //     if (map.get(num) > n / 3) {
        //         result.add(num);
        //     }

        //     if(result.size()==2){
        //         break;
        //     }
        // }

        // return result;

        // Optimal approach
        // TC - O(2n)
        // SC - O(1)
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = 0;
        int el2 = 0;
        List<Integer> result = new ArrayList<>();

        // O(n)
        for (int i = 0; i < nums.length; i++) {
            if (el1 == nums[i]) {
                cnt1++;
            } else if (el2 == nums[i]) {
                cnt2++;
            } else if (cnt1 == 0) {
                cnt1++;
                el1 = nums[i];
            } else if (cnt2 == 0) {
                cnt2++;
                el2 = nums[i];
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++;
            }
        }

        if (cnt1 > nums.length / 3) {
            result.add(el1);
        }

        if (cnt2 > nums.length / 3) {
            result.add(el2);
        }

        return result;
    }
}
