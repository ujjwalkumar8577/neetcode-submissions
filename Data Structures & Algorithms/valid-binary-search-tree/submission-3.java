/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTUtil(TreeNode root, int lb, int ub) {
        if (root == null) {
            return true;
        }
        if (root.val < lb || root.val > ub) {
            return false;
        }
        return isValidBSTUtil(root.left, lb, root.val-1) && isValidBSTUtil(root.right, root.val+1, ub);
    }
}
