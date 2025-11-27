class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0; // base case: empty tree has height 0

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // left subtree not balanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // right subtree not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // current node not balanced

        return Math.max(leftHeight, rightHeight) + 1; // return height
    }
}
