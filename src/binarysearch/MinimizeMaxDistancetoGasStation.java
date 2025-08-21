// Problem: https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1
class Pair{
    double sectionLength;
    int index;
    
    public Pair(double sectionLength, int index){
        this.sectionLength = sectionLength;
        this.index = index;
    }
}

class Solution {
    // Method for optimal approach
    public static boolean checkNumberOfGasStations(int stations[],double mid,int k){
        int noOfStations = 0;
        for(int i=0;i<stations.length - 1;i++){
        int numberInBetween = (int)Math.ceil((stations[i+1] - stations[i]) / mid) - 1;
            noOfStations += numberInBetween;
            if(noOfStations>k){
                return false;
            }
        }
        return true;
    }
    
    public static double findSmallestMaxDist(int stations[], int k) {
        // Brute force approach
        // TC - O(k) * O(n) + O(n)
        // SC - O(n-1)
    //     int[] howMany=new int[stations.length - 1]; // Number of (k)stations's placed and index denotes between which indexes of stations they are stored
        
    //     for(int gs=1;gs<=k;gs++){ // As we want to place k gas stations.
    //         int idx = -1; // to tract idx of howMany array
    //         double maxDistance = -1; // to place gas station where there is max distance
    //         for(int i=0;i<stations.length - 1;i++){
    //             int difference = stations[i+1] - stations[i];
    //             double sectionLength = difference / (double) (howMany[i] + 1); // section Length is the current distance between 2 stations when k stations are placed
    //             // howMany[i] - i because each i denotes ith station of the stations array
    //             if(maxDistance<sectionLength){
    //                 maxDistance = sectionLength;
    //                 idx = i;
    //             }
    //         }
            
    //         // By the end of the inner for loop will get to know which is the current maximum distance between stations after k stations are placed
    //         howMany[idx]++; // Will place a station where there is maxDistance
    //     }
    
    // double distance = -1; // Stores the maximum distance between adjacent gas stations after k stations are placed;
    // for(int i=0;i<stations.length - 1;i++){
    //     int difference = stations[i+1] - stations[i];
    //     double sectionLength = difference / (double) (howMany[i] + 1); // section Length is the current distance between 2 stations when k stations are placed
        
    //     if(distance<sectionLength){
    //         distance = sectionLength;
    //     }
    // }
    
    // return distance;
    
     // Better approach
     // TC - O(n log n) + O(k log n)
     // SC - O(n-1) + O(n-1)
    //  int[] howMany=new int[stations.length - 1]; // Tracks how many stations are placed between each pair of stations
    //  PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p2.sectionLength, p1.sectionLength));
     
    //  for(int i=0;i<stations.length - 1;i++){
    //      int difference = stations[i+1] - stations[i];
    //      pq.add(new Pair(difference,i));
    //  }
     
    //  for(int gs=1;gs<=k;gs++){
    //      Pair largestPair = pq.poll(); // Remove the largest distance from the priority queue
    //      double sectionLength = largestPair.sectionLength;
    //      int idx = largestPair.index;
         
    //      // Update the howMany array and re-calculate the section length after placing a station
    //      howMany[idx]++;
    //      double newSectionLength = (stations[idx + 1] - stations[idx]) / (double) (howMany[idx]+1);
    //      pq.add(new Pair(newSectionLength, idx));
    //  }
     
    //  return pq.peek().sectionLength; // After placing all the stations, the largest distance is the answer
    
    
    // Optimal Approach - Using binary search 
    // TC - O(n) + O(log rangeLength) * O(n)
    // SC - O(1)
    double max = -1;
    for(int i=1;i<stations.length;i++){
        max = Math.max(stations[i] - stations[i-1], max);
    }
    
    double value = 1e-6;  // 1e-6 is equivalent to 10^-6
    double low = 0;
    double high = max;
    
    while (high - low > value){
        double mid = low + ((high - low) / 2.0);
        if(checkNumberOfGasStations(stations,mid,k)){
            high = mid;
        }else{
            low = mid;
        }
    }
    return high; // Both low and high converge to the same within 1e-6. You can safely return either low or high.
    }
// Here opposite polarity wont work as we are assigning mid to low and high
}
