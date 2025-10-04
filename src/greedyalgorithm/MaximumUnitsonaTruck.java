// Problem: https://leetcode.com/problems/maximum-units-on-a-truck/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // TC - O(log n) + O(n)
        // SC - O(n)
        // Sort boxTypes by the units per box (descending order)
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int total = 0;
        int i = 0;

        // Fill the truck
        while(i < boxTypes.length && truckSize!=0){
            if(truckSize >= boxTypes[i][0]){
                // Take all boxes of this type
                total += boxTypes[i][1]*boxTypes[i][0];
                truckSize -= boxTypes[i][0];
            }
            else{
                // Take as many boxes as the remaining capacity allows
                total += boxTypes[i][1]*truckSize;
                truckSize = 0; // No more capacity left
            }

            i++;
        }
        return total;
    }
}