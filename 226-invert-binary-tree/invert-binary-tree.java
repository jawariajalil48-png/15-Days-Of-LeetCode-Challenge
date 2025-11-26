
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if tree is empty
        if (root == null) {
            return null;
        }
        
        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
