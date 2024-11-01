#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>

using namespace std;

const string AUTO = "automaton";
const string ARR = "array";
const string BOTH = "both";
const string NONE = "need tree";

vector<int> getAlphaCount(string str)
{
    vector<int> alpha_cnt(26, 0);
    for (int i = 0; i < str.length(); i++)
    {
        alpha_cnt[str[i] - 'a']++;
    }
    return alpha_cnt;
}

string suffixStructure(string s, string t, string &suffix)
{
    if (t.length() > s.length())
        return suffix = NONE;
    else
    {
        vector<int> alpha_s;
        vector<int> alpha_t;
        alpha_s = getAlphaCount(s);
        alpha_t = getAlphaCount(t);
        for (int i = 0; i < 26; i++)
        {
            if (alpha_t[i] > alpha_s[i])
                return suffix = NONE;
        }

        if (s.length() == t.length())
            return suffix = ARR;

        int similar = 0;
        for (int pos_s = 0, pos_t = 0; pos_s < s.length() && pos_t < t.length(); pos_s++)
        {
            if (s[pos_s] == t[pos_t])
            {
                pos_t++;
                similar++;
            }
        }
        if (similar == t.length())
            return suffix = AUTO;
        else
            return suffix = BOTH;
    }
}

int main()
{
    string s, t;
    cin >> s >> t;

    string suffix;
    suffixStructure(s, t, suffix);
    cout << suffix << endl;

    return 0;
}