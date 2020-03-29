public class PrintDuplicates {
    public static void main(String args[]) {
        int[] arrOne = { 0, 3, 1, 2 };
        int[] arrTwo = { 2, 3, 1, 2, 3 };
        int[] arrThree = { 2, 3, 1, 2, 3, 2 };
//         printDuplicates(arrOne);
//         printDuplicates(arrTwo);
//         printDuplicates(arrThree);
        printDuplictesOptimized(arrThree);
        printDuplictesOptimized(arrOne);
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
    
    static void printDuplictesOptimized(int[] arr) {
        // works only when all the elements in range[0,n)
        int n = arr.length;
        boolean exists = false;
        for(int i = 0; i < n; i++) {
            int x = (arr[i]+n)%n;
            
            arr[x] += n;
        }
        
        for(int i = 0; i < n; i++) {
            if(arr[i]/n >= 2) {
                exists = true;
                System.out.print(i+" ");
            }
        }
        
        System.out.println(exists ? "" : "-1");
    }
}
