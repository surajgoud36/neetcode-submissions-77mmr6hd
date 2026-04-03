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
        int left=0,right=0;
        if(root.left!=null)
            left=cNodes(root.left,root.val);
          if(root.right!=null)
              right=cNodes(root.right,root.val);
        return 1+right+left;
    }

    public int cNodes(TreeNode root,int max){
        int count=0;
        if(max<=root.val)
            count=1;
        max=Math.max(max,root.val);
        int left=0,right=0;
        if(root.left!=null)
            left=cNodes(root.left,max);
          if(root.right!=null)
              right=cNodes(root.right,max);
        return count+right+left;
    }
}
