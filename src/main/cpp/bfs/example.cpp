#include <iostream>
#include <queue>
#include <vector>

using namespace std;
#define MAX 100

int Vertices, Edges;
vector<bool> visited(MAX);
vector<int> path(MAX);
vector<int> graph[MAX];
queue<int> q;

// Function to initialize the graph and reset visited and path vectors
void initialize(int Vertices, int Edges)
{
    // Clear the adjacency list for each vertex
    for (int i = 0; i < Vertices; i++)
    {
        graph[i].clear();
    }

    // Reset visited and path vectors
    visited.resize(Vertices);
    path.resize(Vertices);

    for (int i = 0; i < Vertices; i++)
    {
        visited[i] = false;
        path[i] = -1;
    }

    // Read the edges and build the graph
    for (int j = 0; j < Edges; j++)
    {
        int vertex, adjacent_vertex;
        cin >> vertex >> adjacent_vertex;
        graph[vertex].push_back(adjacent_vertex);
        graph[adjacent_vertex].push_back(vertex);
    }
}

// Function to visit a vertex and mark it as visited
void visit(int vertex, int adjacent_vertex)
{
    if (!visited[adjacent_vertex])
    {
        visited[adjacent_vertex] = true; // Mark as visited
        path[adjacent_vertex] = vertex;  // Set the path to indicate the previous vertex
        q.push(adjacent_vertex);         // Add the adjacent vertex to the queue for further exploration
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
        for (int i = 0; i < graph[vertex].size(); i++)
        {
            int adjacent_vertex = graph[vertex][i];
            visit(vertex, adjacent_vertex);
        }
    }
}

// Function to print the shortest path from the start vertex to an end vertex
void printPathRecursion(int start, int end)
{
    if (start == end)
    {
        cout << start << " ";
    }
    else if (path[end] == -1)
    {
        cout << "No path from " << start << " to " << end << " exists" << endl;
    }
    else
    {
        printPathRecursion(start, path[end]);
        cout << end << " ";
    }
}

int main()
{
    int vertex, adjacent_vertex;
    cin >> Vertices >> Edges; // Read the number of vertices and edges
    initialize(Vertices, Edges);

    int start = 0;                  // Assuming we start BFS from vertex 0
    int end = 5;                    // Assuming we want to find the path to vertex 5
    BFS(start);                     // Perform BFS from the starting vertex
    printPathRecursion(start, end); // Print the path from start to end
    return 0;
}
