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
    record Triple(boolean status,int size,Integer min,Integer max){}
    int res=0;
    public int largestBSTSubtree(TreeNode root) {
        Triple get = dfs(root);
        return res;
    }
    public Triple dfs(TreeNode root){
        if(root == null){
            return new Triple(true,0,null,null);
        }
        Triple r1 = dfs(root.left);
        Triple r2=dfs(root.right);
        if(r1.status() && r2.status()){
            if((r2.min()==null || r2.min()>root.val) && (r1.max() == null || r1.max()<root.val)){
                int min=root.val,max=root.val;
                if(r1.min()!=null)
                    min=Math.min(min,r1.min());
                if(r2.min()!=null)
                    min=Math.min(min,r2.min());
                if(r1.max()!=null)
                    max=Math.max(max,r1.max());
                if(r2.max()!=null)
                    max=Math.max(max,r2.max());
                res=Math.max(res,r1.size()+r2.size()+1);
                return new Triple(true,(r1.size()+r2.size()+1),min,max);
            }
            return new Triple(false,0,null,null);
        }
        return new Triple(false,0,null,null);
    }
}
