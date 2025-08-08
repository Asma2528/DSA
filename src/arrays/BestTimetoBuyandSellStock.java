// Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
class Solution {
    public int maxProfit(int[] prices) {
        // TC - O(n)
        // SC - O(1)
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(price, minPrice);
        }
        return maxProfit;
    }
}