#include <iostream>
#include <vector>
#include <tuple>
using namespace std;

enum class ButtonState
{
    OPEN = 0,
    CLOSED = 1
};

string fashionInBerland(int buttons, vector<int> buttonList)
{
    int openButtons = 0;
    if (buttonList.size() == 1)
    {
        if (buttonList[0] == static_cast<int>(ButtonState::OPEN))
        {
            return "NO";
        }
        return "YES";
    }

    for (auto button : buttonList)
    {
        if (button == static_cast<int>(ButtonState::OPEN))
        {
            openButtons++;
        }
    }
    if (openButtons == 1)
    {
        return "YES";
    }
    return "NO";
}

tuple<int, vector<int>> getInput()
{
    int buttons;
    cin >> buttons;
    vector<int> buttonList(buttons);
    for (int i = 0; i < buttons; ++i)
    {
        cin >> buttonList[i];
    }

    return make_tuple(buttons, buttonList);
}

int main()
{
    auto [buttons, buttonList] = getInput();

    cout << fashionInBerland(buttons, buttonList) << endl;
    return 0;
}