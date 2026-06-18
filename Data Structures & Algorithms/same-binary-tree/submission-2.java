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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        pQueue.add(p);
        qQueue.add(q);

        while(!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();


            if(pNode == null && qNode == null) {
                continue;
            }
            else if(pNode == null || qNode == null || pNode.val != qNode.val ) {
                return false;
            }

            pQueue.add(pNode.left);
            pQueue.add(pNode.right);
            qQueue.add(qNode.left);
            qQueue.add(qNode.right);
        }
        return true;
    }
}
