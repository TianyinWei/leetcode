/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.

Show Company Tags
Show Tags
Show Similar Problems
*/

public class Solution {
/******* Iterative *******/
    public List<String> findStrobogrammatic(int n) {
        List<String> even = new ArrayList<String>(Arrays.asList("")), odd = new ArrayList<String>(Arrays.asList("1", "8", "0"));
        List<String> res = new ArrayList<String>();
        if (n == 0) return res;
        if (n % 2 == 0) {
            res = even;
        }   else {
            res = odd;
        }
        
        for (int i = n%2; i < n; i+=2) {
            List<String> temp = new ArrayList<String>();
            for (String s : res) {
                temp.add("1" + s + "1");
                temp.add("6" + s + "9");
                temp.add("8" + s + "8");
                temp.add("9" + s + "6");
                if(i != (n-2))    temp.add('0' + s + '0');
            }
            res = temp;   
        }
        
        return res;
    }

/******** Recursive ********/
public class Solution {
    public List<String> findStrobogrammatic(int n) {
       return helper(n, n);
        
    }
    
    private List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> semi = helper(n-2, m);
        
        List<String> res = new ArrayList<String>();
        
        for (String s : semi) {
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            
            if (n != m) res.add("0" + s + "0");
        }
        
        return res;
    }
}
}
