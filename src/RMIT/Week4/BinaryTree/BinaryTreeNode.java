package RMIT.Week4.BinaryTree;
public class BinaryTreeNode<T extends Comparable<T>> {
    public T value;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int compareTo(BinaryTreeNode<T> other) {
        return this.value.compareTo(other.value);
    }
}
