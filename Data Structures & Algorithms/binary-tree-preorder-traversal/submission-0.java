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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        //stack.push(root);
        while(root!=null||stack.size()!=0){
            if(root!=null){
                 list.add(root.val);
           
           // TreeNode node=stack.pop();
           
            if(root.right!=null)
                stack.push(root.right);
            root=root.left;
            }
            else{
                root=stack.pop();
            }

           
            
        }
        return list;
    }
}