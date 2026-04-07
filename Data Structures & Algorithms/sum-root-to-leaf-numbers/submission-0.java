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
    int total;
    public int sumNumbers(TreeNode root) {
        total=0;
         dfs(new StringBuilder(),root);
         return total;
    }
    public void dfs(StringBuilder sb,TreeNode root){
        sb.append(Integer.toString(root.val));
        if(root.left==null && root.right==null){
            total+=Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        if(root.left!=null)
            dfs(sb,root.left);
        if(root.right!=null)
            dfs(sb,root.right);
        sb.deleteCharAt(sb.length()-1);
    }   
}