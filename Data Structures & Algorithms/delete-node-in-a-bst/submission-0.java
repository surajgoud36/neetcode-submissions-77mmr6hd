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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else if(key<root.val){
             root.left=deleteNode(root.left,key);
        }
        else{
            //no childeren we return null
            if(root.left==null && root.right==null)
                return null;
            else if(root.left!=null && root.right!=null){
                int minval=minNode(root.right);
                root.val=minval;
                root.right=deleteNode(root.right,minval);
            }
            else{
                if(root.right!=null)
                    return root.right;
                else
                    return root.left;
            }
        }
        return root;
    }

    public int minNode(TreeNode root){
        if(root.left==null){
            return root.val;
        }
        return minNode(root.left);
    }
}