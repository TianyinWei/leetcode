public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        /*
        The main idea is to maintain a sliding window with 2 unique characters. The key is to store the last occurrence of each character as the value in the hashmap. This way, whenever the size of the hashmap exceeds 2, we can traverse through the map to find the character with the left most index, and remove 1 character from our map. Since the range of characters is constrained, we should be able to find the left most index in constant time.
        */
        
        if (s.length() <= 1) return s.length();
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int hi = 0, lo = 0;
        
        while(hi < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(hi), hi);
                hi++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int index : map.values()) {
                    leftMost = Math.min(leftMost, index);
                }
                
                lo = leftMost + 1;
                map.remove(s.charAt(leftMost));
            }
            max = Math.max(max, hi-lo);
        }
        return max;
    }
}
