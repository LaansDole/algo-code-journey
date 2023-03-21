package RMIT.Week3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SinglyLinkedList<T> {

    LinkedList<Integer> linkedList;
    public Node<T> head;
    public Node<T> tail;
    int length;

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
    
    public void appendNode(Node<T> newNode) {
        tail.setNextNode(newNode);
        tail = tail.nextNode;
        length++;
    }
    
    public void insertNewHead(T data) {
        Node<T> newHeadNode = new Node<>(data);
        
        newHeadNode.nextNode = head;
        head = newHeadNode;
        
        length++;
    }

    public Node<T> addAfter(Node<T> currentNode , T data) {
        Node<T> newNode = new Node<>(data);
        newNode.nextNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        length++;
        return newNode;
    }

    public void addAt(int index , T data) {
        addAfter(getNode(index) , data);
    }

    public Node<T> getNode(int searchIndex) { // assume search index >= 0
        if (searchIndex == 0) {
            return head;
        }
        Node<T> currentNode = head;
        int currentIndex = 1;
        while(currentIndex != searchIndex) {
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        return currentNode;
    }

    public void removeAt(int index) {
        if (index == 0) {
            head = head.nextNode;
        } else if (index > 0) {
            Node<T> previous = getNode(index - 1); // the node in front of the removing node
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
}
