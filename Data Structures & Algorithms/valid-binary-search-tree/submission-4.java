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
    int uni=0;
    public boolean isValidBST(TreeNode root) {
        return isValid(root.left,Integer.MIN_VALUE,root.val) && isValid(root.right,root.val,Integer.MAX_VALUE);
    }
    public boolean isValid(TreeNode root,int min,int max){
        if(root==null)
            return true;
        return (root.val>min && root.val<max) && isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
    }
}



//  uni=root.val;
//         return isValidLeft(root.left,root.val,-1001) && isValidRight(root.right,root.val,1001);
//     }
//     public boolean isValidLeft(TreeNode root,int key,int hero){
//         if(root==null)
//             return true;
//         if(root.val<key && root.val>hero){
//             return isValidLeft(root.left,root.val,-1001) && isValidRight(root.right,root.val,uni);
//         }
//         else
//          return false;
//     }
//      public boolean isValidRight(TreeNode root,int key,int hero){
//         if(root==null)
//             return true;
//         if(root.val>key && root.val<hero){
//              return isValidLeft(root.left,root.val,uni) && isValidRight(root.right,root.val,1001);
//         }
//         else
//          return false;
