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
    HashMap<TreeNode, Integer[]> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return robHelper(root, false);
    }

    public int robHelper(TreeNode root, boolean isParentBroken) {
        if (root == null) {
            return 0;
        }
        int ind = isParentBroken ? 0 : 1;
        if (map.containsKey(root) && map.get(root)[ind] != null) {
            return map.get(root)[ind];
        }
        if (!map.containsKey(root)) {
            map.put(root, new Integer[2]);
        }
        if (isParentBroken) {
            return map.get(root)[ind] = robHelper(root.left, false) + robHelper(root.right, false);
        }
        return map.get(root)[ind] = Math.max(
            robHelper(root.left, false) + robHelper(root.right, false),
            root.val + robHelper(root.left, true) + robHelper(root.right, true)
        );
    }
}