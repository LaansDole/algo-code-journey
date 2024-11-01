#include <iostream>
#include <queue>
#include <vector>

using namespace std;
#define MAX 499500

int Vertices, Edges;
vector<bool> visited(MAX);
vector<int> path(MAX);
vector<int> graph[MAX];
queue<int> q;

// Function to initialize the graph and reset visited and path vectors
void initialize(int Vertices, int Edges)
{
    // Clear the adjacency list for each vertex
    for (int i = 0; i <= Vertices; ++i)
    {
        graph[i].clear();
    }
    // Reset visited and path vectors
    fill(visited.begin(), visited.begin() + Vertices + 1, false);
    fill(path.begin(), path.begin() + Vertices + 1, 0);

    // Read the edges and build the graph
    for (int j = 0; j < Edges; j++)
    {
        int vertex, adjacent_vertex;
        cin >> vertex >> adjacent_vertex;
        graph[vertex].push_back(adjacent_vertex); // Add edge from vertex to adjacent_vertex
        graph[adjacent_vertex].push_back(vertex); // Add edge from adjacent_vertex to vertex (undirected graph)
    }
}

// Function to visit a vertex and mark it as visited
void visit(int vertex, int adjacent_vertex)
{
    // If the adjacent vertex has not been visited, mark it and update the path
    if (!visited[adjacent_vertex])
    {
        visited[adjacent_vertex] = true; // Mark as visited
        path[adjacent_vertex] = path[vertex] + 1;
        q.push(adjacent_vertex); // Add the adjacent vertex to the queue for further exploration
    }
}

// Breadth-First Search (BFS) function to traverse the graph from the starting vertex
void BFS(int start)
{
    visited[start] = true; // Mark the starting vertex as visited
    q.push(start);

    // Process each vertex in the queue
    while (!q.empty())
    {
        int vertex = q.front();
        q.pop();
        // Visit all adjacent vertices of the current vertex
        for (int adjacent_vertex : graph[vertex])
        {
            visit(vertex, adjacent_vertex);
        }
    }
}

// Function to print the shortest path from the start vertex to all other vertices
void printPath(int start)
{
    for (int i = 1; i <= Vertices; i++)
    {
        if (i != start)
        {
            if (path[i] != 0)
                cout << path[i] * 6 << " ";
            else
                cout << -1 << " ";
        }
    }
    cout << endl;
}

int main()
{
    int queries, start;
    cin >> queries; // Read the number of queries
    for (int query = 0; query < queries; query++)
    {
        cin >> Vertices >> Edges;
        initialize(Vertices, Edges);

        cin >> start;

        BFS(start);
        printPath(start);
    }
    return 0;
}
