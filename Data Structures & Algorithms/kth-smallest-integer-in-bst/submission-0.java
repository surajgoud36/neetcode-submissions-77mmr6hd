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
    int check=-1;
    public int kthSmallest(TreeNode root, int k) {
        if(check==-1)
            check=k;
         if(root == null)
            return -1;
            int left=kthSmallest(root.left,k);
            if(check==0)
                return left;
            if(check==1){
                check--;
                return root.val;
            }
                
            check--;
            int right=kthSmallest(root.right,k);
            return(Math.max(left,right));
        // if(k==1)
        //     return root.val;
        // if(root == null)
        //     return 0;
        // return (Math.max(KthSmallest(root.left,k),KthSmallest(root.right,k-1)));
    }

    
}
