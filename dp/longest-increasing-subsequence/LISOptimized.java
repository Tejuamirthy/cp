public class LISOptimized {
    public static void main(String args[]) {
        int a[] = { 2, 4, 4, 5, 2};
        
        
        // duplicate elements are not considered part of longest increasing subsequence
        System.out.println(getDiff(a));
    }

    public static int getDiff(int[] arr) {
        int n = arr.length, len = 1;
        if(n <= 1)
            return n;
        int[] tails = new int[n];
        tails[0] = arr[0];
        for(int i = 1; i < n ;i++) {
            if(arr[i] < tails[0]) {
                tails[0] = arr[i];
            } else if(arr[i] > tails[len-1]) {
                tails[len++] = arr[i];
            } else {
                tails[getIndex(tails, -1, len-1, arr[i])] = arr[i];
            }
        }

        return len;
    }
    
    public static int getIndex(int[] tails, int l, int r, int key) {
        while(r-l > 1) {
	         int m = l + (r-l)/2;
	         if(x <= tails[m]) {
	             r = m;
	         } else {
	             l = m;
	         }
	     }
	     return r;
    }
}
