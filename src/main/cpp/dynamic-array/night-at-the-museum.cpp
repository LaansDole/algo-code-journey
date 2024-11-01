#include <iostream>
#include <cmath>
#include <string>
using namespace std;

enum class Alphabet
{
    HALF = 13,
    FULL = 26
};

int getASCII(char c)
{
    return int(c);
}

int nightAtTheMuseum(string code)
{
    char curr_char = 'a';
    int steps = 0;
    for (char code_char : code)
    {
        int pre_steps = abs(getASCII(code_char) - getASCII(curr_char));
        if (pre_steps > static_cast<int>(Alphabet::HALF))
        {
            steps += abs(pre_steps - static_cast<int>(Alphabet::FULL));
        }
        else
        {
            steps += pre_steps;
        }
        curr_char = code_char;
    }

    return steps;
}

int main()
{
    string code;
    cin >> code;
    cout << nightAtTheMuseum(code) << endl;
}
