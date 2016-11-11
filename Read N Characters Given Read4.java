/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) return 0;
        int total = 0;
        boolean overflow = false;
        for (int i = 0; i < buf.length; i+=4) {
            char[] myBuf = new char[4];
            int cnt = read4(myBuf);
            if (total+cnt >= n) {
                cnt = n - total;
                total = n;
                overflow = true;
            }
            if (!overflow) {
                total += cnt;
                
            }
            
            for (int j = 0; j < cnt; j++) {
                buf[i+j] = myBuf[j];
            }
            if (cnt < 4)  {
                return total;
            }
        }
        return total;
        
    }
    
}
