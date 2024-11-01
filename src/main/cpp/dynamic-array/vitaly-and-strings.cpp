#include <iostream>
#include <tuple>
#include <cmath>
using namespace std;

string secondHighestOrLowestSequence(string s, string t)
{
    char s_last = s.back();
    char t_last = t.back();
    if (t_last == 'z')
        return t.substr(0, t.size() - 1) + 'y';
    else if (s_last == 'a')
        return s.substr(0, t.size() - 1) + 'b';

    char t_2nd_last = char(int(t_last) - 1);
    return t.substr(0, t.size() - 1) + t_2nd_last;
}

string vitalyAndStrings(string s, string t)
{
    char s_last = s.back();
    char t_last = t.back();

    if (abs(int(s_last) - int(t_last)) != 1)
        return secondHighestOrLowestSequence(s, t);

    int count_similar = 0;

    for (size_t i = 0; i < s.size(); ++i)
    {
        if (s[i] == t[i])
            count_similar++;
    }

    if (count_similar == s.size() - 1)
        return "No such string";
    else if (count_similar == 0)
        return secondHighestOrLowestSequence(s, t);

    return "No such string";
}

tuple<string, string> getInput()
{
    string s;
    string t;
    cin >> s;
    cin >> t;

    return make_tuple(s, t);
}

int main()
{
    auto [s, t] = getInput();

    cout << vitalyAndStrings(s, t) << endl;
}