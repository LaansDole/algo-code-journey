package RMIT.Week3;

/*
Acknowledgement: Mike Vo
Source code from: https://github.com/miketvo/rmit2023a-cosc2658/blob/main/src/main/java/vn/rmit/cosc2658/w3/Exercise1/Node.java
 */

public class Node<T> {
    protected T data;
    protected Node<T> nextNode;

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node(T data) {
        this(data, null);
    }


    private Node<T> getNextNode() {
        return nextNode;
    }

    public boolean hasNext() {
        return nextNode != null;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
