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

	static int min(int a, int b) {
		return a <= b ? a : b; 
	}

}
