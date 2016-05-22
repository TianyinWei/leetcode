/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/

public class Solution {
    public void reverseWords(char[] s) {
        if (s.length == 0 || s.length == 1) return;
        reverse(s, 0, s.length-1);
        int lo = 0, hi = 0;
        while(hi < s.length) {
            if (s[hi] == ' ') {
                reverse(s, lo, hi-1);
                lo = hi + 1;
            }
            
            hi++;
        }
        reverse(s, lo, hi-1);

    }
    
    private void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = 'a';
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
