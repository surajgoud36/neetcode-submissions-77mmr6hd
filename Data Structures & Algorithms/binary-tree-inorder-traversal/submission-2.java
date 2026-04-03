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
        Deque<TreeNode> stack=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp=stack.pop();
                res.add(temp.val);
                curr=temp.right;
            }
        }
        return res;
    }
}