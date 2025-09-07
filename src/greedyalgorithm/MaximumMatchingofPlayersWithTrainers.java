// Problem: https://leetcode.com/problems/maximum-matching-of-players-with-trainers
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // TC - O(mlogm + nlogn) + O(min(m,n)) // where m: size of players, where n: size of trainers
        // SC - O(1)
        Arrays.sort(players);
        Arrays.sort(trainers);

        int left = 0; // pointer to keep track of players
        int right = 0; // pointer to keep track of trainers

        while(left<players.length && right<trainers.length){
            if(players[left]<=trainers[right]){
                left++;
            }
            right++;
        }
        return left;
    }
}