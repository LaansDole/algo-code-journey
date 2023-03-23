package RMIT.Week3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private static SinglyLinkedList<Integer> linkedList;

    @BeforeAll
    public static void setUp() {
        linkedList = new SinglyLinkedList<>();
    }
    @Test
    void appendTest() {
        
    }

    @Test
    void insertNewHead() {
    }

    @Test
    void addAfter() {
    }

    @Test
    void insertNodeAfterIndexTest() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // Insert into an empty list
        list.insertNodeAfterIndex(0, 1);
        assertEquals(1, list.getNodeAtIndex(0).data);
        assertEquals(1, list.getLength());

        // Insert at the beginning of the list
        list.insertNodeAfterIndex(0, 2);
        assertAll(
                () -> assertEquals(2, list.getNodeAtIndex(0).data),
                () -> assertEquals(1, list.getNodeAtIndex(1).data),
                () -> assertEquals(2, list.getLength())
        );

        // Insert in the middle of the list
        list.insertNodeAfterIndex(1, 3);
        assertAll(
                () -> assertEquals(2, list.getNodeAtIndex(0).data),
                () -> assertEquals(3, list.getNodeAtIndex(1).data),
                () -> assertEquals(1, list.getNodeAtIndex(2).data),
                () -> assertEquals(3, list.getLength())
        );

        // Insert at the end of the list
        list.insertNodeAfterIndex(2, 4);
        assertAll(
                () -> assertEquals(2, list.getNodeAtIndex(0).data),
                () -> assertEquals(3, list.getNodeAtIndex(1).data),
                () -> assertEquals(4, list.getNodeAtIndex(2).data),
                () -> assertEquals(1, list.getNodeAtIndex(3).data),
                () -> assertEquals(4, list.getLength())
        );

        // Insert after the end of the list
        assertThrows(IndexOutOfBoundsException.class, () -> list.insertNodeAfterIndex(5, 5));
    }


    @Test
    void getNodeAtIndex() {

    }

    @Test
    void removeNodeAtIndex() {
    }

    @Test
    public void detectCycleTest() {
        // Empty list should return null
        assertNull(linkedList.detectCycle());

        // List with only one node should return null
        linkedList.append(1);
        assertNull(linkedList.detectCycle());

        // List with two nodes pointing at each other should return the head node
        Node<Integer> headNode = new Node<>(1);
        Node<Integer> nextNode = new Node<>(2);
        headNode.setNextNode(nextNode);
        nextNode.setNextNode(headNode);
        linkedList.head = headNode;
        linkedList.length = 2;
        assertEquals(headNode, linkedList.detectCycle());

        // List with two nodes not pointing at each other should return null
        linkedList.head = new Node<>(1);
        linkedList.head.setNextNode(new Node<>(2));
        linkedList.length = 2;
        assertNull(linkedList.detectCycle());

        // List with three nodes forming a cycle should return the node that starts the cycle
        headNode = new Node<>(1);
        nextNode = new Node<>(2);
        Node<Integer> cycleStartNode = new Node<>(3);
        headNode.setNextNode(nextNode);
        nextNode.setNextNode(cycleStartNode);
        cycleStartNode.setNextNode(nextNode);
        linkedList.head = headNode;
        linkedList.length = 3;
        assertEquals(cycleStartNode, linkedList.detectCycle());

        // List with three nodes not forming a cycle should return null
        linkedList.head = new Node<>(1);
        linkedList.head.setNextNode(new Node<>(2));
        linkedList.head.nextNode.setNextNode(new Node<>(3));
        linkedList.length = 3;
        assertNull(linkedList.detectCycle());
    }

}