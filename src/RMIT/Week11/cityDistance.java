package RMIT.Week11;

public class cityDistance {
    public static void main(String[] args) {
        int[][] distance = new int[][]{
            //   0  1  2  3
                {0, 3, 2, 0}, // 0
                {3, 0, 0, 5}, // 1
                {2, 0, 0, 9}, // 2
                {0, 5, 9, 0}  // 3
        };
    }
    int[][] distance;
    int cityNum = 0;
    public cityDistance(int[][] matrix) {
        distance = matrix;
        for(int[] d: distance) {
            cityNum++; // assuming this is a NxN matrix
        }
    }

    class Graph {
        // this matrix presents the connections in the graph
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
        public void setNodeLabel(int nodeIdx , String label) {
            nodeLabels[nodeIdx] = label;
        }

        // create an edge between two nodes
        public void addEdge(int node1 , int node2) {
            matrix[node1][node2] = 1;
            // for undirected graph, node1 -> node2 also means node2 -> node1
            matrix[node2][node1] = 1;
        }

        // remove an edge between two nodes
        public void removeEdge(int node1 , int node2) {
            matrix[node1][node2] = 0;
            // for undirected graph, node1 -> node2 also means node2 -> node1
            matrix[node2][node1] = 0;
        }
    }

}
