#include <iostream>
#include <algorithm>
#include <string>
#include <cstdlib>
#include <vector>
#include <string>
#include <queue>
using namespace std;

int S;
int M, N;
const int maxn = 100 + 10;
int a[maxn][maxn];
int dx[5] = {-1, 1, 0, 0};
int dy[5] = {0, 0, -1, 1};
struct node
{
    int x, y;
    node(int x, int y) : x(x), y(y) {}
};
int main()
{
    cin >> S >> M >> N;
    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> a[i][j];
        }
    }
    queue<node> q;
    q.push(node{0, 0});
    while (!q.empty())
    {
        node t = q.front();
        if (t.x == M - 1 && t.y == N - 1)
        {
            cout << 1 << "\n";
            return 0;
        }
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = t.x + dx[i] * S;
            int ny = t.y + dy[i] * S;
            if (nx >= 0 && nx < M && ny >= 0 && ny < N)
            {
                q.push(node{nx, ny});
            }
        }
    }
    cout << 0 << "\n";
}