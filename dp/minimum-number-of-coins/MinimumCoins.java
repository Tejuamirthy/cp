public class MinimumCoins {
    public static void main(String[] args) {
        int n = 7; // number to be formed
        int c = 2; // number of different values of coins
        int[] cArr = { 2,1 }; // different coin values
        System.out.println(getNumberCoins(cArr, n, c));
    }
    
    public static int getNumberCoins(int[] arr, int n, int c) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < c; j++) {
                if(arr[j] <= i && dp[i-arr[j]] != Integer.MAX_VALUE)
                    dp[i] = min(dp[i-arr[j]] + 1, dp[i]);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
       
    public static int min(int a, int b) {
        return a <= b ? a : b;
    }
}
