// Problem: https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(n) (for returning the result)
        // ArrayList<Integer> result=new ArrayList<>();
        // for(int i=0;i<arr.length;i++){
        //     Boolean isLeader=true;
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]<arr[j]){
        //             isLeader=false;
        //             break;
        //         }
        //     }
        //     if(isLeader){
        //         result.add(arr[i]);
        //     }
        // }

        // return result;
        
        // Optimal approach
        // TC - O(n) + O(n) (for reversing the result)
        // SC - O(n) (for returning the result)
        // ArrayList<Integer> result=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=max){
                result.add(arr[i]);
            }
            max=Math.max(max,arr[i]);
        }
        
        Collections.reverse(result);
        
        return result;
    }
}
