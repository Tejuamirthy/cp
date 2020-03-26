public class MakeBTFromInAndPostOrders {
    public static void main(String args[]) {
        int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 }; 
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 }; 
        int n = in.length; 
        Node root = buildTree(in, post, n); 
        preOrder(root); 
    }

    static Node buildTree(int[] in, int[] post, int n) {
        Index pInd = new Index(n-1);
        return buildTreeUtil(in, post, 0, n-1, pInd);
    }

    static Node buildTreeUtil(int[] in, int[] post, int start, int end, Index pInd) {
        if(start > end)
            return null;
        Node node = new Node(post[pInd.index--]);
        
        if(start == end)
            return node;
        int index = getInorderIndex(in, node.data, start, end);

        node.right = buildTreeUtil(in, post, index +1, end, pInd);
        node.left = buildTreeUtil(in, post, start, index-1, pInd);

        return node;
    }

    static int getInorderIndex(int[] in, int item, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(in[i] == item)
                return i;
        }
        return -1;
    }

    static void preOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data+" ->");
        preOrder(root.left);
        preOrder(root.right);
    }

    static class Index {
        int index;
        Index(int i){
            index = i;
        }
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