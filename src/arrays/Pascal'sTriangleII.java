// Problem: https://leetcode.com/problems/pascals-triangle-ii
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

    public List<Integer> getRow(int rowIndex) {
        // Brute force approach
        // We solve this problem using nCr formula
        //  n! / (r! * (n-r)!)
        // TC - O(n*r)
        // SC - O(r) //for returning the answer
        // List<Integer> rowList = new ArrayList<>();
        // long value=1;

        // //  O(n)
        // for (int i = 0; i <= rowIndex; i++) {
        //     value = find_nCr(rowIndex,i);
        //     rowList.add((int)value);
        // }

        // return rowList;

        //Optimal approach
        // TC - O(n)
        // SC - O(r) //for returning the answer
        List<Integer> rowList = new ArrayList<>();
        long ans = 1;
        rowList.add((int)ans);

        for (int i = 1; i <= rowIndex; i++) {
            ans = ans * (rowIndex - i + 1);
            ans = ans / i;
            rowList.add((int)ans);
        }

        return rowList;
    }
}