class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both are null
        if (p == null && q == null) {
            return true;
        }
        
        // Case 2: one is null, the other is not
        if (p == null || q == null) {
            return false;
        }
        
        // Case 3: both are non-null
        // Check current node values and recurse on children
        return (p.val == q.val) &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
