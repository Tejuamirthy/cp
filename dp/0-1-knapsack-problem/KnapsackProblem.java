public class KnapsackProblem {
    public static void main(String[] args) {
        int W = 4
        int val = { 1, 2, 3 };
        int wt = { 4, 5, 1 };
        System.out.println(getMaxVal(W, wt, val, val.length));
    }
    
    public static int getMaxVal(int W, int wt[], int val[], int n) { 
        int[][] dp = new int[W+1][n+1];
        for(int i = 0; i <= W; i++) {
            for(int j = 0; j <= n; j++ ) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(i >= wt[j-1])
                    dp[i][j] = Math.max(dp[i-wt[j-1]][j-1] + val[j-1], dp[i][j-1]);
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[W][n];
    } 
}
