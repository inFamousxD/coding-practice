//Given the roots of two binary trees p and q, write a function to check if 
//they are the same or not. 
//
// Two binary trees are considered the same if they are structurally identical, 
//and the nodes have the same value. 
//
// 
// Example 1: 
// 
// 
//Input: p = [1,2,3], q = [1,2,3]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: p = [1,2], q = [1,null,2]
//Output: false
// 
//
// Example 3: 
// 
// 
//Input: p = [1,2,1], q = [1,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both trees is in the range [0, 100]. 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 12
//761 👎 295


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    // struct TreeNode {
    //     int val;
    //     TreeNode *left;
    //     TreeNode *right;
    //     TreeNode() : val(0), left(nullptr), right(nullptr) {}
    //     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    //     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
    // };

public:
    bool traverse(TreeNode* p, TreeNode* q) {
        if (p == nullptr && q == nullptr) return true;
        if (p == nullptr || q == nullptr) return false;

        if (p->val != q->val) return false;
        return traverse(p->left, q->left) && traverse(p->right, q->right);
    }

    bool isSameTree(TreeNode* p, TreeNode* q) {
        return traverse(p, q);
    }
};
//leetcode submit region end(Prohibit modification and deletion)
