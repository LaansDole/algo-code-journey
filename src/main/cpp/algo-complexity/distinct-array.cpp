#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool checkElementPresent(int &element, vector<int> &freq)
{
    return freq[element] == 0;
}

void slidingWindow(int &l, int &r, vector<int> &freq, vector<int> &window)
{
    for (int j = 0; j < window.size(); j++)
    {
        freq[window[j]]--;
        if (checkElementPresent(window[j], freq))
        {
            // Indexing is 1 based for the output
            l = j + 1;
            r = window.size();
            return;
        }
    }
}

void distinctArray(int &n, int &k, int &l, int &r, vector<int> &elements)
{
    int distinct_count = 0;
    vector<int> freq(100001, 0);
    vector<int> window;

    for (int i = 0; i < n; i++)
    {
        if (checkElementPresent(elements[i], freq))
        {
            distinct_count++;
        }

        freq[elements[i]]++;
        window.push_back(elements[i]);

        if (distinct_count == k)
        {
            slidingWindow(l, r, freq, window);
            return;
        }
    }
}

void getInput(int &n, int &k, vector<int> &elements)
{
    cin >> n >> k;
    elements.resize(n);
    for (int i = 0; i < n; ++i)
    {
        cin >> elements[i];
    }
}

int main()
{
    int n, k;
    vector<int> elements;

    getInput(n, k, elements);

    int r = -1;
    int l = -1;
    distinctArray(n, k, l, r, elements);

    cout << l << " " << r << endl;
    return 0;
}