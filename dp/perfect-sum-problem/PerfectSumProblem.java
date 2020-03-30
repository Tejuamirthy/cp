public class PerfectSumProblem {
    public static void main(String args[]) {
        int[] arr = { 2, 3, 5, 6, 8, 10 };
        int k = 10;
        // Count number of subsets of array with given sum
        System.out.println(dpSol(arr, arr.length, k));
    }
    
    public static int dpSol(int[] arr, int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                if(j == 0) 
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = 0;
                else if(j >= arr[i-1])
                    dp[i][j] += dp[i-1][j] + dp[i-1][j-arr[i-1]];
                else
                    dp[i][j] += dp[i-1][j];
            }
        }
        return dp[n][k];
	  }
}
