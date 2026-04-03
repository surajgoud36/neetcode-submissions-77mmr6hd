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
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        int res=findMax(root);
        return Math.max(max,res);
    }
    public int findMax(TreeNode root){
        if(root==null)
            return 0;
        int left=findMax(root.left);
        int right=findMax(root.right);
        max=Math.max(left+right+root.val,max);
        int pathMax=Math.max(left,right);
        max=Math.max(root.val+pathMax,max);
        max=Math.max(max,root.val);
        return Math.max(root.val+pathMax,root.val);
    }
}
