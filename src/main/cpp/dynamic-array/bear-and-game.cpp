#include <iostream>
#include <vector>
#include <tuple>
using namespace std;

int bearAndGame(int highlights, vector<int> highlightMinutes)
{
    const int BORING_TIMEOUT = 15;
    const int GAME_TIMEOUT = 90 - BORING_TIMEOUT;
    int minutes = 0;
    for (int highlightMinute : highlightMinutes)
    {
        if (highlightMinute - minutes > BORING_TIMEOUT)
        {
            break;
        }
        if (highlightMinute > GAME_TIMEOUT || highlightMinute == GAME_TIMEOUT)
        {
            return GAME_TIMEOUT + BORING_TIMEOUT;
        }
        minutes = highlightMinute;
    }

    return minutes + BORING_TIMEOUT;
}

tuple<int, vector<int>> getInput()
{
    int highlights;
    cin >> highlights;
    vector<int> highlightMinutes(highlights);
    for (int i = 0; i < highlights; ++i)
    {
        cin >> highlightMinutes[i];
    }

    return make_tuple(highlights, highlightMinutes);
}

int main()
{
    auto [highlights, highlightMinutes] = getInput();
    cout << bearAndGame(highlights, highlightMinutes) << endl;
}