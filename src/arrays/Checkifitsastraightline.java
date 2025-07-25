// Problem: https://leetcode.com/problems/check-if-it-is-a-straight-line
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Optimal Approach
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        int n = coordinates.length;
        for (int i = 0; i < n - 2; i++) {
            int x1 = coordinates[i][0], y1 = coordinates[i][1];
            int x2 = coordinates[i + 1][0], y2 = coordinates[i + 1][1];
            int x3 = coordinates[i + 2][0], y3 = coordinates[i + 2][1];

            if ((y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1)) {
                return false;
            }
        }
        return true;
    }
}

// Explanation -
// If the slope between every pair of points is the same, the points lie on a straight line.

// Slope between two points (x1, y1) and (x2, y2):
// m = (y2 - y1) / (x2 - x1)

// To check if points (x1, y1), (x2, y2), and (x3, y3) are collinear:
// (y2 - y1)/(x2 - x1) == (y3 - y1)/(x3 - x1)

// Multiply both sides to avoid division:
// (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)

// If the slopes between all pairs of points are equal, then the points lie on the same straight line.
// This is called collinearity in mathematics.

