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

     List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
         list = new ArrayList<>();
         inorderT(root);
         return list;
    }
    public void inorderT(TreeNode root){
        if(root==null)
            return;
        inorderT(root.left);
        list.add(root.val);
        inorderT(root.right);
    }
}