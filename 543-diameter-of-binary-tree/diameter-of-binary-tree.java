
class Solution {
    private int diameter = 0; // global variable to track max diameter
    
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
    
    // Helper function to calculate depth of a node
    private int depth(TreeNode node) {
        if (node == null) return 0;
        
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        
        // Update diameter: longest path through this node
        diameter = Math.max(diameter, leftDepth + rightDepth);
        
        // Return height of this node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
