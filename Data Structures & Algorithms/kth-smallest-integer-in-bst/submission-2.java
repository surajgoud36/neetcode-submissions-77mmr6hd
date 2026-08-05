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
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root,k,1);
        
    }
    public int dfs(TreeNode root, int k,int curr){
        if(root==null){
            return -1 * curr;
        }
        
        int leftSubTree = dfs(root.left,k,curr);
        if(leftSubTree > 0)
            return leftSubTree;
            curr=(-1*leftSubTree);
            if(curr == k){
            return root.val;
            }
        curr++;
        
        return dfs(root.right,k,curr);
    }
}
