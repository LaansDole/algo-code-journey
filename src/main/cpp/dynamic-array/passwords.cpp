#include <iostream>
#include <vector>
#include <string>

using namespace std;

void calculateAttempts(int n, int k, const vector<string> &passwords, const string &correctPassword, int &best, int &worst)
{
    const int LOCK_TIMEOUT = 5;
    const int CORRECT_PASSWORD_LEN = correctPassword.length();
    int wrong_attempts_shorter_length = 0;
    int wrong_attempts_same_length = 0;

    for (int attempts = 0; attempts < n; attempts++)
    {
        if (passwords[attempts].length() < CORRECT_PASSWORD_LEN)
            ++wrong_attempts_shorter_length;

        if (passwords[attempts].length() == CORRECT_PASSWORD_LEN && passwords[attempts] != correctPassword)
            ++wrong_attempts_same_length;
    }

    int worst_attempts = wrong_attempts_shorter_length + wrong_attempts_same_length;

    best = wrong_attempts_shorter_length + (wrong_attempts_shorter_length / k) * LOCK_TIMEOUT + 1;
    worst = wrong_attempts_shorter_length + wrong_attempts_same_length + (worst_attempts / k) * LOCK_TIMEOUT + 1;
}

void getInput(int &n, int &k, vector<string> &passwords, string &correctPassword)
{
    // Read number of passwords and number of failed tries before lockout
    cin >> n >> k;

    // Resize vector to hold the passwords
    passwords.resize(n);

    // Read passwords from input
    for (int i = 0; i < n; ++i)
    {
        cin >> passwords[i];
    }

    // Read the correct password
    cin >> correctPassword;
}

int main()
{
    int n, k;
    vector<string> passwords;
    string correctPassword;

    // Get input from the user using the getInput function
    getInput(n, k, passwords, correctPassword);

    int best, worst;

    // Calculate the best and worst password attempts
    calculateAttempts(n, k, passwords, correctPassword, best, worst);

    // Output the best and worst case times
    cout << best << " " << worst << endl;

    return 0;
}