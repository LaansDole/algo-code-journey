#include <iostream>
#include <vector>
#include <string>

using namespace std;
vector<int> visited(26, 0);

int main()
{
    int n;
    cin >> n;

    string str;
    cin >> str;

    for (char c : str)
    {
        if (c >= 'a' && c <= 'z')
        {
            visited[c - 'a']++;
        }
        else if (c >= 'A' && c <= 'Z')
        {
            visited[c - 'A']++;
        }
    }

    for (int i = 0; i < 26; i++)
    {
        if (visited[i] == 0)
        {
            cout << "NO" << endl;
            return 0;
        }
    }

    cout << "YES" << endl;
    return 0;
}