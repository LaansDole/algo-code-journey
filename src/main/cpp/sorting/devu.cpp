#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cassert>

using namespace std;

void devuLerningHours(int num_subjects, int hour_of_the_first_chapter, vector<int> subjects, long long &total_hours)
{
    sort(subjects.begin(), subjects.end());
    int hours = hour_of_the_first_chapter;

    for (int subject = 0; subject < num_subjects; subject++)
    {
        if (hours == 0)
            hours = 1;
        total_hours += 1LL * hours * subjects[subject];
        hours--;
    }
}

int main()
{

    int num_subjects, hour_of_the_first_chapter;

    cin >> num_subjects >> hour_of_the_first_chapter;

    vector<int> subjects;
    for (int i = 0; i < num_subjects; i++)
    {
        int chapter;
        cin >> chapter;
        subjects.push_back(chapter);
    }
    long long total_hours = 0;
    devuLerningHours(num_subjects, hour_of_the_first_chapter, subjects, total_hours);
    cout << total_hours << endl;

    return 0;
}