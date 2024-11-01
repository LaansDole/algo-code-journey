#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;
vector<int> elements;

int main()
{
    int n;
    cin >> n;

    elements.resize(n);
    for (int i = 0; i < n; i++)
    {
        int element;
        cin >> element;
        elements[i] = element;
    }

    sort(elements.begin(), elements.end());

    cout << elements[n / 2] << endl;
    return 0;
}