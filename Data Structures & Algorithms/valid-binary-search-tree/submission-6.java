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
    public boolean isValidBST(TreeNode root) {
      return checkValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean checkValid(TreeNode root,int lowerLimit,int upperLimit){
        if(root==null)
            return true;
        if(!(root.val>lowerLimit && root.val<upperLimit))
            return false;
        if(!((root.right==null||root.val<root.right.val)&&(root.left==null||root.val>root.left.val)))
            return false;
        return checkValid(root.left,lowerLimit,root.val) && checkValid(root.right,root.val,upperLimit);
    }
}
