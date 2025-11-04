#include <bits/stdc++.h>
using namespace std;

void reverse(vector<int> &arr, int i, int j) {
    if (i >= j) return;

    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    reverse(arr, i + 1, j - 1);
}

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << "-----------" << endl;

    reverse(arr, 0, n - 1);

    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
}