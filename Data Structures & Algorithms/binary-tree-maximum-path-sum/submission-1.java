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
    int max;
    public int maxPathSum(TreeNode root) {
        max=root.val;
        maxPathS(root);
        return max;
    }

    public int maxPathS(TreeNode root){
        if(root==null)
            return 0;
        int left=maxPathS(root.left);
        int right=maxPathS(root.right);
        int res=determineMax(left,right,root.val);
        //max=Math.max(max,res);
        return res;
    }
    public int determineMax(int a,int b,int c){
        // a is left, b right, c is root it self,
        int maxi=c,rv=c;
        maxi=Math.max(maxi,(a+c)); 
        maxi=Math.max(maxi,(b+c));
        rv=maxi;
        maxi=Math.max(maxi,(a+c+b));
        max=Math.max(max,maxi);
        return rv;
    }
}
