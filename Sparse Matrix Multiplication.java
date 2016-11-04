public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        /*** general matrix multiplication ***/
        int m = A.length;
        int n = A[0].length;    //n = B.length;
        int k = B[0].length;
        
        int[][] res = new int[m][k];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int x = 0; x < k; x++) {
                        if (B[j][x] != 0) {
                            res[i][x] += A[i][j] * B[j][x];
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
