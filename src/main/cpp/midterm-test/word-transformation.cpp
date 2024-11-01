#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <queue>
#include <algorithm>

using namespace std;
#define MAX 499500

unordered_map<string, vector<string>> graph;
unordered_map<string, bool> visited;
unordered_map<string, int> path;
queue<string> q;
vector<string> dictionary;

// Function to determine if two words differ by exactly one character
bool isDifferentByOneChar(string a, string b)
{
    if (a.length() != b.length())
        return false;
    int diff = 0;
    for (int i = 0; i < a.length(); i++)
    {
        if (a[i] != b[i])
        {
            diff++;
        }
    }
    return diff == 1;
}

// Function to initialize the graph based on the dictionary
void initializeGraph(const vector<string> &dictionary)
{
    graph.clear();
    for (const string &word : dictionary)
    {
        graph[word] = vector<string>();
    }

    for (int i = 0; i < dictionary.size(); i++)
    {
        for (int j = i + 1; j < dictionary.size(); j++)
        {
            if (isDifferentByOneChar(dictionary[i], dictionary[j]))
            {
                graph[dictionary[i]].push_back(dictionary[j]);
                graph[dictionary[j]].push_back(dictionary[i]);
            }
        }
    }
}

// BFS function to find the shortest path between start and end words
int bfs(string start, string end)
{
    // Clear the queue
    while (!q.empty())
    {
        q.pop();
    }

    // Reset visited and path
    visited.clear();
    path.clear();

    // Begin BFS from the start word
    q.push(start);
    visited[start] = true;
    path[start] = 0;

    while (!q.empty())
    {
        string current = q.front();
        q.pop();

        if (current == end)
        {
            return path[current]; // If we reach the end word, return the number of transformations
        }

        // Explore all neighbors of the current word
        for (const string &neighbor : graph[current])
        {
            if (!visited[neighbor])
            {
                visited[neighbor] = true;
                path[neighbor] = path[current] + 1;
                q.push(neighbor);
            }
        }
    }

    return -1; // If no path found, return -1 (although guaranteed to have a path per problem statement)
}

int main()
{
    int n;
    cin >> n;
    cin.ignore(); // Ignore trailing newline after reading the number of test cases

    bool first_test_case = true;
    while (n--)
    {
        // Clear dictionary for each test case
        dictionary.clear();

        // Read dictionary words until the "*" symbol is encountered
        string str;
        while (true)
        {
            getline(cin, str);
            if (str == "*")
                break;
            dictionary.push_back(str);
        }

        // Initialize the graph based on the current dictionary
        initializeGraph(dictionary);

        // Read word pairs and perform BFS for each pair
        while (getline(cin, str))
        {
            if (str.empty()) // Check for blank line between test cases
                break;

            // Split the input string to get the start and end words
            size_t space_pos = str.find(' ');
            string start = str.substr(0, space_pos);
            string end = str.substr(space_pos + 1);

            // Run BFS to find the shortest transformation path
            int steps = bfs(start, end);

            // Output the result
            if (!first_test_case)
            {
                cout << endl;
            }
            first_test_case = false;
            cout << start << " " << end << " " << steps << endl;
        }

        // Output a blank line between consecutive test cases if there are more test cases left
        if (n > 0)
        {
            cout << endl;
        }
    }

    return 0;
}
