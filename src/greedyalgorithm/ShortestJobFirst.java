// Problem: https://www.geeksforgeeks.org/problems/shortest-job-first/0
class Solution {
    static int solve(int bt[]) {
        // TC - O(n log n) + O(n)
        // SC - O(1)
        Arrays.sort(bt);
        int waitTime = 0;
        int time = 0;
        
        for(int i=0;i<bt.length;i++){
            waitTime += time;
            time += bt[i];
        }
        
        return waitTime / bt.length;
    }   
}