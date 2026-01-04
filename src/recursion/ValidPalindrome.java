// Problem: https://leetcode.com/problems/valid-palindrome/

ASMA SAYED@AsmaSayed MINGW64 /c/MyDocuments/DSA (main)
$ python add_java.py
Enter problem title (e.g., Two Sum): Reverse an array
Enter topic (e.g., arrays, strings, dp): recursion
Enter URL: https://www.geeksforgeeks.org/problems/reverse-an-array/1
Paste your Java solution below (end input with `END` on a new line):
class Solution {
    public boolean checkPalindrome(String s, int i, int j){
        if(i>=j){
            return true;
        }

        // Skip non-alphanumeric from left
        if (!Character.isLetterOrDigit(s.charAt(i))) {
            return checkPalindrome(s, i + 1, j);
        }

        // Skip non-alphanumeric from right
        if (!Character.isLetterOrDigit(s.charAt(j))) {
            return checkPalindrome(s, i, j - 1);
        }

        // Compare characters (case-insensitive)
        if (Character.toUpperCase(s.charAt(i)) !=
                Character.toUpperCase(s.charAt(j))) {
            return false;
        }

        return checkPalindrome(s, i + 1, j - 1);
    }

    public boolean isPalindrome(String s) {
        // Using recursion
        // TC - O(n) - n is length of string
        // SC - O(n) - recursive stack space

        return checkPalindrome(s,0,s.length()-1);
    }
}