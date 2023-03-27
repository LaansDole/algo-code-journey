package RMIT.Week3.LinkedList;

public class SinglyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int length;

    // Create an empty SLL
    public SinglyLinkedList() {
        head = null;
        length = 0;
    }

    // Create an SLL of 1 node
    public SinglyLinkedList(T value) {
        head = new Node<>(value);
        tail = head;
        length = 1;
    }

    // Appends the give node to the end of the list
    public Node<T> append(T data) {
        tail.nextNode = new Node<T>(data); // Set the next node of the tail to the new node with given data
        tail = tail.nextNode; // Update tail to the new node
        length++;
        return tail;
    }
    
    public Node<T> insertNewHead(T data) {
        Node<T> newHeadNode = new Node<>(data);
        
        newHeadNode.nextNode = head;
        head = newHeadNode;
        
        length++;
        return newHeadNode;
    }

    public Node<T> addAfter(Node<T> currentNode , T data) {
        Node<T> newNode = new Node<>(data);
        newNode.nextNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        length++;
        return newNode;
    }

    public Node<T> insertNodeAfterIndex(int index, T data) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range (index < 0 || index > size())");
        }

        if (index == 0) { // If index is 0, insert new node as new head
            return insertNewHead(data);
        }

        if (index == length) { // If index is the last node, insert new node as new tail
            return append(data);
        }

        Node<T> currentNode = getNodeAtIndex(index-1); // Get the node before the specified index
        return addAfter(currentNode, data); // Insert the new node after the node at the specified index
    }

    public Node<T> getNodeAtIndex(int searchIndex) { // assume search index >= 0
        if (searchIndex < 0 || searchIndex > length) {
            throw new IndexOutOfBoundsException("Index " + searchIndex + " is out of range (index < 0 || index > size())");
        }

        if (searchIndex == 0) {
            return head;
        }

        if (searchIndex == length) {
            return tail;
        }

        Node<T> currentNode = head;
        int currentIndex = 0;
        while(currentIndex != searchIndex) {
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        return currentNode;
    }

    public void removeNodeAtIndex(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range (index < 0 || index > size())");
        }

        if (index == 0) {
            head = head.nextNode;
        }

        if (index > 0) {
            Node<T> previous = getNodeAtIndex(index - 1); // the node in front of the removing node
            Node<T> current = previous.nextNode;
            previous.nextNode = current.nextNode;
        }
        length--;
    }

    public Node<T> detectCycle() {
        if(length==0) { return null; }

        // Initialize slow and fast pointer to the start of the list
        Node<T> slow = head;
        Node<T> fast = head;

        // If slow meets fast, there is a loop
        do {
            if(!(fast.hasNext() && fast.nextNode.hasNext())) {
                return null;
            }
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        } while(slow != fast);

        // Reset the slow pointer to the start of the list
        slow = head;
        // Move both pointers one node at a time until they meet again
        while(slow != fast) {
            slow = slow.nextNode;
            fast = fast.nextNode;
        }

        return slow; // The start of the loop
    }

    public int getLength() {
        return length;
    }
}
