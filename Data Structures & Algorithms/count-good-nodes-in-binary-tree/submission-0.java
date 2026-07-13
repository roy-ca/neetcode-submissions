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
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goodNodes;
    }

    public void dfs(TreeNode node, int maxSoFar) {
        if(node == null) {
            return;
        }

        if(node.val >= maxSoFar) {
            goodNodes++;
        }

        dfs(node.left, Math.max(maxSoFar, node.val));
        dfs(node.right, Math.max(maxSoFar, node.val));
    }
}
