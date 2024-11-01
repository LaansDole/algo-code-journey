#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
    int first_banana_cost, balance, num_bananas;
    cin >> first_banana_cost >> balance >> num_bananas;

    int total_cost = 0;
    for (int i = 1; i <= num_bananas; i++)
    {
        total_cost += i * first_banana_cost;
    }

    int borrow = total_cost - balance;
    if (borrow < 0)
    {
        cout << 0 << endl;
    }
    else
    {
        cout << borrow << endl;
    }

    return 0;
}