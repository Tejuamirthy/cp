public class LISModified {
    public static void main(String args[]) {
        int a[] = { 2, 4, 4, 5, 2};
        
        // Bob calculates non-decreasing sequence and alice calculates strctly increasing sequence
        // Difference of these two values
        System.out.println(getDiff(a));
    }

    public static int getDiff(int[] arr) {
        int n = arr.length, bobMax = 0, aliceMax = 0;
        int[] alice = new int[n], bob = new int[n];
        boolean equalsums = true;

        for(int i = 0; i < n ;i++) {
            alice[i] = 1;
            bob[i] = 1;

            if(equalsums && i < n-1 && arr[i] != arr[i+1])
                equalsums = false;
        }

        if(equalsums)
            return n - 1;

        for(int i = 0; i < n ;i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && alice[i] < alice[j] +1) {
                    alice[i] = alice[j] + 1;
                    if(aliceMax < alice[i])
                        aliceMax = alice[i];
                }
                if(arr[i] >= arr[j] && bob[i] < bob[j] +1) {
                    bob[i] = bob[j] + 1;
                    if(bobMax < bob[i])
                        bobMax = bob[i];
                }
            }
        }

        return bobMax - aliceMax;
    }
}
