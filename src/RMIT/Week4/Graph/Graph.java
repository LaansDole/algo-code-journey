package RMIT.Week4.Graph;

import RMIT.Week3.Queue.LinkedListQueue;
import RMIT.Week3.Stack.LinkedListStack;

public class Graph {
    int[][] matrix;

    // this array presents the labels of the vertices/nodes
    String[] nodeLabels;

    int size;

    // find the path?
    boolean found;

    // create a graph with the number of nodes/vertices
    public Graph(int nodes) {
        size = nodes;
        matrix = new int[size][size];
        // no connection/edge initiall
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
        nodeLabels = new String[size];
    }

    // set the label for a node
    public void setNodeLabel(int nodeIdx, String label) {
        nodeLabels[nodeIdx] = label;
    }

    // create an edge between two nodes
    public void addEdge(int node1, int node2) {
        matrix[node1][node2] = 1;
        // for undirected graph, node1 -> node2 also means node2 -> node1
        matrix[node2][node1] = 1;
    }

    // remove an edge between two nodes
    public void removeEdge(int node1, int node2) {
        matrix[node1][node2] = 0;
        // for undirected graph, node1 -> node2 also means node2 -> node1
        matrix[node2][node1] = 0;
    }

    // depth-first search/traversal
    public void DFS() {
        System.out.println("Depth-First Search/Traversal");
        // visited states
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }
        // start the DFS recursively from node 0 (you can start from any node)
        DFSR(0, visited);

        // the above code assumes the graph is connected
        // that mean you can reach all nodes from any node
        // if the graph is not connected, you must call DFSR on every node
        // to make sure you visit all nodes (lecture 4, slide 52)
    }

    public void DFSR(int nodeIdx, boolean[] visited) {
        if (visited[nodeIdx]) {
            // this node has been visited before
            return;
        }
        // this is the "visit" operation
        // do whatever you want with this node
        System.out.println("Visit: " + nodeLabels[nodeIdx]);
        // mark the visited state
        visited[nodeIdx] = true;
        // apply the DFS process to all adjacent nodes
        for (int i = 0; i < size; i++) {
            if (matrix[nodeIdx][i] == 1 && !visited[i]) {
                DFSR(i, visited);
            }
        }
    }

    // breadth-first search/traversal
    public void BFS() {
        System.out.println("Breadth-First Search/Traversal");
        // visited states
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }

        // to enqueue a node, we just need the node index
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        // start from node 0
        // you can start from any node
        queue.enQueue(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int nodeIdx = queue.peekFront();
            queue.deQqueue();
            // "visit" this node
            System.out.println("Visit: " + nodeLabels[nodeIdx]);

            // add all adjacent nodes to the queuq
            for (int i = 0; i < size; i++) {
                if (matrix[nodeIdx][i] == 1 && !visited[i]) {
                    queue.enQueue(i);
                    visited[i] = true;
                }
            }
        }

        // the above code assumes the graph is connected
        // that mean you can reach all nodes from any node
        // if the graph is not connected, you must call BFS on every node
        // to make sure you visit all nodes
    }

    // find a path in a graph using DFS
    // BFS is similar (you can implement it yourself)
    public void pathDFS(int source, int destination) {
        System.out.printf("Find the path from %s to %s\n", nodeLabels[source], nodeLabels[destination]);
        // use a stack to store the nodes in visited order
        LinkedListStack<Integer> path = new LinkedListStack<>();
        // visited states
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }
        found = false;
        // start the search recursively from source
        pathDFSR(source, destination, path, visited);
        // cannot find a path after finish?
        if (!found) {
            System.out.println("Cannot find a path");
        }
    }

    public void pathDFSR(int current, int destination, LinkedListStack<Integer> currentPath, boolean[]visited) {
        if (found) {
            return;
        }
        if (current == destination) {
            found = true;
            // reach the destination, print the result and stop
            StringBuilder result = new StringBuilder();
            result.insert(0, nodeLabels[destination]);
            while (!currentPath.isEmpty()) {
                int parent = currentPath.peek().getData();
                currentPath.pop();
                result.insert(0, nodeLabels[parent] + " -> ");
            }
            System.out.println(result);
            return;
        }
        if (visited[current]) {
            // this node has been visited before
            return;
        }
        // mark the visited and continue
        visited[current] = true;
        currentPath.push(current);
        // apply the DFS process to all adjacent nodes
        for (int i = 0; i < size; i++) {
            if (matrix[current][i] == 1 && !visited[i]) {
                pathDFSR(i, destination, currentPath, visited);
            }
        }
        // remove current from the stack after trying all its branches
        currentPath.pop();
    }
}
