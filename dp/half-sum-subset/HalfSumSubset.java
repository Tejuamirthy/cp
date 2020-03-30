public class HalfSumSubset {

	public static void main(String args[]) {

		int[] arr = { 1,10,5,7,16,2,3 };
		int m = 0;
		for(int i = 0; i < arr.length; i++) {
			m += arr[i];
		}		
		System.out.println(dpSol(arr, m));
	}

	public static boolean dpSol(int[] arr, int k) {
		int n = arr.length, r = 0;
		boolean dp[] = new boolean[k+1];
		dp[0] = true;

		for(int i = 0; i < n; i++) {
			for(int j = r; j >= 0; j--) {
				if(dp[j]) {
					dp[j+arr[i]] = true;
				}
			}
			r = min(r+arr[i], k/2);
		}
		return dp[k/2];
	}

	// another approach for the same solution
	public static boolean isSubsetPossible(int[] arr, int k) {
	     int n = arr.length;
	     boolean[][] dp = new boolean[2][k+1];
	     
	     for(int i = 0; i <= n; i++) {
	         for(int j = 0; j <= k; j++) {
	             if(j == 0)
	                dp[i%2][j] = true;
	             else if( i == 0)
	                dp[i%2][j] = false;
	             else if(j >= arr[i-1])
	                dp[i%2][j] = dp[(i+1)%2][j] || dp[(i+1)%2][j-arr[i-1]];
	             else
	                dp[i%2][j] = dp[(i+1)%2][j];
	         }
	     }
	     
	     return dp[n%2][k];
	}
	
	static int min(int a, int b) {
		return a <= b ? a : b; 
	}

}
