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
    HashMap<Integer, Integer> inorderIndexMap;
    int inorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        inorderIndex = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int val = preorder[inorderIndex++];
        TreeNode root = new TreeNode(val);
        root.left = buildTreeHelper(preorder, inorder, l, inorderIndexMap.get(val) - 1);
        root.right = buildTreeHelper(preorder, inorder, inorderIndexMap.get(val) + 1, r);
        return root;        
    }
}
