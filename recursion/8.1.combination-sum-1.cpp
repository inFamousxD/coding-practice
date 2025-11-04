// leet
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void rec(int i, int target, vector<int>& subseq, vector<int>& arr, vector<vector<int>>& ans) {
        if (target == 0) {
            ans.push_back(subseq);
            return;
        }

        if (i >= arr.size()) return;

        if (target - arr[i] >= 0) {
            subseq.push_back(arr[i]);
            rec(i, target - arr[i], subseq, arr, ans);
            subseq.pop_back();
        }

        rec(i + 1, target, subseq, arr, ans);
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> subseq;
        rec(0, target, subseq, candidates, ans);
        return ans;
    }
};