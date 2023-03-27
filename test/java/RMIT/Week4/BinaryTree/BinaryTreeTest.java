package RMIT.Week4.BinaryTree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree<Integer> myTree = new BinaryTree<Integer>();
    @Test
    void DepthFirstTraversalTest() {
        myTree.addNode(5);
        myTree.addNode(3);
        myTree.addNode(7);
        myTree.addNode(2);
        myTree.addNode(4);
        myTree.addNode(6);
        myTree.addNode(8);

        myTree.printTree(myTree.getRoot(), "", true);

        myTree.transversePreRecursive();
        myTree.transverseInRecursive();
        myTree.transversePostRecursive();
    }
}