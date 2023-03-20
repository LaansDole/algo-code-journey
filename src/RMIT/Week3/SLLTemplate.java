package RMIT.Week3;

public class SLLTemplate {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public class SinglyLinkedList {
        Node head, tail;
        int length;

        // Create an empty SLL
        public SinglyLinkedList() {
            this.head = null;
        }

        // Create an SLL of 1 node
        public SinglyLinkedList(int value) {
            this.head = new Node(value);
            tail = head;
            length = 1;
        }

        public void appendNode(Node newNode) {
            tail.next = newNode;
            tail = tail.next;
            length++;
        }

        public Node addAfter(Node currentNode, int data) {
            Node newNode = new Node(data);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            length++;
            return newNode;
        }

        public void addAt(int index, int data) {
            addAfter(getNode(index), data);
        }

        public Node getNode(int searchIndex) { // assume search index >= 0
            Node currentNode = head;
            if(searchIndex == 0) {
                return currentNode;
            }
            int currentIndex = 1;
            while(currentIndex != searchIndex) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            return currentNode;
        }

        public void removeAt(int index) {
            if(index==0) {
                head = head.next;
            }
            else if(index > 0) {
                Node previous = getNode(index-1); // the node in front the removing node
                Node current = previous.next;
                previous.next = current.next;
            }
            length--;
        }
    }
}
