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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] index = {0};  // mutable int
        return deserializeHelper(tokens, index);
    }

    public TreeNode deserializeHelper(String[] tokens, int[] index) {
        // No need to check as tokens will be always valid
        // if (index[0] >= tokens.length()) {
        //     return null;
        // }
        if (tokens[index[0]].equals("N")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(tokens[index[0]++]));
        node.left = deserializeHelper(tokens, index);
        node.right = deserializeHelper(tokens, index);
        return node;
    }
}
