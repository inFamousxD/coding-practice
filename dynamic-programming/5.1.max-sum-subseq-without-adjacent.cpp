// GFG https://www.geeksforgeeks.org/problems/geek-jump/1
#include <bits/stdc++.h>
using namespace std;

// User function template for C++
class Solution {
    public:
    int rec(int i, vector<int>& arr, vector<int>& dp) {
        // base case here <>
        if (i == 0) return arr[0];
        if (i < 0) return 0;
        
        if (dp[i] != -1) return dp[i];

        // main logic
        int p = rec(i - 2, arr, dp) + arr[i];
        int np = rec(i - 1, arr, dp);
        
        int mx = max(p, np);
        
        dp[i] = mx;
        return mx;
    }
    
    // TABULATED ONLY
    int tab(vector<int>& arr) {
        vector<int> dp(arr.size(), -1);
        dp[0] = arr[0];

        for (int i = 1; i < arr.size(); i++) {
            int pick = arr[i];
            if (i > 1) pick += dp[i - 2];
            
            int notPick = 0 + dp[i - 1];
            
            dp[i] = max(pick, notPick);
        }
        
        return dp[arr.size() - 1];
    }
    
    // TABULATED + Space Optimized
    int tabOpt(vector<int>& arr) {
        int cur = arr[1];
        int prev = arr[0];
        int prev2 = 0;

        for (int i = 1; i < arr.size(); i++) {
            int pick = arr[i] + prev2;
            int notPick = 0 + prev;
            
            cur = max(pick, notPick);
            
            prev2 = prev;
            prev = cur;
        }
        
        return prev;
    }
  
    // calculate the maximum sum with out adjacent
    int findMaxSum(vector<int>& arr) {
        // code here
        // vector<int> dp(arr.size()+1 , -1);
        
        // return rec(arr.size() - 1, arr, dp);
        
        return tabOpt(arr);
    }
};