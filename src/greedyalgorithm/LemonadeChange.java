// Problem: https://leetcode.com/problems/lemonade-change/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // TC - O(n)
        // SC - O(1)
        int five = 0; // To keep track of $5
        int ten = 0; // to keep track of $10
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                ten++;
                if(five>0){
                    five --;
                }
                else{
                    return false;
                }
            }
            else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five > 2){
                    five-=3;
                }
                else{
                    return false;
                }
            }
        }
            return true;
    }
}