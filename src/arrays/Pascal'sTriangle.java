// Problem: https://leetcode.com/problems/pascals-triangle
class Solution {
    // O(r)
    public long find_nCr(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;
    }

    // For brute force approach
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowList = new ArrayList<>();
        long value = 1;

        //  O(n)
        for (int i = 0; i <= rowIndex; i++) {
            value = find_nCr(rowIndex, i);
            rowList.add((int) value);
        }

        return rowList;
    }

    //Optimal approach
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> rowList = new ArrayList<>();
        long ans = 1;
        rowList.add((int) ans);

        for (int i = 1; i <= rowIndex; i++) {
            ans = ans * (rowIndex - i + 1);
            ans = ans / i;
            rowList.add((int) ans);
        }

        return rowList;
    }

    public List<List<Integer>> generate(int numRows) {
        // Brute force approach
        // TC - O(n^3)
        // SC - O(n^2) //for returning the answer
        // List<List<Integer>> pascal = new ArrayList<>();
        // for (int i = 0; i < numRows; i++) {
        //     pascal.add(getRow(i));
        // }

        // return pascal;

        // Optimal approach
        // TC - O(n^2)
        // SC - O(n^2) //for returning the answer
        List<List<Integer>> pascal = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            pascal.add(getRow2(i));
        }

        return pascal;

    }
}