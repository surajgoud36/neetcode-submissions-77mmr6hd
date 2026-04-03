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
        return it(root,new ArrayList<Integer>());
    }

    public List<Integer> it(TreeNode root, List<Integer> list){
        if(root==null)
            return list;
        List<Integer> temp=it(root.left,list);
        temp.add(root.val);
        temp=it(root.right,temp);
        return temp;
    }
}