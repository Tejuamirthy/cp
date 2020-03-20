import java.util.*;
import java.lang.*;

public class AllSubsetsSumKRec {

	public static void main(String args[]) {

		int[] arr = { 1,10,5,7,16,2, 3 };
		int k = 22;
		getSubset(arr, new ArrayList<Integer>(), 0, k, 0);
	}

	public static void getSubset(int[] arr, ArrayList<Integer> list, int sum, int k, int i) {

		if(sum == k) {
			System.out.println(list);
			return;
		} else if(i == arr.length)
			return;
		if(sum + arr[i] <= k) {
			list.add(arr[i]);
			getSubset(arr, list, sum+arr[i], k, i+1);
			list.remove(list.size()-1);
		}
		getSubset(arr, list, sum, k, i+1);

	}


}
