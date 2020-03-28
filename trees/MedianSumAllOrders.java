import java.util.*;

public class MedianSumAllOrders {
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine()); // number of edges    
        int[] parentArr = new int[m];

        for(int i = 0; i < m; i++) {
            parentArr[i] = Integer.parseInt(sc.nextLine());
        }

         Node root = new Node(0);

         fillTree(root, parentArr);
         // Store each order traversal into an array and get the median array of each element 
         int[] inOrdArr = inOrder(root, m+1);
         int[] preOrdArr = preOrder(root, m+1);
         int[] postOrdArr = postOrder(root, m+1);
        //  System.out.println("INorder");
        //  printArr(inOrdArr);
        //  System.out.println("preorder");
        //  printArr(preOrdArr);
        //  System.out.println("postorder");
        //  printArr(postOrdArr);
         System.out.println(getSumMedians(inOrdArr, preOrdArr, postOrdArr));
     }

     static void fillTree(Node root, int[] parentArr) {
        HashMap<Integer, Node> hm = new HashMap<>();
        hm.put(0, root);
        int len = parentArr.length;
        for(int i = 0; i < len; i++) {
            Node node = new Node(i+1);
            hm.put(i+1, node);
            Node p = hm.get(parentArr[i]);
            if(p.left == null)
                p.left = node;
            else
                p.right = node;
        }
     }

     static int getSumMedians(int[] in, int[] pre, int[] post) {
        int sum = 0, n = in.length;
        int[] sumArr = new int[n];        
        for(int i = 0; i < n; i++) {
            int ma = (in[i] > pre[i] && in[i] > post[i]) ? in[i] : (pre[i] > post[i]) ? pre[i] : post[i];
            int mi = (in[i] < pre[i] && in[i] < post[i]) ? in[i] : (pre[i] < post[i]) ? pre[i] : post[i];
            sum += in[i]+post[i]+pre[i] - ma - mi;
            sumArr[i] = in[i]+post[i]+pre[i] - ma - mi;
        }
        // printArr(sumArr);
        return sum;
     }

     static void printArr(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            System.out.print( arr[i]+" ");
        }
        System.out.println("");
     }


     static int[] preOrder(Node root, int n) {

        Stack<Node> stack = new Stack<>();
        int[] arr = new int[n];
        stack.add(root);
        int i = 0;
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            arr[i++] = node.data;
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }        
        return arr;
     }

     static int[] inOrder(Node root, int n) {

        Stack<Node> stack = new Stack<>();
        int[] arr = new int[n];
        // stack.add(root);
        int i = 0;
        Node curr = root;
        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            arr[i++] = curr.data;

            curr = curr.right;
        }        
        return arr;
     }

     static int[] postOrder(Node root, int n) {

        Stack<Node> stack = new Stack<>(), stack2 = new Stack<>();
        int[] arr = new int[n];
        
        int i = n-1;
        stack.push(root);
        while(!stack.isEmpty() && i >=0) {
            Node node = stack.pop();
            arr[i--] = node.data;
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        
        // while(!stack.isEmpty()) {
        //     Node node = stack.pop();
        //     stack2.push(node);
            
        //     if(node.right != null)
        //         stack.push(node.right);
        //     if(node.left != null)
        //         stack.push(node.left);
        // }
        // while(!stack2.isEmpty()) {
        //     Node temp = stack2.pop();
        //     arr[i++] = temp.data;
        // }
        return arr;
     }

     static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
     }
 }
