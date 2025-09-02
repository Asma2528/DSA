// Problem: https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
class Solution {
    public int longestKSubstr(String s, int k) {
    // Brute force approach
    // TC - O(n^2)
    // SC - O(k + 1)
    // int maxLen = -1;

    // for (int i = 0; i < s.length(); i++) {
    //   Set<Character> set = new HashSet<>();
    //   for (int j = i; j < s.length(); j++) {
    //     char c = s.charAt(j);
    //     set.add(c);
    //     if (set.size() > k) {
    //       break;
    //     }
        
    //     if(set.size() == k){
    //         maxLen = Math.max(maxLen, j - i + 1);
    //     }
    //   }
    // }

    // return maxLen;
    
    // Better approach
    // TC - O(2n)
    // SC - O(k + 1) 
    /*
    Store characters and their frequency in map
    Take a right pointer and keep on shifting it until last element
    Whenever the map size is more than k (which means more than k distinct) shift the left pointer until the map size is k
    Update the maxLen when size is k
    */
    // int maxLen = -1;
    // int left = 0;
    // Map<Character, Integer> map = new HashMap<>(); // stores character and its frequency
    // for(int right = 0; right<s.length(); right++){ // O(n)
    // char c1 = s.charAt(right);
    // // Increment the frequency of the current character
    // map.put(c1,map.getOrDefault(c1,0) + 1);

    // // Shrink the window if there are more than k distinct characters
    // while(map.size() > k){ // O(n)
    //     char c2 = s.charAt(left);
    //     map.put(c2,map.getOrDefault(c2,0) - 1);
    //     if(map.getOrDefault(c2,0)==0){
    //         map.remove(c2); 
    //     }
    //     left++;  // Move the left pointer to shrink the window
    // }

    //     // Update maxLen with the size of the valid window
    //     if(map.size() == k){
    //         maxLen = Math.max(maxLen, right - left + 1);
    //     }
    // }

    // return maxLen;

    // Optimal approach
    // TC - O(n)
    // SC - O(k + 1) 
    /*
    Store characters and their frequency in map
    Take a right pointer and keep on shifting it until last element
    Whenever the map size is more than k (which means more than k disctinct characters) shift the left pointer by 1
    When the map size is k update the maxLen 
        
    Difference between better and optimal approach is that we are shifting left pointer by 1 only and updating the maxLen only when the map size is k
    */
    int maxLen = -1;
    int left = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
        char c1 = s.charAt(right);
        map.put(c1, map.getOrDefault(c1, 0) + 1);
        
        if(map.size()>k){
            char c2 = s.charAt(left);
            map.put(c2,map.getOrDefault(c2,0)-1);
            if(map.getOrDefault(c2,0)==0){
                map.remove(c2);
            }
            left++;
        }
            
        if(map.size()==k){
             maxLen = Math.max(maxLen, right - left + 1);
        }
    }

    return maxLen;
        
    }
}