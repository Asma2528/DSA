// Problem: https://leetcode.com/problems/fruit-into-baskets
class Solution {
    public int totalFruit(int[] fruits) {
        // Assume question is: Maximum length subarray with atmost 2 types of numbers
        // Brute force approach
        // TC - O(n^2)
        // SC - O(3)
        /*
        Idea: Generate all subarrays, store elements in a set data structure till 3 elements. Once set size is 3 break the inner loop
        */
        // int maxLen = 0;

        // for(int i = 0;i<fruits.length; i++){
        //     Set<Integer> set = new HashSet<>();
        //     for(int j=i;j<fruits.length;j++){
        //         set.add(fruits[j]);
        //         if(set.size()>2){
        //             break;
        //         }
        //         maxLen = Math.max(maxLen,j-i+1);
        //     }
        // }

        // return maxLen;

        // Better approach
        // TC - O(2n)
        // SC - O(3) 
        /*
        Store elements and their frequency in map
        Take a right pointer and keep on shifting it until last element
        Whenever the map size is more than 2 (which means more than 2 types of fruits) shift the left pointer until the map size is 2
        Update the maxLen
        */
        // int maxLen = 0;
        // int left = 0;
        // Map<Integer, Integer> map = new HashMap<>(); // stores fruit type and its frequency
        // for(int right = 0; right<fruits.length; right++){ // O(n)
        //     // Increment the frequency of the current fruit
        //     map.put(fruits[right],map.getOrDefault(fruits[right],0) + 1);

        //    // Shrink the window if there are more than 2 distinct fruits
        //     while(map.size() > 2){ // O(n)
        //         map.put(fruits[left],map.getOrDefault(fruits[left],0) - 1);
        //         if(map.getOrDefault(fruits[left],0)==0){
        //             map.remove(fruits[left]); 
        //         }
        //         left++;  // Move the left pointer to shrink the window
        //     }

        //     // Update maxLen with the size of the valid window
        //     maxLen = Math.max(maxLen, right - left + 1);
        // }

        // return maxLen;

        // Optimal approach
        // TC - O(n)
        // SC - O(3) 
        /*
        Store elements and their frequency in map
        Take a right pointer and keep on shifting it until last element
        Whenever the map size is more than 2 (which means more than 2 types of fruits) shift the left pointer by 1
        When the map size is 2 or less than 2 update the maxLen 
        
        Difference between better and optimal approach is that we are shifting left pointer by 1 only and updating the maxLen only when the map size is less than 2 or equal to 2
        */
        int maxLen = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if(map.size()>2){
                map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
                if(map.getOrDefault(fruits[left],0)==0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            if(map.size()<=2){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}