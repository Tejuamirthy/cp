public class LongestCommonSubsequenceTwo {

    public static void main(String []args){
        System.out.println(LCSLength("Yellow", "Hell!Now"));
    }
    
    public static int LCSLength(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        
        int[][] dp = new int[sLen+1][tLen+1];
        
        for(int i = sLen-1; i >= 0; i--) {
            for(int j = tLen-1; j >= 0; j--) {
                dp[i][j] = dp[i+1][j+1];
                
                if(s.charAt(i) == t.charAt(j))
                    dp[i][j]++;
                else 
                    dp[i][j] = max(dp[i+1][j], dp[i][j+1]);

            }
        }
        return dp[0][0];
    }
    
    public static int max(int a, int b) {
        if( a >= b)
            return a;
        return b;
    }
    
}
