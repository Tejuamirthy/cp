import java.util.*;

public class FlattenBinaryTreeIntoLinkedList {
    public static void main(String[] args) {
        /*    1 
            /   \ 
            2     5 
            / \     \ 
            3   4     6 */
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(5); 
        root.left.left = new Node(3); 
        root.left.right = new Node(4); 
        root.right.right = new Node(6);
        //printInOrder(root);
        
        bTreeToListUseRefPostOrder(root);
        printNodes(head);
        System.out.println("");
        

    }

    public static void printNodes(Node root) {
        if(root == null)
            return;
        System.out.print(root.data+" "); 
        printNodes(root.right);
        
    }

    public static void printInOrder(Node root) {
        if(root == null)
            return;
        
        System.out.print(root.data+ " -> ");
        
        printInOrder(root.left);
        printInOrder(root.right);
    } 

    static Node head = null;

    public static void bTreeToListUseRefPreOrder(Node root) {
        if(root == null)
            return;

        bTreeToListUseRefPreOrder(root.right);
        bTreeToListUseRefPreOrder(root.left);
        root.right = head;
        /*
            To enable doubly linked list
            
            if(head != null)
                head.left = root;
            
        */
        head = root;   
    }

    public static void bTreeToListUseRefInOrder(Node root) {
        if(root == null)
            return;

        bTreeToListUseRefInOrder(root.right);
        root.right = head;
        /*
            To enable doubly linked list
            
            if(head != null)
                head.left = root;
            
        */
        head = root;
        bTreeToListUseRefInOrder(root.left);
    }

    public static void bTreeToListUseRefPostOrder(Node root) {
        if(root == null)
            return;

        Node temp = root.right;
        root.right = head;
        /*
            To enable doubly linked list
            
            if(head != null)
                head.left = root;
            
        */
        head = root;
        bTreeToListUseRefPostOrder(temp);
        bTreeToListUseRefPostOrder(root.left);
    }

    public static Node stackSol(Node root) {

        Stack<Node> stack = new Stack<>();
        Node a = root;

        while(a != null || stack.size() != 0) {
            if(a.right != null) {
                stack.push(a.right);
            }

            a.right = a.left;
            a.left = null;

            if(a.right == null && stack.size() != 0) {
                a.right = stack.pop();
            }
            a = a.right;
        }
        return root;
    }

    public static Node recurFlatten(Node root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        root.left = recurFlatten(root.left);
        root.right = recurFlatten(root.right);
        if(root.left != null) {
            
            Node temp = root.left;
            
            while(temp.right != null) {
                temp = temp.right;
            }

            temp.right = root.right;
            root.right = root.left;
            root.left = null;
            
        }
        return root;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
}