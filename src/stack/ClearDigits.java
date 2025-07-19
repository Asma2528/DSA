// Problem: https://leetcode.com/problems/clear-digits
class Solution {
    public String clearDigits(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                while (!stack.isEmpty()) {
                    if (!Character.isDigit(stack.peek())) {
                        stack.pop();
                        break;
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();

    }
}