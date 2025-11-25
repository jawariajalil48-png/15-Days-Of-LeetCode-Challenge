class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if the tree is empty
        if (root == null) {
            return 0;
        }
        
        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The depth of the tree is the larger of the two, plus 1 for the root
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
