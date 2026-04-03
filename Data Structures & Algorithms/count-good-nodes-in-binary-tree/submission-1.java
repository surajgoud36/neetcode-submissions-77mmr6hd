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
    public int goodNodes(TreeNode root) {
        return 1+goodNode(root.left,root.val)+goodNode(root.right,root.val);
    }
    public int goodNode(TreeNode root,int max){
        if(root==null)
            return 0;
        if(root.val<max){
            return goodNode(root.left,max)+goodNode(root.right,max);
        }
        return 1+goodNode(root.left,root.val)+goodNode(root.right,root.val);
    }
}
