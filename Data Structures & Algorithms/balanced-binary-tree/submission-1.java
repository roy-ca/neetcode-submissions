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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        findBalanced(root);
        return balanced;
    }

    public int findBalanced(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = findBalanced(node.left);
        int right = findBalanced(node.right);

        balanced = balanced && Math.abs(left - right) <= 1 ? true: false;
        return 1 + Math.max(left, right);
    }
}
