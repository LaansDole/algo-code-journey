#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main()
{
    int num_tests;
    cin >> num_tests;
    while (num_tests--)
    {
        int num_jobs, position;
        cin >> num_jobs >> position;
        vector<int> jobs(num_jobs);
        for (int i = 0; i < num_jobs; i++)
        {
            cin >> jobs[i];
        }

        int my_job = jobs[position];
        pair<int, int> my_job_pair = make_pair(my_job, position);

        queue<pair<int, int>> pq;
        for (int i = 0; i < num_jobs; i++)
        {
            pq.push(make_pair(jobs[i], i));
        }

        int minutes = 0;

        while (!pq.empty())
        {
            pair<int, int> current_job = pq.front();
            pq.pop();

            // Check if there's a higher-priority job in the queue
            bool has_higher_priority = false;
            queue<pair<int, int>> temp_queue = pq;

            while (!temp_queue.empty())
            {
                if (temp_queue.front().first > current_job.first)
                {
                    has_higher_priority = true;
                    break;
                }
                temp_queue.pop();
            }

            // If there is a higher priority job, move the current job to the end
            if (has_higher_priority)
            {
                pq.push(current_job);
            }
            else
            {
                // Print the job
                minutes++;

                // Check if it is your job
                if (current_job == my_job_pair)
                {
                    break; // Your job is printed, exit the loop
                }
            }
        }

        cout << minutes << endl;
    }

    return 0;
}