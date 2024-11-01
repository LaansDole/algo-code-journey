#include <iostream>
#include <vector>
#include <string>

using namespace std;
vector<int> words;

int main()
{
    string str;
    cin >> str;

    for (char c : str)
    {
        if (isupper(c))
        {
            words.push_back(c);
        }
    }

    cout << words.size() << endl;
    return 0;
}