#include <bits/stdc++.h>
using namespace std;


void print(int n, string name, int curr) {
    if (curr >= n) return;
    cout << name << endl;
    print(n, name, curr + 1);
}

int main() {
    int n;
    cin >> n;

    string name;
    cin >> name;

    cout << "==" << endl;

    print(n, name, 0);
}