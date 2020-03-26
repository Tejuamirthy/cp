import java.util.*;

public class PrintKSumPathsBT {
    public static void main(String args[]) {
        
        Node root = new Node(1);  
        root.left = new Node(3);  
        root.left.left = new Node(2);  
        root.left.right = new Node(1);  
        root.left.right.left = new Node(1);  
        root.right = new Node(-1);  
        root.right.left = new Node(4);  
        root.right.left.left = new Node(1);  
        root.right.left.right = new Node(2);  
        root.right.right = new Node(5);  
        root.right.right.right = new Node(2);  
      
        int k = 5;  
        printKSumPathsBT(root, k);  
    }

    public static void printKSumPathsBT(Node root, int k) {
        if(root == null || k == 0)
            return;
        List<Node> list = new ArrayList<Node>();
        getKSumPathUtil(root, k, list, root);
    }

    public static void getKSumPathUtil(Node root, int k, List<Node> list, Node curr) {


        if(curr == null) {
            return;
        }
        
        list.add(curr);
            
        getKSumPathUtil(root, k, list, curr.left);
        getKSumPathUtil(root, k, list, curr.right);
    
        int si = list.size(), sum = 0;
        for(int i = si-1; i >=  0; i-- ) {
            sum += list.get(i).data;
            if(sum == k)
                printNodes(list, i);
        }
        list.remove(list.size()-1);

    } 

    public static void printNodes(List<Node> list, int i){
        int si = list.size();
        while(i < si-1) {
            Node node = list.get(i);
            System.out.print(node.data+ " -> ");
            i++;
        }
        System.out.println(list.get(i).data);
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