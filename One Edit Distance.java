/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
      s: a B c
      t: a D c
 * 2) Delete 1 char from s: 
      s: a D  b c
      t: a    b c
 * 3) Delete 1 char from t
      s: a   b c
      t: a D b c
 */
 /*** my solution ***/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if ((s.length() == 0 && t.length() ==1) || (s.length() == 1 && t.length() == 0))    return true;
            if (Math.abs(s.length() - t.length()) > 1)  return false;
            int cnt = 0;
            if (s.length() == t.length()) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != t.charAt(i)) cnt++;
                }
            }   else {  // Math.abs(s.length() - t.length()) == 1
            	int flag = 0;
                for (int i = 0, j = 0; i < s.length() && j < t.length(); ) {
                	if (s.charAt(i) == t.charAt(j) && (i == s.length()-1 || j == t.length()-1))	{
                		if (flag == 0) return true;;
                	}
                    if (s.charAt(i) != t.charAt(j)) {
                        if (s.length() > t.length()) {
                            i++;
                            cnt++;
                            flag = 1;
                            continue;
                        }
                        else {
                            j++;
                            cnt++;
                            flag = 1;
                            continue;
                        }
                    }
                        i++;
                        j++;
                    }
                }
            return cnt == 1;
    }
}
/*** better solution ***/
public boolean isOneEditDistance(String s, String t) {
    for (int i = 0; i < Math.min(s.length(), t.length()); i++) { 
        if (s.charAt(i) != t.charAt(i)) {
            if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                return s.substring(i + 1).equals(t.substring(i + 1));
            else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                return s.substring(i).equals(t.substring(i + 1));               
            else // s is longer than t, so the only possibility is deleting one char from s
                return t.substring(i).equals(s.substring(i + 1));
        }
    }       
    //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
    return Math.abs(s.length() - t.length()) == 1;        
}
