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
    public List<Integer> postorderTraversal(TreeNode root) {
         Deque<TreeNode> stack=new ArrayDeque<>();
         Deque<Boolean> visited=new ArrayDeque<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        //stack.push(root);
        stack.push(root);
        visited.push(false);
        while(stack.size()!=0){
            TreeNode node=stack.pop();
            boolean state=visited.pop();
            if(state==false){
                stack.push(node);
                visited.push(true);
                if(node.right!=null){
                     stack.push(node.right);
                     visited.push(false);
                }
                   
                if(node.left!=null){
                    stack.push(node.left);
                    visited.push(false);
                }
                    
                
            }else{
                list.add(node.val);
                
                
            }
            
           
            
        }
        return list;
    }
}