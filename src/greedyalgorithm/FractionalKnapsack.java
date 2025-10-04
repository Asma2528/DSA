// Problem: https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
class Solution {
    class Item {
        int val, wt;
        double perUnit;
        
        Item(int val, int wt, double perUnit){
            this.val = val;
            this.wt = wt;
            this.perUnit = perUnit;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        
        // TC - O(n log n)  // O(n log n) for insertion + O(n log n) for polling
        // SC - O(n)
        
         PriorityQueue<Item> pq = new PriorityQueue<>((a,b) -> Double.compare(b.perUnit, a.perUnit));
         
        for(int i = 0; i < val.length; i++){ // O(n)
            Item it = new Item(val[i], wt[i], (double) val[i] / wt[i]);
            pq.add(it); // O(log n)
        }
        
        double totalVal = 0;
        
        
        while(capacity!=0 && !pq.isEmpty()){ // O(n)
            Item curr = pq.poll(); // O(log n)
            
            if(curr.wt <= capacity){
                // Take the whole item
                totalVal += curr.val; 
                capacity -= curr.wt;
            }
            else{
                // Take fractional part
                totalVal += curr.perUnit * capacity;
                capacity = 0;
            }
        }
        
        return totalVal;
    }
}