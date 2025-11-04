#include <bits/stdc++.h>
using namespace std;


void print(int n, int curr) {
    if (curr >= n) return;
    cout << curr + 1 << endl;
    print(n, curr + 1);
}

int main() {
    int n;
    cin >> n;

    cout << "==" << endl;

    print(n, 0);
}