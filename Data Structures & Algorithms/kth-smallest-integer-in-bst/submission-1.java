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
record Pair(int key,int rem){}
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //send left 
        // check curr
        // send right
        Pair res=kSmallest(root,k);
        return res.key();
        
    }
    public Pair kSmallest(TreeNode root,int k){
        if(root==null)
            return new Pair(-1,k);
        Pair left=kSmallest(root.left,k);
        if(left.key()>=0)
            return left;
        int nk=left.rem();
        if(nk==1)
            return new Pair(root.val,nk);
        Pair right=kSmallest(root.right,nk-1);
        return right;
    }
}
