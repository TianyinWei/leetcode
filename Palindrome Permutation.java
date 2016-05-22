/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
*/

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)    return true;
        int[] counts = new int[256];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(counts[cur] > 0) counts[cur]--;
            else counts[cur]++;
        }
        
        for (int temp : counts) {
            if(temp != 0)   cnt++;
        }
        
        return cnt <= 1;
    }
}
