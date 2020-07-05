public class BuyingAndSellingStock {

     public static void main(String []args){
        int[] prices = {2,5,7,1,4,3,1,3};
        
        System.out.println(getMaxTransactions(prices));
     }
     
     public static int getMaxTransactions(int[] prices) {
        int n = prices.length;
        if(n <= 1) {
            return 0;
        }
        int[][] dp = new int[n][n];
        
        for(int i = 1; i < n; i++) { // for a given numberOfTransactions, run this loop till numberOfTransactions
            int maxDiff = -prices[0];
            for(int j = 1; j < n; j++) {
                
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
                
                maxDiff = Math.max(dp[i-1][j]-prices[j], maxDiff);
            }
        }
        // return dp[numberOfTransactions-1][n-1];  // for getting maximum profit with given numberOfTransactions
        return dp[n-1][n-1]; // for getting maximum profit with any number of transactions
     }
}
