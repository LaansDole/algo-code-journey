package RMIT.Week3.LinkedList;

import RMIT.Week3.Node;

import java.util.HashSet;
import java.util.Set;

public class LinkedListUtils<T> {
    private final Node<T> head;
    public LinkedListUtils(Node<T> head) {
        this.head = head;
    }
    /*
    Acknowledgement: ChatGPT3.5 and optimized version of Floyd's Tortoise and Hare Algorithm

    Time complexity: O(N) (Better than original of O(N+K) on average)
    Space complexity: O(N) (Worse than original of O(1))
     */
    public Node<T> optimizedDetectCycle() {
        if(head==null) { return null; }

        Set<Node<T>> visited = new HashSet<>();
        Node<T> current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return current;
            }
            visited.add(current);
            current = current.next;
        }

        return null;
    }

    public void removeOneCycle() {
        Node<T> startOfCycleNode = optimizedDetectCycle();
        if(startOfCycleNode == null) {
            return;
        }

        Node<T> currentNode = head;

        while(currentNode.hasNext()) {

            if(currentNode.next == startOfCycleNode) {
                currentNode.next = null;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * Returns the number of nodes that are part of at least one cycle in the linked list.
     *
     * @return the number of cycle nodes
     */
    /**
     * Removes all cycles from the linked list.
     *
     * Time complexity: O(N+K) + O(N^2) = O(N^2)
     */
    public void removeAllCycles() {
        Set<Node<T>> cycleNodes = new HashSet<>();

        // Initialise slow and fast pointers to the start of the list
        Node<T> slow = head;
        Node<T> fast = head;

        boolean hasCompletedFullCycle = false;

        // Detect all cycle nodes in the linked list
        while (!hasCompletedFullCycle && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Check if the slow and fast pointers have met
            if (slow == fast) {
                // If we have already seen this cycle node before, we have completed a full cycle
                if (!cycleNodes.add(slow)) {
                    hasCompletedFullCycle = true;
                }
            }
        }

        // Remove all cycle nodes from the linked list
        for (Node<T> cycleNode : cycleNodes) {
            // Starting from the cycle node, follow the next pointers until we find a node that is not in the cycle
            Node<T> current = cycleNode.next;
            cycleNode.next = null;

            while (current != null) {
                if (cycleNodes.contains(current)) {
                    current = current.next;
                } else {
                    break;
                }
            }

            // Set the next pointer of the cycle node to the non-cycle node we just found
            cycleNode.next = current;
        }
    }
}
