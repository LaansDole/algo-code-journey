package RMIT.Week3.Stack;

import RMIT.Week3.Node;
public class LinkedListStack<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedListStack() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(T item) {
        // add a new node at the beginning
        Node<T> node = new Node<T>(item);
        if (isEmpty()) {
            tail = node;
        } else {
            node.next = head;
        }
        head = node;
        size++;
        return true;
    }

    public boolean pop() {
        // remove the first node
        // make sure the stack is not empty
        if (isEmpty()) {
            return false;
        }
        // advance head
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return true;
    }

    public Node<T> peek() {
        // make sure the stack is not empty
        if (isEmpty()) {
            return null;
        }
        return head;
    }

    public Node<T> getLast() {
        // make sure the stack is not empty
        if (isEmpty()) {
            return null;
        }
        return tail;
    }
}
