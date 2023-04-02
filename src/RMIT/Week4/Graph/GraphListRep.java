package RMIT.Week4.Graph;

import RMIT.Week3.Stack.LinkedListStack;

import java.util.LinkedList;

public class GraphListRep {
    LinkedList<Integer>[] adjacency;

    public GraphListRep(int nodes) {
        adjacency = new LinkedList[nodes];
        for(int i=0; i<nodes; i++) {
            adjacency[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adjacency[u].add(v);
        this.adjacency[v].add(u);
    }

    public static void main(String[] args) {
        GraphListRep graphListRep = new GraphListRep(4);

        graphListRep.addEdge(0,1);
        graphListRep.addEdge(1,2);
        graphListRep.addEdge(2,3);
        graphListRep.addEdge(3,4);
    }
}
