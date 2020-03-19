public class LongestCommonSubsequence {

    public static void main(String []args){
        System.out.println(LCSLength("Yellow", "Hell!No"));
    }
    
    public static int LCSLength(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        
        int[][] dp = new int[sLen+1][tLen+1];
        
        for(int i = 1; i <= sLen; i++) {
            for(int j = 1; j <= tLen; j++) {
                dp[i][j] = dp[i-1][j-1];
                
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j]++;
                else 
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);

            }
        }
        return dp[sLen][tLen];
    }
    
    public static int max(int a, int b) {
        if( a >= b)
            return a;
        return b;
    }

}
