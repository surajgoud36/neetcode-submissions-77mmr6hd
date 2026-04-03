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
    boolean res;
    public boolean isBalanced(TreeNode root) {
        res=true;
        checkHeight(root);
        return res;
    }
    public int checkHeight(TreeNode root){
        if(root==null)
            return 0;
        int left=checkHeight(root.left);
        
        int right=checkHeight(root.right);

        if(Math.abs(left-right)>1){
            res=false;
        }
        return 1+Math.max(left,right);
    }
}
