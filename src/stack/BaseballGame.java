// Problem: https://leetcode.com/problems/baseball-game
class Solution {
    public int calPoints(String[] operations) {
        int total = 0;
        Stack<Integer> st = new Stack();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            char c = operations[i].charAt(0);
            if (Character.isDigit(c) || (c == '-' && op.length() > 1)) {
                st.push(Integer.parseInt(operations[i]));
            } else if (c == 'C') {
                st.pop();
            } else if (c == 'D') {
                int top = st.peek();
                st.push(2 * top);
            } else if (c == '+') {
                int top = st.pop();
                int ptop = st.peek();
                st.push(top);
                st.push(top + ptop);
            }
        }

        while (!st.isEmpty()) {
            total += st.pop();
        }
        return total;
    }
}