// Problem: https://leetcode.com/problems/assign-cookies/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // TC - O(mlogm + nlogn) + O(min(m,n)) // where m: size of g, where n: size of s
        // SC - O(1)
        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0; // pointer to keep track of greed
        int right = 0; // pointer to keep track of cookies

        while(left<g.length && right<s.length){
            // System.out.println("Can "+g[left]+" greed satisfy "+ s[right] +" cookie");
            if(s[right]>=g[left]){
                left++;
            }
            right++;
        }
        return left;
    }
}