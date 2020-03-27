import java.util.*;

public class ReverseEveryKNodes {
    public static void main(String args[]) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;
        

        /* Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. */

        printNodes(node1);
        //  use reverse method for recursively reverse k nodes
        Node head = reverIter(node1, 3);
        printNodes(head);
    }

    static void printNodes(Node root) {
        while(root != null) {
            System.out.print(root.data+ " -> ");
            root = root.next;
        }
        System.out.println("");
    }

    static Node reverse(Node head, int k) {
        Node prev = null, curr = head, next = null;

        int count = 0;

        while(count < k && curr != null) {
            count++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(curr != null)
            head.next = reverse(curr, k);
        
        return prev;
    }

    static Node reverIter(Node head, int k) {
        Node prev = null, curr = head, prevTemp = null, firstNode = null;

        while(curr != null) {
            int count  = 0;
            firstNode = curr;

            while(count < k && curr != null) {
                count++;
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            if(prevTemp == null)
                head = prev;
            else
                prevTemp.next = prev;
            
            prevTemp = firstNode;
            firstNode.next = curr;

        }

        return head;

    }

    static class Node {
        int data;
        Node next; 
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
}