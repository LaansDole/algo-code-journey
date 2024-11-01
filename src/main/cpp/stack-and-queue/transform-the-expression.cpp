#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <stack>

using namespace std;

string transformExpression(const string &expression)
{
    stack<char> operators;
    string transformedExpression = "";
    for (char c : expression)
    {
        if (c == '(')
            continue;
        if (isalpha(c))
            transformedExpression += c;
        else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
        {
            operators.push(c);
        }
        if (c == ')')
        {
            transformedExpression += operators.top();
            operators.pop();
        }
    }
    return transformedExpression;
}

int main()
{
    int t;
    cin >> t;

    for (int i = 0; i < t; i++)
    {
        string expression;
        cin >> expression;
        cout << transformExpression(expression) << endl;
    }
}