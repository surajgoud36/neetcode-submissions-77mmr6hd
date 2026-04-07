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
    List<Integer> ln;
    List<Integer> lb;
    List<Integer> rb;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ln=new ArrayList<>();
        lb=new ArrayList<>();
        rb= new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        res.add(root.val);
        if(root.left!=null){
            leftBoundary(root.left);
            if(lb.size()>0)
                res.addAll(lb);
        }
        leafNodes(root.left);
        leafNodes(root.right);
        res.addAll(ln);
        if(root.right!=null){
            rightBoundary(root.right);
            if(rb.size()>0){
                Collections.reverse(rb);
                 res.addAll(rb);
            }
               
        }
        return res;
    }
    public void leftBoundary(TreeNode root){
        if(root==null)
            return;
        if(!(root.left==null && root.right==null))
            lb.add(root.val);
        if(root.left!=null){
            leftBoundary(root.left);
            return;
        }
        if(root.right!=null){
            leftBoundary(root.right);
            return;
        }

    }
    public void rightBoundary(TreeNode root){
        if(root==null)
            return;
        if(!(root.left==null && root.right==null))
            rb.add(root.val);
        if(root.right!=null){
            rightBoundary(root.right);
            return;
        }
        if(root.left!=null){
            rightBoundary(root.left);
            return;
        }

    }
    public void leafNodes(TreeNode root){
        if(root==null)
            return;
        if(root.left!=null){
            leafNodes(root.left);
        }
        if(root.right!=null){
            leafNodes(root.right);
        }
        if(root.left==null && root.right==null){
            ln.add(root.val);
        }
    }
}
