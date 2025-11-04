#include <bits/stdc++.h>
using namespace std;


void subseq(int n, vector<int> &sub, vector<int> &arr) {
    if (n >= arr.size()) {
        for (int i = 0; i < sub.size(); i++) {
            cout << sub[i] << " ";
        }
        cout << endl;

        return;
    }

    sub.push_back(arr[n]);
    subseq(n + 1, sub, arr);
    
    sub.pop_back();
    subseq(n + 1, sub, arr);
}

/**
 * time complexity
 * O(2^n * n)
 * 
 * space complexity
 * O(n) -> stack space at the most is the original arr
 */

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    vector<int> sub;

    cout << "-----------" << endl;

    subseq(0, sub, arr);
}