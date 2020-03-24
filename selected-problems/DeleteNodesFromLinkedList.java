public class DeleteNodesFromLinkedList {
    public static void main(String args[]) {
        
        // Delete nodes that have nodes with greater values to right of their position in the list
        
        Node head = initializeNodes();
        printList(head);

        // Solution for this problem using recursion
        Node res = recurSol(head);

        printList(res);
        
        
        /* Method - 2 */
        head = initializeNodes();
        printList(head);

        // Solution for this problem using iteration
        Node resIter = removeMaxList(head);

        printList(resIter);

    }

    static Node initializeNodes() {
        Node node1 = new Node(12);
        Node node2 = new Node(15);
        Node node3 = new Node(10);
        Node node4 = new Node(11);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(2);
        Node node8 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        return node1;
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data+" -> ");
            head = head.next;
        }
        System.out.println("");
    }

    static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    static Node removeMaxList(Node node) {
        
        node = reverseList(node);
        Node curr = node, prev = null;
        
        int max = curr == null ? Integer.MIN_VALUE : curr.data;
        
        if(curr == null || curr.next == null)
            return curr;
        
        prev = curr;
        curr = prev.next;
        
        
        while(curr  != null) {
            // Node next = curr.next;
            // if(next == null)
            //     break;
            if(curr.data < max) {
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }
            if(max < curr.data)
                max = curr.data;
            prev = curr;
            curr = curr.next;
            
        }
        
        node = reverseList(node);
        
        return node;
    }
    
    static Node recurSol(Node head) {
        if(head.next == null)
            return head;
        Node temp = recurSol(head.next);
        if(temp.data > head.data)
            return temp;
        else
            head.next = temp;
        return head;

    }


    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
}
