package RMIT.Week3;

/*
Acknowledgement: Mike Vo
Source code from: https://github.com/miketvo/rmit2023a-cosc2658/blob/main/src/main/java/vn/rmit/cosc2658/w3/Exercise1/Node.java
 */

public class Node<T> {
    protected T data;
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }


    private Node<T> getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
