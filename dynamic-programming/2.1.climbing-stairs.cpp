// leet 70. Climbing Stairs
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int rec(int n, vector<int> &mem) {
        if (n <= 1) return 1;
        if (mem[n] != -1) return mem[n];

        int i = rec(n - 1, mem) + rec(n - 2, mem);
        
        mem[n] = i;

        return i; 
    }

    int climbStairs(int n) {
        vector<int> mem(n + 1, -1);

        return rec(n, mem);
    }
};