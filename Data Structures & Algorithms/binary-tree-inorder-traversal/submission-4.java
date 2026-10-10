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
    public List<Integer> inorderTraversal(TreeNode root) {
        // morris inorder traversal
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                res.add(cur.val);
                cur=cur.right;
            }
            else{
                // go to the rightmost guy in the left subtree and point its right to this cur
                TreeNode temp = cur.left;
                while(temp.right!=null && temp.right!=cur){
                    temp=temp.right;
                }
                if(temp.right == null){
                    temp.right = cur;
                    cur=cur.left;
                }
                else{
                    temp.right=null;
                    res.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return res;
    }
}