#include <bits/stdc++.h>
using namespace std;

int fib(int n, vector<int> &memory) {
    if (n <= 1) return n;

    if (memory[n] != -1) return memory[n];

    int nth =  fib(n - 1, memory) + fib(n - 2, memory);
    memory[n] = nth;

    return nth;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;

    vector<int> memory(n + 1, -1);

    cout << fib(n, memory) << "\n";
    return 0;
}