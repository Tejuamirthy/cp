import java.util.*;

class MinJumpsToArrayEnd
 {
	public static void main (String[] args) {
		// starting  from 1st element
		// jumps in the order of below indices
		// 0 -> 1 -> 4 -> 10
		// 1 -> 3 -> 9 -> 9
		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(minJumps(arr, arr.length));
	 }
	 
	 public static int minJumps(int[] arr, int n) {
		 // to store the min jumps required to reach each point
		int[] dp = new int[n];
		 // 	count - number of jumps
		 //	from - jumping from index, currSteps - number of steps we can jump from index 'from'
		 // 	maxIndex - next index from where we need to count jumps from
		int from = 0, maxIndex = 0, currSteps = arr[0], count = 1;
		for(int i = 1; i < n; i++) {
		 if(currSteps == 0) {
		     if(from == maxIndex)   return -1;
		     count++;
		     from = maxIndex;
		     currSteps = arr[from] - (i - maxIndex);
		 } else
		    currSteps--;

		 if(i + arr[i] > maxIndex + arr[maxIndex] && arr[i] != 0) {
		     maxIndex = i;
		 }
		 dp[i] = count;
		}
		return (dp[n-1] == 0) ? -1 : dp[n-1];
	 }
}
