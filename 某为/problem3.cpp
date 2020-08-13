#include <iostream>
#include <algorithm>
#include <string>
#include <cstdlib>
#include <vector>
#include <string>
using namespace std;

int numRows = 0;
int nextRow(int i, bool &right, bool &goDown)
{

    if (i == (numRows - 1) / 2)
    {
        goDown = !goDown;
        if (right)
            return i + 1;
        else
            return i - 1;
    }
    else if (!goDown && i == (numRows - 1))
    {
        goDown = !goDown;
        return nextRow(i, right, goDown);
    }
    else if (right)
    {
        right = !right;

        return (numRows - 1) - i;
    }
    else if (!right)
    {
        if (goDown)
        {
            return (numRows - 1) - i + 1;
        }
        else
        {
            return (numRows - 1) - i - 1;
        }
    }
}
bool is_digit(char c)
{
    return c >= 'A' && c <= 'Z';
}
int main()
{
    string t;

    cin >> t;
    int idx = 0;
    while (idx < t.size() && is_digit(t[idx++]))
        ;
    string s = t.substr(0, idx - 1);
    if (idx < t.size())
    {
        string number = t.substr(idx);
        numRows = atoi(number.c_str());
    }

    if (numRows == 1)
        cout << s;
    vector<string> rows(min(numRows, int(s.size())));
    int curRow = 0;
    bool right = true;
    bool goDown = true;
    for (int i = 0; i < s.size(); i++)
    {
        rows[curRow] += s[i];
        cout << curRow << " " << goDown;
        curRow = nextRow(curRow, right, goDown);
        cout << " " << curRow << "\n";
    }

    string ret;
    for (int i = 0; i < rows.size(); i++)
    {
        ret += rows[i];
        //cout<<i << " " << rows[i]<<"\n";
    }
    cout << ret;
}