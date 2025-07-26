// Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Approach - 1
        // Time Complexity: O(n1 + n2 + k)
        // Space Complexity: O(1) auxiliary + O(k) output
        //  where k = number of intersecting elements
        // int[] temp = new int[1001];

        // for (int n : nums1) {
        //     temp[n]++;
        // }

        // ArrayList<Integer> list = new ArrayList<>();
        // for (int n : nums2) {
        //     if (temp[n] > 0) {
        //         list.add(n);
        //         temp[n]--;
        //     }
        // }

        // int[] result = new int[list.size()];
        // for (int i = 0; i < result.length; i++) {
        //     result[i] = list.get(i);
        // }

        // return result;
        // Above approach has boxing overhead and Dynamic resizing, overhead

        // Approach - 2
        int[] temp = new int[1001];

        int[] max;
        int[] min;

        if (nums1.length < nums2.length) {
            max = nums2;
            min = nums1;
        } else {
            max = nums1;
            min = nums2;
        }

        for (int n : max) {
            temp[n]++;
        }

        int count = 0;
        int[] result = new int[min.length];
        for (int n : min) {
            if (temp[n] > 0) {
                result[count++] = n;
                temp[n]--;
            }
        }

        return Arrays.copyOf(result, count);
    }
}