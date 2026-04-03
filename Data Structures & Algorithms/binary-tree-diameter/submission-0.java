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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        if(root==null)
            return 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int left=0,right=0;
        if(root.left!=null)
            left=helper(root.left)+1;
        if(root.right!=null)
            right=helper(root.right)+1;
        //int len=helper(root.left)+helper(root.right)+2;
        max=Math.max(max,(left+right));
        return Math.max(left,right);
    }
}
