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
    List<Integer> rightView = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        int level = 0;
        getRightView(root, level);
        return rightView;
    }

    public void getRightView(TreeNode node, int l) {
        if(node == null) {
            return;
        }

        if(rightView.size() == l) {
            rightView.add(node.val);
        }

        getRightView(node.right, l+1);
        getRightView(node.left, l+1);
    }
}
