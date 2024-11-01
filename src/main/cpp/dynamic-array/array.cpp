#include <iostream>
#include <vector>

using namespace std;

string hasSmallerNumber(int nA, int nB, int kA, int mB, vector<int> A, vector<int> B)
{
    // Check if the kth element of A is smaller than the mth element of B
    if (A[kA - 1] < B[nB - mB])
    {
        return "YES";
    }
    else
    {
        return "NO";
    }
}

void getInput(int &nA, int &nB, int &kA, int &mB, vector<int> &A, vector<int> &B)
{
    // Read sizes of arrays A and B from user input
    cin >> nA >> nB;

    // Read values kA and mB from user input
    cin >> kA >> mB;

    // Resize vectors to hold the elements of A and B
    A.resize(nA);
    B.resize(nB);

    // Read elements of array A from user input
    for (int i = 0; i < nA; ++i)
    {
        cin >> A[i];
    }

    // Read elements of array B from user input
    for (int i = 0; i < nB; ++i)
    {
        cin >> B[i];
    }
}

int main()
{
    int nA, nB, kA, mB;
    vector<int> A, B;

    // Get input from the user using the getInput function
    getInput(nA, nB, kA, mB, A, B);

    cout << hasSmallerNumber(nA, nB, kA, mB, A, B) << endl;

    return 0;
}