public class Day4Practice {
    int factorial(int n) {
        if (n==1) return 1;
        return n * factorial(n-1);
    }
    int recursiveSum(int n) {
        if (n==0) return 0;
        return n + recursiveSum(n-1);
    }
    static int fibonacci(int n) {
        if (n == 0) {return 0;}
        if (n==1) {return 1;}
        return fibonacci(n-1) + fibonacci(n-2); // recursive case
    }

    static void insertAtEndLL(Node head, int n) {
        Node latest = new Node(n);

        if (head == null) {   // ChatGPT improvement
            System.out.println("LL is Empty");
            return;
        }

        Node temp = head;

        while(true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = latest;

        // ChatGPT Version -
//        while (temp.next != null) {
//            temp = temp.next;
//        }

        // Why do we use - while (temp.next != null) instead of - while (temp != null)
        // We use (temp.next != null) so that temp stops at the LAST NODE, not at null.
    }

    static Node insertAtStartLL(Node head , int n) {
        Node latest = new Node(n);
        latest.next = head;
        return latest; // IMPORTANT -> Latest element becomes new head
    }

    static Node deleteFirstNodeLL(Node head) {
        if (head == null) return null; // ChatGPT Suggestion (Always consider edge cases)

        Node newHead = head.next;
        return newHead;   // simpler version - return head.next;
    }

    static Node deleteLastNodeLL(Node head) {
        if (head == null) return null; // ChatGPT Suggestion (Always consider edge cases)
        if (head.next == null) return null; // ChatGPT Suggestion (Always consider edge cases)

        Node temp = head;
        while(true) {
            if (temp.next.next == null) { // so that temp stops at the SECOND LAST node.
                //If we use while (temp.next != null) , temp will go to last node
                //temp.next = null; ❌ Does nothing (already null)

//                removedNode = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next; // FORGOT THIS LINE , GOT STUCK IN INFINITE LOOP
        }
//        return removedNode; // always return head in these methods
        return head;
    }

    static Node reverseLL(Node head) {
        Node current = head;
//        Node next = current.next; Mistake - move this inside loop (only setting it once now)
        Node prev = null;
//        current.next = null; - remove this line

        while (current != null) {

            Node next = current.next;

            current.next = prev;
            prev= current;
            current = next;
        }
        return prev;
    }

    static Node middleLL(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int n =4;
        System.out.println(fibonacci(n));

        // LinkedList
        Node head = new Node(10);
        Node n2 = new Node(31);
        Node n3 = new Node(21);
        head.next = n2;
        n2.next = n3;
        insertAtEndLL(head,45);
        head = insertAtStartLL(head,231);
        head = deleteFirstNodeLL(head);
        head = deleteLastNodeLL(head);

        // Traversal
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        Node middle = middleLL(head);
        System.out.println("Middle :" + middle.data);
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

