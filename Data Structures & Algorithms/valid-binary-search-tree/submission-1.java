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
        if (root == null) {
            return true;
        }
        int max = getMax(root.left, Integer.MIN_VALUE);
        int min = getMin(root.right, Integer.MAX_VALUE);
        return
            root.val > max &&
            root.val < min &&
            isValidBST(root.left) &&
            isValidBST(root.right);
    }

    public int getMax(TreeNode root, int max) {
        if (root == null) {
            return max;
        }
        max = Math.max(root.val, max);
        return Math.max(getMax(root.left, max), getMax(root.right, max));
    }

    public int getMin(TreeNode root, int min) {
        if (root == null) {
            return min;
        }
        min = Math.min(root.val, min);
        return Math.min(getMin(root.left, min), getMin(root.right, min));
    }
}
