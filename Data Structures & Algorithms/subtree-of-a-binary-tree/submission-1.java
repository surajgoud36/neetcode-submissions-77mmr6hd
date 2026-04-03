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
    public boolean isSubtree(TreeNode r, TreeNode s) {
        if(s==null)
            return true;
        if(r==null)
            return false;
        if(isSame(r,s))
            return true;
        else
            return ((isSubtree(r.left,s))||(isSubtree(r.right,s)));
    }

    public boolean isSame(TreeNode s,TreeNode t){
        if(s==null && t==null)
            return true;
        if(s!=null && t!=null){
            if(s.val==t.val){
                return ((isSame(s.left,t.left)) && isSame(s.right,t.right));
            }
            else 
            return false;
        }
        return false;
    }
}
