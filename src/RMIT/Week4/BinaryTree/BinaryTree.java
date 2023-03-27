package RMIT.Week4.BinaryTree;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTreeNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public void printTree(BinaryTreeNode<T> node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);

        printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }


    public void addNode(T value) {
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            addNodeHelper(this.root, newNode);
        }
    }

    private void addNodeHelper(BinaryTreeNode<T> currentNode, BinaryTreeNode<T> newNode) {
        if (newNode.compareTo(currentNode) < 0) {
            if (currentNode.left == null) {
                currentNode.left = newNode;
            } else {
                addNodeHelper(currentNode.left, newNode);
            }
        } else {
            if (currentNode.right == null) {
                currentNode.right = newNode;
            } else {
                addNodeHelper(currentNode.right, newNode);
            }
        }
    }

    public void transversePreRecursive() {
        System.out.println("\nPre-order traversal recursive: ");
        preRecursive(root);
    }

    private void preRecursive(BinaryTreeNode<T> node) {
        if(node != null) {
            System.out.print(" "+node.value); // visit node at root
            preRecursive(node.left);
            preRecursive(node.right);
        }
    }

    public void transverseInRecursive() {
        System.out.println("\nIn-order traversal recursive: ");
        inRecursive(root);
    }

    private void inRecursive(BinaryTreeNode<T> node) {
        if (node != null) {
            inRecursive(node.left);
            System.out.print(" " + node.value); // node visit
            inRecursive(node.right);
        }
    }

    public void transversePostRecursive() {
        System.out.println("\nPost-order traversal recursive: ");
        postRecursive(root);
    }

    private void postRecursive(BinaryTreeNode<T> node) {
        if (node != null) {
            postRecursive(node.left);
            postRecursive(node.right);
            System.out.print(" " + node.value); // node visit
        }
    }
}

