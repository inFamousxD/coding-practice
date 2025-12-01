// GFG https://www.geeksforgeeks.org/problems/geek-jump/1
#include <bits/stdc++.h>
using namespace std;


class Solution {
    public:
    int jump(int i, vector<int>& height, vector<int>& mem) {
        if (i == 0) return 0;
        if (i == 1) return abs(height[0] - height[1]);
        if (mem[i] != -1) return mem[i];
        
        int j1 = jump(i - 1, height, mem) + abs(height[i - 1] - height[i]);
        int j2 = jump(i - 2, height, mem) + abs(height[i - 2] - height[i]);
        
        int m = min(j1, j2);
        
        mem[i] = m;
        return m;
    }
    
    int minCost(vector<int>& height) {
        // Code here
        vector<int> mem(height.size() + 1, -1);
        return jump(height.size() - 1, height, mem);
    }
};