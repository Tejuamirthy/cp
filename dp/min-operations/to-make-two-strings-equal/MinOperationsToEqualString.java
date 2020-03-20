public class MinOperationsToEqualString {
    public static void main(String args[]) {
        int cI = 1; // cost to insert a character
        int cD = 2; // cost to delete a character
        int cR = 1; // cost to replace a character
        System.out.println(getMinOperations("MildStroke", "Strike", cI, cD, cR));
    }

    public static int getMinOperations(String m, String n, int cI, int cD, int cR) {
        int mLen = m.length(), nLen = n.length();
        int[][] dp = new int[mLen+1][nLen+1];

        for(int i = 1; i <= mLen; i++ )
            dp[i][0] = i*cD;

        for(int i = 1; i <= nLen; i++ )
            dp[0][i] = i*cI;

        for(int i = 1; i <= mLen; i++) {
            for(int j = 1; j <= nLen; j++) {
                if(m.charAt(i-1) == n.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else 
                    dp[i][j] = dp[i-1][j-1]+ cR;
                
                dp[i][j] = min(dp[i][j], // cost after replacing the character or if it's a same character
                                dp[i-1][j] + cD, // cost after deleting the character
                                    dp[i][j-1]+ cI); // cost after inserting a character 
            }
        }
        
        return dp[mLen][nLen];
    }

    public static int min(int a, int b, int c) {
        return a <= b && a <= c ? a : b <= c ? b : c ; 
    }
}
