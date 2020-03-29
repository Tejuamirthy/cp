public class PrintDuplicates {
    public static void main(String args[]) {
        int[] arrOne = { 0, 3, 1, 2 };
        int[] arrTwo = { 2, 3, 1, 2, 3 };
        int[] arrThree = { 2, 3, 1, 2, 3, 2 };
        printDuplicates(arrOne);
        printDuplicates(arrTwo);
        printDuplicates(arrThree);
    }

    static void printDuplicates(int[] arr) {
        int n = arr.length;
        boolean exists = false;
        for(int i = 0; i < n; i++) {
            boolean printed = false;
            if(arr[i] == -1)
                continue;
            for(int j = 0; j < n; j++ ) {
                if(i != j && arr[j] == arr[i] && arr[j] != -1 && !printed) {
                        arr[j] = -1;
                        exists = true;
                        printed = true;
                        System.out.print(arr[i]+" ");
                }
            }
            arr[i] = -1;
        }
        System.out.println(exists ? "" : "-1");
    }
}
