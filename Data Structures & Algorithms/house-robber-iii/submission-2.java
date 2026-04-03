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
    public int rob(TreeNode root) {
        List<Integer> res = hRob(root);
        return Math.max(res.get(0),res.get(1));
    }
    public List<Integer> hRob(TreeNode root){
        List<Integer> res=new ArrayList<>(Arrays.asList(0,0));
        
        if(root==null)
            return res;
        List<Integer> leftChild=hRob(root.left);
        List<Integer> rightChild=hRob(root.right);
        // compute with Root
        int withRoot = root.val + leftChild.get(1) + rightChild.get(1);
        int withoutRoot = Math.max(leftChild.get(0),leftChild.get(1)) +  Math.max(rightChild.get(0),rightChild.get(1));
        res.set(0,withRoot);
        res.set(1,withoutRoot);
        return res;
    }
}