/*
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
*/

public class Solution {
    public int numWays(int n, int k) {
        if (k == 0 || n ==0) return 0;
        if (n == 1)   return k;
        int[] cnt = new int[n];
        cnt[0] = k;
        cnt[1] = k + k * (k-1);
        for (int i = 2; i < n; i++) {
            cnt[i] = (k-1)*(cnt[i-1] + cnt[i-2]);
        }
        
        return cnt[n-1];
    }
}
