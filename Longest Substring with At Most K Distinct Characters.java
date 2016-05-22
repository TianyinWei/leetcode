/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        if (s.length() == 1)    return 1;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int hi = 0, lo = 0;
        
        while(hi < s.length()) {
            if (map.size() <= k) {
                map.put(s.charAt(hi), hi);
                hi++;
            }
            if (map.size() > k) {
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
