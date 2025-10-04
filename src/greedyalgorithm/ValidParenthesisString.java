// Problem: https://leetcode.com/problems/valid-parenthesis-string/
class Solution {
    public boolean validString(String s, int idx, int cnt) {
        if(cnt<0){
            return false;
        }

        if(idx == s.length()){
            return cnt==0;
        }

        if(s.charAt(idx)=='('){
            return validString(s,idx+1,cnt+1);
        }
        else if(s.charAt(idx)==')'){
            return validString(s,idx+1,cnt-1);
        }
        else{
            return validString(s,idx+1,cnt+1) || validString(s,idx+1,cnt-1) ||validString(s,idx+1,cnt);
        }

    }

    public boolean checkValidString(String s) {  
        // TC - O(3^n)
        // SC - O(n) - recursive stack space   
        return validString(s,0,0);
    }
}